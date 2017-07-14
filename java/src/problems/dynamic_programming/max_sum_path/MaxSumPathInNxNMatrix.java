package    problems.dynamic_programming.max_sum_path;

public class MaxSumPathInNxNMatrix {
	
	
	
	/**
	 * {@link http://www.geeksforgeeks.org/path-maximum-average-value/}  
	 */
	public static void main (String[] args){
		
		int[][] cost = {{1,2,3},
				        {4,5,6},
				        {7,8,9,} } ;
		System.out.println("Max path cost is :"+findPathWithMaximumSum( cost  )) ;
	}
	
	
	private static int findPathWithMaximumSum(int[][] cost ){
		int n = cost.length ;
		int dp[][] = new int[n][n] ;
		dp[0][0] = cost[0][0] ; // initializing result array
		
		for ( int i = 1 ; i < n ; i++) {
			dp[i][0] = dp[i-1][0] + cost[i][0] ;
		}
		
		for ( int j = 1 ; j < n ; j++) {
			dp[0][j] = dp[0][j-1] + cost[0][j] ;
		}
		
		for(int i = 1 ; i< n ; i++ ) {
			for(int j = 1 ; j< n ; j++ ) {
				dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] ) + cost[i][j] ; 
			}
		}
		
		return dp[n-1][n-1] ;
		
	}
	
	
	
	
	
	
}