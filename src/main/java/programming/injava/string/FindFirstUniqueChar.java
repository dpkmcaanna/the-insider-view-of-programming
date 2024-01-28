package programming.injava.string;

import java.util.HashMap;
import java.util.Map;

public class FindFirstUniqueChar {

	public static void main(String[] args) {
		findFirstUniqueCharV1("AAMMGFJIGF");
		findFirstUniqueCharV2("AAMMGFJIIGF");
		findFirstUniqueCharV3("AAMMGFJIGF");
	}
	
	/**
	 * Approach using fixed buffer array of char
	 * */
	public static void findFirstUniqueCharV1(String str) {
		char[] chars = new char[256];
		
		for(char c : str.toCharArray()) {
			chars[c]++;
		}
		
		boolean foundUnique = false;
		int index = 0;
		for(char c : str.toCharArray()) {
			if(chars[c] == 1) {
				foundUnique = true;
				break;
			}
			index++;
		}
		
		if(foundUnique) {
			System.out.println("Found first unique char at: " + index + ", char is: " + str.charAt(index));
		} else {
			System.out.println("All are duplicate chars");
		}
	}
	
	/**
	 * Approach using by comparing index
	 * */
	public static void findFirstUniqueCharV2(String str) {
		
		boolean foundUnique = false;
		int index = 0;
		
		for(char c : str.toCharArray()) {
			if(str.indexOf(c) == str.lastIndexOf(c)) {
				foundUnique = true;
				break;
			}
			index++;
		}
		
		if(foundUnique) {
			System.out.println("Found first unique char at: " + index + ", char is: " + str.charAt(index));
		} else {
			System.out.println("All are duplicate chars");
		}
	}
	
	/**
	 * Approach using by comparing index
	 * */
	public static void findFirstUniqueCharV3(String str) {
		
		Map<Character, Integer> frqMap = new HashMap<>();
		
		for(char c : str.toCharArray()) {
			frqMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
		}
		
		System.out.println(frqMap);
		
		boolean foundUnique = false;
		int index = 0;
		
		for(char c : str.toCharArray()) {
			if(frqMap.get(c) == 1) {
				foundUnique = true;
				break;
			}
			index++;
		}
		
		if(foundUnique) {
			System.out.println("Found first unique char at: " + index + ", char is: " + str.charAt(index));
		} else {
			System.out.println("All are duplicate chars");
		}
	}

}
