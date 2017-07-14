package coding.crack_coding_interview.arrays_strings._1_8_check_if_string_is_rotation;

import java.util.Scanner;

public class CheckIfStringIsRotation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String stringOne = in.nextLine();
		String stringTwo = in.nextLine();

		checkIfRotation(stringOne, stringTwo);

		in.close();
	}

	/**
	 * Assume you have a method isSubstring which checks if one word is a
	 * substring of another. Given two strings, s1 and s2, write code to check
	 * if s2 is a rotation of s1 using only one call to isSubstring (i.e.,
	 * “waterbottle” is a rotation of “erbottlewat”).
	 * 
	 * @param stringOne
	 * @param stringTwo
	 *            Checks if stringTwo is rotation of stringOne .
	 * @return
	 */
	public static boolean checkIfRotation(String stringOne, String stringTwo) {

		if (stringOne.length() != stringTwo.length())
			return false;
		else {
			/*
			 * Concatenate stringOne with itself, if strinTwo is rotation of
			 * stringOne then isSubstring will return TRUE
			 */
			stringOne = stringOne.concat(stringOne);
			return isStringTwoSubStringOfStringOne(stringOne, stringTwo);
		}
	}

	/**
	 * Checks if stringTwo is substring of stringOne .
	 * 
	 * @param stringOne
	 * @param stringTwo
	 * @return
	 */
	public static boolean isStringTwoSubStringOfStringOne(String stringOne, String stringTwo) {
		return stringOne.contains(stringTwo);
	}

}
