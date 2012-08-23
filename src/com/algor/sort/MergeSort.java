package com.algor.sort;

public class MergeSort {
		
	public static int[] merge(int[] A, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;

		int[] L = new int[n1+1];
		int[] R = new int[n2+1];

		for (int i = 0; i < n1; i++) {
			L[i] = A[p + i - 1];
		}

		for (int j = 0; j < n2; j++) {
			R[j] = A[q + j];
		}

		L[n1] = R[n2] = Integer.MAX_VALUE;

		int i = 0, j = 0;

		for (int k = p - 1; k < r; k++) {
			if (L[i] <= R[j]) {
				A[k] = L[i++];
			} else {
				A[k] = R[j++];
			}
		}

		return A;
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
		int[] A = { 12, 34, 443, 23,23, 134, 4, 3 };
		MergeSort.mergeSort(A, 1, A.length);

		for (int i : A) {
			System.out.print(i + ",");
		}

	}

}
