package problems.tree.questions.size_of_binary_tree;

import problems.tree.BinaryTreeNode;

public class SizeBinaryTree {

	public int findSizeOfBinaryTree(BinaryTreeNode root) {
		int noOfNodes = 0;
		if(root==null){
			return noOfNodes;
		} 
		else{
			/**Return no of nodes in left subtree + 1(for root node) + right subtree */
			noOfNodes = findSizeOfBinaryTree(root.getLeft()) + 1 + findSizeOfBinaryTree(root.getRight());
			return  noOfNodes; 
		}
			
	}
	
}
