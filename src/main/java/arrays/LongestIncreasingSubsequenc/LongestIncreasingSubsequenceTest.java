package arrays.LongestIncreasingSubsequenc;

import java.util.*;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

public class LongestIncreasingSubsequenceTest {
	public static void main(String[] args) {

		int[] input = {10,9,2,5,3,7,101,18};

		System.out.println(lengthOfLIS(input));
		//System.out.println(lengthOfLIS_binarySearch(input));
		System.out.println(lengthOfLIS_3(input));

	}

	public static int lengthOfLIS(int[] nums) {

		List<Integer> finalList = new ArrayList<>();

		for(int i= 0; i<nums.length-1; i++){

			if(nums[i] < nums[i+1]){
				finalList.add(nums[i]);
			}
		}

		return finalList.size();
	}

	/**
	 * Behavior of Collections.binarySearch
	 * 	1.	If num is already present in sub:
	 * → returns the index where it’s found.
	 * 	2.	If num is not present in sub:
	 * → returns -(insertionPoint + 1)
	 * where insertionPoint is the index where num should be inserted to keep sub sorted.
	 *
	 *
	 * @param nums
	 * @return
	 */

		public static int lengthOfLIS_binarySearch(int[] nums) {
			List<Integer> sub = new ArrayList<>();

			for (int num : nums) {
				int i = Collections.binarySearch(sub, num);

				if (i < 0) {
					i = -(i + 1);  // insertion point
				}

				if (i < sub.size()) {
					sub.set(i, num);  // replace
				} else {
					sub.add(num);     // append
				}
			}

			return sub.size();
		}

		public static int lengthOfLIS_3(int[] nums) {
			int n = nums.length;
			int[] dp = new int[n];
			Arrays.fill(dp, 1); // each element alone is a subsequence of length 1

			int maxLen = 1;

			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (nums[j] < nums[i]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				maxLen = Math.max(maxLen, dp[i]);
			}

			return maxLen;
		}

}
