package core.dsa.implementation.linkedlist_stack_and_queue;

public class TestMyQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new MyQueue<>();

		queue.add(10);
		queue.add(20);
		queue.add(30);

		System.out.println("Front element is: " + queue.peek()); // Output: 10

		System.out.println("Removed element is: " + queue.remove()); // Output: 10
		System.out.println("Removed element is: " + queue.remove()); // Output: 20

		System.out.println("Front element is: " + queue.peek()); // Output: 30

		// Check exception test cases
		try {
			queue.remove(); // removes 30
			queue.remove(); // should throw exception
		} catch (Exception e) {
			System.out.println("Exception caught: " + e.getMessage());
		}

		System.out.println("should return null : " + queue.poll()); // should return null
	}

}
