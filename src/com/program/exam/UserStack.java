package com.program.exam;

import java.util.ArrayList;
import java.util.List;

public class UserStack<T> {
	
	private List<T> stack;
	
	public UserStack(){
		stack = new ArrayList<T>();
	}
		
	public List<T> push(T ob){
		if(isFull()){
			System.out.println("The stack is full!");
		}else{
			stack.add(ob);
		}
		return stack;
	}
	
	public T pop(){
		if(isEmpty()){
			System.out.println("The stack is empty!");
			return null;
		}else{
			return stack.get(size()-1);
		}
	}
	
	public Integer size(){
		return stack.size();
	}
	
	public boolean isEmpty(){
		if(size()==0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull(){
		if(size() < 50){
			return false;
		}else{
			return true;
		}
	}
	
	public void print(){
		System.out.println(stack);
	}
	
	
	public static void main(String[] args) {
		UserStack<Integer> stack = new UserStack<Integer>();
		boolean empty = stack.isEmpty();
		System.out.println("The stack is empty:"+empty);
		boolean full = stack.isFull();
		System.out.println("The stack is full:"+full);
		Integer j = stack.pop();
		for(int i = 10; i< 61; i++){
			stack.push(i);
		}
		boolean full2 = stack.isFull();
		System.out.println("The stack is full:"+full2);
		System.out.println("The stack's size is "+stack.size());
		stack.print();
	}

}
