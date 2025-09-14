package arrays.move_zeros;

/**
 * ✅ Example:
 *
 * Input:
 *
 * [0, 1, 0, 3, 12]
 *
 * Output
 *
 * [1, 3, 12, 0, 0]
 */

public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int insertPos = 0;

        // Step 1: Move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        // Step 2: Fill the rest with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

        // Print the result
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}