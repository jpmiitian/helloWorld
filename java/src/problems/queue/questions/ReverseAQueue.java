package problems.queue.questions;

import problems.queue.DynQueueCircArr;
import problems.stacks.implementation.LinkListStack;

public class ReverseAQueue {

	/**
	 * Reverse a queue using its operations
	 */
	public DynQueueCircArr reverseQueue(DynQueueCircArr queue) {
		LinkListStack stack = new LinkListStack();
		while(!queue.isEmpty()){
			stack.push(queue.deQueue());
		}
		while(!stack.isEmptyStack()){
			queue.enQueue(stack.pop());
		}
		return queue;
	}
	
}
