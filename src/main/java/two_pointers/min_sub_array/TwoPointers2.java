package two_pointers.min_sub_array;

public class TwoPointers2 {

	public static void main(String[] args) {
		TwoPointers2 twoPointers2 = new TwoPointers2();

		int[] nums= {2,3,1,2,4,3};
		System.out.println(twoPointers2.minSubArrayLen(7, nums));
	}

	public int minSubArrayLen(int target, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		int sum = 0;

		for (int left = 0, right = 0; right < nums.length; ++right) {
			sum += nums[right];
			while (sum >= target) {
				minLength = Math.min(minLength, right - left + 1);
				sum -= nums[left++];
			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
