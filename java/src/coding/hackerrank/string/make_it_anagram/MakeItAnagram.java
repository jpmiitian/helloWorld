package coding.hackerrank.string.make_it_anagram;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Alice recently started learning about cryptography and found that anagrams
 * are very useful. Two strings are anagrams of each other if they have same
 * character set and same length. For example strings "bacdc" and "dcbac" are
 * anagrams, while strings "bacdc" and "dcbad" are not.
 * 
 * Alice decides on an encryption scheme involving 2 large strings where
 * encryption is dependent on the minimum number of character deletions required
 * to make the two strings anagrams. She need your help in finding out this
 * number.
 * 
 * Given two strings (they can be of same or different length) help her in
 * finding out the minimum number of character deletions required to make two
 * strings anagrams. Any characters can be deleted from any of the strings.
 * 
 * Input Format Two lines each containing a string.
 * 
 * Constraints 1 <= Length of A,B <= 10000 A and B will only consist of
 * lowercase latin letter.
 * 
 * Output Format A single integer which is the number of character deletions.
 * 
 * Sample Input #00: cde abc
 * 
 * Sample Output #00: 4
 * 
 * Explanation #00: We need to delete 4 characters to make both strings anagram
 * i.e. 'd' and 'e' from first string and 'b' and 'a' from second string.
 * 
 * @author jay.prakash
 *
 */
public class MakeItAnagram {

	// TODO I haven't checked input constraints
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String lineA = in.nextLine();
		String lineB = in.nextLine();

		System.out.println( minimumCharDeletionsRequired(lineA, lineB) );

		in.close(); // closing resource
	}

	// TODO Add logic : How to use char as array index insted of map eg.something char[a-a]
	private static int  minimumCharDeletionsRequired(String lineA, String lineB) {
		char[] lowerAlphabets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z' };

		Map<Character, Integer> charToCountMapForLineA = new HashMap<>();
		Map<Character, Integer> charToCountMapForLineB = new HashMap<>();

		populateCharToCountMap(lowerAlphabets, charToCountMapForLineA, lineA);
		populateCharToCountMap(lowerAlphabets, charToCountMapForLineB, lineB);

		return  noOfCharDeletionsRequired(lowerAlphabets, charToCountMapForLineA, charToCountMapForLineB);

	}

	private static int noOfCharDeletionsRequired(char[] lowerAlphabets, Map<Character, Integer> charToCountMapForLineA,
			Map<Character, Integer> charToCountMapForLineB) {
		int noOfCharDeletionsRequired = 0;
		int freqncyInLineA = 0 ;
		int freqncyInLineB = 0 ;
		int freqDiff  = 0 ;
		
		for (char eachChar : lowerAlphabets) {
			freqncyInLineA = charToCountMapForLineA.get(eachChar);
			freqncyInLineB = charToCountMapForLineB.get(eachChar);

			// If frequency of any char is different
			if (freqncyInLineA != freqncyInLineB) {
				freqDiff = Math.abs(freqncyInLineA - freqncyInLineB);
				noOfCharDeletionsRequired += freqDiff;
			}
		
		}

		return noOfCharDeletionsRequired;
	}

	/**
	 * This methods populates char to count map for each input string .
	 * @param lowerAlphabets
	 * @param charToCountMapForLine
	 * @param line
	 */
	private static void populateCharToCountMap(char[] lowerAlphabets, Map<Character, Integer> charToCountMapForLine, String line) {
		// populate default map
		for (char eachChar : lowerAlphabets) {
			charToCountMapForLine.put(eachChar, 0);
		}
		// modifying count value in map
		for (char keyChar : line.toCharArray()) {
			// if char exist in map.
			// Note: All lower case char exists in map
			if (charToCountMapForLine.containsKey(keyChar)) {
				int countChar = charToCountMapForLine.get(keyChar);
				charToCountMapForLine.put(keyChar, ++countChar);
			}
		}
	}

}
