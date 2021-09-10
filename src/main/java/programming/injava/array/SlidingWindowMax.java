package programming.injava.array;

import java.util.ArrayList;
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
	
		PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>();
		List<Integer> maxList = new ArrayList();
		
		for(int i = 0; i <= (array.length - 1); i++) {
			while(!maxHeap.isEmpty() && maxHeap.peek().getIndex() <= (i - k)) {
				maxHeap.remove();
			}
			
			maxHeap.add(new Pair(i, array[i]));
			
			if(i >= k - 1) {
				maxList.add(maxHeap.peek().getValue());
			}
		}
		return maxList;
	}
	
	public static void main(String[] args) {
		
		System.out.println(findSlidingWindowMaxUsingHeap(new int[] {1, 3, -1, -3, 5}, 3));
	}

}

@Data
@AllArgsConstructor
class Pair implements Comparable<Pair>{
	int index;
	int value;
	
	@Override
	public int compareTo(Pair pair) {
		return pair.value - this.value;
	}
}