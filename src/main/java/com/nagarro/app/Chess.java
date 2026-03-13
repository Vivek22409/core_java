package com.nagarro.app;

import java.util.*;

public class Chess {
	
	// ─── Main game loop ───────────────────────────────────────────────────────────
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initBoard();

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║       ♔  JAVA CHESS GAME  ♚          ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("Enter moves in: long algebraic (e2e4), short (Nf3),");
        System.out.println("                castling (O-O / O-O-O), or 'quit'.");
        System.out.println("Promotions: e7e8=Q  or  e7e8Q");
        System.out.println();

        while (true) {
            printBoard();
            String turn = whiteTurn ? "White" : "Black";
            List<int[]> legal = legalMoves(whiteTurn);

            if (legal.isEmpty()) {
                if (isInCheck(whiteTurn)) {
                    System.out.println("♛  Checkmate! " + (whiteTurn ? "Black" : "White") + " wins!");
                } else {
                    System.out.println("½  Stalemate! It's a draw.");
                }
                break;
            }

            if (isInCheck(whiteTurn)) System.out.println("  ⚠  " + turn + " is in CHECK!");
            System.out.print("  " + turn + "'s move: ");

            if (!sc.hasNextLine()) break;
            String line = sc.nextLine().trim();
            if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing!");
                break;
            }
            if (line.equalsIgnoreCase("help") || line.equalsIgnoreCase("?")) {
                System.out.println("  Legal moves: ");
                StringBuilder sb = new StringBuilder("  ");
                for (int[] m : legal) {
                    sb.append(squareName(m[0],m[1])).append(squareName(m[2],m[3]));
                    if (m[4] >= 4) sb.append("PNBRQK".charAt((m[4]-4)));
                    sb.append("  ");
                }
                System.out.println(sb);
                continue;
            }

            int[] move = parseMove(line, whiteTurn);
            if (move == null) {
                System.out.println("  ✗ Invalid or illegal move. Try again (type 'help' for legal moves).");
                continue;
            }

            applyMove(move);
            updateState(move);

