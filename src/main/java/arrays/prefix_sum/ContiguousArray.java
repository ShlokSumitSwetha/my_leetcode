package arrays.prefix_sum;

import java.util.*;

public class ContiguousArray {
	public static void main(String[] args) {

		ContiguousArray c = new  ContiguousArray();
		int[] inputArray = {0,1,1,1,1,1,0,0,0};
		System.out.println(c.findMaxLength(inputArray));

	}


	public int findMaxLength(int[] nums) {
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0){
				nums[i]=-1;
			}
		}
		Map<Integer,Integer> map = new HashMap<>();
		map.put(0,-1);
		int sum = 0;
		int maxLength = 0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			if(map.containsKey(sum)){
				maxLength = Math.max(maxLength, i-map.get(sum));
			}else{
				map.put(sum,i);
			}
		}
		return maxLength;
	}
}