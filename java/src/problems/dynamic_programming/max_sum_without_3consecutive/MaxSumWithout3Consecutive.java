package    problems.dynamic_programming.max_sum_without_3consecutive;

public class MaxSumWithout3Consecutive {
	
	
	
	/**
	 * {@link http://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/}  
	 */
	public static void main (String[] args){

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("Max sum without 3 consecutivr nums is :" + findMaximumSumWithOut3ConsecutiveNumsInPostiveArray(arr));

	}
	
	
	private static int findMaximumSumWithOut3ConsecutiveNumsInPostiveArray(int[] arr ){
		int n = arr.length ;
		int sum [] = new int [n ] ;
		sum[0] = arr[0] ;
		sum[1] = arr[1] ;
		
		/* 3 Possibilities for finding sum[2]
		 * 1.Exclude arr[2]
		 * 2.Exclude arr[0]
		 * 3.Exclude arr[1]
		 * */
		for(int i =2 ;i< n ;i++){
			int excPrsntIndxSum = sum[i-1]; //if excluding arr[i]
			int excPreToPrevious = sum[i-3] + arr[i-1] + arr[i] ;
			int excPrevious  = sum[i-3] + arr[i-2] + arr[i] ;
			
			int compSum = excPrsntIndxSum > excPreToPrevious ? excPrsntIndxSum : excPreToPrevious ;
			
			sum[i] = Math.max( compSum , excPrevious )  ;
		}
		
		return sum[n-1] ;
	}
	
	
	
	
	
	
}