            if (!whiteTurn) fullMoveNumber++;
            whiteTurn = !whiteTurn;
        }
        sc.close();
    }

    // ─── Piece constants ────────────────────────────────────────────────────────
    static final int EMPTY = 0;
    static final int PAWN = 1, KNIGHT = 2, BISHOP = 3, ROOK = 4, QUEEN = 5, KING = 6;
    static final int WHITE = 8, BLACK = 16;

    // board[row][col]: row 0 = rank 8 (black side), row 7 = rank 1 (white side)
    static int[][] board = new int[8][8];

    static boolean whiteTurn = true;
    static boolean[] castlingRights = {true, true, true, true}; // wK, wQ, bK, bQ
    static int[] enPassantTarget = null; // {row, col} of EP capture square
    static int halfMoveClock = 0;
    static int fullMoveNumber = 1;

    // ─── Unicode pieces ──────────────────────────────────────────────────────────
    static String pieceChar(int p) {
        boolean white = (p & WHITE) != 0;
        int type = p & 7;
        String[] w = {"·", "♙", "♘", "♗", "♖", "♕", "♔"};
        String[] b = {"·", "*", "♞", "♝", "♜", "♛", "♚"};
        return white ? w[type] : b[type];
    }

    // ─── Board initialisation ────────────────────────────────────────────────────
    static void initBoard() {
        int[] backRank = {ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK};
        for (int c = 0; c < 8; c++) {
            board[0][c] = BLACK | backRank[c];
            board[1][c] = BLACK | PAWN;
            board[6][c] = WHITE | PAWN;
            board[7][c] = WHITE | backRank[c];
        }
    }

    // ─── Print board ─────────────────────────────────────────────────────────────
    static void printBoard() {
        System.out.println();
        System.out.println("    a   b   c   d   e   f   g   h");
        System.out.println("  +---+---+---+---+---+---+---+---+");
        for (int r = 0; r < 8; r++) {
            System.out.print((8 - r) + " |");
            for (int c = 0; c < 8; c++) {
                System.out.print(" " + pieceChar(board[r][c]) + " |");
            }
            System.out.println(" " + (8 - r));
            System.out.println("  +---+---+---+---+---+---+---+---+");
        }
        System.out.println("    a   b   c   d   e   f   g   h");
        System.out.println();
    }

    // ─── Coordinate helpers ───────────────────────────────────────────────────────
    static int[] parseSquare(String s) {
        if (s.length() < 2) return null;
        int col = s.charAt(0) - 'a';
        int row = 8 - (s.charAt(1) - '0');
        if (col < 0 || col > 7 || row < 0 || row > 7) return null;
        return new int[]{row, col};
    }

    static String squareName(int r, int c) {
        return "" + (char)('a' + c) + (8 - r);
    }

    static boolean isWhite(int p) { return (p & WHITE) != 0; }
    static boolean isBlack(int p) { return (p & BLACK) != 0; }
    static boolean sameColor(int a, int b) {
        return (isWhite(a) && isWhite(b)) || (isBlack(a) && isBlack(b));
    }

    // ─── Move generation helpers ─────────────────────────────────────────────────
    // Returns list of [fromR, fromC, toR, toC, flags]
    // flags: 0=normal,1=enpassant,2=castleK,3=castleQ,4=promote
    static List<int[]> pseudoMoves(boolean forWhite) {
        List<int[]> moves = new ArrayList<>();
        int myColor = forWhite ? WHITE : BLACK;
        int dir = forWhite ? -1 : 1;

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                int p = board[r][c];
                if (p == EMPTY || (isWhite(p) != forWhite)) continue;
                int type = p & 7;

                if (type == PAWN) {
                    // forward
                    int nr = r + dir;
                    if (nr >= 0 && nr < 8 && board[nr][c] == EMPTY) {
                        addPawnMove(moves, r, c, nr, c, forWhite);
                        // double push
                        int startRow = forWhite ? 6 : 1;
                        if (r == startRow && board[nr + dir][c] == EMPTY) {
                            moves.add(new int[]{r, c, nr + dir, c, 0});
                        }
                    }
                    // captures
                    for (int dc : new int[]{-1, 1}) {
                        int nc = c + dc;
                        if (nc < 0 || nc > 7) continue;
                        if (nr >= 0 && nr < 8) {
                            int target = board[nr][nc];
                            if (target != EMPTY && isWhite(target) != forWhite) {
                                addPawnMove(moves, r, c, nr, nc, forWhite);
                            }
                            // en passant
                            if (enPassantTarget != null && nr == enPassantTarget[0] && nc == enPassantTarget[1]) {
                                moves.add(new int[]{r, c, nr, nc, 1});
                            }
                        }
                    }
                } else if (type == KNIGHT) {
                    int[][] deltas = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
                    for (int[] d : deltas) {
                        int nr = r + d[0], nc = c + d[1];
                        if (inBounds(nr, nc) && !sameColor(p, board[nr][nc]))
                            moves.add(new int[]{r, c, nr, nc, 0});
                    }
                } else if (type == BISHOP || type == QUEEN) {
                    int[][] dirs = {{-1,-1},{-1,1},{1,-1},{1,1}};
                    for (int[] d : dirs) slidingMoves(moves, r, c, d[0], d[1], p);
                    if (type == QUEEN) {
                        int[][] dirs2 = {{-1,0},{1,0},{0,-1},{0,1}};
                        for (int[] d : dirs2) slidingMoves(moves, r, c, d[0], d[1], p);
                    }
                } else if (type == ROOK || type == QUEEN) {
                    if (type == ROOK) {
                        int[][] dirs2 = {{-1,0},{1,0},{0,-1},{0,1}};
                        for (int[] d : dirs2) slidingMoves(moves, r, c, d[0], d[1], p);
                    }
                } else if (type == KING) {
                    for (int dr = -1; dr <= 1; dr++) for (int dc = -1; dc <= 1; dc++) {
                        if (dr == 0 && dc == 0) continue;
                        int nr = r + dr, nc = c + dc;
                        if (inBounds(nr, nc) && !sameColor(p, board[nr][nc]))
                            moves.add(new int[]{r, c, nr, nc, 0});
                    }
                    // Castling
                    if (forWhite && r == 7 && c == 4) {
                        if (castlingRights[0] && board[7][5]==EMPTY && board[7][6]==EMPTY && board[7][7]==(WHITE|ROOK))
                            moves.add(new int[]{7, 4, 7, 6, 2});
                        if (castlingRights[1] && board[7][3]==EMPTY && board[7][2]==EMPTY && board[7][1]==EMPTY && board[7][0]==(WHITE|ROOK))
                            moves.add(new int[]{7, 4, 7, 2, 3});
                    } else if (!forWhite && r == 0 && c == 4) {
                        if (castlingRights[2] && board[0][5]==EMPTY && board[0][6]==EMPTY && board[0][7]==(BLACK|ROOK))
                            moves.add(new int[]{0, 4, 0, 6, 2});
                        if (castlingRights[3] && board[0][3]==EMPTY && board[0][2]==EMPTY && board[0][1]==EMPTY && board[0][0]==(BLACK|ROOK))
                            moves.add(new int[]{0, 4, 0, 2, 3});
                    }
                }
            }
        }
        return moves;
    }

    static void addPawnMove(List<int[]> moves, int r, int c, int nr, int nc, boolean forWhite) {
        int promRow = forWhite ? 0 : 7;
        if (nr == promRow) {
            // generate promotion for all 4 pieces
            for (int promo : new int[]{QUEEN, ROOK, BISHOP, KNIGHT}) {
                moves.add(new int[]{r, c, nr, nc, 4 + promo}); // flag 4+type
            }
        } else {
            moves.add(new int[]{r, c, nr, nc, 0});
        }
    }

    static void slidingMoves(List<int[]> moves, int r, int c, int dr, int dc, int p) {
        int nr = r + dr, nc = c + dc;
        while (inBounds(nr, nc)) {
            int target = board[nr][nc];
            if (target == EMPTY) {
                moves.add(new int[]{r, c, nr, nc, 0});
            } else {
                if (!sameColor(p, target)) moves.add(new int[]{r, c, nr, nc, 0});
                break;
            }
            nr += dr; nc += dc;
        }
    }

    static boolean inBounds(int r, int c) { return r >= 0 && r < 8 && c >= 0 && c < 8; }

    // ─── Check detection ──────────────────────────────────────────────────────────
    static boolean isInCheck(boolean whiteKing) {
        // Find king position
        int kr = -1, kc = -1;
        for (int r = 0; r < 8; r++) for (int c = 0; c < 8; c++) {
            int p = board[r][c];
            if ((p & 7) == KING && isWhite(p) == whiteKing) { kr = r; kc = c; }
        }
        if (kr == -1) return true;
        // Check if any opponent pseudo-move attacks the king
        for (int[] m : pseudoMoves(!whiteKing)) {
            if (m[2] == kr && m[3] == kc) return true;
        }
        return false;
    }

    // ─── Apply / undo move ────────────────────────────────────────────────────────
    static int[] applyMove(int[] m) {
        // Returns captured piece for undo. We don't do full undo here—just apply.
        int fr = m[0], fc = m[1], tr = m[2], tc = m[3], flag = m[4];
        int piece = board[fr][fc];
        int captured = board[tr][tc];

        board[tr][tc] = piece;
        board[fr][fc] = EMPTY;

        if (flag == 1) { // en passant: remove captured pawn
            int capRow = fr; // captured pawn is on same row as moving pawn
            board[capRow][tc] = EMPTY;
        } else if (flag == 2) { // kingside castle
            board[tr][tc - 1] = board[tr][tc + 1]; board[tr][tc + 1] = EMPTY;
        } else if (flag == 3) { // queenside castle
            board[tr][tc + 1] = board[tr][tc - 2]; board[tr][tc - 2] = EMPTY;
        } else if (flag >= 4) { // promotion
            int promoType = flag - 4;
            int color = isWhite(piece) ? WHITE : BLACK;
            board[tr][tc] = color | promoType;
        }

        return new int[]{captured, fr, fc, tr, tc, flag, piece};
    }

    static void undoMove(int[] saved) {
        int captured = saved[0], fr = saved[1], fc = saved[2], tr = saved[3], tc = saved[4];
        int flag = saved[5], piece = saved[6];

        board[fr][fc] = piece;
        board[tr][tc] = captured;

        if (flag == 1) {
            int color = isWhite(piece) ? BLACK : WHITE;
            board[fr][tc] = color | PAWN;
            board[tr][tc] = EMPTY;
        } else if (flag == 2) {
            board[tr][tc + 1] = board[tr][tc - 1]; board[tr][tc - 1] = EMPTY;
        } else if (flag == 3) {
            board[tr][tc - 2] = board[tr][tc + 1]; board[tr][tc + 1] = EMPTY;
        }
    }

    // ─── Legal move filter ────────────────────────────────────────────────────────
    static List<int[]> legalMoves(boolean forWhite) {
        List<int[]> legal = new ArrayList<>();
        for (int[] m : pseudoMoves(forWhite)) {
            int[] saved = applyMove(m);
            boolean stillInCheck = isInCheck(forWhite);
            undoMove(saved);
            if (!stillInCheck) {
                // Castling: cannot pass through check
                if (m[4] == 2 || m[4] == 3) {
                    int midC = m[4] == 2 ? m[3] - 1 : m[3] + 1;
                    int[] passThroughMove = {m[0], m[1], m[0], midC, 0};
                    int[] s2 = applyMove(passThroughMove);
                    boolean check2 = isInCheck(forWhite) || isInCheck(forWhite);
                    undoMove(s2);
                    // also king can't be in check initially
                    if (isInCheck(forWhite)) continue;
                    if (check2) continue;
                }
                legal.add(m);
            }
        }
        return legal;
    }

    // ─── Parse algebraic move ────────────────────────────────────────────────────
    // Accepts: e2e4, e2-e4, e4 (pawn), Nf3, O-O, O-O-O, e8=Q etc.
    static int[] parseMove(String input, boolean forWhite) {
        input = input.trim().replaceAll("[+#!?]", "");
        List<int[]> legal = legalMoves(forWhite);

        // Castling
        if (input.equals("O-O") || input.equals("0-0")) {
            for (int[] m : legal) if (m[4] == 2) return m;
        }
        if (input.equals("O-O-O") || input.equals("0-0-0")) {
            for (int[] m : legal) if (m[4] == 3) return m;
        }

        // Long algebraic e2e4 or e2-e4
        String clean = input.replace("-", "");
        if (clean.length() >= 4 && clean.charAt(0) >= 'a' && clean.charAt(0) <= 'h') {
            String fromStr = clean.substring(0, 2);
            String toStr = clean.substring(2, 4);
            int[] from = parseSquare(fromStr);
            int[] to = parseSquare(toStr);
            if (from != null && to != null) {
                int promoType = -1;
                if (clean.length() >= 5) {
                    char pc = Character.toUpperCase(clean.charAt(clean.length() - 1));
                    promoType = "PNBRQK".indexOf(pc);
                    if (promoType >= 0) promoType = new int[]{PAWN,KNIGHT,BISHOP,ROOK,QUEEN,KING}[promoType];
                }
                for (int[] m : legal) {
                    if (m[0] == from[0] && m[1] == from[1] && m[2] == to[0] && m[3] == to[1]) {
                        if (m[4] >= 4) {
                            if (promoType < 0) promoType = QUEEN; // default
                            if ((m[4] - 4) == promoType) return m;
                        } else {
                            return m;
                        }
                    }
                }
                // try matching any promotion if none specified
                if (promoType < 0) {
                    for (int[] m : legal) {
                        if (m[0] == from[0] && m[1] == from[1] && m[2] == to[0] && m[3] == to[1] && m[4] >= 4 && (m[4]-4) == QUEEN)
                            return m;
                    }
                }
            }
        }

        return null; // couldn't parse
    }

    // ─── Update game state after move ────────────────────────────────────────────
    static void updateState(int[] m) {
        int fr = m[0], fc = m[1], tr = m[2], tc = m[3];
        int piece = board[tr][tc]; // already moved
        int type = piece & 7;

        // En passant target
        enPassantTarget = null;
        if (type == PAWN && Math.abs(tr - fr) == 2) {
            enPassantTarget = new int[]{(fr + tr) / 2, fc};
        }

        // Castling rights
        if (type == KING) {
            if (isWhite(piece)) { castlingRights[0] = false; castlingRights[1] = false; }
            else { castlingRights[2] = false; castlingRights[3] = false; }
        }
        if (fr == 7 && fc == 0) castlingRights[1] = false;
        if (fr == 7 && fc == 7) castlingRights[0] = false;
        if (fr == 0 && fc == 0) castlingRights[3] = false;
        if (fr == 0 && fc == 7) castlingRights[2] = false;
    }    
}
