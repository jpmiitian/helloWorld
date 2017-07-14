package coding.interview_bit;

import java.util.Arrays;
import java.util.Scanner;

 
public class ThirdLargetNum {

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
	    
	    numToPrint =  countSort (intArr) ;
	    
		System.out.println(numToPrint);
		in.close();
	}
	
	
	private static int  countSort(int A[]){
		
		int maxNum = 0 ;
		for(int i : A ){
			if( i > maxNum ) 
				maxNum = i ;
		}
		
		int[] countSortArr = new int [ maxNum + 1] ; 
		for( int i = 0 ; i < countSortArr.length ; i++  )
			countSortArr[i] = 0 ;
		
		for(int i : A ){
			int count = countSortArr[i] ;
			if(count != 0  ) 
				countSortArr[i] = count ++ ;
		}
		
		int numsFound = 0 ;
		for (int j = countSortArr.length ; j >=0 ; j--  ) {
			if( j!= 0  )
				numsFound++ ; // some num is found
			
			if( numsFound == 3 )
				return j ;
		} 
		
		int k = Integer.MIN_VALUE ;
		return -1 ;
	}
 	
 	
}
