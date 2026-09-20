package dsa.questions.implement_queue_using_stacks;

import java.util.Stack;

class MyQueue {

    Stack<Integer>stack;
    public MyQueue() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        Stack<Integer>tmp = new Stack<>();

        while(!stack.empty())tmp.push(stack.pop());

        stack.push(x);

        while(!tmp.empty())stack.push(tmp.pop());
    }
    
    public int pop() {
        return stack.pop();
    }
    
    public int peek() {
        return stack.peek();
    }
    
    public boolean empty() {
        return stack.empty();
    }
}

public class ImplementQueueUsingStacks {

	public static void main(String[] args) {
		
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek());   // returns 1
		System.out.println(queue.pop());    // returns 1
		System.out.println(queue.empty());  // returns false
	
	}

}
