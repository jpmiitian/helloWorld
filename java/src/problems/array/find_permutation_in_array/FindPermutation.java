package problems.array.find_permutation_in_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FindPermutation {

    public ArrayList<Integer> findPerm(final String str, int n) {
    	
    	ArrayList<Integer> resultList = new ArrayList<Integer> () ;
    	char[] charArr = str.toUpperCase().toCharArray() ;
    	int countD = 0 ;
    	int countI = 0 ;
    	
    	/*
    	 * find count of D's or I's
    	 * This will be helpful in arranging the integers in required order 
    	 */
    	for ( char c : charArr ){
    		if(c=='D')
    			countD++ ; 	
    		if(c=='I')
    			countI++ ; 	
    	}
    	
    	/*
    	 * Begin forming the result list.
    	 * Note : Begin with countD+1 as first integer, as we know we have to decrease at least countD times .
    	 */
    	int nxtBig = countD + 1  ;
    	int nxtSmall = countD ;
    
    	resultList.add(nxtBig++) ;//First Use then increase the variable

    	for(char itrChar : charArr ){
    		if(itrChar=='D'){
    			resultList.add(nxtSmall  ) ;//First use than decrease countD 
    			nxtSmall --  ;
    		}
    		else if(itrChar=='I'){
    			resultList.add(nxtBig ) ;//First use than decrease countD 
    			nxtBig++ ;
    		}
    	}	
    	
    	
    	return resultList ; //returning list 
    }
	
	

 
	 public  int[] quickSort(int A[], int low, int high) {
			int pivot;
			// Termination condition
			if (high > low) {
				pivot = partition(A, low, high);
				quickSort(A, low, pivot - 1);  // call quick sort on left sub array of pivot
				quickSort(A, pivot + 1, high); // call quick sort on right sub array of pivot
			}
			
			return A ;
		//	UtilityMethods.printArrayElements(A);
			//System.out.println("\n");
		}

		public  int partition(int[] arr, int low, int high) {
			int leftIndx, rightIndx, pivot_item = arr[low];
			leftIndx = low;
			rightIndx = high;
		
			while (leftIndx < rightIndx) {
				// move left while item<pivot
				while (leftIndx < arr.length && arr[leftIndx] <= pivot_item ) {
					++leftIndx;
				}
				// move right while item > pivot
				while (arr[rightIndx] > pivot_item) {
					rightIndx--;
				}

				if (leftIndx < rightIndx) { // if left index is smaller than right index
					swap(arr, leftIndx, rightIndx);
				}
			}
			
			/*rightIndx is final position for the pivot .  */
			arr[low] = arr[rightIndx];  //PIVOT ITEM WAS array[low], So this is not swapped   
			arr[rightIndx] = pivot_item;// We are basically swapping the pivot index with right most index.

			return rightIndx;
		}

		/**
		 * Swap two elements in an array
		 */
		public  void swap(int A[], int left, int right) {
			if (left > A.length - 1 || right > A.length - 1) {
				System.out.println("index to swap is out of array max length");
			} else {
				int temp = A[left];
				A[left] = A[right];
				A[right] = temp;
			}

		}
	
	
	

	
	 public static void main (String [] args){
		 FindPermutation d = new FindPermutation () ;
		
	
		 System.out.println(String.valueOf(1000)+"2999");
		 
		 
		 int arr [] = {1,2,3,4,5,9} ;
	
//	 System.out.println( d.largestNumber(arr) );
	 }
	 
	public boolean containsDuplicate(int [] nums){
		
		int zor = 0 ;
		
		for(int item : nums){
			zor = zor^item ;
			if(zor==0)
				return true ;
		}
		
		
		return false ;
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
