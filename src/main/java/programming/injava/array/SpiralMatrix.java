package programming.injava.array;

import java.util.List;

/**
 * 
 * Traverse given matrix in spiral way
 * 
 * **/

public class SpiralMatrix {

	private static List<Integer> traversMatrixInSpriralWay(int[][] matrix) {
		int i, dr = 0, left = 0, right = matrix[0].length - 1, top = 0, down = matrix.length - 1;

		while (left <= right && top <= down) {
			if (dr == 0) {
				for (i = left; i <= right; i++)  // Move in right direction column keep changing by one
					System.out.print(matrix[top][i]  + " "); 
				top++; // after reaching end of row from left direction move to next row and be in same column 
			}
			
			if (dr == 1) {
				for (i = top; i <= down; i++)  // Move in downward direction by incrementing row by one and column fixed
					System.out.print(matrix[i][right]  + " ");
				right--; // after reaching end of column from top direction decrement column by one 
			}
			
			if (dr == 2) {
				for (i = right; i >= left; i--) // Move in left direction by decrementing column by one and row fixed
					System.out.print(matrix[down][i] + " ");
				down--; // after reaching end of row from right direction move to previous row and be in same column 
			}
			
			if (dr == 3) {
				for (i = down; i >= top; i--)  // Move in right direction column keep changing by one
					System.out.print(matrix[i][left] + " ");
				left++; // after reaching end of column from bottom direction increment column by one 
			}
			
			dr = (dr + 1) % 4;
		}
		return null;
	}

	public static void main(String[] args) {
		int[][] input = {
				{1, 2, 3, 4, 40},
				{5, 6, 7, 8, 80}
		};
		traversMatrixInSpriralWay(input);
	}

}
