package problems.stacks.questions.check_redundant_braces_in_string;

import java.util.Stack;

public class RedundantBraces {
	

	public int braces(String string){
		boolean hasRedundantBrace = false;
		if(string==null || string.isEmpty()|| string.length() < 2)
			return 0 ; //no redundancy
		
		char[] chars = string.toCharArray() ;
		
		Stack<Character> stack = new Stack<Character>() ;
		
		int i = 0;
		char lastChar = chars[0];
		
		while (i < chars.length) {
			char item = chars[i] ;
			if(!isCloseBrace(item)){ 
				stack.push(item) ;  //  push if (,[,{ or 2 or any other char
			}
			
			if(!stack.isEmpty() && isCloseBrace(item)){ 
			   Character poppedChar = stack.pop() ;
//			   if(i==chars.length-2 && !stack.isEmpty() && !isOperator(poppedChar)) {
//				   if(!isOperator(poppedChar)){
//					   hasRedundantBrace = true ;
//					   return 0 ;
//				   }
//			   }

			   if(stack.isEmpty() && !isOperator(poppedChar))
				   return 1 ; // no redundant braces	
				   
			   Character topChar = stack.peek() ;//looks at top char 
			   
			   
			   if(!isOperator(topChar)){
					hasRedundantBrace = true ;
					return 1 ;
			   }else{
				    char opBr = getOpenBrace(item ) ;
				   	char itrPop = poppedChar ;
				    while(!stack.isEmpty() && itrPop != opBr) {
				    	itrPop = stack.pop() ;
				   	}
				   	stack.push('k') ;//pushed constant instead of close brace 
			   }
			   
			}

			lastChar = item ; //updating last char
			i++ ; //iterate to next char of input string
		}
		
		
		
		return   hasRedundantBrace ? 1 : 0 ; //
	}
	
	
	private char getOpenBrace(char c) {
		if (c == ')')
			return '(';
		else if ( c == ']')
			return '[' ;
		else if(c == '}')
			return '{' ;
	
		return 'k' ;
	}

	private boolean isOperator(char c){
		if(c=='+'||c=='-'||c=='*'||c=='/')
			return true ;
		else
			return false ;
	}
	
	private boolean isOpenBrace(char c) {
		if (c == '(' || c == '[' || c == '{')
			return true;
		else
			return false;
	}

	private boolean isCloseBrace(char c) {
		if (c == ')' || c == ']' || c == '}')
			return true;
		else
			return false;
	}	
	
	
	public static void main (String [] args ){
		String in1 = "(a+(a+b))" ;
		String in2 = "(a+b)*c)" ;
		String in3 = "((a*7)-8)" ;
		String in4 = "a" ;
		String in5 = "()" ;
		
		RedundantBraces rdBS = new RedundantBraces() ;
		
		System.out.println("Has redundancy no so : " +rdBS.braces(in1) );
		System.out.println("Has no redundancy so : " +rdBS.braces(in2) );
		System.out.println("Has no redundancy so : " +rdBS.braces(in3) );
		System.out.println("Has no redundancy so : " +rdBS.braces(in4) );
		System.out.println("Has redundancy so : " +rdBS.braces(in5) );
		
		
	}
	
}
