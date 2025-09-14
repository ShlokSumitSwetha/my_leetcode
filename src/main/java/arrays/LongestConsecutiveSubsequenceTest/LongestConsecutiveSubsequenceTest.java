package arrays.LongestConsecutiveSubsequenceTest;

import java.util.*;
import java.util.stream.*;

/**
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * Example 3:
 *
 * Input: nums = [1,0,1,2]
 * Output: 3
 */

public class LongestConsecutiveSubsequenceTest {
	public static void main(String[] args) {

		int[] input = {9,1,4,7,3,-1,0,5,8,-1,6};

		System.out.println(lengthOfLIS_binarySearch(input));

	}



	/*
	 * @param nums
	 * @return
	 */

		public static int lengthOfLIS_binarySearch(int[] nums) {
			List<Integer> result = new ArrayList<>();
			List<Integer> sub = Arrays.stream(nums)   // IntStream
					.boxed()       // convert int -> Integer
					.collect(Collectors.toList());

			Collections.sort(sub);
			System.out.println("Sorted"+sub);
			if(nums.length>=1) {
				result.add(sub.get(0));
			}
			for (int i = 0; i < nums.length-1; i++) {
				int value = sub.get(i);
			  if(value+1 ==(sub.get(i+1))){
				  result.add(sub.get(i+1));
			  }
			}
			System.out.println(result);
			return result.size();
		}

}
