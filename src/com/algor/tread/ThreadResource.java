package com.algor.tread;

public class ThreadResource extends Thread{
	
	private int count =  5;

	@Override
	public void run() {
		for(int i = 0; i < 7; i++){
			if(count > 0){
				System.out.println("count = " + count--);
			}
		}
	}
	
	public static void main(String[] args){
		Thread th1 = new ThreadResource();
		Thread th2 = new ThreadResource();
		
		th1.start();
		th1.start();
	}
	
	
	
}
