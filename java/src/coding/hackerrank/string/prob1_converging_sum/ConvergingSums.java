package coding.hackerrank.string.prob1_converging_sum;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class ConvergingSums {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println(Integer.MAX_VALUE);
		
//		if(1000000000 < Integer.MAX_VALUE)
//			System.out.println("JAY");
//		Integer inpNumber = in.nextInt() ; // .nextLine();

		
		Integer	inpNumber = 1000000000 ;
		
		File file = new File("E:\\sca\\Exp_TestNG\\out1.txt"); //Your file
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
	//	System.out.println("This goes to out.txt");
		
		LinkedHashSet<Integer> convergeNumSet  = new LinkedHashSet<Integer>() ;
		
		int i=1 ;
		while(i<=1000){
			int convergeNum =  findConvergingNum(i) ;
			if(! convergeNumSet.contains(convergeNum))
				convergeNumSet.add(convergeNum) ;
			System.out.printf( "converging num for %d is :  %-10d ",i,convergeNum );
			System.out.println();
			i++ ;
		}
		System.out.println("***********************************************************************") ;
		System.out.printf("********* converging set has %-3d elements " , convergeNumSet.size() );
		System.out.println("***********************************************************************") ;
		for(Integer convNum : convergeNumSet ){
			System.out.printf( "converging set has num :  %-10d ",convNum );
			System.out.println();
		}
		
		int j = 20 ;
		System.out.println( "converging num for "+j+" is : "+ findConvergingNum(j) );
		
		
		/*
		 * Assumption 
		 * Input text is in lower cases with words separated by space
		 */
		String  inpNumAsStr = String.valueOf( inpNumber  );

		char[] digArray = inpNumAsStr.toCharArray() ;
		
		
		in.close(); // closing scanner
	}
	
	public static int findConvergingNum(int inpNum){
		Set<Integer> finalSumSet = new LinkedHashSet<Integer>() ; 
		Map<Set<Integer>,Integer> finalSumSetToConvergNum = new  HashMap<Set<Integer>,Integer>() ; 
		finalSumSet.add(inpNum) ;
		int convergingSum = doOperations(inpNum, finalSumSet, finalSumSetToConvergNum) ;
	//	printFinalSumsForInp( inpNum,  finalSumSet) ;
		return convergingSum ; //TODO modify
	}
	
	private static void printFinalSumsForInp(int inpNum, Set<Integer> finalSumSet){
		System.out.println("\n Input No. is :"+inpNum);
		for(Integer i : finalSumSet){
			System.out.println(" fsum is "+i);
		}
	}
	
	private static int doOperations(int inpNum, Set<Integer> finalSumSet, Map<Set<Integer>,Integer> finalSumSetToConvergNum) {
		int sumOfSquaredDigts = calculateSumOfSquaresOfDigits(inpNum,finalSumSet ) ;
		
		if(! finalSumSet.contains(sumOfSquaredDigts)) {
			finalSumSet.add(sumOfSquaredDigts) ;
			return doOperations(sumOfSquaredDigts, finalSumSet, finalSumSetToConvergNum) ;
		}
		else if(finalSumSet.contains(sumOfSquaredDigts) ){
			finalSumSetToConvergNum.put(finalSumSet, sumOfSquaredDigts) ;
			return sumOfSquaredDigts ; 
		}
		return 0 ; // default return 
	}
	
	private static int calculateSumOfSquaresOfDigits(Integer num, Set<Integer> finalSumSet) {
		int sumOfSquaresOfDigits  = 0 ;
		
//		while(num % 10 == 0 ){
//			num = num /10 ;
//			finalSumSet.add(num) ; //add number to set
//		}
		
		while(num !=0){ //		while(num%10 !=0){
			int onesNum = num % 10 ;
			sumOfSquaresOfDigits = sumOfSquaresOfDigits+(onesNum*onesNum ) ;
			num = num/10 ;
		}
		
		return sumOfSquaresOfDigits ;
	}
	
  

}
