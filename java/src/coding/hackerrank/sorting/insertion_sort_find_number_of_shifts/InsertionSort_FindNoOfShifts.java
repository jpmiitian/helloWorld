package coding.hackerrank.sorting.insertion_sort_find_number_of_shifts;

import java.util.Scanner;

import problems.sorting.comparison_based_sorting_algorithms.quicksort_divide_and_conquer.QuickSort;

public class InsertionSort_FindNoOfShifts {
	
	
	public static void insertionSort(int[] arr, int n) {
		int i, temp,countShifts = 0;
		for (i = 1; i <= n; i++) {
			temp = arr[i];
			int k = 0, pos = 0, posChanged = 0;
			
			for (k = i; k > 0; k--) {
				if (arr[k - 1] > temp) {
					++countShifts ; 
					arr[k] = arr[k - 1];//shifting array elements 
					posChanged = 1;
					pos = k - 1;
				}
			}
			
			if (posChanged == 1)
				arr[pos] = temp;
		//	printArray(arr);
		}
		
		System.out.println( countShifts );//print no shifts required 
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

		insertionSort(arr, arr.length - 1);

	//		new QuickSort().quickSort(arr, 0, _a_size -1);//testing QuickSort for input array
		next = null;
		next_split = null;
		arr = null;
		in.close();

	}

}