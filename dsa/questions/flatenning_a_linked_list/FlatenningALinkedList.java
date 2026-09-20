package dsa.questions.flatenning_a_linked_list;


class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}

class Solution {
    public Node flatten(Node root) {
        if(root == null || root.next == null)return root;
       Node newNode = flatten(root.next);
       return merge(root,newNode);
    }
    private Node merge(Node l1, Node l2){
        Node ans = new Node(0);
        Node node = ans;
        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                node.bottom = l1;
                l1 = l1.bottom;
            }else{
                node.bottom = l2;
                l2 = l2.bottom;
            }
            node = node.bottom;
        }
        if(l1!=null)node.bottom = l1;
        else node.bottom = l2;
        
        return ans.bottom;
    }
}
public class FlatenningALinkedList {

	public static void main(String[] args) {
		Solution solution = new Solution();
		Node head = new Node(5);
		head.bottom = new Node(7);
		head.bottom.bottom = new Node(8);
		
		head.next = new Node(10);
		head.next.bottom = new Node(20);
		
		head.next.next = new Node(19);
		head.next.next.bottom = new Node(22);
		
		head.next.next.next = new Node(28);
		head.next.next.next.bottom = new Node(40);
		head.next.next.next.bottom.bottom = new Node(45);
		
		
		Node flattenedList = solution.flatten(head);
		
		// verify the flattened list
		Node current = flattenedList;
		while (current != null) {
		    System.out.print(current.data + "->");
		    current = current.bottom;
		}
		System.out.println("null");
	}

}
