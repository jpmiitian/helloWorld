package problems.stacks.questions.min_stack;

import java.util.Stack;

public class MinStack {
	 Stack<Long > itmStack ;
	 Stack<Long> minStack  ;
    public MinStack() {
        this.itmStack = new Stack<Long> () ;
        this.minStack = new Stack<Long> () ;
        
    	
    }
    
    public void push(long x) {
    	this.itmStack.push(x) ;
    	
    	if(this.minStack.isEmpty()) {
    		this.minStack.push(x) ;
    	}

    	if(!this.minStack.isEmpty() && this.minStack.peek() > x){
    		//this.minStack.pop() ;
    		this.minStack.push(x) ; 
    	}

    		

    }
    
    public void pop() {
     long stkTop =	this.itmStack.peek() ;
     
     if(this.minStack.peek() == stkTop ){
    	 this.minStack.pop() ;
    	 this.itmStack.pop() ;
     }
     else {
    	 this.itmStack.pop() ;
     }
     
    }
    
    public long top() {
    	return this.itmStack.peek() ;
    }
    
    public long getMin() {
    	return this.minStack.peek() ;
    }	
	
 
	
	
	
	public static void main (String [] args ){
		String in1 = "(()[]{})" ;
		String in2 = "({}[])" ;
 
		long l = (long) 1 ;
		
		MinStack rdBS = new MinStack() ;
		
//	System.out.println("Has redundancy no so : " +rdBS.isValid(in1) );
//	System.out.println("Has no redundancy so : " +rdBS.isValid(in2) );
// 
		
	}
	
	
	
	
}
