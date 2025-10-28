package dsa.questions.valid_palindrome;

class Solution {
	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (!Character.isLetterOrDigit(s.charAt(left)))
				left++;
			else if (!Character.isLetterOrDigit(s.charAt(right)))
				right--;
			else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
				return false;
			else {
				left++;
				right--;
			}
		}
		return true;
	}
}

public class ValidPalindrome {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String str = "A man, a plan, a canal: Panama";
		System.out.println("Valid Palindrome : " + solution.isPalindrome(str));
	}

}
