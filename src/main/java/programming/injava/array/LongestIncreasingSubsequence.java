package programming.injava.array;

import java.util.ArrayList;
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
		int n = arr.length;
		
		int[] temp = new int[n];
		
		Arrays.fill(temp, 1); // Every element is subsequnce of len 1
		
		// arr[i] >  arr[j] -> ensure sequence is always increasing 
		// &&  temp[i] < temp[j] + 1 -> ensure length is less than next at jth position
		
		int[] hash=new int[n];
		
	    Arrays.fill(hash,1);
		
		for(int i = 0; i < n - 1; i++) {
			hash[i] = i;
			for(int j = 0; j <= i; j++) {
				if(arr[i] >  arr[j] && temp[i] < temp[j] + 1) {
					temp[i] = temp[j] + 1;
					hash[i] = j;
				}
			}
		}
		
		int maxLen = -1;
		int lastIndex = -1;
		
		for(int i = 0; i < n; i++) {
			if(temp[i] > maxLen) {
				maxLen = temp[i];
				lastIndex = i;
			}
		}
		
		ArrayList<Integer> lis = new ArrayList<>();
		lis.add(arr[lastIndex]);
		
		while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
	        lastIndex = hash[lastIndex];
	        lis.add(arr[lastIndex]);    
	    }
	    
	    // reverse the array 
	    
	    System.out.print("The subsequence elements are ");
		
	    for(int i=lis.size()-1; i>=0; i--){
	        System.out.print(lis.get(i)+" ");
	    }
	    System.out.println();
		
		return Arrays.stream(temp).max().getAsInt();
	}

}
