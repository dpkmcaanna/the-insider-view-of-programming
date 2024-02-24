package programming.injava.array;

public class FindElementIn2DArray {

	public static void main(String[] args) {
		int[][] a = new int[][] {
			{-1, 2, 4, 4, 6},
			{1, 5, 5, 9, 21},
			{3, 6, 6, 9, 22},
			{3, 6, 8, 10, 24},
			{6, 8, 9, 12, 25},
			{8, 10, 12, 13, 40}
		};
		
		findElementInSorted2DArray(a, 40);
	}
	
	public static void findElementInSorted2DArray(int[][] a, int t) {
		int r = 0, c = a[0].length - 1, rowCount = a.length - 1;
		boolean isFound = false;
		for(;r <= rowCount && c >= 0;) {
			if(a[r][c] == t) {
				System.out.println("Element "+ a[r][c] +" found at row: " + (r + 1) + ", column: " + (c + 1));
				isFound =true;
				break;
			} else if(a[r][c] < t) {
				r++;
			} else {
				c--;
			}
		}
		
		if(!isFound) {
			System.out.println("Element not found");
		}
	}

}
