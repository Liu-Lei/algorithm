package com.algor.sort;

public class MergeSort2 {

	public static int[] merge(int[] A, int p, int q, int r) {
		int i = p, j = q + 1, k = 0;
		int[] tmp = new int[r - p + 1];

		while (i <= q && j <= r) {
			if (A[i] <= A[j]) {
				tmp[k] = A[i++];
			} else {
				tmp[k] = A[j++];
			}
			k++;
		}
		
		while (i <= q) {
			tmp[k++] = A[i++];
		}
		while (j <= r) {
			tmp[k++] = A[j++];
		}
		for (i = 0; i < k; i++) {
			A[p + i] = tmp[i];
		}
		return tmp;
	}

	public static int[] mergeSort(int[] A, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(A, p, q);
			mergeSort(A, q + 1, r);
			merge(A, p, q, r);
		}
		return A;
	}

	public static void main(String[] args) {
		int[] A = { 12, 34, 443, 23, 23, 134, 4, 3 };
		int[] B = MergeSort2.mergeSort(A, 0, A.length-1);
		
		for (int i : B) {
			System.out.print(i + ",");
		}

	}

}
