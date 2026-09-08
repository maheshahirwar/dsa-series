package dsa.questions.detect_cycle_in_linkedList;

/**
 * Leetcode Problem 141: Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/ TC - O(N)
 */
class Solution {
	public boolean hasCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}

public class DetectCycleInLinkedList {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		// Creating a cycle for testing
		head.next.next.next.next = head.next;

		boolean result = solution.hasCycle(head);
		System.out.println("Linked List has cycle: " + result);
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}