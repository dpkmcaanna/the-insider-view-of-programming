package programming.injava.array;

import java.util.Arrays;

/**
 * Find length of longest subsequence i.e. non continues array
 * **/
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int arr[] = new int[] { 10, 22, 9, 33, 21, 50, 41, 60 }; 
		System.out.println("Length of max subsequence is : " + findLengthOfSubsequence(arr) ); 
		
		arr = new int[] { 5, 8, 7, 1, 9 }; 
		System.out.println("Length of max subsequence is : " + findLengthOfSubsequence(arr) ); 
	}
	
	static int findLengthOfSubsequence(int[] arr) {
		
		int[] temp = new int[arr.length];
		
		Arrays.fill(temp, 1); // Every element is subsequnce of len 1
		
		// arr[i] >  arr[j] -> ensure sequence is always increasing 
		// &&  temp[i] < temp[j] + 1 -> ensure length is less than next at jth position
		
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++)
				if(arr[i] >  arr[j] && temp[i] < temp[j] + 1) 
					temp[i] = temp[j] + 1;
		}
		
		return Arrays.stream(temp).max().getAsInt();
	}

}
