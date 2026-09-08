package dsa.questions.intersection_of_two_linkedLists;

/**
 * Leetcode Problem 160: Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/ TC - O(N+M)
 */
class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int n = len(headA);
		int m = len(headB);
		int diff = Math.abs(n - m);
		ListNode largeNode = (n > m) ? headA : headB;
		ListNode smallNode = (n > m) ? headB : headA;
		while (diff-- > 0) {
			largeNode = largeNode.next;
		}

		while (largeNode != null && smallNode != null) {
			if (largeNode == smallNode)
				return largeNode;
			largeNode = largeNode.next;
			smallNode = smallNode.next;
		}
		return null;
	}

	private int len(ListNode head) {
		ListNode node = head;
		int len = 0;
		while (node != null) {
			len++;
			node = node.next;
		}
		return len;
	}
}

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode headA = new ListNode(4);
		headA.next = new ListNode(1);
		ListNode intersection = new ListNode(8);
		intersection.next = new ListNode(4);
		intersection.next.next = new ListNode(5);
		headA.next.next = intersection;

		ListNode headB = new ListNode(5);
		headB.next = new ListNode(0);
		headB.next.next = new ListNode(1);
		headB.next.next.next = intersection;

		ListNode result = solution.getIntersectionNode(headA, headB);
		if (result != null) {
			System.out.println("Intersection at node with value: " + result.val);
		} else {
			System.out.println("No intersection");
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