package dsa.questions.palindrome_linked_list;

/**
 * Leetcode Problem 234: Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/ TC - O(N)
 */
class Solution {
	public boolean isPalindrome(ListNode head) {
		ListNode middle = findMiddle(head);
		ListNode reversed = reverse(middle);
		return isPalindrome(head, reversed);
	}

	private boolean isPalindrome(ListNode l1, ListNode l2) {
		while (l1 != null && l2 != null) {
			if (l1.val != l2.val)
				return false;
			l1 = l1.next;
			l2 = l2.next;
		}
		return true;
	}

	private ListNode findMiddle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}

public class PalindromeLinkedList {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);

		boolean result = solution.isPalindrome(head);
		System.out.println("Is the linked list a palindrome? " + result);
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int x) {
		val = x;
		next = null;
	}
}
