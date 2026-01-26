package core.dsa.implementation.linkedlist_stack_and_queue;

public class MyDoublyLinkedList<E> implements DoublyLinkedList<E> {

	private class Node {
		E data;
		Node prev;
		Node next;

		Node(E data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public MyDoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	@Override
	public void addFirst(E data) {
		Node newNode = new Node(data);
		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		size++;
	}

	@Override
	public void addLast(E data) {
		Node newNode = new Node(data);
		if (size == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}

	@Override
	public E removeFirst() {
		if (size == 0) {
			throw new IllegalStateException("UnderFlowException :: List is empty");
		}
		E data = head.data;
		head = head.next;
		if (head != null) {
			head.prev = null;
		} else {
			tail = null; // List is now empty
		}
		size--;
		return data;
	}

	@Override
	public E removeLast() {
		if (size == 0) {
			throw new IllegalStateException("UnderFlowException :: List is empty");
		}
		E data = tail.data;
		tail = tail.prev;
		if (tail != null) {
			tail.next = null;
		} else {
			head = null; // List is now empty
		}
		size--;
		return data;
	}

	@Override
	public E getFirst() {
		return (head != null) ? head.data : null;
	}

	@Override
	public E getLast() {
		return (tail != null) ? tail.data : null;
	}

	public E remove(Node node) {
		if (node == null) {
			throw new IllegalArgumentException("Node to be removed cannot be null");
		}
		if (node == head) {
			return removeFirst();
		}
		if (node == tail) {
			return removeLast();
		}
		node.prev.next = node.next;
		node.next.prev = node.prev;
		size--;
		return node.data;
	}

}
