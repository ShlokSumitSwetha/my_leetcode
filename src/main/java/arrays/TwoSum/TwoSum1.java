package arrays.TwoSum;

import java.util.Arrays;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,5,5,11};
        System.out.println(Arrays.toString(twoSum(nums, 10)));
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result= new int[2];
        for (int i = 0; i<nums.length-1; i++){
            for (int j = 1; j<=nums.length-1; j++) {
                int value1= nums[i];
                int value2= nums[j];
                if(j!=i && (target == (nums[i] + nums[j]))){
                    System.out.println("value1:"+value1+"value2:"+value2);
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }
}
