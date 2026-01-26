package core.dsa.implementation.linkedlist_stack_and_queue;

public class MyStack<E> implements Stack<E> {

	private MyDoublyLinkedList<E> list;

	public MyStack() {
		this.list = new MyDoublyLinkedList<>();
	}

	@Override
	public void push(E element) {
		list.addFirst(element);
	}

	@Override
	public E peek() {
		return list.getFirst();
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

}
