package programming.injava.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Given an array and a window size, we are required to return an array of maximum elements for all the windows of given size
 * 
 * **/

public class SlidingWindowMax {

	private static List<Integer> findSlidingWindowMaxUsingHeap(int[] array, int k) {
	
		// Priority queue to keep larger element by index at head
		PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(); // In Java priority queue is used as heap based on comparision type to make max and min heap
		
		//List to keep adding max element of each window
		List<Integer> maxList = new ArrayList<Integer>();
		
		for(int i = 0; i <= (array.length - 1); i++) {
			
			// while queue is not empty and first element is out of window
			// To maintain element in desc order
			while(!maxHeap.isEmpty() && maxHeap.peek().getIndex() <= (i - k)) {
				maxHeap.remove();
			}
			
			// Now h
			maxHeap.add(new Pair(i, array[i]));
			
			// Add element to max if we have reached slide window of size k since i start from 0 and k =2 so i==1 will be window size of 2
			if(i >= k - 1) {
				maxList.add(maxHeap.peek().getValue());
			}
		}
		return maxList;
	}
	
	
	private static List<Integer> findSlidingWindowMaxUsingDll(int[] array, int k) {
		List<Integer> maxList = new ArrayList<Integer>();
		LinkedList<Pair> slideWindow = new LinkedList<Pair>(); // In Java we have LinkedList as doubly list
		
		for(int i = 0; i <= (array.length - 1); i++) { 
			
			// finding first element is in sliding window or not
			while(!slideWindow.isEmpty() && slideWindow.getFirst().getIndex() <= (i - k)) {
				slideWindow.remove();
			}
			
			// Maintain element in descending order
			while(!slideWindow.isEmpty() && slideWindow.getLast().getValue() < array[i])
				slideWindow.remove();
			
			slideWindow.add(new Pair(i, array[i]));
			
			if(i >= (k -1)) {
				maxList.add(slideWindow.getFirst().value);
			}
			
		}
		
		return maxList;
	}
	
	public static void main(String[] args) {
		System.out.println("Using heap: " + findSlidingWindowMaxUsingHeap(new int[] {1, 3, -1, -3, 5}, 3));
		System.out.println("Using DLL: " + findSlidingWindowMaxUsingDll(new int[] {1, 3, -1, -3, 5}, 3));
	}

}

@Data
@AllArgsConstructor
class Pair implements Comparable<Pair>{
	int index;
	int value;
	
	@Override
	public int compareTo(Pair pair) {
		// compare element value object2 - object1 for desc order here we have object1 = this and object2 = pair
		return pair.value - this.value;
	}
}