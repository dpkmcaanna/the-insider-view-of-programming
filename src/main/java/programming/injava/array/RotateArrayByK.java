package programming.injava.array;

/**
 * Rotate Array
 * 
 * **/
public class RotateArrayByK {

	//In Anti clockwise
	private static int[] roateByK(int[] arr, int k) {
		int len = arr.length;
		int[] rotatedArr =  new int[len];
		
		for(int i = 0; i < len; i++) {
			rotatedArr[i] = arr[(i +k)%len];
		}
		
		return rotatedArr;
	}
	
	// In clock wise
	private static void rotateArrayWithNoExtraSpace(int[] arr, int k) {
		swap(arr, 0, arr.length - 1);
		swap(arr, 0, k - 1);
		swap(arr, k, arr.length - 1);
	}
	
	private static void swap(int[] arr, int s, int e) {
		while(s < e) {
			arr[s] = arr[s] + arr[e];
			arr[e] = arr[s] - arr[e];
			arr[s] = arr[s] - arr[e];
			s++;
			e--;
		}
	}
	
	private static void printArray(int[] arr) {
		for(int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] rotatedArr = roateByK(arr, 3);
		printArray(rotatedArr);
		
		System.out.println();
		
		rotateArrayWithNoExtraSpace(arr, 4);
		printArray(arr);
	}
}
