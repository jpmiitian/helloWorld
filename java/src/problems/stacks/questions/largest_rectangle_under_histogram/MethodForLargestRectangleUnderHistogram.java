package problems.stacks.questions.largest_rectangle_under_histogram;

import java.util.Stack;

public class MethodForLargestRectangleUnderHistogram {

	/**
	 * Given array of heights of histogram (assume width 1)
	 * We need to find the largest rectangle possible
	 */
	public long largestRectangleUnderHistogram(int A[] , int n){
		long maxArea = 0;
		if(A==null || A.length== 0)
			return maxArea;
		Stack<StackItem> S = new Stack<StackItem>();
		S.push(new StackItem(Integer.MIN_VALUE,-1));
		for(int i= 0; i <n ; i++){
			StackItem cur = new StackItem((i< n ? A[i] : Integer.MIN_VALUE), -1);
			StackItem topItem=S.pop();// getting top of stack 
			S.push(topItem); // push again
			if(cur.height > topItem.height ){
				S.push(cur);
				continue;
			}
			while(S.size() > 1){
				StackItem topItem2=S.pop();// getting top of stack 
				S.push(topItem2);// push again 
				StackItem previousStkItem = topItem2;
				long area = (i- previousStkItem.index)* previousStkItem.height;
				if(area > maxArea){
					maxArea = area;
				}
				previousStkItem.height = cur.height;
				if(previousStkItem.height >S.get(S.size() - 2).height){
					break;
				}
				S.pop();
			}
		}
		
		return maxArea;
	} 
	
}
