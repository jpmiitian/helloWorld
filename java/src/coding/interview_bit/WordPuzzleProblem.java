package coding.interview_bit;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

 
public class WordPuzzleProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//Write code here
	    Integer noOfTestCases;
	    noOfTestCases =Integer.parseInt(in.nextLine());
	   
	    String[][] strInArr= new  String[noOfTestCases][2]  ;
	    
	    for(int i= 0 ; i < noOfTestCases ; i++ ){
	    	String str1 = in.nextLine() ;
	    	strInArr[i][0] = str1 ;
	    	String str2 = in.nextLine() ;
	    	strInArr[i][1] = str2 ;
	    }
	    
		for (int i = 0; i < noOfTestCases; i++) {
			boolean flag = checkIfEqualStrings(strInArr[1][0], strInArr[1][0]) ;
			System.out.println( flag ? "Equal" : "Not-Equal");
		}	    

		in.close();
	}
	
	
	private static boolean checkIfEqualStrings(String s1, String s2) {
		boolean flag = false  ;
		
		if(s1==null && s2!=null  ||  s1!=null && s2==null )
			return false ;
		if(s1.length() != s2.length() )
			return false ;
			
		Set<Character> set1  =  new HashSet<Character> () ;
		for ( char  ch : s1.toCharArray()) {
			set1.add(ch ) ;	
		}			 
		
		for ( int i = 0 ; i<s2.length() ; i++  ){
			if(set1.contains( s2.charAt(i)  ))
				flag = true ;
			else 
				flag = false ;
		}
		
		return flag ;
	}
 	
}
