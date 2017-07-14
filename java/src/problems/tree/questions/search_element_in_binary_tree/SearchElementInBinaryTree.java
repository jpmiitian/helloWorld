package problems.tree.questions.search_element_in_binary_tree;

import problems.tree.BinaryTreeNode;

public class SearchElementInBinaryTree {

	/**
	 * given a binary tree and an element, we need to search this element in
	 * binary tree.(return true if element exists )
	 */
	public boolean searchUsingRecursion(BinaryTreeNode root, int data) {
		Boolean temp = false;
		if (root == null) {
			System.out.println("No Node in tree ");
			return true;
		}
		if(root.getData()==data){
			temp = true;
		}
		else{
			temp = searchUsingRecursion(root.getLeft(), data);
			if(temp!=true)
				return temp;
			else
				temp=searchUsingRecursion(root.getRight(), data);
		}
		return temp;
	}
}