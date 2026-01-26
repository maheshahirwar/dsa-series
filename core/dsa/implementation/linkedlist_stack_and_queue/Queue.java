package core.dsa.implementation.linkedlist_stack_and_queue;

public interface Queue<E> {

	public boolean offer(E element);

	public boolean add(E element);

	public E peek();

	public E element();

	public E poll();

	public E remove();
}
