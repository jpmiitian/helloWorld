package problems.stacks.questions;

import java.util.EmptyStackException;

/**
 * 
 * Array with three stacks
 */

public class ArrayWithThreeStacks {

	private int[] dataArray;
	private int size, topOne, topTwo, baseThree, topThree;

	public ArrayWithThreeStacks(int size) {
		if (size < 3) {
			throw new IllegalStateException("size less than 3 is not permissible for array with 3 stacks");
		} else {
			dataArray = new int[size];
			this.size = size;
			topOne = -1;
			topTwo = size;
			baseThree = size / 2;
			topThree = baseThree;
		}
	}

	public void push(int stackId, int data) {
		if (stackId == 1) {
			if (topOne + 1 == baseThree) {
				if (isStackThreeRightShiftable() == true) {
					shiftStackThreeToRight();
					dataArray[++topOne] = data;
				} else {
					throw new StackOverflowError("Stack has reached its max limit ");
				}
			}
			else{
				dataArray[++topOne] = data;
			}

		} else if (stackId == 2) {
			if (topTwo - 1 == topThree) {
				if (isStackThreeLeftShiftable() == true) {
					shiftStackThreeToLeft();
					dataArray[--topTwo] = data;
				} else {
					throw new StackOverflowError(" Stack Two has reached its maximum limit ");
				}
			}
			else{
				dataArray[--topTwo] = data;
			}
		} else if (stackId == 3) {
			if (topThree + 1 == topTwo) {
				if (isStackThreeLeftShiftable() == true) {
					shiftStackThreeToLeft();
					dataArray[++topThree] = data;

				} else {
					throw new StackOverflowError(" Stack Three has reached its maximum limit ");
				}
			}
			else{
				dataArray[++topThree] = data;
			}
		}
	}

	public int pop(int stackId) throws Exception{
		
		int NULL_VALUE = (Integer)null;
		int toTop = NULL_VALUE;
		if(stackId==1){
			if(topOne==-1) 
				throw new  Exception("First stack is empty"); 
			else{
				toTop = dataArray[topOne];
				dataArray[topOne--] = (Integer) NULL_VALUE;
				return toTop;
			}
		}
		else if(stackId==2){
			if(topTwo==size ) 
				throw new  Exception("Second stack is empty"); 
			else{
				 toTop = dataArray[topTwo];
				dataArray[topTwo++] = (Integer) NULL_VALUE;
				return toTop;
			}
		}
		else if(stackId==3){
			if(topThree== this.size && dataArray[topThree] ==  NULL_VALUE) 
				throw new  Exception("Third stack is empty"); 
			else{
				 toTop = dataArray[topThree];
				 if(topThree >baseThree){
				   dataArray[topThree--] = (Integer) NULL_VALUE;
				   }
				 else if(topThree ==baseThree){
					 dataArray[topThree] = (Integer) NULL_VALUE;// deleting info from previous top position.
				 }
				return toTop;
			}
		}
		
		return toTop;
	
	}
	
	public boolean isEmpty(int stackId){
		int NULL_VALUE = (Integer)null;
		if(stackId== 1){
			return (topOne==-1);
		}
		else if(stackId== 2){
			return (topTwo==size);		} 
		else if(stackId== 3){
			return (topThree==baseThree && dataArray[baseThree]== NULL_VALUE);
		}
		return true;
	}
	
	public boolean isStackThreeRightShiftable() {
		if(++topThree < topTwo)
			return true;
		else
			return  false;
	}
	

	public boolean isStackThreeLeftShiftable() {
		if(--baseThree >topOne) // first decrease baseThree then use in operation i.e. baseThree = baseThree-1; 
			return true;
		else
			return false;
	}

	public void shiftStackThreeToRight() {
		for(int i= topThree+1;i > baseThree;i-- ){
			dataArray[i]= dataArray[i-1];
		}
		dataArray[baseThree ++] = (Integer)null; // updating baseThree
		topThree++; // updating TopThree
	}

	public void shiftStackThreeToLeft() {
		for(int i = baseThree-1; i <= topThree-1 ;i++){// moving in pre location
			dataArray[i] =dataArray[i+1] ;  
		}
		dataArray[topThree--] = (Integer)null;  // updating TopThree
		baseThree--;// updating baseThree
		
	}

}
