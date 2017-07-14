package problems.sorting.comparison_based_sorting_algorithms.merge_sort_divide_and_conquer;

/**
 * Merge sort is example of divide and conquer <br>
 * Time Worst  case : O(_n_log_n_) <br>
 * Time Average case: O(_n_log_n_) <br>
 * SPACE Worst case : O(_n_log_n_) AUXILLARY <br>
 * 
 * MergerSort is stable as but Quicksort is not stable
 */
public class MergeSort {

	public void mergeSort(int[] arr, int temp[], int left, int right) {
		int mid = 0;
		if (right > left)
			mid = (right + left) / 2;
		mergeSort(arr, temp, left, mid);
		mergeSort(arr, temp, mid + 1, right);
		merge(arr, temp, left, mid + 1, right);
	}

	public void merge(int A[], int[] temp, int left, int mid, int right) {
		int i, left_end, size, temp_pos;
		left_end = mid - 1;
		temp_pos = mid;
		size = right - left + 1;
		
		while (left <= left_end && mid <= right) {
			if (A[left] <= A[mid]) {
				temp[temp_pos] = A[left];
				temp_pos = temp_pos + 1;
				left = left + 1;
			} else {
				temp[temp_pos] = A[mid];
				temp_pos = temp_pos + 1;
				mid = mid + 1;
			}
		}
		
		while (left <= left_end) {
			temp[temp_pos] = A[left];
			left = left + 1;
			temp_pos = temp_pos + 1;
		}
		
		while (mid <= right) {
			temp[temp_pos] = A[mid];
			mid = mid + 1;
			temp_pos = temp_pos + 1;
		}
		
		for (i = 0; i <= size; i++) {
			A[right] = temp[right];
			right = right - 1;
		}

	}

}
