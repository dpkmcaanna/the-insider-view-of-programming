package programming.injava.dp;

import java.util.List;

/**
 * Given a binary matrix of 0s and 1s write an algorithm to find out the maximum size squre sub matrix with all 1s.
 * Return the length of the side.
 * 
 * **/
public class FindMaximumSubSqure {

	public static void main(String[] args) {
		List<List<Integer>> matrix = List.of(List.of(0, 1, 1, 0, 1),
				List.of(1, 1, 0, 1, 0),
				List.of(0, 1, 1, 1, 0),
				List.of(1, 1, 1, 1, 0),
				List.of(1, 1, 1, 1, 1),
				List.of(0, 0, 0, 0, 0));
		
		int len = findLengthOfMaximumBinarySubSquare(matrix);
		
		System.out.println("\n\n========= Side of max sub binary matrix with 1's ========= \n " + len);
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
					maxSqureLen = mem[i][j];
					max_i = i;
					max_j = j;
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
