package coding.hackerrank.string.two_strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoStrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(in.nextLine());

		String[] strArray = new String[noOfTestCases * 2];

		for (int i = 0; i < noOfTestCases * 2; i++) {
			strArray[i] = in.nextLine();
		}

		for (int i = 0; i < strArray.length - 1; i += 2) {
			String stringOne = strArray[i];
			String stringTwo = strArray[i + 1];
			String printThis = checkIfCommonChar(stringOne, stringTwo) == true ? "YES" : "NO";
			System.out.println(printThis);

		}

		in.close(); // closing resource
	}

	private static boolean checkIfCommonChar(String stringOne, String stringTwo) {

		Map<Character, Boolean> charMapForStringOne = new HashMap<>();
		Map<Character, Boolean> charForStringTwo = new HashMap<>();

		populateCharMapForString(charMapForStringOne, stringOne);
		populateCharMapForString(charForStringTwo, stringTwo);

		return isCommonSubString(charMapForStringOne, charForStringTwo);

	}

	private static boolean isCommonSubString(Map<Character, Boolean> charToCountMapForLineA, Map<Character, Boolean> charToCountMapForLineB) {
		boolean isCommonCharExists = false;

		for (char keyChar : charToCountMapForLineB.keySet()) {
			if (charToCountMapForLineA.containsKey(keyChar)) {
				isCommonCharExists = true;
				return isCommonCharExists;
			}
		}
		return isCommonCharExists;
	}

	/**
	 * This methods populates char to count map for each input string .
	 * 
	 * @param charMapForString
	 * @param inputString
	 */
	private static void populateCharMapForString(Map<Character, Boolean> charMapForString, String inputString) {

		// populate default map and modifying count value in map
		for (char keyChar : inputString.toCharArray()) {
			// if char does not exist in map, put in map
			if (!charMapForString.containsKey(keyChar)) {
				charMapForString.put(keyChar, true);

			}
		}
	}

}
