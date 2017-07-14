package coding.hackerrank.project_euler.sum_multiples;

import java.util.Scanner;

public class SumMulti {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOFTests;
		noOFTests = in.nextInt();
		long[] arr = new long[noOFTests];
		
		for (int i = 0; i < noOFTests; i++) {
			arr[i] = in.nextLong();
		}
		for (long i : arr) {
			System.out.println(findSumMulti_3_5 (i));
		}
		in.close();
	}
	
	static long findSumMulti_3_5(long n){
		long sum = 0;
		if (n > 3) {
			long quotient = n/3;
			if (n % 3 == 0) {	 
				long aN = 3+(quotient-1-1)*3;
				float ap3Sum = ((quotient-1)/2)*(3+aN);
				sum =(long)ap3Sum ;
			}
			else {			 
				long aN2 = 3+(quotient-1)*3;
				float ap3Sum2 =((float)quotient/2)*(3+aN2); 
				sum = (long) ap3Sum2;
			}
		}
		
		if (n > 5) {
			long quot = n/5;
			if (n % 5 == 0) {	 
				long aM = 5+(quot-1-1)*5;
				float ap5Sum = ((float)(quot-1)/2)*(5+aM);
				sum = sum + (long)ap5Sum;
				for(int i=15;i<=aM;i+=15){
					if(i%3==0 && i%5==0){
						sum = sum-i;
					}
				}
			}
			else {		 
				long aM2 = 5+(quot-1)*5;
				float ap5sum2 = ((float)quot/2)*(5+aM2); 
				sum= sum + (long)ap5sum2;
				 //find sum of common multiples
				for(int i=15;i<aM2;i+=15){
					if(i%3==0 && i%5==0){
						sum = sum-i;
					}
				}
			}
		}
		return sum;
	}

}
