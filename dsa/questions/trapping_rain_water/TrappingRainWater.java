package dsa.questions.trapping_rain_water;

/**
 * Brute Force Solution TC : O(2xN^2) SC : O(1)
 */
class Solution {
	public int trap(int[] height) {
		int trappedWater = 0;
		for (int i = 0; i < height.length; i++) {

			int leftMax = 0, rightMax = 0;
			int left = i, right = i;
			while (left >= 0)
				leftMax = Math.max(leftMax, height[left--]);
			while (right < height.length)
				rightMax = Math.max(rightMax, height[right++]);

			trappedWater += leftMax > rightMax ? Math.max(0, rightMax - height[i]) : Math.max(0, leftMax - height[i]);
		}
		return trappedWater;
	}
}

/**
 * Better Solution TC : O(N) SC : O(N)
 */
class BetterSolution extends Solution {

	public int trap(int[] height) {
		int trappedWater = 0;
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		for (int i = 0; i < height.length; i++) {
			leftMax[i] = i > 0 ? Math.max(leftMax[i - 1], height[i]) : height[i];
		}
		for (int i = height.length - 1; i >= 0; i--) {
			rightMax[i] = i < height.length - 1 ? Math.max(rightMax[i + 1], height[i]) : height[i];
		}
		for (int i = 0; i < height.length; i++) {
			trappedWater += leftMax[i] > rightMax[i] ? Math.max(0, rightMax[i] - height[i])
					: Math.max(0, leftMax[i] - height[i]);
		}
		return trappedWater;
	}
}

/**
 * Optimized Solution TC : O(N) SC : O(1)
 */
class OptimizedSolution extends Solution {
	public int trap(int[] height) {
		int trappedWater = 0, left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;
		while (left <= right) {
			if (leftMax < rightMax) {
				trappedWater += Math.max(0, leftMax - height[left]);
				leftMax = Math.max(leftMax, height[left++]);
			} else {
				trappedWater += Math.max(0, rightMax - height[right]);
				rightMax = Math.max(rightMax, height[right--]);
			}
		}
		return trappedWater;
	}
}

public class TrappingRainWater {

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] heights = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Brute Force :: Trapped water : " + solution.trap(heights)); // TC : O(N^2), SC : O(1)

		solution = new BetterSolution();
		System.out.println("Better Solution :: Trapped water : " + solution.trap(heights)); // TC : O(N), SC : O(N)

		solution = new OptimizedSolution();
		System.out.println("Optimized Solution :: Trapped water : " + solution.trap(heights)); // TC : O(N), SC : O(1)
	}

}
