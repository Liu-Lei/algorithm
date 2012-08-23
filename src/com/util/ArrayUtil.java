package com.util;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
	
	//print the data that in arr1 and not in arr2
	public static List<String> twoArrayDiffData(String[] arr1,String[] arr2){
		Integer arr1Length = arr1.length;
		Integer arr2Length = arr2.length;
		List<String> returnArr = new ArrayList<String>();
		boolean flag = false;
		for(int i = 0; i< arr1Length; i++){
			flag = false;
			for(int j = 0; j < arr2Length; j++){
				if(arr2[j].equals(arr1[i])){
					flag = true;
				}
			}
			if(!flag){
				returnArr.add(arr1[i]);
			}
		}
		return returnArr;
	}
}
