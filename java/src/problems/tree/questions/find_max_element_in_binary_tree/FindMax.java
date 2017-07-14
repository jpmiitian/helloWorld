package problems.tree.questions.find_max_element_in_binary_tree;

import problems.queue.LLQueue;
import problems.tree.BinaryTreeNode;

public class FindMax {

	public int findMaxInBianryTree(BinaryTreeNode root) {
		int root_val, left, right, max = Integer.MIN_VALUE;
		if (root != null) {
			root_val = root.getData();
			left = findMaxInBianryTree(root.getLeft());
			right = findMaxInBianryTree(root.getRight());
			if (left > right) {
				max = left;
			} else {
				max = right;
			}
			// compare max with root value
			if (root_val > max) {
				max = root_val;
			}
		}
		return max;
	}

	// Time O(n) Space O(n)
	public int findMaxUsingLevelOrderTraversal(BinaryTreeNode root) {
		BinaryTreeNode temp;
		int max = Integer.MIN_VALUE;
		LLQueue Q = new LLQueue();
		Q.enQueue(root);
		if(!Q.isEmpty()){
			temp = (BinaryTreeNode)Q.deQue();
			if(max < temp.getData()){
			max = temp.getData();
			} 
			if(temp.getLeft()!=null){
				Q.enQueue(temp.getLeft());	
			}
			if(temp.getRight()!=null){
				Q.enQueue(temp.getRight());	
			}
		}
		Q.deleteQ();
		return max;
	}

}
