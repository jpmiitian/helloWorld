package problems.tree.questions.tree_traversals;

import problems.queue.LLQueue;
import problems.tree.BinaryTreeNode;

/**
 * It has methods for level order traversals in Binary Tree.
 * 
 * @author jay.prakash
 */
public class LevelOrderTraversal {

	/**
	 * Time O(n) Space O(n),since in worst case all nodes are at last level
	 * 
	 * @param root
	 */
	public void levelOrderTraversal(BinaryTreeNode root) {
		LLQueue queue = new LLQueue();
		if (root == null)
			return;

		queue.enQueue(root);

		while (!queue.isEmpty()) {
			BinaryTreeNode temp = (BinaryTreeNode) queue.deQue();
			// process current node
			System.out.println("data is " + temp.getData());
			/* If leftChild exists, add left child to Queue */
			if (temp.getLeft() != null)
				queue.enQueue(temp.getLeft());

			/* If rightChild exists, add right child to Queue */
			if (temp.getRight() != null)
				queue.enQueue(temp.getRight());
		}
		queue.deleteQ();// deleting Q after traversal
	}

}
