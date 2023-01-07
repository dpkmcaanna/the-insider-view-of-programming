package programming.injava.string;

public class FindLcsInTwoString {

	/**
	 * 1. Any string can null 2. Longest length can be any one string completely
	 * found in other string
	 */
	public static int findLcsOfTwoGivenString(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
			return 0;

		int m = str1.length();
		int n = str2.length();

		int[][] lcsMatrix = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
				} else {
					lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
				}
			}
		}

		System.out.println("=================== Printing length matrix ==================");
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(lcsMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=============================================================");

		int lcsOfLen = lcsMatrix[m][n];

		System.out.println("Length of common subsequence is : " + lcsOfLen);

		char[] lcs = new char[lcsOfLen];

		int i = m;
		int j = n;
		while (i > 0 && j > 0) {
			System.out.println("Row index: " + i + ", Column index: " + j + ", char is: " + str1.charAt(i - 1));
			if (lcsMatrix[i - 1][j] == lcsMatrix[i][j - 1]) {
				System.out.println("Value at [i - 1][j] == [i][j - 1]: " + str1.charAt(i - 1));
				if (lcsMatrix[i][j] == lcsMatrix[i - 1][j - 1] + 1) {
					System.out.println("Found a common char: " + str1.charAt(i - 1));
					lcs[--lcsOfLen] = str1.charAt(i - 1);
				}
				i--;
				j--;
			} else if (lcsMatrix[i - 1][j] > lcsMatrix[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}

		System.out.println("\nCommon string: " + String.valueOf(lcs));
		return lcsMatrix[m][n];
	}

	/**
	 * 1. Find longest common sequence in given string
	 */
	public static int findLcsInGivenString(String str) {
		if (str == null || str.length() == 0)
			return 0;

		int m = str.length();

		int[][] lcsMatrix = new int[m + 1][m + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= m; j++) {
				if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
					lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
				} else {
					lcsMatrix[i][j] = Math.max(lcsMatrix[i - 1][j], lcsMatrix[i][j - 1]);
				}
			}
		}

		System.out.println("LCS length: " + lcsMatrix[m][m]);
		return lcsMatrix[m][m];
	}

	public static void main(String[] args) {
		System.out.println("========================\"\", \"abdcaabdca\"=====================================");
		findLcsOfTwoGivenString("", "abdcaabdca");
		System.out.println("==========================\"adca\", \"abdcaabdca\"===================================");
		findLcsOfTwoGivenString("adca", "abdcaabdca");
		System.out.println("==========================\"adcaffff\", \"abdcaabdca\"===================================");
		findLcsOfTwoGivenString("adcaffff", "abdcaabdca");
		System.out.println("===========================\"adfffcaf\", \"abdcaabdca\"==================================");
		findLcsOfTwoGivenString("adfffcaf", "abdcaabdca");
		System.out.println("===========================\"ABCDGH\", \"AEDFHR\"==================================");
		findLcsOfTwoGivenString("ABCDGH", "AEDFHR");
		System.out.println("============================\"AGGTAB\", \"GXTXAYB\"=================================");
		findLcsOfTwoGivenString("AGGTAB", "GXTXAYB");
		System.out.println("=============================================================");
		// findLcsInGivenString("abdcaabdcafghjkl");
	}

}
