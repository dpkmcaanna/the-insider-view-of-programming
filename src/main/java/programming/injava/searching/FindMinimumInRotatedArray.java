package programming.injava.searching;

public class FindMinimumInRotatedArray {

	public static void main(String[] args) {
		int[] a = {378, 478, 550, 631, 103, 203, 220, 234, 279, 368};
		
		findMinimumInRotatedArrayV1(a);
	}
	
	/**
	 * if A[m] > A[n-1] then minimum will be in [m+1, n-1]
	 * if A[m] < A[n-1] 
	 * */
	public static void findMinimumInRotatedArrayV1(int[] a) {
		
		int left = 0, right = a.length - 1, mid = 0;
		
		while(left < right) {
			mid = left + ((right - left) / 2);
			if(a[mid] > a[right]) {
				left = mid + 1; // Minimum must be in the range of [mid + 1, right]. That means right side of array is sorted from smallest to mid
			} else {
				right = mid; //  Minimum cann't be in the range of [mid + 1, right], so it must be in [left, mid]
			}
		}
		
		System.out.println("Left: " + left + ", Right: " + right + ", Min element: " + a[left]);
	}
	
	public static void findMinimumInRotatedArrayV2(int[] a, int t) {
		
		int left = 0, right = a.length - 1, mid = 0;
		
		while(left < right) {
			mid = left + ((right - left) / 2);
			if(a[mid] > a[right]) {
				left = mid + 1; // Minimum must be in the range of [mid + 1, right]. That means right side of array is sorted from smallest to mid
			} else {
				right = mid; //  Minimum cann't be in the range of [mid + 1, right], so it must be in [left, mid]
			}
		}
		
		System.out.println("Left: " + left + ", Right: " + right + ", Min element: " + a[left]);
	}

}
