//Brute force solution
class Solution {
    public int maxProduct(int[] nums) {
      int ans = Integer.MIN_VALUE;
      for(int i=0;i<nums.length;i++){
        int prod = 1;
        for(int j=i;j>=0;j--){
            prod *= nums[j];
            ans = Math.max(ans,prod);
        }
      }
      return ans;
    }
}

//Optimized Solution
class Solution {
    public int maxProduct(int[] nums) {
       int ans=Integer.MIN_VALUE, prevMin=1,prevMax=1;
       for(int i=0;i<nums.length;i++){
        int currMin = Math.min(nums[i],Math.min(prevMin*nums[i],prevMax*nums[i]));
        int currMax = Math.max(nums[i],Math.max(prevMin*nums[i],prevMax*nums[i]));
        ans = Math.max(ans,Math.max(currMax,currMin));
        prevMin = currMin;
        prevMax = currMax;
       }
       return ans;
    }
}
