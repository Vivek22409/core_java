package com.nagarro.collections;

class CustomStackException extends Exception{	
	private static final long serialVersionUID = 1L;

	CustomStackException(String msg){
		super(msg);
	}
}

public class Stack {
	private final int SIZE_MAX=10;
	private int top =-1;
	private int[] stack = new int[SIZE_MAX];

	public boolean isEmpty(){
		boolean status = false;
		if(top==-1){
			status = true;
		}
		return status;
	}
	public boolean isFull(){
		boolean status = false;
		if(top==(SIZE_MAX-1)){
			status = true;
		}
		return status;
	}
	public void push(int num) throws CustomStackException{
		if(isFull()){
			throw new CustomStackException("StackFullException...");
		} else {
			stack[++top] = num;	
		}
	}
	public int pop() throws CustomStackException{
		int result = 0;
		if(isEmpty()){
			throw new CustomStackException("StackEmptyException...");
		} else {
			result =  stack[top--];
		}
		return result;
	}
	public int peek() throws CustomStackException{
		int result = 0;
		if(isEmpty()){
			throw new CustomStackException("StackEmptyException...");
		} else {
			result =  stack[top];
		}
		return result;
	}
	

	public static void main(String arg[]) throws CustomStackException{
		Stack st = new Stack();	
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
		st.push(6);
		st.push(7);
		st.push(8);
		st.push(9);
		st.push(10);
		st.push(11);
		//st.push(12);
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.peek());
		System.out.println(st.pop());
		//System.out.println(st.pop());

	}

}


