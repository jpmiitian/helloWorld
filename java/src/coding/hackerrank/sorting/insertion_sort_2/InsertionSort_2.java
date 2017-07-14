package coding.hackerrank.sorting.insertion_sort_2;

import java.util.Scanner;

public class InsertionSort_2 {
	public static void insertionSort(int[] arr, int n) {
		int i, temp;
		for (i = 1; i <= n; i++) {
			temp = arr[i];
			int k = 0, pos = 0, posChanged = 0;
			for (k = i; k > 0; k--) {
				if (arr[k - 1] > temp) {
					arr[k] = arr[k - 1];
					posChanged = 1;
					pos = k - 1;
				}
			}
			if (posChanged == 1)
				arr[pos] = temp;
			printArray(arr);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _a_size = Integer.parseInt(in.nextLine());

		int[] arr = new int[_a_size];
		int arr_item;
		String next = in.nextLine();
		String[] next_split = next.split("\\ ");

		for (int i = 0; i < _a_size; i++) {
			arr_item = Integer.parseInt(next_split[i]);
			arr[i] = arr_item;
		}

		insertionSort(arr, arr.length - 1);
		next = null;
		next_split = null;
		arr = null;
		in.close();

	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}