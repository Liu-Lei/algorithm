package com.algor.sort;

import com.util.Print;

public class Bubble {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {1,4,5,6,5,8,3,4,8,34,34,454,2};
		int[] sortArray = bubble(array);
		for(int i = 0; i < sortArray.length; i++){
			Print.print(sortArray[i]+" ");
		}
	}
	
	public static int[] bubble(int[] array){
		int length = array.length;
		for(int i = 0; i < length; i++){
			for(int j = i+1; j < length; j++){
				if(array[i] > array[j]){
					array[i] = array[i] + array[j];
					array[j] = array[i] - array[j];
					array[i] = array[i] - array[j];
				}
			}
		}
		return array;
	}
	

}
