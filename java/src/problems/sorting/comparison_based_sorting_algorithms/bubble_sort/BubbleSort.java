package problems.sorting.comparison_based_sorting_algorithms.bubble_sort;

public class BubbleSort {

	public static void main(String [] args){
		
		int arr[ ] = {2,3,34,4,65} ;
		new BubbleSort().bubbleSort_O_N_Square(arr, arr.length) ;
	}
	
	/**
	 * simplest sorting Algorithm
	 * Time : O(N^2)
	 */
	public void bubbleSort_O_N_Square(int[] arr, int n) {
		for (int pass = n - 1; pass >= 0; pass--) {
			for (int i = 0; i < pass - 1; i++) { // Time O(n^2) even in best
													// case
				if (arr[i] > arr[i + 1]) {
					// swap elements
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	
		utility_methods.UtilityMethods.printArrayElements(arr) ;//print Array Elements 
	}


	/**
	 * We can improve BEST CASE COMPLEXITY of bubble sort from O(n^2) to O(n) by keeping one extra
	 * flag. No more swaps indicate the completion sorting If the list is
	 * already sorted we can use this flag to skip the remaining process
	 */
	public void bubbleSort_Best_Case_Time_Improved_O_N_(int[] A, int n) {
		int pass, i, temp, swapped = 1;
		for (pass = n - 1; pass >= 0 && swapped == 1; pass--) {
			swapped = 0;
			for (i = 0; i < pass - 1; i++) {
				if (A[i] > A[i + 1]) {
					// swap elements
					temp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = temp;

				}
			}
		}
	}
}
