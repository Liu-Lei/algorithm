package com.algor.test;

public class TestIfElse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer freq = 0;
		Integer format = getFormatFreq(freq);
		System.out.println(format);

	}
	
	private static Integer getFormatFreq(Integer freq) {
	      Integer formatFreq = 0;
	      if(freq >= 30000){
	          formatFreq = 6;
	      }else if(freq>= 10000 && freq < 30000){
	          formatFreq = 5;
	      }else if(freq >= 1000 && freq < 1000){
	          formatFreq=4;
	      }else if(freq >= 100 && freq < 1000){
	          formatFreq = 3;
	      }else if (freq >= 10 && freq < 100){
	          formatFreq = 2;
	      }else if(freq >=0 && freq < 10){
	          formatFreq = 1;
	      }
	      return formatFreq;
	  }

}
