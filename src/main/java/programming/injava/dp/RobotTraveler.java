package programming.injava.dp;

import java.util.HashMap;
import java.util.Map;

public class RobotTraveler {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		System.out.println("Number of path for travelling using recursion from [0][0] to [m][n]: " + findTravelDistanceUsingRecursion(112, 112, new HashMap<String, Long>()));

		System.err.println("\nTravelling time using recursion from [0][0] to [m][n]: " + (System.currentTimeMillis() - start));
		
		
		start = System.currentTimeMillis();

		System.out.println("Number of path for travelling using mem matrix from [0][0] to [m][n]: " + findNumberOfPath(112, 112));

		System.err.println("\nTravelling time using mem matrix  from [0][0] to [m][n]: " + (System.currentTimeMillis() - start));
	}

	public static Long findTravelDistanceUsingRecursion(int m, int n, Map<String, Long> cache) {
		String key = n + "," + m;
		if (cache.containsKey(key))
			return cache.get(key);

		if (m == 1 && n == 1) 
			return 1l;
		if (m == 0 || n == 0)
			return 0l;

		Long pathCount = findTravelDistanceUsingRecursion(m - 1, n, cache)
				+ findTravelDistanceUsingRecursion(m, n - 1, cache);
		cache.put(key, pathCount);

		return pathCount;
	}
	
	public static long findNumberOfPath(int row, int col) {
		
		if(row == 1 || col == 1)
			return 1;
		
		if(row == 0 || col == 0)
			return 1;
		
		long[][] mem =  new long[row][col];

		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(i == 0 || j == 0) {
					mem[i][j] = 1;
				} else {
					mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
				}
			}
		}
		
		return mem[row - 1][col - 1];
	}
}
