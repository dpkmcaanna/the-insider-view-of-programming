package programming.injava.string;
// Java Code for the above approach

import java.util.*;

class FindConsecutiveOnes {
	// Driver Code
	public static void main(String[] args)
	{
		int[] arr = { 1, 0, 1, 1, 0, 1, 0 };
		int K = 2;
		int N = arr.length;

		// Function call
		System.out.println(find_Max_Consecutive_Ones(arr, N, K));
	}

	// Function to find maximum length of
	// consecutive ones
	public static int find_Max_Consecutive_Ones(int[] arr, int n, int k)
	{

		int start = 0, end = 0, zeros = 0, ones = 0;
		int ans = 0;
		while (end < n) {
			if (arr[end] == 1)
				ones++;
			else
				zeros++;

			// Compressing window in case
			// required
			
			System.out.println("ones : " + ones + ", zeros: " + zeros);
			while (zeros > k) {
				if (arr[start] == 1)
					ones--;
				else
					zeros--;
				start++;
			}

			// Taking maximum of all possible
			// answers
			ans = Math.max(ans, ones);

			// Expanding window
			end++;
		}
		return ans;
	}
}
