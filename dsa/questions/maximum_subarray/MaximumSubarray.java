import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        int largestSum = Integer.MIN_VALUE;
        int runningSum = 0;
        for(int num:nums){
            runningSum = Math.max(num, runningSum+num);
            largestSum = Math.max(largestSum, runningSum); 
        }
        return largestSum;
    }
}
public class MaximumSubarray {
    public static void main(String[] args) {
      Solution solution = new Solution();
      int largestSum = solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
      System.out.println(largestSum);
    }
}
