package com.threadpool;

public class TestThreadPool {

	/**
	 * Main entry point.
	 * 
	 * @param args
	 *            No arguments are used.
	 */
	public static void main(String args[]) {
		ThreadPool pool = new ThreadPool(10);

		for (int i = 1; i < 25; i++) {
			pool.assign(new TestWorkerThread());
		}

		pool.complete();

		System.out.println("All tasks are done.");
	}
}
