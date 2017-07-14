package coding.hackerrank.warmup.staircase;

import java.util.Scanner;

public class StairCasePrint {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int stairCaseHeight = 0;
		stairCaseHeight = in.nextInt();
		printStairCase(stairCaseHeight);
		in.close();
	}

	private static void printStairCase(int stairCaseHeight) {
		if (stairCaseHeight <= 0) {
			System.out.println("Height Not Greater than 0 .");// print
		} else {
			int levelToPrint = 1;
			int noSpacesToPrint;
			/* while loop to print each level */
			while (levelToPrint <= stairCaseHeight) {
				noSpacesToPrint = stairCaseHeight - levelToPrint;
				/* for loop to print SPACE */
				for (int i = 0; i < noSpacesToPrint; i++) {
					System.out.print(" ");//Print SPACE
				}

				/* for loop to print # */
				for (int j = 0; j < levelToPrint; j++) {
					if (j == levelToPrint - 1) { // if check for newLine
						System.out.print("#\n"); // Print HASH ('#') and NEXT_LINE ('\n') 
					} else {
						System.out.print("#");	// Print HASH ('#')
					}
				}

				levelToPrint++;// increase level to be used in while loop
								// condition check.
			}
		}
	}

}
