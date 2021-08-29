package programming.injava.dp;

import java.util.HashMap;
import java.util.Map;

public class RobotTraveler {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		System.out.println(findTravelDistanceUsingRecursion(100, 100, new HashMap<String, Long>()));

		System.out.println("Total runtime: " + (System.currentTimeMillis() - start));
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
}
