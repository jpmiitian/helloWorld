package coding.hackerrank.warmup.very_big_sum;

import java.util.Scanner;

/**
 
 */
public class VeryBigSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer noOfElements = 0;
		noOfElements = Integer.parseInt(in.nextLine());
		Long sumFinal = null;
		String numbersInLine = in.nextLine();
		String[] numberArray = numbersInLine.split("\\ ");

		for (int i = 0; i < noOfElements; i++) {
			sumFinal = sumFinal == null ? (Long.parseLong(numberArray[i]))
					: (sumFinal + Long.parseLong(numberArray[i]));
		}

		System.out.println(sumFinal);
		in.close();
	}

}
