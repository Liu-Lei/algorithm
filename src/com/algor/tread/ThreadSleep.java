package com.algor.tread;

public class ThreadSleep implements Runnable{
	
	@Override
	public void run() {
		for(int i = 0; i < 13; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
	public static void main(String[] args){
		ThreadSleep tj = new ThreadSleep();
        Thread demo = new Thread(tj,"Ïß³Ì");
        demo.start();
	}
	
	
	
}
