package coding.hackerrank.sorting.quick_sort_2;

import java.util.Scanner;

import utility_methods.UtilityMethods;

public class QuickSort_2 {
/*	public static void quickSortTwo(int[] array) {
		int lowIndx = 0 , highIndx = array.length -1  ; 
		int pivotIndx = partition(array  ) ;
		array = getSubArray(array ,  lowIndx ,   pivotIndx -1 ) ;
		quickSort (  array   ) ;
		array = getSubArray(array ,  lowIndx ,   pivotIndx -1 ) ;
		quickSort(array  ) ;
	//	printArray(array, lowIndx, highIndx); 
	}*/

	public static void quickSort(int[] inArray) {
		int lowIndx = 0;
		int highIndx = inArray.length - 1;

		if (highIndx > lowIndx) {
			
			int pivotIndx = partition(inArray);

			int[] leftSubArray = getSubArray(inArray, lowIndx, pivotIndx - 1);
			quickSort(leftSubArray);

			int[] rightSubArray = getSubArray(inArray, pivotIndx + 1, highIndx);
			quickSort(rightSubArray);
		}
		
		
	}
 
 
 
	private static int partition(int[] array ) {
	 int lowIndx =0 ;
	 int pivotIndx =0 ;
	 
	 int nextSmallIndx = 0 ;
	 int iteratorIndx = 1 ;

 	 int pivotItem = array[pivotIndx] ;

 	 while(iteratorIndx < array.length ){
 		 
   		//next element smaller than pivot item then shift array
 		 if(array[iteratorIndx] < pivotItem) {
 			shiftElements(array,nextSmallIndx ,iteratorIndx) ;
 		 }
 	 
 	 // iterator index increased 	 
 	 iteratorIndx++ ;
 	 }
 	
		
		
		return pivotIndx; // return default 
	}


	/**
	 * This method shifts elements array elements from startIndx to lastIndx,
	 * replacing the element at startIndx with lastIndx, like rotating the array clockwise. 
	 * 
	 * @param array
	 * @param startIndx
	 * @param lastIndx
	 */
	public static void shiftElements(int[] array, int startIndx, int lastIndx) {

		int tempOne= array[startIndx];// ;
		int tempTwo ;//= array[lastIndx] ;

		for (int indx = startIndx; indx < lastIndx; indx++) {

		//	tempOne = array[indx];
			tempTwo = array[indx + 1];

			array[indx + 1] = tempOne;

			if(indx==lastIndx-1)
				array[startIndx] = tempTwo  ; 
			
			tempOne = tempTwo ;
		}
		
	
		UtilityMethods.printArrayElements(array);
		
	}



	private static int[] getSubArray(int[] array, int lowIndx, int highIndx) {
		int subArray[] = { array[lowIndx] }  ; // initialising with one element 
		
		if(lowIndx>=0 && highIndx>=0){
		  subArray = new int [highIndx - lowIndx + 1 ] ; 
		}
		
		//copy elements from lowIndx to highIndx in other array ;
		for(int j=0 ,i = lowIndx   ; i<=highIndx ; i++){
			subArray[j++] = array[ i] ; 
		}
		return subArray;
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = in.nextInt();
		}
	//	quickSort( array );
	shiftElements(array, 0, array.length -1 );
		in.close();
	}

	/**
	 * Swap two elements in an array
	 */
	public static void swap(int A[], int leftIndx, int rightIndx) {
		if (leftIndx > A.length - 1 || rightIndx > A.length - 1) {
			System.out.println("index to swap is out of array max length");
		} else {
			int temp = A[leftIndx];
			A[leftIndx] = A[rightIndx];
			A[rightIndx] = temp;
		}
	}

	static void printArray(int[] ar, int low, int high) {
		for (int indx = low; indx <= high; indx++) {
			System.out.print(ar[indx] + " ");
		}
		System.out.println("");
	}

	
}