class Solution {
    public int maxArea(int[] height) {
      int left=0,right=height.length-1;
      int ans=0;
      while(left<right){
        int min = Math.min(height[left],height[right]);
        int area = min * (right-left);
        ans = Math.max(ans,area);

        while(height[left]<=min && left<right)left++;
        while(height[right]<=min && left<right)right--;
      }
      return ans;
    }
}
