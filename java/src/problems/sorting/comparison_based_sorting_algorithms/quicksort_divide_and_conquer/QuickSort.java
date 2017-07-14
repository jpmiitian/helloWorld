package problems.sorting.comparison_based_sorting_algorithms.quicksort_divide_and_conquer;

import java.util.Scanner;

import utility_methods.UtilityMethods;

public class QuickSort {

	/**
	 * Algorithm 
	 * 1.If no elements to be sorted return. 
	 * 2.pick an element in
	 * array to be served as 'pivot' point.(usually the left most element is used) 
	 * 3.split the array into two parts, one with elements larger than PIVOT and other with elements smaller than PIVOT.
	 * 4.Recursive REPEAT the Algorithm for both halves of array.
	 * 
	 *   Worst case time O(n^2)
	 * Average case time O(n-log-n-)
	 * 	  Best case time O(n-log-n-) 
	 * Worst case space complexity : O(1)
	 */

	public static void quickSort(int A[], int low, int high) {
		int pivot;
		// Termination condition
		if (high > low) {
			pivot = partition(A, low, high);
			quickSort(A, low, pivot - 1);  // call quick sort on left sub array of pivot
			quickSort(A, pivot + 1, high); // call quick sort on right sub array of pivot
		}
		
		UtilityMethods.printArrayElements(A);
		//System.out.println("\n");
	}

	public static int partition(int[] arr, int low, int high) {
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
	public static void swap(int A[], int left, int right) {
		if (left > A.length - 1 || right > A.length - 1) {
			System.out.println("index to swap is out of array max length");
		} else {
			int temp = A[left];
			A[left] = A[right];
			A[right] = temp;
		}

	}
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _a_size = Integer.parseInt(in.nextLine());

		int[] arr = new int[_a_size];
		int arr_item;
		String next = in.nextLine();
		String[] next_split = next.split("\\ ");

		for (int i = 0; i < _a_size; i++) {
			arr_item = Integer.parseInt(next_split[i]);
			arr[i] = arr_item;
		}

		quickSort(arr, 0, _a_size -1);//testing QuickSort for input array
		
		next = null;
		next_split = null;
		arr = null;
		in.close();

	}

	
}
