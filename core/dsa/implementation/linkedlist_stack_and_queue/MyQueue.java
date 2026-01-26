package core.dsa.implementation.linkedlist_stack_and_queue;

import java.util.NoSuchElementException;

public class MyQueue<E> implements Queue<E> {

	private MyLinkedList<E> list;

	public MyQueue() {
		this.list = new MyLinkedList<>();
	}

	@Override
	public boolean offer(E element) {
		list.add(element);
		return true;
	}

	@Override
	public boolean add(E element) {
		if (offer(element))
			return true;
		else
			throw new IllegalStateException("Queue full");
	}

	@Override
	public E peek() {
		try {
			return list.get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public E element() {
		E e = peek();
		if (e != null)
			return e;
		else
			throw new NoSuchElementException();
	}

	@Override
	public E poll() {
		try {
			return list.remove(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	@Override
	public E remove() {
		E e = poll();
		if (e != null)
			return e;
		else
			throw new NoSuchElementException();
	}

}
