package com.password.test;

import com.util.Print;

public class MathRandom {

	/**
	 * math .random
	 */
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		long test1 = 0;
		long test0 = 0;
		long length = 10000000;
		for(long i = 0; i < length; i++){
			if(Math.round(Math.random()) == 1){
				test1 += 1;
			}else{
				test0 += 1;
			}
		}
		Print.println("1 count = " + test1);
		Print.println("0 count = " + test0);
		Print.println("the % of 1 is " + (float)((float)test1/(float)length));
		long endTime = System.currentTimeMillis();
		Print.println("The program cost time : "+ (endTime-startTime) + " mill seconds");
	}

}
