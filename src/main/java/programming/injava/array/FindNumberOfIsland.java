package programming.injava.array;

/**
 * Find number island 
 * 
 * All reachable one or more 1'a are considered as island
 * 
 * only horizontally and vertically 1's are considered as connected
 *  
 * **/
public class FindNumberOfIsland {
	
	private static void traverseIsland(int[][] matrix, int x, int y, int r, int c) {
		if(x < 0 || x >= r || y < 0 || y >= c || matrix[x][y] != 1) // check x and y are inside the boundary and not 0
			return;
		
		matrix[x][y] = 2; // To mark connected cell
		
		traverseIsland(matrix, x, y + 1, r, c); // RIGHT
		traverseIsland(matrix, x, y - 1, r, c); // LEFT
		traverseIsland(matrix, x + 1, y, r, c); // DOWN
		traverseIsland(matrix, x - 1, y, r, c); // UP
	}
	
	private static int findNoOfIsland(int[][] matrix) {
		
		int c = matrix[0].length;
		int r = matrix.length;
		int noOfIsland = 0;
		
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(matrix[i][j] == 1) {
					traverseIsland(matrix, i, j, r, c);
					noOfIsland++;
				}
			}
		}
		
		return noOfIsland;
	}
	
	public static void main(String[] args) {
		int[][] input = {
				{0, 1, 1, 0},
				{1, 0, 0, 0},
				{1, 0, 0, 1},
				{0, 1, 1, 0},
		};
		
		System.out.println(findNoOfIsland(input));
	}

}
