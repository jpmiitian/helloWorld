package problems.stacks.questions.check_valid_braces;

import java.util.Stack;

public class ValidBraces {
	
	public int isValid(String str) {
		boolean res= false ;
		if( isCloseBrace(str.charAt(0)) )
			return 0 ;	
		Stack<Character> opBrcStack = new Stack<Character>() ;
		Stack<Character> closeBrcStack = new Stack<Character>() ;
		
		for(char c : str.toCharArray()){
			if(isCloseBrace(c) && !opBrcStack.isEmpty() ){
				closeBrcStack.push(c) ;
				if (getOpenBrace(c) == opBrcStack.peek()) {
					opBrcStack.pop() ;
					res = true ;
				}
				else {
					res= false ;
					break ;
				}
			}
			
			if(!isCloseBrace(c) ){
				opBrcStack.push(c) ;
			}
		}
		
		
		return res ? 1 : 0 ;
	}

	private boolean isCloseBrace(char ch){
		return ch=='}'||ch==')'||ch==']' ? true : false ;
	}
	
	private char getOpenBrace(char iChar){
		if(iChar==')')
			return '(' ;
		else if(iChar=='}')
			return '{' ;
		else if(iChar==']')
			return '[' ;
		
		
		return  'k' ;
	}
	
	
	
	
	public static void main (String [] args ){
		String in1 = "(()[]{})" ;
		String in2 = "({}[])" ;
 
		ValidBraces rdBS = new ValidBraces() ;
		
	System.out.println("Has redundancy no so : " +rdBS.isValid(in1) );
	System.out.println("Has no redundancy so : " +rdBS.isValid(in2) );
 
		
	}
	
	
	
	
}
