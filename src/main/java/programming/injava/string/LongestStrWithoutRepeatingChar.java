package programming.injava.string;

import java.io.*;
import java.util.Arrays;

class LongestStrWithoutRepeatingChar {
	
	public static int longestUniqueSubsttrV1(String str)
	{
		// if string length is 0
		if (str.length() == 0)
			return 0;

		// if string length 1
		if (str.length() == 1)
			return 1;

		// if string length is more than 2
		int maxLength = 0;
		boolean[] visited = new boolean[256];

		// left and right pointer of sliding window
		int left = 0, right = 0;
		while (right < str.length()) {

			// if character is visited
			if (visited[str.charAt(right)]) {

				// The left pointer moves to the right while marking visited characters as false until 
				// the repeating character is no longer part of the current window.
				while (visited[str.charAt(right)]) {

					visited[str.charAt(left)] = false;
					left++;
				}
			}

			visited[str.charAt(right)] = true;

			// The length of the current window (right - left + 1) is calculated and answer is updated accordingly.
			maxLength = Math.max(maxLength, (right - left + 1));
			right++;
		}
		return maxLength;
	}
	
	static int longestUniqueSubsttrV2(String str)
    {
        int n = str.length();
 
        int res = 0; // result
 
        // last index of all characters is initialized as -1
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
 
        // Initialize start of current window
        int i = 0;
 
        // Move end of current window
        for (int j = 0; j < n; j++) {
 
            // Find the last index of str[j] Update i (starting index of current window) as maximum of 
        	// current value of i and last index plus 1
            i = Math.max(i, lastIndex[str.charAt(j)] + 1);
 
            // Update result if we get a larger window
            res = Math.max(res, j - i + 1);
 
            // Update last index of j.
            lastIndex[str.charAt(j)] = j;
        }
        return res;
    }

	// Driver code
	public static void main(String[] args)
	{
		String str = "geeksforgeeks";
		System.out.println("The input string is " + str);

		int len = longestUniqueSubsttrV1(str);
		System.out.println("The length of the longest non-repeating character substring is " + len);
		
		len = longestUniqueSubsttrV2(str);
		System.out.println("The length of the longest non-repeating character substring is " + len);
	}
}
