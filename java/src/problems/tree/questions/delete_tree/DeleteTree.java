package problems.tree.questions.delete_tree;

import problems.tree.BinaryTreeNode;

public class DeleteTree {

/**To delete without using any extra space We will have to use POST-ORDER traversal,
 * as we can delete root node only after left & right subtrees are deleted.
 * Space : O(n)
 * Time  : O(n)
 * 
 * For other deleting using other traversal, we will require extra space for storing root node 
 *  */
	public void deleteBinaryTree(BinaryTreeNode root) {
		if (root == null)
			return;
		//delete both subtrees
		if (root.getLeft() != null)
			deleteBinaryTree(root.getLeft());
		
		if (root.getRight() != null)
			deleteBinaryTree(root.getRight());
		
		//after deleting both left& right subtrees, delete current node
		root=null;
	}

}
