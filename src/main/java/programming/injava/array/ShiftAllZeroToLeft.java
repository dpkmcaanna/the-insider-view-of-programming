package programming.injava.array;

/**
 * Given an array of random numbers, Push all the zero’s of a given array to the end of the array. For example, if the given arrays is
 * 
 * {0, 6, 1, 0, 0, 3, 5} -> 0 0 0 6 1 3 5 
 * 
 * complexity is O(n) and extra space is O(1).
 * **/
public class ShiftAllZeroToLeft {

	public static void main(String[] args) {
		shiftZero(new int[] {0, 1, 0, 0, 3, 5});
		
		System.out.println();
		shiftZero(new int[] {0, 6, 1, 0, 0, 3, 5});
		
		System.out.println();
		shiftZero(new int[] {1, 6, 1, 0, 0});
		
		System.out.println();
		shiftZero(new int[] {0, 0, 21, 10, 40});
		
		System.out.println();
		shiftZero(new int[] {1, 2, 0, 0, 0, 3, 6});
		
		System.out.println();
		shiftZero(new int[] {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0});
		
		System.out.println();
		shiftZero(new int[] {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0});
		
		System.out.println();
		shiftZero(new int[] {1, 6});
		
		System.out.println();
		shiftZero(new int[] {1});
		
		System.out.println();
		shiftZero(new int[] {6, 0});
		
		System.out.println();
		shiftZero(new int[] {0, 6});
		
		System.out.println();
		shiftZero(new int[] {0});
		
		System.out.println();
		shiftZero(new int[] {0, 0});
	}
	
	static void shiftZero(int[] arr) {
		int len = arr.length;
		int left = len -1, right = len - 1;
		
		while(left >=0 && arr[left] > 0) left--;
		
		right = left;
		
		while(right >= 0 && left >= 0) {
			if(right < left && (arr[right] != 0 && arr[left] == 0)) {
				arr[left--] = arr[right];
				arr[right--] = 0;
			} else {
				right--;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
