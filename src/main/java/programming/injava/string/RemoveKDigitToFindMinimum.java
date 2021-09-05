package programming.injava.string;

import java.util.Stack;

/**
 * Find the smallest number after removing K digits from a given number. Without changing order of digit
 * 
 * **/
public class RemoveKDigitToFindMinimum {

	private static String removeKDigitToFindMinimum(String nums, int k) {
		if(k == 0)
			return nums;
		
		if(nums.isEmpty())
			return nums;
		
		Stack<Character> peekElement = new Stack<>();
		
		for(char c :  nums.toCharArray()) {
			while(!peekElement.isEmpty() && k > 0 && peekElement.peek() > c) {
				--k;
				peekElement.pop();
			}
			if(!peekElement.isEmpty() || c != '0')
				peekElement.add(c);
		}

		while(!peekElement.isEmpty() && k-- > 0)
			peekElement.pop();
		
		if(peekElement.isEmpty())
			return "0";
		
		int n = peekElement.size();
		char[] str = new char[n];
		
		while(!peekElement.isEmpty()) {
			char c = peekElement.pop();
			str[n - 1] = c;
			--n;
		}
		
		return String.copyValueOf(str);
	}
	
	public static void main(String[] args) {
		System.err.println(removeKDigitToFindMinimum("1231", 1));
		System.err.println(removeKDigitToFindMinimum("14301620", 4));
	}

}
