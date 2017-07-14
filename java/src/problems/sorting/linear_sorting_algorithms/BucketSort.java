package problems.sorting.linear_sorting_algorithms;

public  class BucketSort {

	
	public void  bucketSort(int A[], int array_size) {
		
		int TEN_BUCKETS = 10;
		int i, j, k;
		int buckets[] = new int[TEN_BUCKETS]; // Keeping 10 buckets

		// initialize array elements to ZERO
		for (j = 0; j < TEN_BUCKETS; j++) {
			buckets[j] = 0;
		}
		for (i = 0; i < array_size; i++) {
			++buckets[A[i]];
		}
		for (i = 0, j = 0; j < TEN_BUCKETS; j++) {
			for (k = buckets[j]; k > 0; --k) {
				A[i++] = j;
			}
		}
		
		
	}
	
}
