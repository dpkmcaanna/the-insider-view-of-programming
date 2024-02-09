package programming.injava.array;

import java.util.Arrays;

public class LongestPlindromicString {

	public static void main(String[] args) {

		findLongestPlindromicStringV1("babad");
		findLongestPlindromicStringV1("cbbd");
		findLongestPlindromicStringV1("babaddabad");
	}

	public static void findLongestPlindromicStringV1(String s) {
		int start = 0, end = 0, len = 0, oddLen = 0, evenLen = 0;

		for (int i = 0; i < s.length(); i++) {
			oddLen = expandToCenter(s, i, i);
			evenLen = expandToCenter(s, i, i + 1);

			len = Math.max(oddLen, evenLen);

			if (len > (end - start)) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}

		if (len > 0) {
			System.out.println("Planidromic string: " + s.substring(start, end + 1));
		} else {
			System.out.println("No planidromic string found");
		}
	}

	public static int expandToCenter(String s, int left, int right) {
		int l = left, r = right;

		while (l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))) {
			l--;
			r++;
		}

		return r - l - 1;
	}

	public static void findLongestPlindromicStringV2(String s) {
		int n = s.length();
		
		boolean[][] dp = new boolean[n][n];
		
		for (boolean[] g : dp) {
			Arrays.fill(g, true);
		}
		
		int k = 0, mx = 1;
		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				dp[i][j] = false;
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1];
					if (dp[i][j] && mx < j - i + 1) {
						mx = j - i + 1;
						k = i;
					}
				}
			}
		}
	}
}
