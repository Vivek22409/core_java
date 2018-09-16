package com.nagarro.basic;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedListDemo {
	public static void main(String arg[]) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		Node n = n1;
		
		while(n!=null) {
			System.out.println(n.data);
			n=n.next;
		}
		
		Node pre = null;
		Node curr = n1;
		Node nxt = null;
		
		while(curr!=null) { // null 1 2 3
			nxt = curr.next;			
			curr.next= pre;				
			pre = curr;	
			curr = nxt;
		}
		
		Node root = pre;
		while(root!=null) {
			System.out.println(root.data);
			root=root.next;
		}
		
	}
}
