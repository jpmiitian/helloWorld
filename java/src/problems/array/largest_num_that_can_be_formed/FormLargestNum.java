package problems.array.largest_num_that_can_be_formed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FormLargestNum {

	public String largestNumber(int[] nums) {

		String[] strs = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String s1, String s2) {
				String leftRight = s1 + s2;
				String rightLeft = s2 + s1;
				
				return - leftRight.compareTo(rightLeft); // Minus for descending order

			}
		});

		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s);
		}

		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	} 
 
	
	 public static void main (String [] args){
		 FormLargestNum d = new FormLargestNum () ;
		
	
		 System.out.println(String.valueOf(1000)+"2999");
		 
		 
		 int arr [] = {1,2,3,4,5,9} ;
	
	 System.out.println( d.largestNumber(arr) );
	 }
	 
	public boolean containsDuplicate(int[] nums) {
		int zor = 0;
		for (int item : nums) {
			zor = zor ^ item;
			if (zor == 0)
				return true;
		}
		return false;
	}
 
    public ArrayList<Integer> findPerm(final String str, int n) {

    	
    	
    	
    	return null ; // TODO 
    }

    public int missingNumber(int[] nums) {
        int n = nums.length ;
        
        int sumTillN = n * (n-1)/2 ;
        
        int arrSum = 0;
        
        for(int item : nums){
        	arrSum+=item ;
        }
        
       return sumTillN - arrSum ;
         
    }
	
	public int firstMissingPositive(ArrayList<Integer> list) {
		
	    int minPos = -1 ;
	    int maxPos = -1 ;
	    
	    for(Integer num : list) {
	    	if(num > 0 &&  (num < minPos || num!=-1 )){
	    		minPos = num ;
	    	}
	    	
	    	if(num > 0 &&  num > maxPos ){
	    		maxPos = num ;
	    	}
	    }
	    
	    
	    if(minPos < 0 && maxPos!=1 )
	    		return 1 ;
	    

	    return minPos ;
	}
	
	
	
	
}
