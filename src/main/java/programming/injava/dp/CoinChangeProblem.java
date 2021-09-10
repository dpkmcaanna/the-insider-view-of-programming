package programming.injava.dp;

/**
 * 
 * **/
public class CoinChangeProblem {

	private static int coinChange(int[] coins, int amount) {
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
	
	public static void main(String[] args) {
		System.out.println("Input -> coins={1, 2, 3}, amount=5, minimum coin to change: " +  coinChange(new int[] {1, 2, 3}, 5));
	}

}
