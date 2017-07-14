package coding.interview_bit.check_if_identical_trees;

import problems.tree.BinaryTreeNode;

public class CheckIdenticalTrees {
	
	/**
	 * Checks if two trees are same, i.e. having same structure and data.
	 * @param a First Tree 
	 * @param b Second Tree
	 * @return True if both trees are same, i.e. having same structure and data.
	 */
	public static boolean isSameTree(BinaryTreeNode a, BinaryTreeNode b) {
		
		if(a== null && b==null) // both trees are empty
			return true ;
		
		// If one tree is empty return false.
		if((a!= null && b==null) ||  (a== null && b!=null)) // one is empty
			return false ;
		
		// If structure does not matches return false 
		if(a.getLeft()==null && b.getLeft()!=null || a.getRight()!=null && b.getRight()==null )
			return false ;
		
		/*
		 * If both LST and RST are identical, then check if root's data is same 
		 * If data same in both nodes, return true
		 */
		if (isSameTree(a.getLeft(), b.getLeft()) && isSameTree(a.getRight(), b.getRight())) {
			if (a.getData() == b.getData()) {
				return true;
			}
		}
		return false;

	}
	
	
	/**
	 * Checks if left and right subtrees are identical.	
	 * @param root
	 * 			 input tree.	
	 * @return
	 * 		 	0 if tree is not symmetric
	 */
	public static int  isSymmetric(BinaryTreeNode root) {
		
		if(root == null ) // both trees are empty
			return 0 ;
		
		if( isSymmetric(root.getLeft())==1
			&& isSymmetric(root.getRight())==1){
			return 1; 
		} 

		if(isMirrorTree(root.getLeft() , root.getRight() ))
			 return 1 ;
		
		return 0 ;

	}


	private static boolean isMirrorTree(BinaryTreeNode a, BinaryTreeNode b) {
		
		if(a== null && b==null) // both trees are empty
			return true ;
		
		if((a.getLeft()==null && b.getRight() !=null) 
				|| 
				   (a.getLeft()!=null && b.getRight() ==null ) )
			return false ;
		
		if(isMirrorTree(a.getLeft() , b.getRight())) {
			if(a.getData() == b.getData())
				return true ;
		}
		
		return false ;
	}

	
	public int isBalanced(BinaryTreeNode a) {
	
		if(a == null) //empty tree
			return 1 ;
		
		
		boolean isLSTBalanced = isBalanced(a.getLeft())==1 ;
		boolean isRSTBalanced = isBalanced(a.getRight())==1 ;
		
		if (isLSTBalanced  && isRSTBalanced ){
			int leftHeight = findHeight(a.getLeft()) ;
			int rightHeight = findHeight(a.getRight()) ;
			int diff = Math.abs(leftHeight - rightHeight) ;
			
			if(diff >= 0  && diff <=1 ){
				return 1 ;
			}
//			else {
//				return 0 ;
//			}
		}
//		else {
			return 0 ;
//		}
		
		
	}

	private int findHeight(BinaryTreeNode root){
		if(root==null)
			return-1 ;
		
		return Math.max(findHeight(root.getLeft()), findHeight(root.getRight()) ) + 1 ;
		
	}
	
	
	






}
