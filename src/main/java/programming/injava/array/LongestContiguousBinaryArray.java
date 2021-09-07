package programming.injava.array;

import java.util.HashMap;
import java.util.Map;

/**
 * {1, 0, 1, 1, 0, 0, 1}
 *  1, 0, 1, 2, 1, 0, 1  = sum 
 **/
public class LongestContiguousBinaryArray {

	private static int findLengthOfLongestSubArray(int[] array) {
		if (array.length == 0)
			return 0;

		// To cache index of calculated sum
		Map<Integer, Integer> indexOfSum = new HashMap<Integer, Integer>();

		int longest_subArray = 0, sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			sum += (array[i] == 0 ? -1 : 1);

			//Case 1: if sum become zero then we have equal number of zero and one
			if (sum == 0) {
				if (longest_subArray < i + 1)
					longest_subArray = i + 1;
			} else if (indexOfSum.containsKey(sum)) { //Case 2: if previously has the sum then we have equal number of zero and one between current index and previous sum's index
				if (i - indexOfSum.get(sum) > longest_subArray) {
					longest_subArray = i - indexOfSum.get(sum);
				}
			} else { // Case 3: if a new sum found put in hashmap
				indexOfSum.put(sum, i);
			}
		}
		return longest_subArray;
	}

	public static void main(String[] args) {
		System.out.println(findLengthOfLongestSubArray(new int[] {1, 1}));
		System.out.println(findLengthOfLongestSubArray(new int[] {1, 1, 0}));
		System.out.println(findLengthOfLongestSubArray(new int[] {1, 1, 0, 0}));
		System.out.println(findLengthOfLongestSubArray(new int[] {1, 1, 0, 1, 0, 1}));
		System.out.println(findLengthOfLongestSubArray(new int[] {1, 0, 1, 1, 0, 0, 1}));
	}

}
