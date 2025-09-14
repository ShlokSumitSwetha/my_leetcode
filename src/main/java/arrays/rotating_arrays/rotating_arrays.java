package arrays.rotating_arrays;
import java.util.*;
import java.util.stream.*;

/**
 *
 * Example:
 *
 * nums = [1, 2, 3, 4, 5, 6, 7], k = 3
 * Expected Output: [5, 6, 7, 1, 2, 3, 4]
 *
 */
public class rotating_arrays {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // In case k > n

        // Reverse whole array
        reverse(nums, 0, n - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining n-k elements
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);

        rotateBruteForce(nums, k);

        rotateExtraArray(nums, k);

        rotateCollections(nums, k);

        System.out.println("Rotated Array: " + Arrays.toString(nums));
    }

    public static void rotateBruteForce(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        for (int i = 0; i < k; i++) {
            int last = nums[n - 1];
            nums[0] = last;
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
        }
    }

    public static void rotateExtraArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handle k > n
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }

        System.arraycopy(result, 0, nums, 0, n);
    }


    public static void rotateCollections(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);

        Collections.rotate(list, k);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
    }

    public static int[] rotateJava8(int[] nums, int k) {
        int n = nums.length;
       return IntStream.range(0, n)
                .map(i -> nums[(i - k + n) % n])
                .toArray();
    }
}