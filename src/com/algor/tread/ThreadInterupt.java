package com.algor.tread;

import com.util.Print;

public class ThreadInterupt implements Runnable{
	
	@Override
	public void run() {
		Print.println("线程开始执行");
			try {
				Print.println("线程开始休眠");
				Thread.sleep(10000);
				Print.println("线程休眠结束");
			} catch (InterruptedException e) {
				Print.println("休眠被打断");
				return;
			}
			Print.println("线程正常结束");
	}
	
	public static void main(String[] args){
		ThreadInterupt tj = new ThreadInterupt();
        Thread demo = new Thread(tj,"线程");
        demo.start();
        try {
        	Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        demo.interrupt();
	}
	
	
	
}
