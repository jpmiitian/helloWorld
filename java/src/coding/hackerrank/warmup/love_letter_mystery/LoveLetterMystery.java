package coding.hackerrank.warmup.love_letter_mystery;

import java.util.Scanner;

public class LoveLetterMystery {
/*	Problem Statement

	James found a love letter his friend Harry has written for his girlfriend. James is a prankster, so he decides to meddle with the letter. He changes all the words in the letter into palindromes.

	To do this, he follows two rules:

	He can reduce the value of a letter, e.g. he can change d to c, but he cannot change c to d.
	In order to form a palindrome, if he has to repeatedly reduce the value of a letter, he can do it until the letter becomes a. Once a letter has been changed to a, it can no longer be changed.
	Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.

	Input Format

	The first line contains an integer T, i.e., the number of test cases. 
	The next T lines will contain a string each. The strings do not contain any spaces.

	Constraints 
	1≤T≤10 
	1≤ length of string ≤104 
	All characters are lower case English letters.

	Output Format

	A single line containing the number of minimum operations corresponding to each test case.
*/

	  public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
	        int noOFLines;
	        noOFLines = Integer.parseInt(in.nextLine());
	        String[] linesArray = new String[noOFLines];
	        for(int i=0;i<noOFLines;i++){
	        linesArray[i] = in.next();
	        }
	        for(String strInArray : linesArray){
		        try{
		        	System.out.println(countOperations(strInArray));
		        }
		        catch(NullPointerException ne){
		        	ne.printStackTrace();
		        }
	        }
		        
	        in.close();
	        //System.exit(0);
	  }	
	  
	  static int countOperations(String str){
		  //int 5/2 = 2 str eg.. abcde 
		  //int 4/2 = 2 
		  int count = 0;
		  int length = str.length();
		  for(int i=0;i<length/2;i++){
			  count += Math.abs(str.charAt(i) - str.charAt(length-1-i));
		  }
		  return count; 
	  }
	  
}
