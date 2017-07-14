package coding.hackerrank._30_day.check_prime;

import java.util.Scanner;

public class CheckPrime {

	/*
	 * This method checks if an integer is prime by checking if the num is divisible by any num b/w 2 to (num-1). 
	 */
	public static  boolean isPrimeIterateAllNums(int num){
		if(num < 2)
			return false ; // integer less than 2, so not a prime number. 	
		if(num==2 )
			return true ;
		for(int i=2 ; i <num ;i++ ){
			if(num%i==0)
				return false ;
		}
		return true ;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int noTests = Integer.parseInt(in.nextLine());

		int[] arr = new int[noTests];
		for (int i = 0; i < noTests; i++) {
			arr[i] = Integer.parseInt(in.nextLine());
		}

		for (int i = 0; i < noTests; i++) {
			String printThis = null ;
			printThis = isPrimeIterateAllNums(arr[i]) ? "Prime" : "Not prime" ;
			System.out.println(printThis );
		}

		arr = null; // memory deallocation
		in.close(); // closing resource 
	}

}
