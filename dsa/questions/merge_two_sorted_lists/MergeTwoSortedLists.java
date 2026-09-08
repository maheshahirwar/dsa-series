package dsa.questions.merge_two_sorted_lists;

/**
 * Leetcode Problem 21: Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/ TC - O(N+M)
 */
class Solution {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode ansList = new ListNode();
		ListNode temp = ansList;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				temp.next = new ListNode(list1.val);
				list1 = list1.next;
			} else {
				temp.next = new ListNode(list2.val);
				list2 = list2.next;
			}
			temp = temp.next;
		}

		while (list1 != null) {
			temp.next = new ListNode(list1.val);
			list1 = list1.next;
			temp = temp.next;
		}

		while (list2 != null) {
			temp.next = new ListNode(list2.val);
			list2 = list2.next;
			temp = temp.next;
		}
		return ansList.next;

	}
}

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);
		printList(list1);
		printList(list2);
		ListNode mergedList = solution.mergeTwoLists(list1, list2);
		printList(mergedList);
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

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}