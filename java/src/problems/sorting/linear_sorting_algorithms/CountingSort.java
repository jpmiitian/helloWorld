package problems.sorting.linear_sorting_algorithms;

public class CountingSort {
	
/** COUNT THE NO. OF ELEMENTS LESS THAN INPUT ELEMENT
  * IN THIS WAY WE CAN FIND APPROPRIATE POSITION OF INPUT ELEMENT
  * Suppose, an element is larger than 10 elements, 
  * than its OUTPUT POSITION WILL BE AFTER 10 elements in Output array.
  *   
  */
	
 /**
  * It is not comparison-based sorting.
  * 
  *  Counting sort gives O(n) time complexity, to achieve this 
  *  counting sort assumes that each element is integer in the range [0..to k], 
  *  for some integer K, when K = O(n), the counting sort runs in O(n) time 
  *  
  *  THE BASIC IDEA IN COUNTING SORT IS TO DETERMINE FOR AN INPUT ELEMENT 'X' THE NO OF ELEMENTS LESS THAN 'X'  
  *    	
  */
	
 /**
  *Below A[] is input array with length n, 
  *In counting sort we need two more arrays,
  *Lets assume B[] contains SORTED OUTPUT
  *and the array C[0...k-1] PROVIDES TEMPORARY STORAGE
  *  
  */
	public void countingSort(int A[], int n, int B[], int K) {
		int temp[] = new int[K];
		int i, j;

		// complexity O(K)
		for (i = 0; i < K; i++) {
			temp[i] = 0;
		}
		
		// complexity O(n)
		for (j = 0; j < n; j++) {
			temp[A[j]] = temp[A[j]] + 1;
			// temp [i] now contains the no. of elements equal to i
		}
		
		// complexity O(k)
		for (i = 1; i < n; i++) {
			temp[i] = temp[i] - 1;
			// temp [i] now contains the no. of elements less than equal to i
		}
		
		//complexity O(n)
		for (j = n - 1; j >= 0; j--) {
			B[temp[A[j]]] = A[j];
			temp[A[j]] = temp[A[j]] - 1;
		}

	}
	
}
