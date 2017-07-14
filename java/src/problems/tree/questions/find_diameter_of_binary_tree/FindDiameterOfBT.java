package problems.tree.questions.find_diameter_of_binary_tree;

import problems.tree.BinaryTreeNode;
import problems.tree.questions.find_height_of_binary_tree.FindHeightOfBT;

public class FindDiameterOfBT {

	
	/**
	 * Diameter of BT is 
	 * 	<br>	max (diameter (leftSubtree),  diameter(leftSubtree),<br>  longest path b/w two nodes passing through root node).
	 *  <br>
	 *  	It's the longest path between two nodes in a Binary Tree.
	 * 
	 * 
	 * 
	 * @param root 
	 * 		    The root Node of Binary Tree.
	 * @return 
	 * 			Maximum length between two nodes in Binary Tree. 	
	 */
	
	public static int findDiameterOfBinaryTree(BinaryTreeNode root ) { 
		
		if(root==null)
			return 0;
		
		int diamRtSubTree = findDiameterOfBinaryTree(root.getRight()) ;
		int diamLtDubTree  = findDiameterOfBinaryTree(root.getLeft()) ;
		
		int maxPathViaRoot = 1 
							+ FindHeightOfBT.findHeightOfBinaryTree1(root.getLeft())
							+ FindHeightOfBT.findHeightOfBinaryTree1(root.getRight());		
		
		/*
		 * Return maximum (diamRtSubTree , diamLtDubTree ,  maxPathViaRoot )
		 */
		
		if(diamRtSubTree > diamLtDubTree ){
			return Math.max(diamRtSubTree, maxPathViaRoot) ;
		}
		else { // if(rightDiameter > leftDiameter ){
			return  Math.max(diamRtSubTree, maxPathViaRoot) ;
		}
		
		
//		return findDiameterOfBinryTree(root) ;
		
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
		
		root.setLeft(node2);
	//	node2.setLeftChild(node3);
	//	node3.setLeftChild(node4);
		node2.setRight(node4);
		
		int height = findDiameterOfBinaryTree( root ) ;
		
		System.out.println("\n Diameter of The B.T. is : "+ height );
	}
	
}
