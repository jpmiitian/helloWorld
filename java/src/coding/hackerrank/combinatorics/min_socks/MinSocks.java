package coding.hackerrank.combinatorics.min_socks;

import java.util.Scanner;


public class MinSocks{

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int noTests = Integer.parseInt(in.nextLine());

		int[] arr = new int[noTests];
		for(int i=0;i<noTests;i++){
		arr[i]=Integer.parseInt(in.nextLine());
		}

		for (int i = 0; i < noTests; i++) {
			System.out.println(++arr[i]);	
		}

		arr = null;//memory deallocation
		in.close();

	}
	
}
