package problems.array.find_missing_integer_in_array;

import java.util.ArrayList;

public class FindMissingInt {
	/*
	 * Given an unsorted integer array, find the first missing positive integer.
		Example:
		Given [1,2,0] return 3,
				[3,4,-1,1] return 2,
				[-8, -7, -6] returns 1
		Your algorithm should run in O(n) time and use constant space.
	 * 
	 */

	 public static void main (String [] args){
		 FindMissingInt d = new FindMissingInt () ;
		 System.out.println(String.valueOf(1000)+"2999");
		  //int arr [] = {1,2,3,4,5,9} ;
		 
		 int arr[] = {0, 10, 2, -10, -20};
		 
		 FindMissingInt f = new FindMissingInt() ;
		 
		  int missing = f.segregate(arr, arr.length);
	
		  //return 0;
		 
		 //	 System.out.println( d.largestNumber(arr) );
	 }
	  
	 
	 
	 
	 /* Utility function that puts all non-positive (0 and negative) numbers on left 
	   side of arr[] and return count of such numbers */
	 public int segregate (int arr[], int size){
	     int j = arr.length-1 , i;
	     for(i = 0; i < size; i++){
	        if (arr[i] <= 0){
	            swap(arr, i, j );
	            j-- ;  // increment count of non-positive integers
	        }
	     }
	  
	     return arr.length-1 - j;
	 }
	 
 
	 
	 public int findDuplicate(int[] nums) {
		 nums =	quickSort(nums, 0, nums.length -1);//testing QuickSort for input array
		 int i = 0;
		 while(i<nums.length -1){
			 if(nums[i]== nums[i+1]){
				 return nums[i] ;
			 }
			 else {
				 i++ ;
			 }
		 }
		 return 0 ;	
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
	
	
	

	 
	public boolean containsDuplicate(int [] nums){
		int zor = 0 ;
		
		for(int item : nums){
			zor = zor^item ;
			if(zor==0)
				return true ;
		}
		return false ;
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
