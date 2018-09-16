package com.nagarro.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	
	public static void main(String arg[]) throws SQLException{
		Connection con = null;
		Statement stmnt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","admin");
			stmnt = con.createStatement();
			System.out.println("Connection established...");
			System.out.println(stmnt.executeUpdate("insert into user(u_id,u_name) values(3,'bhavneesh');"));
//			while(rs.next()) {
//				System.out.println(rs.getInt("u_id")+" "+rs.getString("u_name"));
//			}

		}catch(Exception ex) {
			ex.printStackTrace();
		} finally{
			stmnt.close();
			con.close();
		}
		
		
	}

}
