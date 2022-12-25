package programming.injava.array;

public class FindSubArrayOfGivenSum {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 1, 3, 5 };

		findSubArrayOfGivenSum(arr, 2);
	}

	static void findSubArrayOfGivenSum(int[] arr, int sum) {
		int left = 0, right = 0;
		int subArraySum = 0;
		while (right < arr.length) {
			subArraySum = subArraySum + arr[right];

			if (subArraySum == sum) {
				// found sub array with given sum so return
				System.out.println("Subarray start index : " + left + ", last index: " + right);
				return;
			}

			while(subArraySum > sum && left <= right) {
				subArraySum = subArraySum - arr[left];
				left++;
				
				if (subArraySum == sum) {
					// found sub array with given sum so return
					System.out.println("Subarray start index : " + left + ", last index: " + right);
					return;
				}
				
			}
			right++;
		}
	}
}
