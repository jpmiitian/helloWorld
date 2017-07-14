package problems.stacks.questions;

import problems.stacks.implementation.LinkListStack;

/**
 * given an array A the Span S[i] is the  maximum number of consecutive elements 
 * A[j] immediately preeceding a[i] and such that A[j]<= A[j+1]
 */
public class FindingSpans {

	/**
	 * Simple way 
	 * Each day check the how many consecutive days are there with less stock price
	 * i.e. check consecutive greater elements.
	 *Time O(n^2)
	 *Space O(1) 
	 */
	public int[] findSpans_1stSolution(int arr[]){
		int[] spans = new int [arr.length];
		for(int i= 0; i < arr.length-1; i++){
			int span =1;
			int j = i-1;
			while(j >=0  && arr[j]<arr[j+1]){
			span ++;
			j--;
			}
			spans[i] =span;
		}
		return spans;
	}

	
	/**
	 *for each day, We can find span if we know the last day when the stock was greater than present day
	 *Time O(n)
	 *Space O(n) 
	 */
	public int[] findSpans_2ndSolution(int arr[]){
		int[] spans = new int [arr.length];
		LinkListStack stack = new LinkListStack();
		int p = 0 ;
		for(int i= 0; i < arr.length-1; i++){
			while(!stack.isEmptyStack() && arr[i] < arr[(Integer) stack.pop() ]){
				stack.pop();
			}
			if(stack.isEmptyStack()){
				p=-1;
				}
			else{
					p = (Integer) stack.pop();
			}
			spans[i] = i-p;
			stack.push(i);
		}
			
		return spans;
	}
	
	
}
