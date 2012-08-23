package com.algor.tread;

public class RunnableResource implements Runnable{
	
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
		RunnableResource th1 = new RunnableResource();
		RunnableResource th2 = new RunnableResource();
		
		new Thread(th1).start();
		new Thread(th2).start();
	}
	
	
	
}
