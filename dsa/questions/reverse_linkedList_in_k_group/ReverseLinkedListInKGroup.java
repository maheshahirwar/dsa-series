package dsa.questions.reverse_linkedList_in_k_group;

public class ReverseLinkedListInKGroup {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // build linked list: 1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2; // reverse in groups of k
//        Node res = solution.reverseKGroup(head, k);
        Node res = solution.reverseKGroupRecursive(head, k);

        // print result
        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }
}


class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class Solution {
    public Node reverseKGroup(Node head, int k) {
        if(head == null || k==1)return head;

        Node curr = head, newHead = null, tail = null;
        while(curr!=null){
            Node groupHead = curr;
            Node prev = null;
            int count = 0;
            while(curr!=null && count<k){
                count++;
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if(newHead == null)newHead = prev;
            if(tail!=null)tail.next = prev;
            tail = groupHead;
        }
        return  newHead;
    }

    public Node reverseKGroupRecursive(Node head, int k) {
        if(head == null || k==1)return head;

        Node prev = null, curr = head;
        int count = 0;
        while(curr!=null && count<k){
            count++;
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(curr!=null){
            head.next = reverseKGroupRecursive(curr,k);
        }
        return prev;
    }
}
