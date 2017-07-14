package problems.tree.questions.convert_sorted_array_to_BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import problems.tree.BinaryTreeNode;
import utility_methods.UtilityMethods;

public class BalancedBSTFromSortedArray {


	public static BinaryTreeNode balanceBSTFromSortedArray(Integer[] arr , int l , int r) {
		
		BalancedBSTFromSortedArray bST = new BalancedBSTFromSortedArray() ;
		BinaryTreeNode root = bST. new BinaryTreeNode() ;
			
		if(r-l < 0 || r-l > arr.length )
				return null ;
		
		if(l==r ){
			root.setData(arr[l]) ;
			return root ;
		}
		
		if(l >= 0 &&  r < arr.length ){
			int midIndx = (r+l)/2 ;
			
			if(l <= midIndx) {
				root.setData(arr[midIndx]); 
			}
			
			
			
				root.setLeftChild(balanceBSTFromSortedArray(arr, l,midIndx - 1)); 
				root.setRightChild(balanceBSTFromSortedArray(arr, midIndx + 1 , r )); 
			
			
	
		}
		
		
		return root  ;
		
	}

	public static boolean isValidIndx(int[] arr , int indx) {
		if(indx >= 0 && indx <arr.length )
			return true ;
		
		return false ;
	}
	
/*	public static void main(String[] args){
		  //  	String[] unSortedStringArray =  ("46 8 16 80 55 32 8 38 40 65 18 15 45 50 38 54 52 23 74 81 42 28 16 66 35 91 36 44 9 85 58 59 49 75 20 87 60 17 11 39 62 20 17 46 26 81 92").split(" ") ; 
		
				String[] sortedStrArr =  ("1 2 3 4 5 6").split(" ") ; 
				int arr[]  = new int[sortedStrArr.length ];
		    	for(int i = 0 ; i< sortedStrArr.length ; i++ ){
		    		arr[i] = Integer.parseInt(sortedStrArr[i] )  ;
		    	}
		 BinaryTreeNode root =    	balanceBSTFromSortedArray(arr, 0 , sortedStrArr.length - 1 )  ;
	
		 preOrder(root) ;
		 
	}*/

	 public static void main(String[] args){
	
	Scanner in = new Scanner(System.in);
	Integer noOfTestCases;
	noOfTestCases = Integer.parseInt(in.nextLine());
	int sizeOfArray  ;
	
	List<Integer[]> listOfArrays = new ArrayList<Integer[]>(noOfTestCases ) ;
	
	Integer[] testCaseArr = null ; // new Integer [sizeOfArray]  ;
	
	for(int i = 0 ; i < noOfTestCases ; i ++ ){
		sizeOfArray = Integer.parseInt(in.nextLine());
		testCaseArr = new Integer [sizeOfArray]  ;
		
		String[]  strArr = 	in.nextLine().split(" ") ;	
		
		for(int j = 0 ; j < testCaseArr.length ; j++ ){
			testCaseArr[j ] =  Integer.parseInt(strArr[j]) ;
		}
		
		listOfArrays.add(testCaseArr) ;
	}
	
	
	
		for (int i = 0; i < noOfTestCases; i++) {
			Integer[] arr = listOfArrays.get(i);

			BinaryTreeNode root = balanceBSTFromSortedArray(arr, 0, arr.length - 1);
			
			preOrder(root);
			System.out.println(" ");
		}	
	
		
		
	in.close();
	}
	
  
	private static void preOrder(BinaryTreeNode root) {
		if (root == null)
			return;
		System.out.print(root.getData() + " ");
		preOrder(root.getLeftChild());
		preOrder(root.getRightChild());

	}
	
	public class BinaryTreeNode {//Node

		private int data;				// data for node
		private BinaryTreeNode leftChild;//points to left sub tree
		private BinaryTreeNode rightChild;// points to right sub tree

		public BinaryTreeNode() {
		}

		public BinaryTreeNode(int data) {
			this.data = data ;
		}


		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public BinaryTreeNode getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(BinaryTreeNode leftChild) {
			this.leftChild = leftChild;
		}
		public BinaryTreeNode getRightChild() {
			return rightChild;
		}
		public void setRightChild(BinaryTreeNode rightChild) {
			this.rightChild = rightChild;
		}

	 
	}
	



 
 
 
	
}
