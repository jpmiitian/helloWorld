package problems.tree.questions.search_element_without_recursion;

import problems.queue.LLQueue;
import problems.tree.BinaryTreeNode;

public class SearchWithOutRecursion {

	/** 
	 * Search In Binary Tree WithOut Recursion
	 *  */
	public boolean searchInBinaryTreeWithOutRecursion(BinaryTreeNode root, int element){
		LLQueue Q = new LLQueue();
		Q.enQueue(root);
		while(!Q.isEmpty()){
			BinaryTreeNode node = (BinaryTreeNode)Q.deQue();
			if(node.getData()==element){
				return true;
			}
			if(node.getLeft()!=null)
				Q.enQueue(node.getLeft());
			if(node.getRight()!=null)	
				Q.enQueue(node.getRight());
		}
		Q.deleteQ();
		return false;
	}
	
}
