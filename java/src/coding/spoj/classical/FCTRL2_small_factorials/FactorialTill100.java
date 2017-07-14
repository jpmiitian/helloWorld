package coding.spoj.classical.FCTRL2_small_factorials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FactorialTill100 {

	public static void main(String [] args) {
	    int i,j,x;
	    x = 0;
	    j = 0;
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    try{
	      j = Integer.parseInt(br.readLine());
	    }
	    catch(IOException e){
	      e.printStackTrace();
	    }
	    for(i=0;i<j;i++){
	      try{
	        x = Integer.parseInt(br.readLine());
	      }
	      catch(IOException e){
	        e.printStackTrace();
	      }
	      System.out.println(factorial(x));
	    }    
	  }

	  public static BigInteger factorial(int x){
	    BigInteger result = new BigInteger("1");
	    while(x>0){
	      result = result.multiply(new BigInteger(""+x));
	      x--;
	    }
	    return result;
	  }
}
