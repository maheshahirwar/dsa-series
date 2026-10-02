package dsa.questions.merge_k_sorted_lists;

public class MergeKSortedLists {

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        ListNode result = solution.mergeKLists(lists);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}


// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)return null;
        return mergeSort(lists,0,lists.length-1);
    }

    private ListNode mergeSort(ListNode[]lists, int low, int high){
        if(low == high)return lists[low];

        int mid = (low+high)/2;

        ListNode left = mergeSort(lists, low, mid);
        ListNode right = mergeSort(lists,mid+1, high);
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
        else node.next =l2;
        return ans. next;
    }
}
