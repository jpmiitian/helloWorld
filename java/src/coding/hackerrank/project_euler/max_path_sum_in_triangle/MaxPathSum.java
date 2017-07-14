package coding.hackerrank.project_euler.max_path_sum_in_triangle;

import java.util.Scanner;

public class MaxPathSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOFLines;
		noOFLines = Integer.parseInt(in.nextLine());
		String[] lines = new String[noOFLines];
		for (int i = 0; i < noOFLines; i++) {
			lines[i] = in.next();

		}

		int[][] arr = new int[noOFLines][];
		int arr_item;

		for (int i = 0; i < lines.length; i++) {
			String[] next_split = lines[i].split("\\ ");
			for (int j = 0; j < lines[i].length(); i++) {
				arr_item = Integer.parseInt(next_split[i]);
				arr[i][j] = arr_item;
			}
		}
		System.out.println(calMaxPath(arr));
		in.close();

	}

	static int calMaxPath(int arr[][]) {
		int pathSum = 0;
		int posPrevRow = 0;
		int posPrevCol = 0;
		
		
		
		return 0;
		

	
	
	}

}
