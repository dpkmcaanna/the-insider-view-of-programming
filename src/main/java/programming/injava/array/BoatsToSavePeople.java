package programming.injava.array;

import java.util.Arrays;

public class BoatsToSavePeople {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c = findNoOfBoatsNeeded(new int[] {3,2,2,1}, 3);
		System.out.println("Required boats: " + c);
		
		
		c = findNoOfBoatsNeeded(new int[] {2,1}, 3);
		System.out.println("Required boats: " + c);
		
		
		c = findNoOfBoatsNeeded(new int[] {3,5,3,4}, 5);
		System.out.println("Required boats: " + c);
	}
	
	public static int findNoOfBoatsNeeded(int[] people, int boatsLimit) {
		Arrays.sort(people);
		
		int boats = 0;
		
		int left = 0, right = people.length - 1;
		
		while(left <= right) {
			if(people[right] + people[left] <= boatsLimit) {
				left++;
			}
			boats++;
			right--;
		}
		
		return boats;
	}

}
