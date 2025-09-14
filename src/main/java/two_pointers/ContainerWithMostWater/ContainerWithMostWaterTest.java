package two_pointers.ContainerWithMostWater;

public class ContainerWithMostWaterTest {

	public static void main(String[] args) {
		;
		System.out.println(maxAreaBruteForce(new int[] { 1,7,2,5,4,7,3,6 }));
		System.out.println(maxAreaTwoPointer(new int[] { 1,7,2,5,4,7,3,6 }));
	}

	public static int maxAreaBruteForce(int[] heights) {

		int totalMaxArea=0;

		for(int i=0;i<heights.length;i++){
			for(int j=i+1;j<heights.length;j++){
				int maxHeight= heights[i]<heights[j]? heights[i]:heights[j];
				int maxArea =  maxHeight*(j-i);
				if(maxArea >totalMaxArea){
					totalMaxArea = maxArea;
				}
			}
		}
		return totalMaxArea;
	}

	public static int maxAreaTwoPointer(int[] heights) {

		int totalMaxArea=0;

		int startPointer= 0;
		int endPointer= heights.length-1;

		while(startPointer<endPointer) {
			int maxHeight = heights[startPointer] < heights[endPointer] ? heights[startPointer] : heights[endPointer];
			int maxArea = maxHeight * (endPointer - startPointer);
			if (maxArea > totalMaxArea) {
				totalMaxArea = maxArea;
			}
			// move the pointers with lowest height forward
			if (heights[startPointer] < heights[endPointer]) {
				startPointer++;
			} else {
				endPointer--;
			}
		}
		return totalMaxArea;

		}

	}

