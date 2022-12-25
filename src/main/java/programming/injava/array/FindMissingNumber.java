package programming.injava.array;

/**
 * Find missing number in given array of N natural number
 * 
 * **/
public class FindMissingNumber {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 5 };
		System.out.println(findMissingNumberInGivenKNaturalNo(arr));

		arr = new int[] { 1, 2, 3, 5 };
		System.out.println(findMissingNumberInGivenKNaturalNo(arr));
	}

	static int findMissingNumberInGivenKNaturalNo(int[] arr) {
		int actualNoCount = arr.length + 1;
		int sum = (actualNoCount * (actualNoCount + 1)) / 2;

		for (int i = 0; i < arr.length; i++) {
			sum = sum - arr[i];
		}
		return sum;
	}
}
