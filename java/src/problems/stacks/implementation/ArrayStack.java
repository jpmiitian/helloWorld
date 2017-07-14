package problems.stacks.implementation;

public class ArrayStack {

	int top;
	int capacity;
	int[] stackArr;


	public ArrayStack() { // constructor for stackArr object creation
		capacity = 1;
		stackArr = new int[capacity];
		top = -1;
	}

	
	public boolean isFull() {
		if (top == capacity - 1)
			return true;
		else
			return false;
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	public void push(int data) {
		if (isFull() == false) {
			stackArr[++top] = data; // first increase top then use
			System.out.println(data+"  pushed ");
		} else {
			System.out.println("stack is full");
		}
	}

	public int pop() {
		if (isEmpty() == true) {
			System.out.println("Empty stack");
			return 0;
		} else {
			return stackArr[top--];
		}
	}
	
	public void deleteStack(){
		top=-1;
	}

	public static void main (String[] args){
		ArrayStack stack = new ArrayStack();
		stack.push(5);
		System.out.println(stack.top); // returning where top is 
		System.out.println(stack.pop());
	}
	
}
