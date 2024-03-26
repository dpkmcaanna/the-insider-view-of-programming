package programming.injava.array;

/**
 * Given a string with only characters X and Y. Find the minimum number of characters to remove from the string such that 
 * there is no interleaving of character X and Y and all the Xs appear before any Y.
 * 
 * if(s[i+1] == 'A') 
 * 
 * There are two options: either to include this 'A' or exclude.
 * If 'A' included then all B's before it should be deleted by definition of the task where A must be always before 'B'.
 * If 'A' excluded then increment min_dels for range s[0..i] to one, that is add the 'A' which we going to exclude/delete to the number of deleted items
 * 
 * min_dels[0..i+1] = min(num_Bs, min_dels[0..i]+1); // num_Bs is the total number of Bs in s[0..i]
 * else  {
 * Since B is at the end there is no need to exclude this B
 * min_dels[0..i+1] = min_dels[0..i];
 * }
 * 
 * */
public class MinDeletionsToObtainString {

	public static void main(String[] args) {
		System.out.println("Mid no of del ops: " + findMinDeletion("YXXXYXY"));
		System.out.println("Mid no of del ops: " + findMinDeletion("YYXYXX"));
		System.out.println("Mid no of del ops: " + findMinDeletion("XXYYYY"));
	}
	
	public static int findMinDeletion(String str) {
		char charX = 'X';
		int numY = 0;
		int minDel = 0;
		
		for(char c : str.toCharArray()) {
			if(c == charX) {
				minDel = Math.min(numY, minDel + 1);
			} else {
				numY++;
			}
		}
		return minDel;
	}

}
