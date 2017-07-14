package coding.interview_bit;

import java.util.Arrays;
import java.util.Scanner;

 
public class MajorityElement {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//Write code here
	    Integer noOfInputs;
	     int numToPrint = -1 ; 
	    noOfInputs =Integer.parseInt(in.nextLine());
	    String str = in.nextLine() ;
	    String[] sArr = str.split(" ") ;
	    int numItems = sArr.length ;
	    int [] intArr = new int[sArr.length] ; 
	    for(int i = 0 ; i< sArr.length ; i++   ){
	    	intArr[i] = Integer.parseInt(sArr[i]) ;
	    }
	    Arrays.sort(intArr) ; 
	 
	    boolean isEvenNums = false ;
	 //   int midIndex  =  noOfInputs/2 ;
	  
	    if(noOfInputs % 2 == 0 )
	    	isEvenNums = true ;

	    int nByTwo = numItems/2 ;
	    // if odd length array input
	    if(! isEvenNums ) {
	    	int start = intArr[0 ] ;
	    	int mid = intArr [ nByTwo ] ;
	    	int last = intArr[numItems - 1 ] ;
	    	if(start == mid || last== mid )
	    		numToPrint =  mid ; 	
	    }
	    else { 
	    	int start = intArr[0 ] ;
	    	int midOne = intArr [numItems/2  ] ;
	    	int midTwo = intArr [(numItems/2) + 1  ] ;
	    	int last = intArr[numItems - 1 ] ;
	    	
	    	if(midOne==midTwo ) {
	    		if(start == midOne )
	    			numToPrint =  midOne ; 
	    		else if(last == midOne )
	    			numToPrint =  midOne ; 
	    	}
	    }
	    	
		System.out.println(numToPrint);
		in.close();
	}
	
	
 
 	
 	
}
