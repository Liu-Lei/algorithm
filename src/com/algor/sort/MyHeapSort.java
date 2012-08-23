package com.algor.sort;

import com.util.Print;

public class MyHeapSort {

	public static int[] HeapSort(int[] A){
		
		int heapSize = A.length;
		
		BuildMaxHeap(A,heapSize);
		
		for(int i = A.length-1; i > 0; i--){
			A[0] = A[0]+A[i];
			A[i] = A[0]-A[i];
			A[0] = A[0]-A[i];
			
			--heapSize;
			maxHeapify(A, 0, heapSize);
		}
		return A;
	}
	
	public static void BuildMaxHeap(int[] A, int heapSize){
		for(int i = heapSize/2; i > 0; i--){
			maxHeapify(A,i-1,heapSize);
		}
	}
	
	public static void maxHeapify(int[] A, int i, int heapSize){
		int left = i*2+1;
		int right = left+1;
		int largest = i;

		if(left < heapSize && A[left] > A[i]){
			largest = left;
		}
		
		if(right < heapSize && A[right] > A[largest]){
			largest = right;
		}
		
		if(largest != i){
			//exchange x and y
			A[i] = A[i]+A[largest];
			A[largest] = A[i]-A[largest];
			A[i] = A[i] - A[largest];
			maxHeapify(A,largest,heapSize);
		}
		
	}
	
	public static void main(String[] args) {
		int[] intArray = {25,456,102,23,56,37,98,4,86,45};	
		
		HeapSort(intArray);
		
		for(int i : intArray){
			Print.print(i+",");
		}
	}

}
