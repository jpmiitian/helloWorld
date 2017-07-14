package coding.hackerrank.warmup.maximizing_xor;

import java.math.BigInteger;
import java.util.Scanner;

public class MaximizingXor {


    private static int maxXor(int l, int r) {
    	int small;// =l<r?r:r;
    	int big ;//= l>r ?l:r;
    	if(l<=r){
    		small =l;
    		big =r;
    	}else {
    		small =r;
    		big =l;
    		
    	}
    	int rsltMaxXor = 0 ;
    	/*BigInteger bi1 = new BigInteger(String.valueOf(small));
    	BigInteger bi2 = new BigInteger(String.valueOf(big));
    	*/
    	for(int i = small;i<=big;i++){
    		BigInteger bigI = new BigInteger(String.valueOf(i));
        	for(int j = i+1; j<=big; j++){
        		BigInteger bigJ = new BigInteger(String.valueOf(j));
        		
        		BigInteger xor = bigI.xor(bigJ);
    			
    			if(xor.intValue() > rsltMaxXor){
    				//System.out.println("xor is "+xor.intValue());
    				rsltMaxXor = xor.intValue() ;
    				//System.out.println("max xor is "+rsltMaxXor);
    			}
    		}
    		
    	}
    	return rsltMaxXor;
    	
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        in.close();
        
    }
	
	
}
