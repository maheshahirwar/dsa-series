package dsa.questions.sort_lists;


//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
 
class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)return head;

        ListNode mid = findMid(head);
        ListNode rightNode = mid.next;
        mid.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(rightNode);
        return merge(left,right);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode ans = new ListNode();
        ListNode node = ans;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if(l1!=null)node.next = l1;
        else node.next = l2;
        return ans.next;
    }


    private ListNode findMid(ListNode node){
        ListNode slow = node, fast = node;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

public class SortLists {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);

		ListNode sortedHead = solution.sortList(head);

		while (sortedHead != null) {
			System.out.print(sortedHead.val + " ");
			sortedHead = sortedHead.next;
		}
	}

}
