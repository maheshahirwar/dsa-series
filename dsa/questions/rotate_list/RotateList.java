package dsa.questions.rotate_list;

/**
 * Leetcode Problem 61: Rotate List https://leetcode.com/problems/rotate-list/
 * TC - O(N)
 */
class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return head;
		int n = 1;
		ListNode fast = head;
		while (fast.next != null) {
			n++;
			fast = fast.next;
		}
		k = k % n;
		if (k == 0)
			return head; // No rotation required
		int diff = n - k;
		ListNode slow = head;
		while (diff-- > 1) {
			slow = slow.next;
		}
		ListNode newHead = slow.next;
		slow.next = null;
		fast.next = head;
		return newHead;
	}
}

public class RotateList {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		int k = 2; // Rotate the list to the right by 2 places
		ListNode result = solution.rotateRight(head, k);

		// Print the rotated list
		ListNode current = result;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
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
