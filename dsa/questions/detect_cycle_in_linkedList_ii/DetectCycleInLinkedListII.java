package dsa.questions.detect_cycle_in_linkedList_ii;

/**
 * Leetcode Problem 142: Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/ TC - O(N)
 */
class Solution {
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (fast == null || fast.next == null) {
			return null; // NO cycle
		}
		fast = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}

public class DetectCycleInLinkedListII {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		// Creating a cycle for testing
		head.next.next.next.next = head.next;
		ListNode result = solution.detectCycle(head);
		if (result != null) {
			System.out.println("Cycle detected at node with value: " + result.val);
		} else {
			System.out.println("No cycle detected");
		}
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