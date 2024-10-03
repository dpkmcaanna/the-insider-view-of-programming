package programming.injava.hankerrank;

import java.util.Arrays;


public class DeliverProjectFeature {

    public static int getMinTime(int[] developmentTime, int[] integrationTime) {
        // Number of features
        int n = developmentTime.length;

        // Sort the features based on development time in descending order
        int[][] features = new int[n][2];
        for (int i = 0; i < n; i++) {
            features[i][0] = developmentTime[i];
            features[i][1] = integrationTime[i];
        }

        // Sort by development time (descending)
        Arrays.sort(features, (a, b) -> b[0] - a[0]);

        // Track the cumulative integration time
        int cumulativeIntegrationTime = 0;
        int minTime = 0;

        // Check for each feature if it is better to integrate or develop
        for (int i = 0; i < n; i++) {
            // Update cumulative integration time
            cumulativeIntegrationTime += features[i][1];

            // The minimum time is either the maximum development time or the cumulative integration time
            minTime = Math.max(minTime, Math.min(cumulativeIntegrationTime, features[i][0]));
        }

        return minTime;
    }

    public static void main(String[] args) {
        // Sample Test Case 1
        int[] developmentTime = {1, 5, 7, 2};
        int[] integrationTime = {1, 1, 3, 3};

        // Expected output is 4
        System.out.println(getMinTime(developmentTime, integrationTime));
        
        int[] developmentTime1 = {10, 12, 13, 8, 15};
        int[] integrationTime1 = {1, 2, 1, 1, 1};
        
        // Expected output is 6
        System.out.println(getMinTime(developmentTime1, integrationTime1));
        
        int[] developmentTime2 = {3, 4, 5, 9};
        int[] integrationTime2 = {3, 2, 5, 5};
        
        // Expected output is 5
        System.out.println(getMinTime(developmentTime2, integrationTime2));
    }
}
