package programming.injava.array;


/**
 * Find maximum water stored in between the building
 * 
 * Approach:
 * 
 * Take two additional array, let say leftMax == will hold max height in the left for given index.
 * 
 * rightMax == will hold max height in the right for given index.
 * 
 * Now traverse again the array and calculate Math.min(leftMax[i], rightMax[i]) - a[i]
 * 
 * **/
public class TrappingRainWater {

	public static void main(String[] args) {
		trappingRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
	}
	
	public static void trappingRainWater(int[] a) {
		int len = a.length;
		
		int[] leftMax = new int[len];
		int[] rightMax = new int[len];
		
		leftMax[0] = a[0];
		
		for(int i = 1; i < len; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], a[i]);
		}
		
		rightMax [len - 1] = a[len - 1];
		
		for(int j = len - 2; j >= 0; j--) {
			rightMax[j] = Math.max(rightMax[j + 1], a[j]);
		}
		
		int totalWater = 0;
		for(int k = 0; k < len; k++) {
			totalWater = totalWater + (Math.min(leftMax[k], rightMax[k]) -  a[k]);
		}
		
		System.out.println("Total water: " + totalWater);
	}

}
