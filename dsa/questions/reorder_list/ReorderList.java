package dsa.questions.reorder_list;

/**
 * Leetcode Problem 143: Reorder List
 * https://leetcode.com/problems/reorder-list/ TC - O(N)
 */
class Solution {
	public void reorderList(ListNode head) {
		ListNode mid = findMiddle(head);
		ListNode reversed = reverse(mid.next);
		mid.next = null;
		mergeTwoLists(head, reversed);
	}

	private ListNode findMiddle(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode curr = head, prev = null;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private void mergeTwoLists(ListNode l1, ListNode l2) {
		while (l1 != null && l2 != null) {
			ListNode next1 = l1.next;
			ListNode next2 = l2.next;
			l1.next = l2;
			l2.next = next1;
			l1 = next1;
			l2 = next2;
		}
	}
}

public class ReorderList {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		solution.reorderList(head);
		printList(head);
	}

	private static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println("null");
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
