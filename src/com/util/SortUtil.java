package com.util;

public class SortUtil {
	
	public static void exchange(Integer a, Integer b){
		a = a + b;
		b = a - b;
		a = a - b;
	}
	
	public static void main(String[] args){
		Integer a = 3;
		Integer b = 6;
		
		SortUtil.exchange(a, b);
		
		Print.println(a);
		Print.println(b);
		
	}
	
}
