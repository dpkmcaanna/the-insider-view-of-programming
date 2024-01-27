package programming.injava.array;

import java.util.Arrays;

public class FindMinimumPlatformNeeded {

	public static void main(String[] args) {
		int[] arrivalTime = {600, 630, 700, 900, 915, 1200, 1215};
		int[] deptTime = {730, 800, 710, 1100, 1000, 1215, 1230};
		
		findMinPlatforNeedForKTrain(arrivalTime, deptTime);
	}
	
	public static void findMinPlatforNeedForKTrain(int[] arrivalTime, int[] deptTime) {
		
		//Sort the arrival time
		Arrays.sort(arrivalTime);
		Arrays.sort(deptTime);
		
		/**
		 * Start with two pointer, one reading arrival time array and increment platform count if time is before hand of depart time.
		 * if arrival time is after hand of depart time then decrement the platform
		 * 
		 * */
		
		int platformCount = 0, minPlatformCount = Integer.MIN_VALUE;
		
		for(int i = 0, j = 0; i < arrivalTime.length && j < deptTime.length;) {
			
			if(arrivalTime[i] < deptTime[j]) {
				++platformCount;
				++i;
				minPlatformCount = Math.max(minPlatformCount, platformCount);
			} else {
				platformCount--;
				j++;
			}
		}
		
		System.out.println("Min Platform needed: " + minPlatformCount);
		
	}

}
