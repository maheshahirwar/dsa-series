package core.dsa.implementation.linkedlist_stack_and_queue;

public interface Queue<E> {

	public void offer(E element);

	public void add(E element);

	public E peek();

	public E poll();

	public E remove();
}
