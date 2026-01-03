package programming.injava.list;
public class Solution {
    public static long findMinIncrease(int[] threadSize) {
        int n = threadSize.length;
        long[] dp = new long[n];  // Array to hold the minimum increase for each segment

        // Base case: no increase needed for the first segment
        dp[0] = 0;

        // Iterate through the segments
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1];  // Initially, take the previous value
            
            // If we can make segment i-1 special
            if (i > 1) {
                // Calculate what is needed to make segment i special
                long increase = 0;
                if (threadSize[i - 1] > threadSize[i] || threadSize[i] <= threadSize[i + 1]) {
                    // If current i-1 isn't special, we need to increase
                    increase = Math.max(0, threadSize[i + 1] - threadSize[i - 1] + 1);
                    increase += Math.max(0, threadSize[i - 1] - threadSize[i] + 1);
                }

                // Update dp[i] if we can increase to make it special
                dp[i] = Math.min(dp[i], dp[i - 2] + increase);
            }
        }

        // Calculate the minimum increase for the whole array
        long totalIncrease = 0;
        for (int i = 0; i < n; i++) {
            totalIncrease += dp[i];
        }

        return totalIncrease;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] threadSize1 = {3, 2, 1, 2, 3};
        System.out.println(findMinIncrease(threadSize1));  // Output: 4

        // Sample Test Case 2
        int[] threadSize2 = {2, 3, 4, 5};
        System.out.println(findMinIncrease(threadSize2));  // Output: 2
        
        // Sample Test Case 3
        int[] threadSize3 = {3, 1, 4, 5, 5, 2};
        System.out.println(findMinIncrease(threadSize3));  // Output: 3
    }
}
