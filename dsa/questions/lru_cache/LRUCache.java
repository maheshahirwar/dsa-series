package dsa.questions.lru_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	private int capacity;
    Map<Integer,Node>cache;
    Node head,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        /*
         null <---- head <====> tail ----> null
        */
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node!=null){
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node!=null){
           remove(node);
        }

        if(cache.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }

    private void insert(Node node){
        cache.put(node.key,node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(Node node){
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node{
        int key,value;
        Node next,prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
	public static void main(String[] args) {
		
		// ["LRUCache","put","put","get","put","get","put","get","get","get"]
		//[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
		LRUCache obj = new LRUCache(2);
		
		obj.put(1, 1);
		obj.put(2, 2);
		
		System.out.println(obj.get(1)); // returns 1
		
		obj.put(3, 3); // evicts key 2
		
		System.out.println(obj.get(2)); // returns -1 (not found)
		
		obj.put(4, 4); // evicts key 1
		
		System.out.println(obj.get(1)); // returns -1 (not found)
		
		System.out.println(obj.get(3)); // returns 3
		
		System.out.println(obj.get(4)); // returns 4

	}

}
