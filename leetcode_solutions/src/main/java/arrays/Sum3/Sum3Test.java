package arrays.Sum3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 *
 * Output: [[-1,-1,2],[-1,0,1]]
 */
public class Sum3Test {
	public static void main(String[] args) {
		int[] nums= {-1,0,1,2,-1,-4};
		//System.out.println(threeSum(nums));
		//System.out.println(threeSum3Streams(nums));
		//System.out.println(threeSumHashMap(nums));
		System.out.println(threeSumhashmap2(nums));
		System.out.println(threeSum2Pointer(nums));
	}

	public static List<List<Integer>> threeSum2(int[] nums) {
		Set<List<Integer>> res = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[k]);
						res.add(tmp);
					}
				}
			}
		}
		return new ArrayList<>(res);
	}

		public static List<List<Integer>> threeSum(int[] nums) {
		List<Integer> list;
		Set<List<Integer>> set= new HashSet<>();
		Arrays.sort(nums);
		for (int i=0; i<nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j+1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						set.add(list);
					}
				}
			}
		}

		 return new ArrayList<>(set);

		}

	public static List<List<Integer>> threeSum3Streams(int[] nums) {
		// Sort the array first
		Arrays.sort(nums);

		// Generate triplets using streams
		return IntStream.range(0, nums.length)
				.boxed() // Convert int indices to Integer
				.flatMap(i -> IntStream.range(i + 1, nums.length)
						.boxed()
						.flatMap(j -> IntStream.range(j + 1, nums.length)
								.filter(k -> nums[i] + nums[j] + nums[k] == 0)
								.mapToObj(k -> Arrays.asList(nums[i], nums[j], nums[k]))))
				.distinct() // Remove duplicate triplets
				.collect(Collectors.toList());

	}

		public static List<List<Integer>> threeSumHashMap(int[] nums) {
			Arrays.sort(nums);
			Map<Integer, Integer> count = new HashMap<>();
			for (int num : nums) {
				count.put(num, count.getOrDefault(num, 0) + 1);
			}

			List<List<Integer>> res = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				count.put(nums[i], count.get(nums[i]) - 1);
				if (i > 0 && nums[i] == nums[i - 1]) continue;

				for (int j = i + 1; j < nums.length; j++) {
					count.put(nums[j], count.get(nums[j]) - 1);
					if (j > i + 1 && nums[j] == nums[j - 1]) continue;

					int target = -(nums[i] + nums[j]);
					if (count.getOrDefault(target, 0) > 0) {
						res.add(Arrays.asList(nums[i], nums[j], target));
					}
				}

				for (int j = i + 1; j < nums.length; j++) {
					count.put(nums[j], count.get(nums[j]) + 1);
				}
			}
			return res;
		}

	/**
	 *
	 * The goal is to find three numbers nums[i], nums[j], and nums[k] such that:
	 *
	 *      nums[i] + nums[j] + nums[k] = 0
	 *
	 *       This can be rewritten as:
	 *
	 *       nums[j] + nums[k] = -nums[i]
	 *
	 *      So, for each number nums[i] in the array, the problem reduces to a Two-Sum Problem on the subarray starting from nums[i+1] to the end of the array.
 	 *
	 *  @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSumhashmap2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		// Sort the array to handle duplicates easily
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			// Skip duplicate values for the first number
			if (i > 0 && nums[i] == nums[i - 1]) continue;

			int target = -nums[i]; //  nums[j] + nums[k] = -nums[i]

			Sum2(nums, i, target, result);
		}

		return result;
	}

	private static void Sum2(int[] nums, int i, int target, List<List<Integer>> result) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int j = i + 1; j < nums.length; j++) {
			int complement = target - nums[j];

			if (map.containsKey(complement)) {
				// Add the triplet
				result.add(Arrays.asList(nums[i], nums[j], complement));

				// Skip duplicate second and third numbers
				while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
			}

			map.put(nums[j], j);
		}
	}

	public static List<List<Integer>> threeSum2Pointer(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();


		for(int i=0;i<nums.length;i++){

			// Check if the current element is a duplicate of the previous element and skip it if it is.
			if (i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			int j=i+1;
			int k= nums.length-1;
			while(j<k) {

				if(nums[i]+nums[j]+nums[k]==0){
					res.add(Arrays.asList(nums[i], nums[j], nums[k]));

					/* Increment the j pointer to skip any duplicate elements. */
					/**
					 * when we found one of the target triplets, we move j once but we check the number after we move j.
					 * If the number is the same previous number, we continue to move j until we find differnt number,
					 * so that we can avoid duplicate combination.
					 */
					j++;
					while (nums[j] == nums[j-1] && j < k) {
						j++;
					}
					/*****            *******/
				}
				if ((nums[i] + nums[j] + nums[k] < 0)) {
					j++;
				}else{
					k--;
				}

			}
		}





		return res;
	}

}
