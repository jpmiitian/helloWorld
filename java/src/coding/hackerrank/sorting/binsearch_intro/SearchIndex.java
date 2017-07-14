package coding.hackerrank.sorting.binsearch_intro;

import java.util.Scanner;

public class SearchIndex {

	public static int searchIndex(int[] a, int low, int high, int n) {
		int mid = (low + high) / 2; // 1 4 7 8 9 12,l= 0,h=5,mid=2
		
		if (a[mid] == n) {
			return mid;
		}
		else if (a[low] == n) {
			return low;
		}
		else if (a[high] == n) {
			return high;
		}
		else if (a[mid] < n) {
			return searchIndex(a, mid + 1, high, n);
		}
		else {//if (a[mid ] > n) {
			return searchIndex(a, low, mid - 1, n);
		}
		 
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;

		int srchIndexOf = Integer.parseInt(in.nextLine());
		int _a_size = Integer.parseInt(in.nextLine());

		int[] arr = new int[_a_size];
		int arr_item;
		String next = in.nextLine();
		String[] next_split = next.split("\\ ");

		for (int i = 0; i < _a_size; i++) {
			arr_item = Integer.parseInt(next_split[i]);
			arr[i] = arr_item;
		}

		res = searchIndex(arr, 0, (arr.length - 1), srchIndexOf);

		System.out.println(res);
		next = null;
		next_split = null;
		arr = null;
		in.close();

	}

}
