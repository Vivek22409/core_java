package com.nagarro.ds_algorithms;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class Node{
	 int data;
	 Node left,right;
	
	public Node(int data) {
		this.data=data;
		left=right=null;
	}
}

public class TreeDemo {
	public static void main(String arg[]) {
		Node root = new Node(5);
		Node ln = new Node(3);
		root.left = ln;
		Node rn = new Node(7);
		root.right = rn;
		Node lln = new Node(2);
		ln.left = lln;
		Node lrn = new Node(4);
		ln.right = lrn;
		Node rrn = new Node(8);
		rn.right = rrn;
		Node rln = new Node(6);
		rn.left = rln;
		int counter = 0;
		Stack<Node> stackOfNodes = new Stack<>();
		stackOfNodes.push(root);
		
		//Queue<Node> q = new LinkedBlockingQueue<>();
		
		
		/*Node myNode = root;
		q.add(myNode);*/
		
		/*while(q.isEmpty()==false) {
			Node node = q.peek();
			System.out.println(node.data);
			if(node.left!=null)
			q.add(node.left);
			if(node.right!=null)
			q.add(node.right);
			q.poll();					
		}*/
		
		
		
		while(stackOfNodes.isEmpty()==false) {
			Node n = stackOfNodes.peek();
			System.out.println(n.data);
			stackOfNodes.pop();
			if(n.right!=null)
			stackOfNodes.push(n.right);
			if(n.left!=null)
			stackOfNodes.push(n.left);
			counter++;
		}
		System.out.println("*"+counter);
		//recursive(root);		
	}
	public static void recursive(Node root) {
		if(root==null)
			return;
		
		recursive(root.left);
		System.out.println(root.data+"*");
		recursive(root.right);
	}
}
