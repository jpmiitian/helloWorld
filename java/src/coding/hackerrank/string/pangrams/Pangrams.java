package coding.hackerrank.string.pangrams;

import java.util.Scanner;

public class Pangrams {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String inputLine = in.nextLine();

		printIsPangram(inputLine);

		in.close();
	}

	/**
	 * This method checks if a sentence is Pangram or not 
	 * and prints 'pangram' or 'not pangram' based on the result .
	 * 
	 * @param inputLine
	 */
	private static void printIsPangram(String inputLine) {
		boolean isPangram = checkIsPangram(inputLine);
		String printThis = isPangram ? "pangram" : "not pangram";
		System.out.println(printThis);

	}

	private static boolean checkIsPangram(String inputLine) {
		boolean isPangram = true;
		
		char[] lowerAlphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		char[] capitalAlphabets = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q' ,'R' ,'S' ,'T' ,'U' ,'V' ,'W' ,'X','Y' ,'Z'};
		
		for(int i=0 ;i<26 ;i++){
			char smallChar = lowerAlphabets[i] ;
			char capitalChar = capitalAlphabets[i] ;
			
			if( (inputLine.contains(String.valueOf(smallChar))) || inputLine.contains(String.valueOf(capitalChar)) ){
				isPangram = true ;
			}
			else {
				isPangram = false ;
				return isPangram ;//No further check if any char is not there 
			}
		}
		return isPangram;
	}

}
