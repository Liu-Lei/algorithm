package com.algor.sort;

import com.util.Print;

public class DividFind {

	public static void find(int[] A, int p, int r, int findNum){
		if(findNum == A[p]){
			Print.println("The number have fond,the index is " + p);
			return;
		}
		if(p == r){
			Print.println("The number have not fond, the index is " + p);
		}
		
		if(p < r){
			int q = (p + r) / 2;
			if(A[q] > findNum){
				find(A,p,q,findNum);
			}else if(A[q] < findNum){
				find(A,q+1,r,findNum);
			}else{
				Print.println("The number have fond,the index is " + q);
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] A = { 3,4,12,23,23,34,134,443};
	//	MergeSort.mergeSort(A, 1, A.length);
		
		DividFind.find(A, 0, A.length-1, 33);
	}

}
