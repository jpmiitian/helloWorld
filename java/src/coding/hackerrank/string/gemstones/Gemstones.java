package coding.hackerrank.string.gemstones;

import java.util.Scanner;

/**
 * Print number of chars common given lines .
 * 
 * @author jay.prakash
 *
 */
public class Gemstones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int noOfTestCases = Integer.parseInt(in.nextLine() );
		
		String[] inputLineArray = new String [noOfTestCases] ;
		
		for(int i=0 ;i< inputLineArray.length ;i++){
			inputLineArray[i] = in.nextLine();
		}

		printNoOfCharsCommonInLines(inputLineArray);

		in.close();
	}

	/**
	 * This method checks if a sentence is Pangram or not 
	 * and prints 'pangram' or 'not pangram' based on the result .
	 * 
	 * @param inputLine
	 */
	private static void printNoOfCharsCommonInLines(String[] inputLineArray) {
	
		char[] lowerAlphabets = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

		int noCommonChars = 0  ;
		
		for (char charToCheck : lowerAlphabets) {
			if (checkIfCharExists(charToCheck, inputLineArray)) {
				++noCommonChars;
			}
		}
		
		System.out.println(noCommonChars);
	}

	/**
	 * This method checks if the input  charToCheck exists in the String[] inputLineArray
	 * @param charToCheck
	 * @param inputLineArray
	 * @return
	 */
	private static boolean checkIfCharExists(char charToCheck,String[] inputLineArray) {
		boolean isCharExisting = false;
		
		for(String line :inputLineArray){
			
			if( (line.contains(String.valueOf(charToCheck)))  ){
				isCharExisting = true ;
			}
			else {
				isCharExisting = false ;
				return isCharExisting ;//No further check if any char is not there 
			}
		}
		return isCharExisting;
	}

}
