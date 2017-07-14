package coding.hackerrank._30_day.check_if_fibonum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CheckIfFiboNum {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        
        int n = Integer.valueOf( br.readLine() ) ;
        
        int ip[] = new int[n] ;
        for(int i=0; i<n ;i++){
        	ip[i] = Integer.valueOf( br.readLine() ) ;
        }
     
        int [] fSeries = new int[1024] ; 
               fSeries = makeFiboSeries() ;
           
        int m[]  = getMax(fSeries) ; 
        
        int maxF2 = m[1] ;
        int maxF1 = m[0] ;
       
        for ( int j : ip ){
            boolean rs = checkIsFiboNum( fSeries ,  maxF1 ,  maxF2 , j )  ;           
            System.out.println( rs ? "IsFibo" : "IsNotFibo" ) ;
        }
 
        br.close() ;
    }
    
    private static boolean checkIsFiboNum(int [] fSeries , int maxF1 , int maxF2 , int n ) {
        if(n==maxF1 || n==maxF2  )
            return true ;
        if ( n <  1024  ) {
            return fSeries[n]==0 ? false : true ;
        }
        
        int sum = maxF1 + maxF2 ;
        
        while ( sum  <=  n ){
            if((maxF1 + maxF2)  ==  n )
                return true ; // num. matched
            else {
                maxF1 = maxF2 ;
                maxF2 =  sum ;
                sum = maxF1 + maxF2 ;
            }
        }
        return false ; 
        
    }
    
    
    private static int[] getMax(int [] fSeries) {
        int []  m = new int[2] ;
        boolean isM1Found = false ;
        int i = fSeries.length  ;
           
        while( i > 0 ){
            if(!isM1Found && fSeries[ i ] == 1 ){
                m[0] = i ; 
                isM1Found = true ;
                i-- ;
                continue ;
            } 
            if( isM1Found ){
                m[1] = i ;
                break ;
            }
            i-- ;
        } 
        
        return m ;
    }
    
    private static int[] makeFiboSeries() {
     int fs [] = new int[1024] ;  
       fs[0] =  1 ; // 0 is fib
       fs[1]  = 1 ; // 1 is fib
        int indx = 2 ;
        while(indx < 1024){
            fs[indx ] = 0 ;
            indx ++ ;
        }
        
        int i = 2 ; 
        int f1 = 0 ;
        int f2 = 1 ;
        
        while(i < 1024){
            int nFS =  f1 + f2 ;
            fs[nFS] = 1 ;  
            f1 = f2 ;
            f2 = nFS ;
            i++ ;  // inc. i
        }
        
     return fs ;   
    }
    
    
    
    
	
	
	
}
