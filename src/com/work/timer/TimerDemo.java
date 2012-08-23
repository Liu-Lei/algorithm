package com.work.timer;

import java.util.Date;
import java.util.Timer;

public class TimerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer timer = new Timer("TIMER-THREAD");
		timer.scheduleAtFixedRate(new RunTask(), new Date(), 1000);
	}

}
