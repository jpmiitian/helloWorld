package problems.searching.two_elements_in_array_having_sum_k;

public class TwoElementsInArrayHavingSumK {

	/**lets assume sorted array,
	 * Now, we need to find elements having required sum
	 * 
	 * On sorted array maintain two indices loIndx & hiIndx.
	 * Compute sum = A[loIndx]+A[hiIndx]
	 * if sum==K, we are done 
	 * else if sum less than K, decrement hiIndex
	 * else if sum greater than K, decrement hiIndex 
	 *  
	 */
	public void searchTwoElementsInArrayWithSumK(int[] arr, int k){
		int i ,j ,temp; 
		for (i = 0, j =arr.length - 1; i < j ;) {
			temp=	arr[i] + arr[j];
			if (temp == k) {
				System.out.println("These are required Elements");
			} else if (temp < k) {
				i++;
			} else if (temp> k) {
				j--;
			}
		}
		
	}
	
	
}
