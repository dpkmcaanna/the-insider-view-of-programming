package programming.injava.dp;

import java.util.List;

/**
 * Given a binary matrix of 0s and 1s write an algorithm to find out the maximum size squre sub matrix with all 1s.
 * Return the length of the side.
 * 
 * **/
public class FindMaximumSubSqure {

	public static void main(String[] args) {
		List<List<Integer>> matrix = List.of(
				List.of(0, 1, 1, 0, 1),
				List.of(1, 1, 0, 1, 0),
				List.of(0, 1, 1, 1, 0),
				List.of(1, 1, 1, 1, 0),
				List.of(1, 1, 1, 1, 1),
				List.of(0, 0, 0, 0, 0));
		
		int len = findLengthOfMaximumBinarySubSquare(matrix);
		
		System.out.println("\n\n========= Side of max sub binary matrix with 1's ========= \n " + len);
		
		
		len = findMaxSubBinraySqure(matrix);
		
		System.out.println("\n\n========= Side of max sub binary matrix with 1's ========= \n " + len);
		
	}
	
	static int findMaxSubBinraySqure(List<List<Integer>> matrix) {
		int row = matrix.size();
		int col = matrix.get(0).size();
		
		System.out.printf("Row: %s and column: %s\n", row, col);
		
		int dp[][] = new int[row][col];
		
		int max = 0;
		int max_i = 0, max_j = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = matrix.get(i).get(j);
				} else {
					if(matrix.get(i).get(j) == 0) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = Integer.min(Integer.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]) + 1;
					}
					//max = Integer.max(max, dp[i][j]);
					if(dp[i][j] > max) {
						max = dp[i][j];
						max_i = i;
						max_j = j;
					}
				}
			}
		}
		
		for(int k = max_i - max +1; k <= max_i; k++) {
			for(int m = max_j - max+1; m <= max_j; m++) {
				System.out.print(matrix.get(k).get(m));
			}
			System.out.println();
		}
		
		return max;
	}
	
	static int findLengthOfMaximumBinarySubSquare(List<List<Integer>> matrix) {
		int row = matrix.size();
		int col = matrix.get(0).size();
		
		int maxSqureLen = 0;
		
		int[][] mem = new int[row][col];
		
		if(row == 1 && col == 1) {
			return 1;
		}
		
		int max_i = 0, max_j = 0;
		for(int i = 1; i < row; i++) {
			for(int j = 1; j <  col; j++) {
				if(matrix.get(i - 1).get(j - 1) == 1)
					mem[i][j] = Integer.min(Integer.min(mem[i - 1][j], mem[i][j - 1]), mem[i -1][j - 1]) + 1;
				
				if(mem[i][j] > maxSqureLen) {
					maxSqureLen = mem[i][j]; // calculate size of sub matrix
					max_i = i; // memorizing row index of sub matix
					max_j = j; // memorizing column index of sub matix
				}
			}
		}
		
		for(int i = max_i; i > max_i - maxSqureLen; i--) {
			for(int j = max_j; j > max_j - maxSqureLen; j--) {
				System.out.print(matrix.get(i - 1).get(j - 1) + " ");
			}
			System.out.println();
		}
		
		return maxSqureLen;
	}

}
