package dsa.questions.remove_nth_node_from_end_of_linkedList;

class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode start = new ListNode();
		ListNode slow = start;
		ListNode fast = start;
		start.next = head;

		while (n-- > 0)
			fast = fast.next;

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return start.next;

	}
}

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		int n = 2; // Remove the 2nd node from the end
		ListNode result = solution.removeNthFromEnd(head, n);

		// Print the modified list
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
