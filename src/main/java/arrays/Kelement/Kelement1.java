package arrays.Kelement;

import java.util.*;

public class Kelement1 {
	public static void main(String[] args) {

		int[][] grid = {
				{5, 3,7},
				{8, 2,6}
		};
        int[] limits= {2,2};
		int k = 3;
		System.out.println(maxSum( grid, limits,  k));
	}

	public static  long maxSum(int[][] grid, int[] limits, int k) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		// Convert arrays to map
		// Convert 2D array to map
		int i =0;
		for (int[] pair : grid) {
			List<Integer> values= new ArrayList<>();
			// Dynamically add all elements in the row
			for (int num : pair) {
				values.add(num);
			}
			Collections.sort(values, Collections.reverseOrder());
			map.put(i, values);
			i++;
		}
		List<Integer> selectedValues= new ArrayList<>();

		int j=-0;
		for(int t: limits){
			List<Integer> values = map.get(j);
			// Ensure we don't exceed the list size
			if (t > values.size()) {
				t = values.size();
			}
			selectedValues.addAll(new ArrayList<>(values.subList(0, t)));
			j++;
		}
		Collections.sort(selectedValues, Collections.reverseOrder());

		List<Integer> topKValues = selectedValues.subList(0, Math.min(k, selectedValues.size()));
		long totalSum = topKValues.stream().mapToLong(Integer::longValue).sum();
		System.out.println(map);
		System.out.println(topKValues);
		System.out.println(totalSum);


		return totalSum;
	}
}
