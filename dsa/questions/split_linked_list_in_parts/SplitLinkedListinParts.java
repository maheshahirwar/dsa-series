package dsa.questions.split_linked_list_in_parts;

/**
 * Leetcode Problem 725: Split Linked List in Parts
 * https://leetcode.com/problems/split-linked-list-in-parts/ TC - O(N)
 */
class Solution {
	public ListNode[] splitListToParts(ListNode head, int k) {
		int len = len(head);
		ListNode[] ansList = new ListNode[k];
		int parts = len / k;
		int extraPart = len % k;
		ListNode node = head;
		for (int i = 0; i < k; i++) {
			ansList[i] = node;
			int distance = parts + ((extraPart-- > 0) ? 1 : 0);

			while (distance-- > 1)
				node = node.next;
			if (node == null)
				break;
			ListNode next = node.next;
			node.next = null;
			node = next;
		}
		return ansList;
	}

	private int len(ListNode head) {
		int len = 0;
		ListNode node = head;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}
}

public class SplitLinkedListinParts {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		int k = 3; // Split the list into 3 parts
		ListNode[] result = solution.splitListToParts(head, k);

		// Print the split parts
		for (int i = 0; i < result.length; i++) {
			System.out.print("Part " + (i + 1) + ": ");
			ListNode current = result[i];
			while (current != null) {
				System.out.print(current.val + " ");
				current = current.next;
			}
			System.out.println();
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
