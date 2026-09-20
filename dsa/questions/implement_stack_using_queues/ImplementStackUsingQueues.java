package dsa.questions.implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer>queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        Queue<Integer>tmp = new LinkedList<>();

        while(!queue.isEmpty())tmp.add(queue.poll());
        queue.add(x);

        while(!tmp.isEmpty())queue.add(tmp.poll());
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.top());   // returns 2
		System.out.println(stack.pop());   // returns 2
		System.out.println(stack.empty()); // returns false
	}

}
