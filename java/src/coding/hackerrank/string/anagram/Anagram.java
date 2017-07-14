package coding.hackerrank.string.anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

 	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(in.nextLine());

		String[] strArray = new String[noOfTestCases];

		for (int i = 0; i < noOfTestCases; i++) {
			strArray[i] = in.nextLine();
		}

		for (String string : strArray) {

		System.out.println(noOfChangesRequired(string));
		
		}

		in.close(); // closing resource
	}

 
 	private static int  noOfChangesRequired(String inputString) {
 		
 		//TODO lower alphabet check can be put for validating constraints
		char[] lowerAlphabets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z' };

		String firstSubString =	null;
		String secondSubString = null;
		Map<Character, Integer> charToCountMapForLineA = new HashMap<>();
		Map<Character, Integer> charToCountMapForLineB = new HashMap<>();


		if(inputString.length() % 2 != 0) {
			return -1 ; //odd length
		}
		else {
			 firstSubString = inputString.substring(0, inputString.length()/2) ; //endIndex = halfLength will give chars till (endIndex-1)
			 secondSubString = inputString.substring(inputString.length()/2 ) ;
		}
		
		populateCharToCountMap( charToCountMapForLineA, firstSubString);
		populateCharToCountMap( charToCountMapForLineB, secondSubString);

		
		
		
		return  calculateNoOfChangesRequired( charToCountMapForLineA, charToCountMapForLineB);

	}

	private static int calculateNoOfChangesRequired( Map<Character, Integer> charToCountMapForLineA,
			Map<Character, Integer> charToCountMapForLineB) {
		int countChanges = 0;

 		for (char keyChar : charToCountMapForLineB.keySet()) {

			int changesForThisChar = 0;
			
			if (charToCountMapForLineA.containsKey(keyChar)) {
				int freqncyInLineA = charToCountMapForLineA.get(keyChar);
				int freqncyInLineB = charToCountMapForLineB.get(keyChar);
				changesForThisChar = freqncyInLineB - freqncyInLineA;
				
				if(changesForThisChar>=0){
					countChanges += changesForThisChar;
				}

			} else {
				changesForThisChar = charToCountMapForLineB.get(keyChar);
				countChanges += changesForThisChar;
			}

		}
		return countChanges;
	}

	/**
	 * This methods populates char to count map for each input string .
	 * @param charToCountMapForLine
	 * @param line
	 */
	private static void populateCharToCountMap(Map<Character, Integer> charToCountMapForLine, String line) {
		
		// populate default map and modifying count value in map
		for (char keyChar : line.toCharArray()) {
			// if char does not exist in map, put in map
			if (! charToCountMapForLine.containsKey(keyChar)) {
				charToCountMapForLine.put(keyChar, 1 );
					
			}
			else {
				int countChar = charToCountMapForLine.get(keyChar);
				charToCountMapForLine.put(keyChar, ++countChar);
			}
			
			
		}
	
	
	
	}

}
