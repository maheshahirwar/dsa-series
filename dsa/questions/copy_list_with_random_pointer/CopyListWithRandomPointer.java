package dsa.questions.copy_list_with_random_pointer;


//Definition for a Node
class Node {
 int val;
 Node next;
 Node random;

 public Node(int val) {
     this.val = val;
     this.next = null;
     this.random = null;
 }
}


class Solution {
 public Node copyRandomList(Node head) {
     if(head == null)return null;
     Node node = head;

     while(node!= null){
         Node temp = node.next;
         node.next = new Node(node.val);
         node.next.next = temp;
         node = temp;
     }
     node = head;

     while(node!=null){
         node.next.random = (node.random!=null)?node.random.next:null;
         node = node.next.next;
     }

     Node org = head;
     Node copy = head.next;
     Node newhead = copy;
     while(org!=null && copy!=null){
         org.next = (org.next!=null)?org.next.next:null;
         copy.next = (copy.next!=null)?copy.next.next:null;
         org = org.next;
         copy = copy.next;
     }
     return newhead;
 }
}
public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		Node head = new Node(7);
		head.next = new Node(13);
		head.next.next = new Node(11);
		head.next.next.next = new Node(10);
		head.next.next.next.next = new Node(1);

		head.random = null;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next;
		head.next.next.next.next.random = head;

		Node copiedListHead = solution.copyRandomList(head);

		
		// compare the original list and the copied list
		
		Node originalNode = head;
		Node copiedNode = copiedListHead;
		
		while (originalNode != null && copiedNode != null) {
		    System.out.println("Original Node Value: " + originalNode.val + ", Copied Node Value: " + copiedNode.val);
		    if (originalNode.random != null) {
		        System.out.println("Original Node Random Value: " + originalNode.random.val);
		    } else {
		        System.out.println("Original Node Random Value: null");
		    }
		    if (copiedNode.random != null) {
		        System.out.println("Copied Node Random Value: " + copiedNode.random.val);
		    } else {
		        System.out.println("Copied Node Random Value: null");
		    }
		    originalNode = originalNode.next;
		    copiedNode = copiedNode.next;
		}
	}

}
