package programming.injava.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindVovelsSubstringCount {

	public static void main(String[] args) {
		
		List<String> allSubVowelString = findAllVowelSubString("aaeioxaaeiuou");
		
		allSubVowelString.stream().forEach(System.out::println);
		
		System.out.println("Total count of substring having all vovels: " + findCountOfSubStringWithAllVowels("aaeioxaaeiuou"));

	}

	public static int findCountOfSubStringWithAllVowels(String s) {
		int count = 0;
		
		for(int i = 0; i < s.length() - 5; i++) {
			Set<Character> vowelCount = new HashSet<Character>();
			
			for(int j = i; j < s.length(); j++) {
				if(!isVowel(s.charAt(j))) {
					break;
				}
				
				vowelCount.add(s.charAt(j));
				
				if(vowelCount.size() == 5) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	
	public static List<String> findAllVowelSubString(String s) {
		Set<Character> vowelCount = new HashSet<Character>();
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for(char c : s.toCharArray()) {
			if(isVowel(c)) {
				sb.append(c);
				vowelCount.add(c);
			}else {
				String t = sb.toString();
				if(t.length() > 1 && vowelCount.size() == 5) {
					res.add(t);
				}
				sb = new StringBuilder();
				vowelCount.clear();
			}
		}
		
		String t = sb.toString();
		
		if(t.length() > 1 && vowelCount.size() == 5) {
			res.add(t);
			sb = new StringBuilder();
			vowelCount.clear();
		}
		
		return res;
	}
	
	public static boolean isVowel(char c) {
		return c == 'a' ||  c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}
}
