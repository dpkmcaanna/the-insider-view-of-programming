package programming.injava.array;

import java.util.List;

public class SpiralMatrix {

	private static List<Integer> traversMatrixInSpriralWay(int[][] matrix) {
		int i, dr = 0, left = 0, right = matrix[0].length - 1, top = 0, down = matrix.length - 1;

		while (left <= right && top <= down) {
			if (dr == 0) {
				for (i = left; i <= right; i++)
					System.out.print(matrix[top][i]  + " ");
				top++;
			}
			
			if (dr == 1) {
				for (i = top; i <= down; i++)
					System.out.print(matrix[i][right]  + " ");
				right--;
			}
			
			if (dr == 2) {
				for (i = right; i >= left; i--)
					System.out.print(matrix[down][i] + " ");
				down--;
			}
			
			if (dr == 3) {
				for (i = down; i >= top; i--)
					System.out.print(matrix[i][left] + " ");
				left++;
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
