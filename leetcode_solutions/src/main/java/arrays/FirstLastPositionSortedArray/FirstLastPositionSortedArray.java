package arrays.FirstLastPositionSortedArray;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class FirstLastPositionSortedArray {
	public static void main(String[] args) {

		int[] inputArray= {5,7,7,8,8,10};
		int target = 8;
		System.out.println(Arrays.toString(searchRange(inputArray,target)));

	}
		public static int[] searchRange(int[] nums, int target) {

		int[] output= new int[2];

		for(int i =0 ; i< nums.length-1; i++){

			if(nums[i]==target){
				int length = output.length;
				output[0] = i;
				output[1] = i;
			}
		}
		 if(output.length== 0){
			 output = new int[]{-1, -1};
		 }

		return output;
		}

	public int search(int[] nums, int target) {
		int r = nums.length - 1, l = 0;
		while (r >= l) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target) return mid;
			if (nums[mid] >= nums[l]) {
				if (target < nums[mid] && target >= nums[l]) {
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			} else {
				if (target > nums[mid] && target < nums[l]) {
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}
		}
		return -1;
	}
}
