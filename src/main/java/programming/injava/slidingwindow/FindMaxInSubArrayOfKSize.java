package programming.injava.slidingwindow;

import java.util.PriorityQueue;

/**
 * Function to print maximum element of  each window of size k.
 * 
 * */
public class FindMaxInSubArrayOfKSize {

	public static void main(String[] args) {
		int[] a = {5, -1, 0, 9, -4, 7, 1};
		
		findMaxInSubArrayOfKSizeV1(a, 3);
		
		a = new int[] {2, -3, 6, 6, -1, 7, -6, 8};
		
		findMaxInSubArrayOfKSizeV1(a, 4);
	}

	public static void findMaxInSubArrayOfKSizeV1(int[] a, int k) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (e1, e2) -> e2.compareTo(e1));
		
		int wSize = k;
		
		while(--wSize >= 0) {
			maxHeap.add(a[wSize]);
		}
		
		for(int i = k; i < a.length; i++) {
			System.out.print(maxHeap.peek() + " ");
			maxHeap.remove(a[i - k]);
			maxHeap.add(a[i]);
		}
		
		System.out.println(maxHeap.peek());
	}
}
