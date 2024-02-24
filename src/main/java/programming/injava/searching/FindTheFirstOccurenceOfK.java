package programming.injava.searching;

public class FindTheFirstOccurenceOfK {

	public static void main(String[] args) {
		int[] a = {-14, 20, 2, 108, 108, 243, 285, 285, 285, 401};
		
		findTheFirstOccurenceOfKV1(a, 108);
		
		System.out.println("========================");
		
		findTheFirstOccurenceOfKV1(a, 285);
	}
	
	public static void findTheFirstOccurenceOfKV1(int[] a, int k) {
		int left = 0, right = a.length - 1, mid = 0, result = -1;
		
		while(left <= right) {
			mid = left + ((right - left) / 2);
			
			if(a[mid] == k) {
				result = mid;
				right = mid - 1; //Nothing to the right of mid can be 1st occurrence of k
				System.out.println("Match found at index: " + mid);
			} else if (a[mid] < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		if(result > -1) {
			System.out.println("First occurrence of :" + a[result] + ", is at index: " + result);
		} else {
			System.out.println("No match found");
		}
	}

}
