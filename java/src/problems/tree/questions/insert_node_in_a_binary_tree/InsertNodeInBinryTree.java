package problems.tree.questions.insert_node_in_a_binary_tree;

import problems.queue.LLQueue;
import problems.tree.BinaryTreeNode;

public class InsertNodeInBinryTree {

	/**
	 * We can insert the data, wherever we find that left or right child is null
	 * Using level order traversal
	 * Time: O(n) Space: O(n) 
	 */
	public void insertNodeInBinaryTree(BinaryTreeNode root, int data) {
		LLQueue q = new LLQueue();
		BinaryTreeNode temp = new BinaryTreeNode();
		temp.setData(data);
		temp.setLeft(null);
		temp.setRight(null);
		if (root == null) {
			root = temp;
			return;
		}

		q.enQueue((BinaryTreeNode) root);

		while (!q.isEmpty()) {
			BinaryTreeNode deQElement = (BinaryTreeNode) q.deQue();
			if (deQElement.getLeft() != null) {
				q.enQueue((BinaryTreeNode) deQElement.getLeft());
			} 
			else {// No need for condition check
					// if(deQElement.getLeftChild()==null){
				deQElement.setLeft(temp);
				q.deleteQ();
				return;
			}

			if (deQElement.getRight() != null) {
				q.enQueue((BinaryTreeNode) deQElement.getRight());
			} 
			else { // here No need for condition check
			 	// if(deQElement.getRightChild() ==null){
				deQElement.setRight(temp);
				q.deleteQ();
				return;
			}
			q.deleteQ();
		}	
		
	}
	
}
