package problems.array.wave_sort_an_array;

import java.util.ArrayList;
import java.util.Collections;

public class WaveSortArray {
	
	public int[] waveSortArray(int A[]) {
		
		A = quickSort(A,0, A.length-1) ;
		
		System.out.print("sorted array :  ");
		for(int i : A){
			System.out.print(i+" ");
		}
		System.out.println(" ");
		
		
		for(int i=0 ;i< A.length-1 ; i++){
			swap(A, i, ++i);
		}
		
		return A ;
	}
	
	

	public int[] quickSort(int A[], int low, int high) {
		int pivot;
		// Termination condition
		if (high > low) {
			pivot = partition(A, low, high);
			quickSort(A, low, pivot - 1); // call quick sort on left sub array of pivot
			quickSort(A, pivot + 1, high); // call quick sort on right sub array of pivot
		}
		return A;
	}

	public int partition(int[] arr, int low, int high) {
		int leftIndx, rightIndx, pivot_item = arr[low];
		leftIndx = low;
		rightIndx = high;

		while (leftIndx < rightIndx) {
			// move left while item<pivot
			while (leftIndx < arr.length && arr[leftIndx] <= pivot_item) {
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

		/* rightIndx is final position for the pivot . */
		arr[low] = arr[rightIndx]; // PIVOT ITEM WAS array[low], So this is not swapped
		arr[rightIndx] = pivot_item;// We are basically swapping the pivot index with right most index.

		return rightIndx;
	}

	/**
	 * Swap two elements in an array
	 */
	public void swap(int A[], int left, int right) {
		if (left > A.length - 1 || right > A.length - 1) {
			System.out.println("index to swap is out of array max length");
		} else {
			int temp = A[left];
			A[left] = A[right];
			A[right] = temp;
		}

	}

	public static void main(String[] args) {
		WaveSortArray d = new WaveSortArray();

		int arr[] = { 4, 3, 9, 1, 5, 3, 6 };
		
		for(int i : d.waveSortArray(arr)){
			System.out.print(i+" ");
		}
		 ArrayList<Integer> newList = new ArrayList<>() ;
		for(int i : arr)
			newList.add(i) ;

		System.out.println("wave list :  ");
		for(Integer i :	d.wave(newList )) 
			System.out.print(i+" "); 
		
	}
	
	/**
	 * This method uses Collections.sort() to sort the list.
	 * After sorting, we are making new list with alternate sorted values. 
	 * @param a
	 * 			list of integers. 
	 * @return
	 * 		  	wave sorted list.	
	 */
	public ArrayList<Integer> wave(ArrayList<Integer> a) {
		 ArrayList<Integer> newList = new ArrayList<>() ;
		 Collections.sort(a);
		 for(int i =0;i< a.size()-1 ;i++){
			 newList.add(a.get(i+1)) ;
			 newList.add(a.get(i)) ;
			 i++ ;
		 }
		 if(a.size()%2==1)
			 newList.add(a.get(a.size()-1)) ;
		 return newList;
	}
	
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
		ArrayList<Integer> rsltList = new ArrayList<Integer>() ;
		
		Collections.sort(a); 
		
		for(int i= 0 ; i< a.size()-1 ; i++){
			int nextIndx = i+1 ;
			while(nextIndx < a.size() &&  a.get(nextIndx) == a.size() ){
				nextIndx++ ;
			}
			
			if(nextIndx < a.size()) {
				rsltList.add(a.get(nextIndx)) ;
			}
			else 
				rsltList.add(-1) ;
		}
		
	    
	 return rsltList ;   
	}
	

}
