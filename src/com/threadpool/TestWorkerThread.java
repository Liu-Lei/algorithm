package com.threadpool;

public class TestWorkerThread implements Runnable {
	static private int count = 0;
	private int taskNumber;
	protected Done done;

	/**
	 * 
	 * @param done
	 */
	TestWorkerThread() {
		count++;
		taskNumber = count;
	}

	public void run() {
		for (int i = 0; i < 100; i += 2) {
			System.out.println("Task number: " + taskNumber
					+ ",percent complete = " + i);
			try {
				Thread.sleep((int) (Math.random() * 500));
			} catch (InterruptedException e) {
			}
		}
	}
}