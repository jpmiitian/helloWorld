package coding.hackerrank.combinatorics.hand_shake;

import java.util.Scanner;


public class HandShake {

	static int handShake(int n){
		return ((n-1)*n)/2;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int noTests = Integer.parseInt(in.nextLine());

		int[] arr = new int[noTests];
		for(int i=0;i<noTests;i++){
		arr[i]=Integer.parseInt(in.nextLine());
		}

		for (int i = 0; i < noTests; i++) {
			System.out.println(handShake(arr[i]));	
		}

		arr = null;//memory deallocation
		in.close();

	}
	
}
