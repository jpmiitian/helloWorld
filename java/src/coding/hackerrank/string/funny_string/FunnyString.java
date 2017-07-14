package coding.hackerrank.string.funny_string;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(in.nextLine());

		String[] strArray = new String[noOfTestCases];

		for (int i = 0; i < noOfTestCases; i++) {
			strArray[i] = in.nextLine();
		}

		for (String string : strArray) {
			callPrintFunnyOrNotFunny(string);
		}

		in.close();

	}

	private static void callPrintFunnyOrNotFunny(String string) {

		boolean isFunny = false;
		for (int i = 0; i < string.length() - 1; i++) {
			char indexI = string.charAt(i);
			char indexIPlusOne = string.charAt(i + 1);

			char indexJ = string.charAt((string.length() - 1) - i);
			char indexJminusOne = string.charAt((string.length() - 1) - 1 - i);

			if (Math.abs(indexI - indexIPlusOne) == Math.abs(indexJ - indexJminusOne)) {
				isFunny = true;
			}
			else if (!(Math.abs(indexI - indexIPlusOne) == Math.abs(indexJ - indexJminusOne))) {
				isFunny = false;
				System.out.println("Not Funny");
				break;
			}

		}

		if (isFunny) {
			System.out.println("Funny");
		}

	}

}
