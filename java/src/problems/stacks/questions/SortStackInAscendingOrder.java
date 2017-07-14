package problems.stacks.questions;

import problems.stacks.implementation.LinkListStack;

public class SortStackInAscendingOrder {
/**
 * Sort stack in ascending order
 * NOTE: WE SHOULD NOT MAKE ANY ASSUMPTIONS about HOW the stack is IMPLEMENTED.
 */
	public static LinkListStack stackSort(LinkListStack stakToSort){
		LinkListStack stack = new LinkListStack();
		while(!stakToSort.isEmptyStack()){
			int temp = stakToSort.pop();
			while(!stack.isEmptyStack() && stack.top() > temp ){
				stakToSort.push(stack.pop());
			}
		}
		return stack;
	}
	/**
	 * Refer kurumanchi book
	 * Time O(n^2)
	 * Space O(n)
	 * 
	 */
}
