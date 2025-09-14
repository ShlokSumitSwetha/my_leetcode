package arrays.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Twosum3 {

    public static void main(String[] args) {
        int[] i1 =  {5,4,5,15};

        int target= 10;
        int[] result = twoSum(i1, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        // Build the hash table
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        // Find the complement
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{}; // No solution found
    }
}