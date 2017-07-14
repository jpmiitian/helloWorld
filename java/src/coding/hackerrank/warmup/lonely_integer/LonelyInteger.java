package coding.hackerrank.warmup.lonely_integer;
import java.util.HashMap;
import java.util.Scanner;


public class LonelyInteger {
/**
 * 
Problem Statement

There are N integers in an array A. All but one integer occur in pairs. Your task is to find the number that occurs only once.

Input Format

The first line of the input contains an integer N, indicating the number of integers. The next line contains N space-separated integers that form the array A.

Constraints

1≤N<100 
N % 2=1 (N is an odd number) 
0≤A[i]≤100,∀i∈[1,N]
Output Format

Output S, the number that occurs only once.
 */

	public static int lonelyinteger(int[] a) {
		int lonelyInt = -1 ;
		Integer ONE = 1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length ; i++) {
			Integer val = map.get(a[i]);
			if(val==null){
				map.put(a[i], 1);
			}
			else  {
				val++;
				map.put(a[i], val);
			}
		}
		for (Integer key : map.keySet()) {
			int value = map.get(key);
			if (value == ONE ){
				lonelyInt = key;
				break;
				}
		}
		return lonelyInt;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int _a_size = Integer.parseInt(in.nextLine());
		int[] arr = new int[_a_size];
		int arr_item;
		String next = in.nextLine();
		String[] next_split = next.split("\\ ");

		for (int i = 0; i < _a_size; i++) {
			arr_item = Integer.parseInt(next_split[i]);
			arr[i] = arr_item;
		}

		res = lonelyinteger(arr);
		System.out.println("lonelyinteger : "+ res+"\n");
		
		System.out.println("binarySearchLonelyInt : "+ searchLonelyIntInSortedArray(arr)+"\n");
		
		in.close();

	}
	
	public static int searchLonelyIntInSortedArray(int[] array) {
		int low = 0;
		int high = array.length - 1;
		return  findNonRepeatingIntegerInSortedArray(array, low, high) ; 
	}
	
	/**
	 * Time Complexity : O(log.n ) <br>
	 * This algorithm returns a lonely integer in a sorted array.
	 * <br> It assumes the integers in array are in sorted ascending order and all except one integer occur in pair in the array.
	 * 
	 * @param array
	 * @param low
	 * @param high
	 * @return lonelyIntegerInSortedArray
	 */
	private static int findNonRepeatingIntegerInSortedArray(int [] array, int low , int high){
		int lonelyInt = -1 ;
		
		/* Only single element */
		if(low==high){
			return array[high] ; 
		}
		
		/* mid index will be even pointing to  odd  position in array */
		int mid = (high-low) / 2 ;  
		
		/*
		 *  Example. 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5
		 *  
		 *  Lonely integer is at mid position
		 */
		if(array[mid]>array[mid-1] && array[mid]< array[mid + 1] ){
			lonelyInt = array[mid] ;
			return lonelyInt ;
		}
		
		/*
		 * array to check has length 3.
		 */
		if(high-low == 2){
			if(array[mid]!=array[mid-1] && array[mid]== array[mid + 1] ){
				return array[low] ;
			}
			else if(array[mid]==array[mid-1] && array[mid] !=  array[mid + 1] ){
				return array[high] ; //array[mid + 1]
			}
		}
		
		/*
		 * It means lonely integer is at right side of mid.
		 *
		 *  Example. 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5
		 *  
		 *  Example. 1, 1, 2, 2, 3, 3, 4
		 * 			 4  1  1  2  2  3  3 
		 * 					(mid)		 
		 */
		 if(array[mid]>array[mid-1] && array[mid]== array[mid + 1] ){ //lone in left 
			int newHigh = mid - 1 ;
	//		if(newHigh >  low ){
				lonelyInt = findNonRepeatingIntegerInSortedArray(array,low,newHigh) ;
	/*		}
			else if(newHigh == low ) { //already checked above , Recursive call will handle this 
				lonelyInt = array[newHigh] ; // array[high]
			}	
	*/	 }
		 /*
		  * lonely integer is in right subArray .
		  */
		else if (array[mid] == array[mid - 1] && array[mid] < array[mid + 1]) {
			int newLow = mid + 1;
	/*		if (high == newLow) {
				lonelyInt = array[newLow];
			} else if (newLow < high) {
*/				lonelyInt = findNonRepeatingIntegerInSortedArray(array, newLow, high);
//			}

		}
		
		
		return lonelyInt ; 
	}
	
}


