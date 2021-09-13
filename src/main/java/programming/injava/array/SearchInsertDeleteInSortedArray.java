package programming.injava.array;

/**
 * Binary Search and insert in array
 *  
 * **/
public class SearchInsertDeleteInSortedArray {

	private static int serach(int[] arr, int k) {
		int mid, low = 0, high = arr.length - 1;

		while (high >= low) {
			mid = low + (high - low) / 2;

			if (k == arr[mid]) {
				return mid;
			} else if (k > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(serach(new int[] { 1, 3, 4, 5, 6, 7, 8, 11, 22, 26, 18, 44 }, 4));

		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

		System.out.println(serach(arr, 4));


		System.out.println(serach(new int[] { 2, 3, 4, 10, 40 }, 10));
		System.out.println(serach(new int[] { 2, 3, 4, 10, 40 }, 40));
		System.out.println(serach(new int[] { 2, 3, 4, 10, 40 }, 2));
		System.out.println(serach(new int[] { 2, 3, 4, 10, 40 }, 1));
		System.out.println(serach(new int[] { 2, 3, 4, 10, 40 }, 50));


	}

}
