package programming.injava.array;

public class LongestPlindromicString {

	public static void main(String[] args) {

		findLongestPlindromicStringV1("babad");
		findLongestPlindromicStringV1("cbbd");
		findLongestPlindromicStringV1("babaddabad");
	}
	
	public static void findLongestPlindromicStringV1(String s) {
		int start = 0, end = 0, len = 0, oddLen = 0, evenLen = 0;
		
		for(int i = 0; i < s.length(); i++) {
			oddLen = expandToCenter(s, i, i);
			evenLen = expandToCenter(s, i, i + 1);
			
			len = Math.max(oddLen, evenLen);
			
			if(len > (end - start)) {
				start = i - (len - 1)/2;
				end = i + len/2;
			}
		}
		
		if(len > 0) {
			System.out.println("Planidromic string: " + s.substring(start, end + 1));
		} else {
			System.out.println("No planidromic string found");
		}
	}
	
	public static int expandToCenter(String s,  int left, int right) {
		int l = left, r = right;
		
		while(l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))) {
			l--;
			r++;
		}
		
		return r - l - 1;
	}

}
