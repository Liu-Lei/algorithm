package com.algor.sort;

import com.util.Print;

public class MyQuickSort {

	public static int[] quickSort(int[] A, int p, int r){
		if(p < r){
			int q = partition(A, p, r);
			quickSort(A, p, q-1);
			quickSort(A, q+1, r);
		}
		return A;
	}
	
	public static int partition(int[] A, int p, int r){
		int x = A[r], temp = 0;
		int i = p - 1;
		
		for(int j = p; j < r; j++){
			if(A[j] >= x){
				++i;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		temp = A[r];
		A[r] = A[i+1];
		A[i+1] = temp;
		
		return i + 1;
	}
	
	public static void main(String[] args) {
		int[] intArray = {25,456,102,23,56,37,98,4,86,45};
		
		for(int a : quickSort(intArray, 0, intArray.length-1)){
			Print.print(a + ",");
		}
		
	}

}
