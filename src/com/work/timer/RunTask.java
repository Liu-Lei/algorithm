package com.work.timer;

import java.util.TimerTask;

import com.util.Print;

public class RunTask extends TimerTask {

	@Override
	public void run() {
		Print.println("Hello, timer task!");
	}

}
