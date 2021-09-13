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

	static int binarySearch(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, (mid + 1), high, key);
		return binarySearch(arr, low, (mid - 1), key);
	}

	private static int insertInSortedArray(int[] arr, int len, int k) {
		int capacity = arr.length;

		if (len >= capacity) {
			System.out.println("Can't insert since capacity is already full");
			return len;
		}

		int index = serach(arr, k);

		if (index > -1)
			return k;

		int i = len - 1;
		
		for (; (i >= 0 && k < arr[i]); i--)
			arr[i + 1] = arr[i];

		arr[i + 1] = k;

		return len + 1;
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

		System.out.println(binarySearch(arr, 0, 12, 4));

		System.out.println("=========== insert ===============");
		int arr1[] = new int[20];
		arr1[0] = 12;
		arr1[1] = 16;
		arr1[2] = 20;
		arr1[3] = 40;
		arr1[4] = 50;
		arr1[5] = 70;

		int n = insertInSortedArray(arr1, 6, 26);

		System.out.print("\nAfter Insertion: ");
		for (int i = 0; i < n; i++)
			System.out.print(arr1[i] + " ");

	}

}
