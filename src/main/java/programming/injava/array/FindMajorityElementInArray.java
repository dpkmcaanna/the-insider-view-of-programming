package programming.injava.array;

/**
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * 
 * **/
public class FindMajorityElementInArray {

	// find x is majority as n/2 element or not in sorted array
	private static void isMajorityElement(int[] arr, int x) {
		int len = arr.length;

		// to point 2nd pointer as mid this mid index if len = 5, then mid = 2 [i.e 0, 1, 2]
		// if len = 6, then mid = 3 [i.e 0, 1, 2, 3], fourth element
		int mid = len / 2;
		for (int i = 0; i < mid; i++) {
			if (arr[i] == x && arr[i + mid] == x) {
				System.out.println("True");
				return;
			}
		}
		System.out.println("False");
	}
	
	private static void isMajorityElementInUnOrderedArray(int[] arr, int x) {
		
	}
	
	public static void main(String[] args) {
		isMajorityElement(new int[] { 1, 1, 2, 2, 3 }, 2); // i = 1, mid = 2
		isMajorityElement(new int[] { 1, 2, 3, 3, 3, 3, 10 }, 3);
		isMajorityElement(new int[] { 1, 1, 2, 4, 4, 4, 6, 6 }, 4);
		isMajorityElement(new int[] { 1, 1, 1, 2, 2 }, 1);
	}

}
