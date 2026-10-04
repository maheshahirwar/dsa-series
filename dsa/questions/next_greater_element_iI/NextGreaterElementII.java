package dsa.questions.next_greater_element_iI;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int[]nge = nge(nums);

        return Arrays.copyOfRange(nge,0,nums.length);
    }

    private int[] nge(int[]nums){
        Stack<Integer>stack = new Stack<>();

        int[]nge = new int[nums.length*2];
        for(int i=nums.length*2-1;i>=0;i--){
            while(!stack.empty() && stack.peek()<=nums[i%nums.length]){
                stack.pop();
            }

            nge[i] = (stack.empty()?-1:stack.peek());

            stack.push(nums[i%nums.length]);
        }
        return nge;
    }
}

public class NextGreaterElementII {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		int[] nums = {1,2,1};
		int[] result = solution.nextGreaterElements(nums);
		for (int num : result) {
			System.out.print(num + " ");
		}
	}

}
