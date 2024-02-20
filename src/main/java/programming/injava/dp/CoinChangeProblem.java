package programming.injava.dp;

import java.util.Arrays;

/**
 * 
 * **/
public class CoinChangeProblem {
	
	public static void main(String[] args) {
		
		int[] coins = new int[]  {1, 2, 3};
		int sum = 5;
		
		System.out.println("Input -> coins={1, 2, 3}, amount=5, minimum coin to change: " +  findMinimumNumberOfCoinV1(coins, sum));
	
		sum = 4;
		
		int[][] dp = new int[coins.length + 1][sum + 1];
		
		for (int[] row : dp)
            Arrays.fill(row, -1);
		
		int totalNoWay = findNoWayToMakeChange(coins, 3, sum, dp);
		
		//{1, 1, 1, 1}, {1, 1, 2}, {2, 2}, {1, 3}. 
		System.out.println("Total no way to change is: " + totalNoWay); 
		
		
		int[] memo = new int[sum + 1];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		int minNoCoin = findMinimumNumberOfCoinV2(sum, coins, memo);
		
		System.out.println("Input -> coins={1, 2, 3}, amount=5, minimum coin to change: " +  minNoCoin);
	}

	private static int findMinimumNumberOfCoinV1(int[] coins, int amount) {
		int totalCoin = coins.length;
		int[][] dp = new int [totalCoin + 1][amount + 1];
		
		for(int i = 0; i <= totalCoin; i++) {
			for(int j = 0; j <= amount; j++ ) {
				if(j == 0)
					dp[i][j] = 0;
				else if(i == 0)
					dp[i][j] = Integer.MAX_VALUE;
				else if(coins[i-1] > j) //if amount is less than coin
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = Integer.min(1 + dp[i][j - coins[i-1]], dp[i-1][j]);
			}
		}
		return dp[totalCoin][amount] > Integer.MAX_VALUE ? -1 : dp[totalCoin][amount];
	}
	
	/**
	 * Will use recursive call with memorisation
	 * 
	 * Find no of way a sum can be made using unlimited times of given coins
	 * */
	private static int findNoWayToMakeChange(int[] coins, int n, int sum, int[][] dp) {
		
		if(sum == 0) { //if there is no target sum then only one way to make change by not selecting the coins
			return dp[n][sum] = 1;
		}
		
		if(n == 0 || sum < 0) { //if there is no coin so no way to make change
			return 0;
		}
		
		if(dp[n][sum] != -1) {
			return dp[n][sum];
		}
		
		return dp[n][sum] = findNoWayToMakeChange(coins, n, (sum - coins[n - 1]), dp) 
				+  findNoWayToMakeChange(coins, n - 1, sum, dp);
	}
	
	private static int findMinimumNumberOfCoinV2(int n, int[] coins, int[] memo) {
		if(n == 0) return 0;
		
		if(memo[n] != -1) return memo[n];
		
		int ans = Integer.MAX_VALUE;
		
		for(int coin : coins) {
			if(n >= coin) {
				int subAns = 0;
				if(memo[n - coin] != -1) {
					subAns = 1 + memo[n - coin];
				} else {
					subAns = 1 + findMinimumNumberOfCoinV2((n - coin), coins, memo);
				}
				ans = Math.min(ans, subAns);
			}
		}
		
		memo[n] = (ans == Integer.MAX_VALUE) ? -1 : ans;
		return ans;
	}
}
