package programming.injava.array;

import java.util.HashMap;
import java.util.Map;

/*

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

[-1,-2,-3,-4,-5]
-8

Runtime: 44 ms, faster than 36.13% of Java online submissions for Two Sum.
Memory Usage: 41.8 MB, less than 9.50% of Java online submissions for Two Sum.

*/

public class TwoSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tmp = { 0, 2, 7, 15, 16, 19 };

		solveTwoSumProblem(tmp, 18);
		solveTwoSumProblem(tmp, 31);
		solveTwoSumProblem(tmp, 22);
		solveTwoSumProblem(tmp, 19);

		tmp = new int[] { -1, -2, -3, -4, -5 };
		solveTwoSumProblem(tmp, -8);
		
		System.out.println("====================findTwoSumV1===================");
		findTwoSumV1(new int[] { 0, 2, 15, 16, 7 }, 9);
	}

	private static void solveTwoSumProblem(int[] nums, int target) {
		int li = 0, ri = 0, num2;
		boolean found = false;
		for (int i = 0; i < nums.length && !found; i++) {
			num2 = target - nums[li = i];
			ri = nums.length - 1;
			while (ri > i) {
				if (nums[ri] == num2) {
					found = true;
					break;
				} else
					ri--;
			}

		}
		if (nums[li] + nums[ri] == target) {
			System.out.println("[" + li + ", " + ri + "]");
		}
	}
	
	private static void findTwoSumV1(int[] nums, int target) {
		Map<Integer, Integer> eles = new HashMap<Integer, Integer>();
		
		int otherElement = 0;
		
		for(int i = 0; i <  nums.length; i++) {
			otherElement = target - nums[i];
			
			if(eles.containsKey(otherElement)) {
				System.out.println("[" + eles.get(otherElement) + ", " + i + "]");
				break;
			}
			eles.put(nums[i], i);
		}
		
	}

}
