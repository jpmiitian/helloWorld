package coding.crack_coding_interview.arrays_strings._1_7_if_element_zero_in_m_x_n_matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire
 * row and column is set to 0.
 * 
 * @author jay.prakash
 */
public class MxN_Matrix_WithElementsZero {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int _M = 3;
		int _N = 3;
		int twoDArray[][] = new int[_M][_N];
		for (int i = 0; i < twoDArray.length; i++) {
			for (int j = 0; j < twoDArray.length; j++) {
				twoDArray[i][j] = i + i * 3 + j;
			}
		}
		modifyMatrix(_M, _N, twoDArray);
		in.close();
	}

	public static void modifyMatrix(int row, int colm, int[][] matrix) {
		List<Integer> rowIndicesList = new ArrayList<Integer>();
		List<Integer> colIndicesList = new ArrayList<Integer>();

		// print original matrix
		printArray(matrix);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colm; j++) {
				if (matrix[i][j] == 0) {
					rowIndicesList.add(i);
					colIndicesList.add(j);
				}
			}
		}

		for (int indPosInList = 0; indPosInList < rowIndicesList.size(); indPosInList++) {
			int rowInd = rowIndicesList.get(indPosInList);
			int colInd = colIndicesList.get(indPosInList);
			// make all row elements ZERO : '0'
			for (int col = 0; col < colm; col++) {
				matrix[rowInd][col] = 0;
			}
			// make all column elements ZERO : '0'
			for (int rowItr = 0; rowItr < row; rowItr++) {
				matrix[rowItr][colInd] = 0;
			}
		}
		// print modified matrix
		printArray(matrix);
	}

	private static void printArray(int[][] twoDArray) {
		for (int i = 0; i < twoDArray.length; i++) {
			for (int j = 0; j < twoDArray.length; j++) {
				System.out.print(" " + twoDArray[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
}
