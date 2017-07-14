package problems.stacks.questions;

import problems.stacks.implementation.DynArrayStack;


public class ReverseStackUseOnlyPushPop {

/**
 * Reverse stack using push pop only TIme O(n^2),  space O(n) for recursive stack
 */
	public static void reverseStackUsingPushPopOnly(DynArrayStack stack) {
		if (stack.isStackEmpty(stack)) {
			System.out.println("stack empty");
		} else {
			int top = stack.pop();
			reverseStackUsingPushPopOnly(stack);
			insertAtBottom(stack, top);
		}

	}

	public static void insertAtBottom(DynArrayStack stack, int data) {
		if(stack.isStackEmpty(stack) ){
			stack.push(data);
		}else{
		int temp= stack.pop();	
		insertAtBottom(stack, data);
		stack.push(temp);
		}
	}
}
