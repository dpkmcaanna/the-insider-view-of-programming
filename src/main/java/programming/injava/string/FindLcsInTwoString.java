package programming.injava.string;

public class FindLcsInTwoString {

	/**
	 * 1. Any string can null
	 * 2. Longest length can be any one string completely found in other string
	 * */
	public static int findLcsOfTwoGivenString(String str1, String str2) {
		if(str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0) return 0;
		
		
		int m = str1.length();
		int n = str2.length();
		
		int[][] lcsMatrix = new int[m + 1][n + 1];
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					lcsMatrix[i][j] = lcsMatrix[i - 1][j - 1] + 1;
				} else {
					lcsMatrix[i][j] = Math.max(lcsMatrix[i-1][j], lcsMatrix[i][j - 1]);
				}
			}
		}
		
		System.out.println("LCS length: " + lcsMatrix[m][n]);
		return lcsMatrix[m][n];
	}
	
	public static void main(String[] args) {
		findLcsOfTwoGivenString("", "abdcaabdca");
		findLcsOfTwoGivenString("adca", "abdcaabdca");
		findLcsOfTwoGivenString("adcaffff", "abdcaabdca");
		findLcsOfTwoGivenString("adfffcaf", "abdcaabdca");
	}

}
