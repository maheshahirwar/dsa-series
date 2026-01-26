package core.dsa.implementation.linkedlist_stack_and_queue;

public interface DoublyLinkedList<E> {

	public void addFirst(E data);

	public void addLast(E data);

	public E removeFirst();

	public E removeLast();

	public E getFirst();

	public E getLast();
}
