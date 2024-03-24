package programming.injava.string;

// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class ReplaceMinusPlus {
	public static String solution(String s) {
		String plus = "plus";
		String minus = "minus";

		int len = s.length();

		StringBuilder sb = new StringBuilder();
		int start = 0;
		int slen = 0;
		for (int i = 0; i < len;) {
			if (s.charAt(i) == 'm') {
				start = i;
				for (int j = 0; j < 5 && i < len; j++) {
					//System.out.println("m - i" + i + ", j" + j);
					if (s.charAt(i) == minus.charAt(j)) {
						i++;
						slen++;
					}
				}
				if (slen == minus.length()) {
					sb.append("-");
				} else {
					sb.append(s.substring(start, i));
				}
			} else if (s.charAt(i) == 'p') { //plus 0123
				start = i;
				for (int j = 0; j < 4 && i < len; j++) {
					//System.out.println("p - i" + i + ", j" + j);
					if (s.charAt(i) == plus.charAt(j)) {
						i++;
						slen++;
					}
				}
				if (slen == plus.length()) {
					sb.append("+");
				} else {
					sb.append(s.substring(start, i));
				}
			}
			slen = 0;
			start = 0;
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		String s  = solution("plusminusminusplus");
		
		System.out.println(s);
		
	}
}
