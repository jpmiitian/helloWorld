package coding.hackerrank.string.morgan_and_string;

import java.util.Scanner;
import java.util.Stack;

public class MorganAndString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfTestCases = Integer.parseInt(in.nextLine());
		if(noOfTestCases > 5 ){
			System.out.println("Test cases can not be more than 5.");
		}
		
		String[] strArray = new String[noOfTestCases * 2];

		for (int i = 0; i < noOfTestCases * 2; i++) {
			strArray[i] = in.nextLine();
			if(strArray[i].length() > 100000 ){
				System.out.println("Length can not be more than 100000.");
			}
		}

		for (int i = 0; i < strArray.length - 1; i += 2) {
			String stringOne = strArray[i];
			String stringTwo = strArray[i + 1];
			String printThis = getlexicoGraphicallyMinimalString(stringOne, stringTwo);
			System.out.println(printThis);

		}

		in.close(); // closing resource
	}

	private static String getlexicoGraphicallyMinimalString(String stringOne, String stringTwo) {
		char[] charArrayForStringOne = stringOne.toCharArray();
		char[] charArrayForStringTwo = stringTwo.toCharArray();

		Stack<Character> stackForStringOne = new Stack<Character>();
		Stack<Character> stackForStringTwo = new Stack<Character>();

		for (int i = charArrayForStringOne.length - 1; i >= 0; i--) {
			char iteratorCharForFirstString = charArrayForStringOne[i];
			stackForStringOne.push(iteratorCharForFirstString);
		}
		for (int i = charArrayForStringTwo.length - 1; i >= 0; i--) {
			char iteratorCharForSecondString = charArrayForStringTwo[i];
			stackForStringTwo.push(iteratorCharForSecondString);
		}

		StringBuilder strBuilder = new StringBuilder();
		Character lexoSmallerChar = null;

		while ((!stackForStringOne.isEmpty()) && (!stackForStringTwo.isEmpty())) {
			char charFromStackOne;
			char charFromStackTwo;

			if ((!stackForStringOne.isEmpty()) && (!stackForStringTwo.isEmpty())) {
				charFromStackOne = stackForStringOne.peek();
				charFromStackTwo = stackForStringTwo.peek();
				if (charFromStackOne < charFromStackTwo) {
					lexoSmallerChar = stackForStringOne.pop() ;
			//		lexoSmallerChar = charFromStackOne;
				} else {
					lexoSmallerChar = stackForStringTwo.pop() ;
				//	lexoSmallerChar = charFromStackTwo;
				}
			}
			else if (stackForStringOne.isEmpty() && !stackForStringTwo.isEmpty()) {
				lexoSmallerChar = stackForStringTwo.pop();
			} else if (!stackForStringOne.isEmpty() && stackForStringTwo.isEmpty()) {
				lexoSmallerChar = stackForStringOne.pop();
			}
			
			strBuilder.append(lexoSmallerChar);
		}

/**/		while ((stackForStringOne.isEmpty()) && (!stackForStringTwo.isEmpty())) {
			while (!stackForStringTwo.isEmpty()) {
				lexoSmallerChar = stackForStringTwo.pop();
				strBuilder.append(lexoSmallerChar);
			}
		}

		while ((!stackForStringOne.isEmpty()) && (stackForStringTwo.isEmpty())) {
			while (!stackForStringOne.isEmpty()) {
				lexoSmallerChar = stackForStringOne.pop();
				strBuilder.append(lexoSmallerChar);
			}
		}
/**/
		return (strBuilder.toString());

	}
}
