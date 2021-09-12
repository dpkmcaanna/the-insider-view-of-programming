package programming.injava.array;

/**
 * Rotate Array
 * 
 * **/
public class RotateArrayByK {

	private static int[] roateByK(int[] arr, int k) {
		int len = arr.length;
		int[] rotatedArr =  new int[len];
		
		for(int i = 0; i < len; i++) {
			rotatedArr[i] = arr[(i +k)%len];
		}
		
		return rotatedArr;
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
	}
}
