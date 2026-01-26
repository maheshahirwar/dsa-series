package core.dsa.implementation.linkedlist_stack_and_queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements LinkedList<E>, Iterable<E> {

	// Simple singly-linked node
	private static class Node<E> {
		E data;
		Node<E> next;

		Node(E data) {
			this.data = data;
		}
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
				if (cur.data == null)
					return idx;
			} else {
				if (target.equals(cur.data))
					return idx;
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
			if (head == null)
				tail = null;
			size--;
			return val;
		}
		Node<E> prev = head;
		for (int i = 1; i < index; i++) {
			prev = prev.next;
		}
		Node<E> toRemove = prev.next;
		prev.next = toRemove.next;
		if (toRemove == tail)
			tail = prev;
		size--;
		return toRemove.data;
	}

	@Override
	public void insert(int index, E element) {
		checkIndex(index);
		if (index == 0) {
			Node<E> newNode = new Node<>(element);
			newNode.next = head;
			head = newNode;
			if (tail == null)
				tail = head;
			size++;
			return;
		}
		Node<E> prev = head;
		for (int i = 1; i < index; i++) {
			prev = prev.next;
		}
		Node<E> newNode = new Node<>(element);
		newNode.next = prev.next;
		prev.next = newNode;
	}

	/**
	 * Removes the give n node from the linked list. The node must be part of the
	 * list. It cannot be last node.
	 * 
	 * @param node
	 * @return
	 */
	public E remove(Node<E> node) {
		if (node == null) {
			throw new IllegalArgumentException("Node to be removed cannot be null");
		}
		if (head == null) {
			throw new IllegalStateException("UnderFlowException :: List is empty");
		}
		if (node == tail) {
			throw new IllegalArgumentException("Cannot remove the last node using this method");
		}
		if (node == head) {
			return remove(0);
		}
		node.data = node.next.data;
		node.next = node.next.next;
		if (node.next == null) {
			tail = node;
		}
		size--;
		return node.data;
	}

//	@Override
//	public void forEach(Consumer<? super E> consumer) {
//		Node<E> cur = head;
//		while (cur != null) {
//			consumer.accept(cur.data);
//			cur = cur.next;
//		}
//	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private Node<E> current = head;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				if (!hasNext())
					throw new NoSuchElementException();
				E data = current.data;
				current = current.next;
				return data;
			}
		};
	}

}