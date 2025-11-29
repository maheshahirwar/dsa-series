package core.dsa.implementation.linkedlist_stack_and_queue;

public class MyLinkedList<E> implements LinkedList<E> {

	// Simple singly-linked node
	private static class Node<E> {
		E data;
		Node<E> next;
		Node(E data) { this.data = data; }
	}

	private Node<E> head;
	private Node<E> tail;
	private int size = 0;

	@Override
	public void add(E element) {
		Node<E> node = new Node<>(element);
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		}
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		Node<E> cur = head;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur.data;
	}

	@Override
	public int search(E target) {
		Node<E> cur = head;
		int idx = 0;
		while (cur != null) {
			if (target == null) {
				if (cur.data == null) return idx;
			} else {
				if (target.equals(cur.data)) return idx;
			}
			idx++;
			cur = cur.next;
		}
		return -1;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		if (index == 0) {
			E val = head.data;
			head = head.next;
			if (head == null) tail = null;
			size--;
			return val;
		}
		Node<E> prev = head;
		for (int i = 1; i < index; i++) {
			prev = prev.next;
		}
		Node<E> toRemove = prev.next;
		prev.next = toRemove.next;
		if (toRemove == tail) tail = prev;
		size--;
		return toRemove.data;
	}

}