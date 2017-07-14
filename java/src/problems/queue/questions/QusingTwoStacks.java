package problems.queue.questions;

import problems.stacks.implementation.LinkListStack;

public class QusingTwoStacks {

	/**
	 * Implement queue using two stacks
	 */
	LinkListStack stack1; // push data here
	LinkListStack stack2; // remove data from here

	/**Time complexity :
	 * From the Algo, if stack 2 is not empty then time complexity is O(1)
	 * If stack2 is empty,WE NEED TO TRANSFER DATA FORM stack1 to stack2,
	 * BUT,if we carefully observe , the NO. OF TRANSFERRED ELEMENTS and NO. OF POPPED ELEMENTS FROM stack2 are EQUAL.
	 * DUE to this the average complexity of POP OPERATION in this case is O(1)
	 * 
	 *     Hence, AMORTISED COMPLEXITY OF POP OPERATION IS O(1)
	 *      
	 * */
	
	public QusingTwoStacks() {
		stack1 = new LinkListStack();
		stack2 = new LinkListStack();
	}

	// DEAFAULT IMPLEMENTATION
	public boolean isEmptyQ() {
		if (stack1.isEmptyStack()) {
			while (!stack2.isEmptyStack()) {
				stack1.push(stack2.pop());
			}
		}
		return stack2.isEmptyStack();
	}

	public void enQueue(int data) {
		stack1.push(data);
	}

	public int deQueue() {
		if (!stack2.isEmptyStack()) {
			return stack2.pop();
		} 
		else {
			while (!stack1.isEmptyStack()) {
				stack2.push(stack1.pop()); // transfer all from stack1 to stack2
			}
		}
		return stack2.pop();
	}

}
