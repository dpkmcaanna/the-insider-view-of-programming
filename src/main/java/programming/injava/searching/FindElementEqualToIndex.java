package programming.injava.searching;

public class FindElementEqualToIndex {

	public static void main(String[] args) {
		int[] a = {-14, 20, 2, 108, 108, 243, 285, 285, 285, 401};
		
		findElementEqualToIndexV1(a);
		
		System.out.println("===================");
		
		a = new int[] {-2, -1, 2, 0, 2, 2, 6};
		findElementEqualToIndexV1(a);
	}
	
	public static void findElementEqualToIndexV1(int[] a) {
		int left = 0, right = a.length - 1, mid = 0, diff = 0;
		
		while(left <= right) {
			mid = left + ((right - left) / 2);
			diff = a[mid] - mid;
			
			System.out.println("a[mid]: " + a[mid] + ", diff: " + diff + ", left :" + left + ", right: " + right + ", mid: " + mid );
			
			if(diff == 0) {
				System.out.println("Element found: " + a[mid] + " and index: " + (mid + 1));
				break;
			} else if (diff < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
	}

}
