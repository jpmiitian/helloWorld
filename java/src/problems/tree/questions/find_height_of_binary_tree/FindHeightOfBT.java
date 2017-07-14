package problems.tree.questions.find_height_of_binary_tree;

import problems.tree.BinaryTreeNode;

public class FindHeightOfBT {

	/**
	 * This method return the No. of Nodes in the longest path from root node to deepest leaf node in a Binary Tree.
	 * It can be modified to give the Number of edges in that path.
	 * @param rootNode
	 * @param level
	 * @return
	 */
	public static int findHeightOfBinaryTree(BinaryTreeNode rootNode, int level) { 
		int maxLevel = level ;
		if(rootNode==null)
			return maxLevel;
		else{
		//	++ level ;
			int leftMax = findHeightOfBinaryTree(rootNode.getLeft(),level) ;
			int rightMax = findHeightOfBinaryTree(rootNode.getRight(),level) ;
			maxLevel = Math.max(leftMax, rightMax) +1;
		}
		return maxLevel ;
	}
	
	
	
	public static int findHeightOfBinaryTree1(BinaryTreeNode root ) { 
		if(root==null)
			return 0;
			
		return Math.max(findHeightOfBinaryTree1(root.getLeft()), findHeightOfBinaryTree1(root.getRight())) + 1;
	}

	/**
	 * This method returns height of B.T. as no. of edges between root node and deepest leaf node.
	 * @param root
	 * @return
	 */
	public static int findHeightOfBinaryTreeConsiderNoOfEdges(BinaryTreeNode root ) { 
		if(root==null)
			return -1;
		
	/*	//this if block isn't needed
		if(root!= null && (root.getLeftChild()==null && root.getRightChild()==null )){
			return 0 ; // not needed already handling case with single node 
		}
		//above if block not needed 
	*/	
		
		/*
		 * Max (height of left subtree,height of right subtree ) + 1 
		 * 
		 */
		return Math.max(findHeightOfBinaryTreeConsiderNoOfEdges(root.getLeft()), findHeightOfBinaryTreeConsiderNoOfEdges(root.getRight()) ) + 1 ;
		
	}
 
	
	
	
	public static void main(String[] args){
		BinaryTreeNode root = new BinaryTreeNode();
		root.setData(1);
		BinaryTreeNode node2 = new BinaryTreeNode();
		node2.setData(2);
		BinaryTreeNode node3 = new BinaryTreeNode();
		node3.setData(3);
		BinaryTreeNode node4 = new BinaryTreeNode();
		node4.setData(4);

		BinaryTreeNode node5 = new BinaryTreeNode();
		node4.setData(5);
		root.setLeft(node2);
		root.setRight(node3);
		
		node2.setLeft(node4);
		node2.setRight(node5);
		
		int height = findHeightOfBinaryTree(root, 0) ;
		
//		System.out.println("Method 1 : "+height);
//		System.out.println("Method 2 : "+findHeightOfBinaryTree1(root));
//		System.out.println("findHeightOfBinaryTreeConsiderNoOfEdges method 3 : "+findHeightOfBinaryTreeConsiderNoOfEdges(root));
//		System.out.println("Method 4 : "+ maxDepthOfTree(root));
		
		System.out.println("minDepthOfTree : "+ minDepthOfTree(root) +"\n");

		
	}
	
	public static int maxDepthOfTree(BinaryTreeNode root ){
		if(root==null)
			return -1 ;
		
		return    1 + Math.max( maxDepthOfTree(root.getLeft()) , maxDepthOfTree(root.getRight())); 
	}
	
	public static int minDepthOfTree(BinaryTreeNode root ){
		
		if(root==null)
			return 0 ;

		/*root is leaf node 
		* return path distance till here 
		*
		*/
		if ( root.getLeft() == null && root.getRight() != null ) {
			return minDepthOfTree(root.getRight()) + 1 ; // NOTE : +1 for current node's height.  
		} 
		else if (root.getLeft() != null && root.getRight() == null ) {
			return minDepthOfTree(root.getLeft()) + 1 ; 
		}
		else {
			return Math.min(minDepthOfTree(root.getRight()), minDepthOfTree(root.getLeft())) + 1;
		}
	}
	
	
	
	
	
}
