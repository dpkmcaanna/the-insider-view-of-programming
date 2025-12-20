package programming.injava.array;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int c = findContainerWithMostWater(new int[] {1,8,6,2,5,4,8,3,7});
		System.out.println("Required boats: " + c);
	}
	
	public static int findContainerWithMostWater(int[] conatiner) {
		int maxWater = 0;
		int left = 0, right = conatiner.length - 1;
		
		while(left < right) {
			int waterInCurrentContainer = (right - left) * Math.min(conatiner[left], conatiner[right]);
			maxWater = Math.max(maxWater, waterInCurrentContainer);
			
			if(conatiner[left] < conatiner[right]) {
				left++;
			} else {
				right--;
			}
		}
		
		return maxWater;
	}

}
