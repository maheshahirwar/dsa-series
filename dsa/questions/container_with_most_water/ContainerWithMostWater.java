package dsa.questions.container_with_most_water;

class Solution {
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int ans = 0;
		while (left < right) {
			int min = Math.min(height[left], height[right]);
			int area = min * (right - left);
			ans = Math.max(ans, area);

			while (height[left] <= min && left < right) {
				left++;
			}
			while (height[right] <= min && left < right) {
				right--;
			}
		}
		return ans;
	}
}

public class ContainerWithMostWater {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int result = solution.maxArea(height);
		System.out.println("The maximum area of water that can be contained is: " + result); // 49
	}
}
