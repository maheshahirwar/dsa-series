package core.dsa.implementation.linkedlist_stack_and_queue;

import java.util.NoSuchElementException;

public class MyQueue2<E> implements Queue<E> {

	private Object[] elements;
	private int size = 0;

	public MyQueue2() {
		this.elements = new Object[10];
	}

	@Override
	public boolean offer(E element) {
		if (size == elements.length) {
			resize();
		}
		elements[size++] = element;
		return true;
	}

	private void resize() {

		int newCapacity = elements.length * 2;
		Object[] newArray = new Object[newCapacity];
		System.arraycopy(elements, 0, newArray, 0, elements.length);
		elements = newArray;
	}

	@Override
	public boolean add(E element) {
		if (size == elements.length) {
			throw new IllegalStateException("Queue is full");
		}
		elements[size++] = element;
		return true;
	}

	@Override
	public E peek() {
		if (size == 0) {
			return null;
		}
		@SuppressWarnings("unchecked")
		E frontElement = (E) elements[0];
		return frontElement;
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
		if (size == 0) {
			return null;
		}
		@SuppressWarnings("unchecked")
		E frontElement = (E) elements[0];
		// Shift elements to the left
		System.arraycopy(elements, 1, elements, 0, size - 1);
		elements[--size] = null; // Clear reference for garbage collection
		return frontElement;
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
