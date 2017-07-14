package problems.selection_algorithms.find_k_smallest_elements_in_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K_SmallestElementsInArray {

	/**Find k-smallest element in an array using Partition method 
	 * Algorithm:
	 * 1.Choose a pivot from the array
	 * 2.Partition the array so that A[low..pivot-1] <= pivotPoint <= A[pivot+1...high]
	 * 3.if k < pivotItem then it must be on left of pivot, so do same method recursively on LEFT part.
	 * 4.if k = pivotItem then it must be the pivot, print all elements from low to pivot..
	 * 5.if k > pivotItem then it must be on the right of pivot,so do same method recursively on RIGHT part     
	 * 
	 */
	
	public void selection(int low,int high,int k ){
		
	}

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static int kthsmallest(final List<Integer> a, int k) {
	
		List<Integer> newList =  new ArrayList<Integer>() ;
		Collections.copy(newList, a);
		Collections.sort(newList);
		
		
		return newList.get(k - 1 ) ; 
	}
	
	public static void main(String[] args){
    	String[] unSortedStringArray =  ("46 8 16 80 55 32 8 38 40 65 18 15 45 50 38 54 52 23 74 81 42 28 16 66 35 91 36 44 9 85 58 59 49 75 20 87 60 17 11 39 62 20 17 46 26 81 92").split(" ") ; 
    	int kthPosn = 9 ; // find nth smallest element from this unsorted array 
    	
    	ArrayList<Integer> finalList = new ArrayList<>(); 
    	
    	for(String num : unSortedStringArray  ){
    		finalList.add(Integer.parseInt(num)) ;
    	}
		
    	kthsmallest(finalList, kthPosn)  ;
		
	}
	
	
}
