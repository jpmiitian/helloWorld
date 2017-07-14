package problems.array.find_missing_integer_in_array;

public class FindMissingIntUsingXOR {
	/*
	 * Given an unsorted integer array, find the first missing positive integer.
	 */
	public static void main(String[] args) {
		int arr[] = { 6, 1, 2, 3, 4 }; // given array of 5 integers
		int missingInteger = findMissingIntegerUsingXOR(arr);
		System.out.println(missingInteger);
	}

	private static int findMissingIntegerUsingXOR(int[] nums) {
		int numsXOR = 0 ; 
		int allNumsXOR = 0 ; 
		
		//calculate XOR till n
		int number =  1 ;
		while(number <= nums.length +1) {
			allNumsXOR^=number ;
			number++ ;
		}
		
		//calculate XOR of array numbers
		for(int num : nums) {
			numsXOR^=num ;
		}
		
		// return XOR of both calculations.
		return  allNumsXOR^numsXOR  ;

	}

}
