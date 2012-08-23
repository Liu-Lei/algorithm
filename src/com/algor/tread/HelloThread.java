package com.algor.tread;

public class HelloThread extends Thread{
	
	private String name;

	public HelloThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++){
			System.out.println(name + " run " + i);
		}
	}
	
	public static void main(String[] args){
		Thread th1 = new HelloThread("A");
		Thread th2 = new HelloThread("V");
		
		th1.start();
		th2.start();
	}
	
}
