package com.algor.test;

import com.util.Print;

public class AllSort {
	
	public static void main(String[] args){
		int[] A = {2,3,4};
		
		for(int a : A){
			for(int b : A){
				for(int c : A){
					Print.print(a+""+b+""+c+",");
				}
			}
		}
		
	}
	
	
	
}
