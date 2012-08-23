package com.algor.test;

public class ArrayReverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1,4,5,6,5,8,3,4,8,34,34,454,2};
		int[] reverse = reverse(array);
		for(int i = 0; i < reverse.length; i++){
			System.out.print(reverse[i]+" ");
		}
	}
	
	public static int[] reverse(int[] array){
		int length = array.length;
//		for(int i = 0; i < length/2; i++){
			//两值互换
//			int temp = array[i];
//			array[i] = array[length-i-1];
//			array[length-i-1] = temp;
//		}
		
		for(int i = 0; i < length/2; i++){
			//两值互换
			array[i] = array[i] + array[length-i-1];
			array[length-i-1] = array[i] - array[length-i-1];
			array[i] = array[i] - array[length-i-1];
		}
		
		return array;
	}
	

}
