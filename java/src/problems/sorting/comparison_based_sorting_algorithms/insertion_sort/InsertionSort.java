package problems.sorting.comparison_based_sorting_algorithms.insertion_sort;

public class InsertionSort {
	
	/**
	 * Insertion sort is SIMPLE & EFFICIENT COMPARISON SORT
	 * In this Algo. , EACH ITERATION REMOVES an element from the input data and 
	 * INSERT IT AT the CORRECT POSITION in the list being sorted .
	 * The choice of the element being removed from the input is random and 
	 * this process is repeated until all elements have gone through. 
	 *
	 * ADVANTAGES :
	 * 1.Simple implementation
	 * 2.Efficient for small data
	 * 3.ADAPTIVE: if the input list is pre-sorted (may not be completely),
	 *             then Insertion Sort takes O(n+d) time,where d is no. of inversions
	 *             
	 * 4.Practically more efficient than bubble & selection sort,
	 *   even though all of them have O(n^2) worst case complexity
	 *   
	 * 5.STABLE : Maintains relative order of input data if the keys are same
	 * 
	 * 6.IN-PLACE: It requires only constant amount O(1) additional storage
	 * 
	 * 7.ONLINE : Insertion sort can sort as it receives it
	 *   
	 * ALGORITHM : 
	 * Every iteration of insertion-sort removes an element from the input data,
	 * inserts it into the CORRECT-POSITION in already sorted list until no input elements remain.
	 * 
	 * SORTING IS TYPICALLY DONE IN PLACE
	 * 
	 * The resulting ARRAY after k-iterations has the property,
	 * where the first K+1 elements are SORTED. 
	 * 
	 * Time : Worst O(n^2) 
	 * 		: Best CAse : O(n^2)
	 * 
	 * Comparison to other sort:
	 * IT IS USED WHEN THE DATA IS NEARLY SORTED, due to its adaptiveness or when the input size is small                                 
	 *                                 
	 */
	public void insertionSort(int[] arr, int n) {
		int i, j, temp;
		for (i = 2; i <= n-1; i++) {
			temp = arr[i];
			j = i;
			while (arr[j - 1] > temp && j > 1) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}	

}
