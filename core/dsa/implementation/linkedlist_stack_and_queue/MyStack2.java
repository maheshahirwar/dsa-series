package core.dsa.implementation.linkedlist_stack_and_queue;

public class MyStack2<E> implements Stack<E> {

	private Object[] elements;
	private int size;
	private static final int DEFAULT_CAPACITY = 10;

	public MyStack2() {
		this.elements = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}

	@Override
	public void push(E element) {

		if (size == elements.length) {
			resize();
		}
		elements[size++] = element;
	}

	private void resize() {
		int newCapacity = elements.length * 2;
		Object[] newArray = new Object[newCapacity];
		System.arraycopy(elements, 0, newArray, 0, elements.length);
		elements = newArray;
	}

	@Override
	public E peek() {

		if (size == 0) {
			throw new IllegalStateException("Stack is empty");
		}
		@SuppressWarnings("unchecked")
		E topElement = (E) elements[size - 1];
		return topElement;
	}

	@Override
	public E pop() {
		if (size == 0) {
			throw new IllegalStateException("Stack is empty");
		}
		@SuppressWarnings("unchecked")
		E topElement = (E) elements[--size];
		elements[size] = null; // Clear reference for garbage collection
		return topElement;
	}

}
