package problems.selection_algorithms.find_largest_element_in_arrary;

public class FindLargest {

	
/**
 * Note:Any deterministic algorithm that can find largest of n keys takes at least n-1 comparisons
 * 
 * Time :  O(n)
 * Space : O(1)
 */
	public int findLargestInArray(int[] arr){
		int largest = 0;
		for(int i=0; i<arr.length -1 ; i++ ){
			if(arr[i] > largest)
				largest = arr[i];
		}
		return largest;
	}
	
	public void findSmallestAndLargest(int[] arr) {
		/**The worst case comparison is 2(n-1) */
		int smallest = 0;
		int largest = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > largest)
				largest = arr[i];
			else if (arr[i] < smallest) {
				smallest = arr[i];
			}
		}
		System.out.println("smallest is "+smallest +" and largest is "+largest);
	}
	
	

}
