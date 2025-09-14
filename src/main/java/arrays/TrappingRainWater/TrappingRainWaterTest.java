package arrays.TrappingRainWater;

public class TrappingRainWaterTest {

	public static void main(String[] args) {

		trap(new int[] { 0,2,0,3,1,0,1,3,2,1 });
	}

	public static int trap(int[] height) {

		int maxArea= 0;

		for(int x=0; x<height.length; x++) {

			if(height[x]<=0){
				continue;
			}

			int y = x+1;
			while(y<height.length){
				if(height[y] < height[x]){
					y++;
					continue;
				}
				// calculate area
				int maxHeight= height[x]<height[y]? height[x]:height[y];
				 maxArea =  maxArea+ maxHeight*(y-x);


		}



	}
		return maxArea;
}
}
