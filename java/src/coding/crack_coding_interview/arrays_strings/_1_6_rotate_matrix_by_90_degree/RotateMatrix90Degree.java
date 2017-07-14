package coding.crack_coding_interview.arrays_strings._1_6_rotate_matrix_by_90_degree;

import java.util.Scanner;

/**
 * Rotate NxN 2D Matrix by 90 degree right.
 * 
 * @author jay.prakash
 *
 */
public class RotateMatrix90Degree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noRows = 3;
		int noColumns = 3;
		int twoDArray[][] = new int[noRows][noColumns];
		for (int i = 0; i < twoDArray.length; i++) {
			for (int j = 0; j < twoDArray.length; j++) {
				twoDArray[i][j] = i + i * 3 + j;
			}
		}
		rotateMatrix(noRows, noColumns, twoDArray);
		in.close();
	}

	/**
	 * Rotate NxN Matrix by 90 degree right. noRows = noColumns
	 * 
	 * @param matrix
	 */
	public static void rotateMatrix(int noRows, int noColumns, int[][] matrix) {
 		for (int layer = 0; layer < noRows / 2; layer++) {
			int first = layer;
			int last = noRows - 1 - layer;

			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				 // left -> top
				 matrix[first][i] = matrix[last-offset][first];
				 // bottom -> left
				 matrix[last-offset][first] = matrix[last][last - offset];
				 // right -> bottom
				 matrix[last][last - offset] = matrix[i][last];
				 // top -> right
				 matrix[i][last] = top; // right <- saved top
			}
		}

		printArray(matrix);
	}

	private static void printArray(int[][] twoDArray) {
		for (int i = 0; i < twoDArray.length; i++) {
			for (int j = 0; j < twoDArray.length; j++) {
				System.out.print(" " + twoDArray[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
