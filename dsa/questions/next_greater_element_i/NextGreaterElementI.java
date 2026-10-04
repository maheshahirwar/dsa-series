package dsa.questions.next_greater_element_i;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
     Map<Integer,Integer>nge = nextGreaterElement(nums2);

     int[]ans = new int[nums1.length];
     for(int i=0;i<nums1.length;i++){
        ans[i] = nge.get(nums1[i]);
     }

     return ans;   
    }


    private Map<Integer,Integer> nextGreaterElement(int[]nums){
        Stack<Integer>stack = new Stack<>();

        Map<Integer,Integer>nge = new HashMap<>();
        for(int i=nums.length-1;i>=0;i--){

            while(!stack.empty() && stack.peek()<=nums[i]){
                stack.pop();
            } 

            nge.put(nums[i], (stack.empty()?-1:stack.peek()));


            stack.push(nums[i]);
        }

        return nge;
    }
}

public class NextGreaterElementI {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		int[] result = solution.nextGreaterElement(nums1, nums2);
		for (int num : result) {
			System.out.print(num + " ");
		}
	}

}
