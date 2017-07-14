package problems.stacks.implementation;

public class DynArrayStack {

	int capacity;
	int[] dynStackArr;
	int top;
	
	//lets take this stack for testing while push
	DynArrayStack stack =new DynArrayStack();
	
	public DynArrayStack() {
		capacity = 1;
		dynStackArr = new int[capacity];
		top = -1;

	}

	public boolean isStackEmpty(DynArrayStack dynArrayStack) {
		if (top == -1)
			return true;
		else
			return false;
	}

	public boolean isStackFull(DynArrayStack dynArrayStack) {
		if (top == capacity - 1)
			return true;
		else
			return false;
	}
	
	
	
	public void push(int data){
		if(isStackFull(stack)==true){
			doubleStackSize();
			dynStackArr[top++]=data;
		}
		else{
			dynStackArr[++top]=data;
		}
			
	}
	
	public int pop() {
		if(isStackEmpty(stack)==true){
			System.out.println("stack empty \n");
			return 0;
		}
		else {
			return dynStackArr[top--];
		}
		
	}
	
	public void doubleStackSize() {
		int[] nArr = new int[capacity*2];
		System.arraycopy(dynStackArr, 0, nArr, 0, capacity);
		capacity = capacity*2;
		dynStackArr=nArr;
	}
	

	
}
