package coding.hackerrank.string.prob1_converging_sum;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ConvergeToOne {

	public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
//      System.out.print("Enter k:");
//      Integer inpNumber = in.nextInt();
      Integer	inpNumber = 1000000000 ;
      Long startTime =  System.currentTimeMillis() ;
		
		System.out.println("Input number is : "+inpNumber);

      int numsConvergingToOne = 1; // 1 converges to one.

      int i = 2; // start from 2 as we already considered 1.
      
      int convToOneArr[] = new int[1000];
      int notConvToOneArr[] = new int[1000];

      for (int j = 0; j < 1000; j++) {
          convToOneArr[j] = 0;
          notConvToOneArr[j] = 0;
      }
      convToOneArr[1]=1; // 1 converges 1, so putting 1 as flag to mark as converging to 1 
     
      /*
       * numbers 2 to 6 does not converges to 1, so putting 1 against  notConvToOneArr[] 
       */
//      int num = 2 ;
//      while(num < 6 ){
//      	notConvToOneArr[num]=1;
//      	num++ ;
//      }
      notConvToOneArr[2]=1;notConvToOneArr[3]=1;notConvToOneArr[4]=1;notConvToOneArr[5]=1;
      notConvToOneArr[6]=1;
      
      
      while (i <= inpNumber) {
          int n = i;
          Set<Integer> noSet = new HashSet<>();
          boolean isNumConvrgTo1 = false;
          while (true) {
              int s = calculateSumOfSquaresOfDigits(n, null);
              //System.out.println(s);
              if (notConvToOneArr[s] != 0) {
                  isNumConvrgTo1 = false;
                  if (n < 1000)
                      notConvToOneArr[n] = 1;
                  break;
              }
              if (convToOneArr[s] != 0) {
                  isNumConvrgTo1 = true;
                  if (n < 1000)
                      convToOneArr[n]++;
                  break;
              }
              if (!noSet.contains(s)) {
                  noSet.add(s);
              } else {
                  isNumConvrgTo1 = false;
                  break;
              }
              n = s;
          }

          for (final Integer setEle : noSet) {
              if (isNumConvrgTo1) {
                  convToOneArr[setEle] = 1;
              } else {
                  notConvToOneArr[setEle] = 1;
              }
          }
          if (isNumConvrgTo1) {
              numsConvergingToOne++;
          }
          i++;
      }

      // print number of integers converging to 1.
      System.out.println("Numbers that converge to 1:" + numsConvergingToOne);
  	System.out.println("Time Taken in milliseconds : "+ (System.currentTimeMillis() - startTime) )  ;

      in.close(); // closing scanner
  }
	
	private static Map<Integer, Integer> inpNumToConvergeNumMap = new TreeMap<Integer,Integer >() ;
	
	public static int findConvergingNum(int inpNum){
		Map<Integer,Boolean> finalSumSet = new HashMap<Integer,Boolean>() ;
		Map<Set<Integer>,Integer> finalSumSetToConvergNum = new  HashMap<Set<Integer>,Integer>() ; 
		finalSumSet.put(inpNum,true) ;
		int convergingSum = doOperations(inpNum, finalSumSet, finalSumSetToConvergNum) ;
		return convergingSum ; //TODO modify
	}
	
	/**
	 * This map holds converging 
	 */
	private static Map<Integer, Integer> memo = new TreeMap<Integer,Integer >() ;
	private static Map<Integer, Integer> memoSumSquaredDigits = new TreeMap<Integer,Integer >() ;

	
	private static int doOperations(int inpNum, Map<Integer, Boolean> finalSumSet, Map<Set<Integer>,Integer> finalSumSetToConvergNum) {
		
		if ( inpNumToConvergeNumMap.containsKey(inpNum) )
			return inpNumToConvergeNumMap.get(inpNum) ;
		
		if( memo.keySet().contains(inpNum)) {
			return memo.get(inpNum) ;
		}
			
		int sumOfSquaredDigts = calculateSumOfSquaresOfDigits(inpNum,finalSumSet ) ;
		
		if(! finalSumSet.keySet().contains(sumOfSquaredDigts)) {
			finalSumSet.put(sumOfSquaredDigts,true)  ;
			return doOperations(sumOfSquaredDigts, finalSumSet, finalSumSetToConvergNum) ;
		}
		else if(finalSumSet.keySet().contains(sumOfSquaredDigts) ){
			return sumOfSquaredDigts ; 
		}
		return 0 ; // default return 
	}
	
	private static int calculateSumOfSquaresOfDigits(Integer num, Map<Integer, Boolean> finalSumSet) {
		int sumOfSquaresOfDigits  = 0 ;
		
		if( memoSumSquaredDigits.keySet().contains(num) ) {
			return memoSumSquaredDigits.get(num) ;
		}
		
		while(num !=0){ 
			int onesNum = num % 10 ;
			sumOfSquaresOfDigits = sumOfSquaresOfDigits+(onesNum*onesNum ) ;
			num = num/10 ;
		}
		
		return sumOfSquaresOfDigits ;
	}
	
  

}
