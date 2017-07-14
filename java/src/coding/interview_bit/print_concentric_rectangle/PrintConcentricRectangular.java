package coding.interview_bit.print_concentric_rectangle;

import java.util.ArrayList;

/**
 * Print concentric rectangular pattern in a 2d matrix. 
 * @author jay.prakash
 * 
	Input: A = 4.
	Output:
		  |
		  |
		  |	
	4 4 4 4 4 4 4 
	4 3 3 3 3 3 4 
	4 3 2 2 2 3 4 
	4 3 2 1 2 3 4 --------------Add lists till here
	4 3 2 2 2 3 4 
	4 3 3 3 3 3 4 
	4 4 4 4 4 4 4 
 *
 */

public class PrintConcentricRectangular {

	public static void main(String[] args) {
		//Scanner in = new Scanner(System.in);
		Integer maxDigit;
		//maxDigit = Integer.parseInt(in.nextLine());
		maxDigit = 5 ;
		prettyPrint(maxDigit);
	//	in.close();
	}

	
	/*
	 * This method will return 2D Array which will be concentric rectangular matrix.
	 */
	public static ArrayList<ArrayList<Integer>> prettyPrint(int n) {
		ArrayList<ArrayList<Integer>> horiRowList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> horiRow = new ArrayList<Integer>();
		ArrayList<Integer> prevRowList = null ;
		
		int midPos = n ; // same as incoming n
		int rowNum = 0 ;
		int midIndx = midPos - 1 ; 

		for (rowNum = 0; rowNum < midIndx + 1; rowNum++) {
			int j = 0;
			
			if (rowNum == 0) {
				while (j < midPos) { // while j < midd.. add in list
					if (rowNum == 0) {
						horiRow.add(n);
					}
					j++;
				}
//				horiRowList.add(mirrorCopy(horiRow, midPos));
//				prevRowList = horiRow;
//				continue; // continue is not needed anyway we are putting if else condition  
			}
			else {
				horiRow = new ArrayList<Integer>();
				while (j <= midIndx) {
					if (rowNum > j) {// copy from previous list
						horiRow.add(prevRowList.get(j));
					}
					if (rowNum <= j) {// New A[ij] = prev A[ij] -1 ;
						horiRow.add(prevRowList.get(j) - 1);
					}
					j++;
				}
//				prevRowList = mirrorCopy(horiRow, midPos);
//				horiRowList.add(prevRowList);
			}
			prevRowList = mirrorCopy(horiRow, midPos);
			horiRowList.add(prevRowList);

		}
		
		horiRowList = mirrorCopyAllLists(horiRowList, midPos) ;
		
		return horiRowList  ;
	}

	
	/*
	 * midPos is the position of the middle element, its not the mid index 
	 */
	private static ArrayList<ArrayList<Integer>> mirrorCopyAllLists(ArrayList<ArrayList<Integer>> horiRowList, int midPos) {
		int pos = midPos - 2; // index before middle point
		
		while (pos >= 0) {
			horiRowList.add(horiRowList.get(pos));
			pos--;
		}
		printAllLists(horiRowList);
		return horiRowList;
	}

	
	private static void printAllLists(ArrayList<ArrayList<Integer>> horiRowList) {
		int itrListIndx  = 0 ;
	    
		while(itrListIndx < horiRowList.size()){
			printList(horiRowList.get(itrListIndx));
			itrListIndx++ ;
		}
	}

	private static ArrayList<Integer> mirrorCopy(ArrayList<Integer> horiRow, int midPos) {
		int pos = midPos - 2; // index before middle point
		while (pos >= 0) {
			horiRow.add(horiRow.get(pos));
			pos--;
		}
//		printList(horiRow ) ;
		return horiRow;
	}

	private static void printList(ArrayList<Integer> horiRow) {
		
		for(int itr = 0 ; itr< horiRow.size() ; itr++){
			int i =  horiRow.get(itr) ;
			System.out.print(i+" " );
			if(itr==( horiRow.size() - 1) )
			   System.out.println();
		}
	}
}
