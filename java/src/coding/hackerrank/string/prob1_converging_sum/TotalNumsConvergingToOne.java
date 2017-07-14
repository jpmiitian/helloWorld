package coding.hackerrank.string.prob1_converging_sum;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TotalNumsConvergingToOne {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter k:");
        Integer inpNumber = in.nextInt();
//      Integer	inpNumber = 1000000000 ;

        Long startTime =  System.currentTimeMillis() ;
		
		System.out.println("Input number is : "+inpNumber);
        
		/*
		 * keeping two arrays convTo1Arr[] and notConvTo1Arr[],
		 * if a sum is less than 1000, we will use these arrays to see if the sum converges to 1 or not.
		 */
        int convTo1Arr[]    = new int[1000];
        int notConvTo1Arr[] = new int[1000];

        for (int j = 0; j < 1000; j++) {
            convTo1Arr[j] = 0;
            notConvTo1Arr[j] = 0;
        }
        convTo1Arr[1]=1; // 1 converges 1, so putting 1 as flag to mark as converging to 1 
       
        /*
         * numbers 2 to 6 does not converges to 1, so putting 1 against  notConvToOneArr[] 
         */
        notConvTo1Arr[2]=1;notConvTo1Arr[3]=1;notConvTo1Arr[4]=1;notConvTo1Arr[5]=1;
        notConvTo1Arr[6]=1;
        

        int numsConvrgingToOne = 1; // 1 converges to one.
        int i = 2;                  // start from 2 as we already considered 1.
        
        while (i <= inpNumber) {
            int n = i;
            Set<Integer> noSet = new HashSet<>();
            boolean isNumConvergingTo1 = false;
            
            // loop to consider sum of squares of digits. 
            while (true) {
              /*
               *  code block to calculate sum of squares of digits
               */
            	int s = 0;   
                int num = n ;
                while (num != 0) {
                    int onesNum = num % 10;
                    s = s + (onesNum * onesNum);
                    num = num / 10;
                }
	          /*
	           * code block ends to calculate sum of squares of digits
	           */
                // check entry for this sum in notConvTo1Arr, if entry is 1 means the input number doesn't converges to one.
                if (notConvTo1Arr[s] != 0) { 
                    isNumConvergingTo1 = false;
                    // if n is less than 1000, put 1 in notConvergingToOne array.
                    if (n < 1000)
                        notConvTo1Arr[n] = 1; // to indicate n is not converging to 1.
                    break;
                }
                // check entry for this sum in convTo1Arr, if entry is 1 means the input number converges to one.
                if (convTo1Arr[s] != 0) {
                    isNumConvergingTo1 = true;
                    if (n < 1000)
                        convTo1Arr[n]++;
                    break;
                }
                /*
                 * if set doesn't contain s (sum of squares of digits), then add s to set of sums.
                 * else 
                 * the sum is already present in set of (sum of squares of digits), this means this is the converging number for input n. 
                 */
                if (!noSet.contains(s)) {
                    noSet.add(s);
                } else {
                    isNumConvergingTo1 = false;
                    break;
                }
                /*
                 * update n to s (sum of squares of digits).  
                 */
                n = s;
            }
            //end of loop to consider sum of squares of digits. 
            
            // update arrays for sums in set
            for (final Integer setEle : noSet) {
                if (isNumConvergingTo1) {
                    convTo1Arr[setEle] = 1;
                } else {
                    notConvTo1Arr[setEle] = 1;
                }
            }
            // increase count of numbers that are converging to 1.
            if (isNumConvergingTo1) {
                numsConvrgingToOne++;
            }
            i++;
        }

        // print number of integers converging to 1.
        System.out.println("Numbers that converge to 1:" + numsConvrgingToOne);
    	System.out.println("Time Taken in milliseconds : "+ (System.currentTimeMillis() - startTime) )  ;

        in.close(); // closing scanner
    }
 
    
 
	
}
