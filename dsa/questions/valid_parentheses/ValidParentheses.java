package dsa.questions.valid_parentheses;

import java.util.Map;
import java.util.Stack;

class Solution {
    Map<Character,Character>map = Map.of(')','(','}','{',']','[');

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpen(c)){
                stack.push(c);
                continue;
            }
            if(!stack.empty() && stack.peek() == map.get(c)){
                stack.pop();
            }else{
                return false;
            }    
        }
        return stack.empty();
    }

    private boolean isOpen(char c){
        return c == '{' || c == '[' || c == '(';
    }
}

public class ValidParentheses {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		boolean isValid = solution.isValid("()[]{}");
		System.out.println(isValid);
	}

}
