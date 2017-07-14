package coding.hackerrank.string.palindrome_index;

import java.util.Scanner;

/**
 * Problem Statement
 * 
 * You are given a string of lower case letters. Your task is to figure out the
 * index of the character on whose removal it will make the string a palindrome.
 * There will always be a valid solution.
 * 
 * In case the string is already a palindrome, then -1 is also a valid answer
 * along with possible indices.
 * 
 * Input Format
 * 
 * The first line contains , i.e. the number of test cases. lines follow, each
 * containing a string.
 * 
 * Output Format
 * 
 * Print the position (0 index) of the letter by removing which the string turns
 * into a palindrome. For a string, such as
 * 
 * bcbc we can remove b at index 0 or c at index 3. Both answers are accepted.
 * 
 * Constraints
 * 
 * length of string All characters are Latin lower case indexed.
 * 
 * Sample Input
 * 
 * 3 aaab baa aaa Sample Output
 * 
 * 3 0 -1
 * 
 * 
 * @author jay.prakash
 *
 */
public class PalindromeIndex {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(in.nextLine());

		if(noOfTestCases > 20 ){
			System.out.println("No of test cases can not be greater than 20 .");
			in.close(); 
			return ;
		}
		
		
		String[] strArray = new String[noOfTestCases];

		for (int i = 0; i < noOfTestCases; i++) {
			strArray[i] = in.nextLine();
			if(strArray[i].length() > 100005){
				in.close(); 
				System.out.println("String length can not be greater than 100005 .");
				return ;
			}
		}

		for (String string : strArray) {

			System.out.println(getIndexOfCharWhoseRemovalCanMakeTheStringPallindrome(string));

		}

		in.close(); // closing resource
	}

	private static int getIndexOfCharWhoseRemovalCanMakeTheStringPallindrome(String string) {
		int charIndex = -1;
		int lengthOfString = string.length();

		for (int i = 0; i <= lengthOfString / 2; i++) {

			int rearIndex = lengthOfString - 1 - i;

			int nxtRearIndx = lengthOfString - 1 - i - 1;
			int nxtFrontIndx = i + 1;

			char frontChar = string.charAt(i);
			char rearChar = string.charAt(rearIndex);

			char nextRearChar = string.charAt(nxtRearIndx);
			char nextFrontChar = string.charAt(nxtFrontIndx);

			if (frontChar != rearChar) {
				if (frontChar == nextRearChar) {
					charIndex = rearIndex;
					return charIndex;
				} else if (nextFrontChar == rearChar) {
					charIndex = i;
					return charIndex;
				}
			}

		}

		return charIndex;
	}

	

 	
	
	
	
	
	
	
	
	
}
