package com.algor.tread;

public class HelloRunnable implements Runnable{
	
	private String name;

	public HelloRunnable(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++){
			System.out.println(name + " run " + i);
		}
	}
	
	public static void main(String[] args){
		HelloRunnable ru1 = new HelloRunnable("A");
		HelloRunnable ru2 = new HelloRunnable("B");
		Thread th1 = new Thread(ru1);
		Thread th2 = new Thread(ru2);
		
		th1.start();
		th2.start();
	}
	
	
	
}
