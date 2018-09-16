package com.nagarro.ds_algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkedList {

	private Node head;
	private Node tail;
	private Node pointer;
	private int size = 0;

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public int getSize() {
		return size;
	}

	public void addNode(Node node) {
		if (isEmpty()) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
			tail.data = node.data;
		}
		size++;
	}

	public boolean isEmpty() {
		if (head == null && tail == null) {
			return true;
		}
		return false;
	}

	public boolean removeFromHead() {
		if (isEmpty())
			return false;
		head = head.next;
		size--;
		return true;
	}

	public void reverse() {
		if (isEmpty())
			throw new ListEmptyException("ListEmptyException");

		Node prevNode = null;
		Node pointer = head;
		Node nextNode = null;

		while (pointer != null) {
			nextNode = pointer.next;
			pointer.next = prevNode;
			prevNode = pointer;
			pointer = nextNode;
		}
		head = prevNode;
	}

	public boolean removeNode(Node node) {
		if (isEmpty())
			return false;
		if (node.data == head.data) {
			head = head.next;
			size--;
		}
		pointer = head;
		Node prevNode = pointer;
		while (pointer != null) {
			if (pointer.data == node.data) {
				prevNode.next = pointer.next;
				size--;
			}
			prevNode = pointer;
			pointer = pointer.next;
		}
		pointer = null;
		return true;
	}

	public void values() {
		if (isEmpty()) {
			throw new ListEmptyException("ListEmptyException");
		}
		pointer = head;
		while (pointer != null) {
			System.out.println(pointer.data);
			pointer = pointer.next;
		}
		pointer = null;
	}

	public void getMiddleNode() {
		if (isEmpty()) {
			throw new ListEmptyException("ListEmptyException");
		}
		Node slowPointer = head;
		Node fastPointer = head;
		while (fastPointer != null) {
			if (size % 2 == 0) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;
			} else {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;
				if (fastPointer.next == null) {
					break;
				}
			}
		}
		System.out.println(slowPointer.data);
	}

	public static void main(String[] arg) {

		LinkedList l = new LinkedList();
		for (int i = 1; i <= 7; i++) {
			Node newNode = new Node(i);
			l.addNode(newNode);
		}
		System.out.println(l.head.data);
		l.getMiddleNode();

	}

}
