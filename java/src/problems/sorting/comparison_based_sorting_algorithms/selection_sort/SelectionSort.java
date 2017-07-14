package problems.sorting.comparison_based_sorting_algorithms.selection_sort;

public class SelectionSort {
	
	/**
	 * Selection sort is IN-PLACE sorting algorithm.
	 * Selection sort works well for small files.
	 * It is USED FOR SORTING FILES with large values and SMALL Keys
	 *
	 * ADVANTAGES : Easy to implement
	 * 			  : In-Place Sort Algorithm(does not require additional storage space)
	 * 
	 * DISADVANTAGE : IN-Efficient O(n^2)	
	 *
	 * Algorithm 
	 * 1.find the minimum in list
	 * 2.swap the minimum with current
	 * 3.repeat for all elements,till all array is sorted.  
	 * 
	 * Worst Case : O (n^2)
	 * Best Case : O(n)
	 * Average Case : O(n^2)
	 * 
	 */
	public void  selectionSort(int[] A, int n){
		int i,j,min,temp;
		for(i=0;i<n-1;i++){
			min=i;
			for(j=i+1;j<n-1;j++){
				if(A[j] < A[min]){
					min = j;
				}
				// swap elements
				temp = A[i];
				A[i]=A[min];
				A[min]=temp;
			}
		}
	}
		
	
	

}
