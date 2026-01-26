package core.dsa.implementation.linkedlist_stack_and_queue;

public class TestMyStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new MyStack<>();

		stack.push(10);
		stack.push(20);
		stack.push(30);

		System.out.println("Top element is: " + stack.peek()); // Output: 30

		System.out.println("Popped element is: " + stack.pop()); // Output: 30
		System.out.println("Popped element is: " + stack.pop()); // Output: 20

		System.out.println("Top element is: " + stack.peek()); // Output: 10

	}

}
