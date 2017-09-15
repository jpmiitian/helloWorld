package coding.hackerrank.string.alternating_chars;

import java.util.Scanner;


public class AlternatingChars {

/**
 * This program checks if an input string has same alternating chars.	
 * @param args
 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noTests = Integer.parseInt(in.nextLine());

		String[] strArr = new String[noTests];
		
		for(int i=0;i<noTests;i++){
			strArr[i]=in.nextLine();
		}
		for (String string : strArr) {
			int count =0;
			for (int i = 0; i < string.length()-1; i++) {
				if(string.charAt(i)==string.charAt(i+1)){
					count++;
				}
			}
			System.out.println(count);
		}
		
		in.close();

	}
	
	
}
