package programming.injava.array;

import java.util.Arrays;

class SortBinaryArray {
	
	// Function to sort a binary array in linear time
	public static void sortV1(int[] A) {
		int pivot = 1;
		int j = 0;

		// each time we encounter a 0, `j` is incremented, and
		// 0 is placed before the pivot
		for (int i = 0; i < A.length; i++) {
			if (A[i] < pivot) {
				swap(A, i, j);
				j++;
			}
		}
	}

	public static void sortV2(int[] A) {
		
		// `k` stores index of next available position
		int k = 0;

		// do for each element
		for (int i : A) {
			// if the current element is zero, put 0 at the next free
			// position in the array
			if (i == 0) {
				A[k++] = 0;
			}
		}

		// fill all remaining indices by 1
		for (int i = k; i < A.length; i++) {
			A[k++] = 1;
		}
	}

	// Utility function to swap elements at two indices in the given array
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		int[] A = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };

		sortV1(A);

		// print the rearranged array
		System.out.println(Arrays.toString(A));
	}
}