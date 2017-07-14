package utility_methods;

import problems.tree.BinaryTreeNode;

public class UtilityMethods {

	/**
	 * Prints elements of integer array .  
	 * @param arr
	 */
	public static void printArrayElements(int[] arr) {
		for(int intgr : arr){
			System.out.print(intgr+" " );
		}
		System.out.print("\n" );
	}

	public static void printInOrder(BinaryTreeNode root ){
		if(root == null)
			return ;
		
		printInOrder(root.getLeft());
		System.out.print(root.getData()+" ");
		printInOrder(root.getRight());
		
	}
	
	
	
}
