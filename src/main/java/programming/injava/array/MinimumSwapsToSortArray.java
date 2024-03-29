package programming.injava.array;

import java.util.*;

public class MinimumSwapsToSortArray {

	public static int minSwaps(int[] arr) {
		int n = arr.length;
		int swaps = 0;

		// Create a map to store the original indices of elements
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			indexMap.put(arr[i], i);
		}

		// Sort the array in ascending order
		Arrays.sort(arr);

		// Create a visited array to keep track of visited nodes
		boolean[] visited = new boolean[n];

		// Iterate through the array
		for (int i = 0; i < n; i++) {
			// If the element is already visited or in its correct position
			if (visited[i] || indexMap.get(arr[i]) == i) {
				continue;
			}

			int cycleSize = 0;
			int j = i;

			// Traverse the cycle and mark nodes as visited
			while (!visited[j]) {
				visited[j] = true;
				j = indexMap.get(arr[j]);
				cycleSize++;
			}

			// Add the number of swaps needed to sort the current cycle
			if (cycleSize > 0) {
				swaps += (cycleSize - 1);
			}
		}

		return swaps;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 1, 2 };
		int minSwaps = minSwaps(arr);
		System.out.println("Minimum number of swaps needed: " + minSwaps); // Output: 2
	}
}
