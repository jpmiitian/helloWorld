package coding.hackerrank.string.prob1_converging_sum;

import java.util.LinkedHashSet;
import java.util.Set;

public class ConvergingSet {

/*
 * Let say input number n = 10^9 = 1000000000 (10 raised to power 9)
 * Maximum number till 10^9 (maxNum) = 99999999 
 * Sum of squares of digits of maxNum =  (square of 9 )x  8 times = 81x8 = 648
 */
	public static void main(String[] args)   {
		LinkedHashSet<Integer> convergeNumSet  = new LinkedHashSet<Integer>() ;
		System.out.println("This program prints numbers present in a converging set.\n");
		/*
		 * considering numbers up to 1000 to find converging set. 
		 */
		int i=1 ; 
		while(i < 1000){
			int convergeNum =  findConvergingNum(i) ;
			if(! convergeNumSet.contains(convergeNum))
				convergeNumSet.add(convergeNum) ;
			i++ ;
		}

		System.out.printf( "Converging set has following numbers :\n ");
		
		int count = 1 ;
		for(Integer convNum : convergeNumSet ){
			System.out.printf( "%d",convNum );
			if(count < convergeNumSet.size())
				System.out.print(",");
			count++ ;
		}
		
	}
	
	public static int findConvergingNum(int inpNum){
		Set<Integer> finalSumSet = new LinkedHashSet<Integer>() ; 
		finalSumSet.add(inpNum) ;
		int convergingSum = doOperations(inpNum, finalSumSet) ;
		return convergingSum ; 
	}
	
	
	private static int doOperations(int inpNum, Set<Integer> finalSumSet) {
		int sumOfSquaredDigts = calculateSumOfSquaresOfDigits(inpNum  ) ;
		
		if(! finalSumSet.contains(sumOfSquaredDigts)) {
			finalSumSet.add(sumOfSquaredDigts) ;
			return doOperations(sumOfSquaredDigts, finalSumSet) ;
		}
		else if(finalSumSet.contains(sumOfSquaredDigts) ){
			return sumOfSquaredDigts ; 
		}
		return 0 ;  
	}
	
	private static int calculateSumOfSquaresOfDigits(Integer num ) {
		int sumOfSquaresOfDigits  = 0 ;
		/*
		 * calculate sum of squares of digits of a number.
		 */
		while(num !=0){  
			int onesNum = num % 10 ;
			sumOfSquaresOfDigits = sumOfSquaresOfDigits+(onesNum*onesNum ) ;
			num = num/10 ;
		}
		return sumOfSquaresOfDigits ;
	}
	
  

}
