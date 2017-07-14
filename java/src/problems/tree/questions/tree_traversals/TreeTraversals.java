package problems.tree.questions.tree_traversals;

import java.util.Stack;


import problems.tree.BinaryTreeNode;

/**
 * This class has Tree Traversals method implementations.
 */
public class TreeTraversals {

	/**
	 * PRE-ORDER Traversal of Tree 1.Visit root 2.Traverse left sub tree in
	 * PRE-ORDER 3.Traverse right sub tree in PRE-ORDER
	 * 
	 * Time : O(n) Space : O(n)
	 * 
	 */
	public void preOrderTraversal(BinaryTreeNode root) {
		if (root != null) {
			printElement(root.getData());
			preOrderTraversal(root.getLeft());
			preOrderTraversal(root.getRight());
		}
	}

	public void printElement(int data) {
		System.out.println("Element is " + data);
	}

	/**
	 * POST-ORDER Traversal 1.Traverse left subtree in POST-ORDER 2.TRAverse
	 * right subtree in POST-ORDER 3.print node data
	 */

	public void postOrderTraversal(BinaryTreeNode root) {
		if (root != null) {
			postOrderTraversal(root.getLeft());
			postOrderTraversal(root.getRight());
			printElement(root.getData());
		}
	}

	/**
	 * IN-ORDER Traversal 1.Traverse left subtree in IN-ORDER 2.Print node data
	 * 3.Traverse Right subtree in IN-ORDER
	 */
	public void inOrderTraversal(BinaryTreeNode root) {
		if (root != null) {
			inOrderTraversal(root.getLeft());
			printElement(root.getData());
			inOrderTraversal(root.getRight());
		}
	}

	public void preOrderNonRecursiveTraversal(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		//this stack stores node of binary tree
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while (true) {
			while (root != null) {
				printElement(root.getData());       //  Time  O(n)
				stack.push(root);					//	Space O(n)
				root = root.getLeft();
			}
			if (stack.isEmpty()) {
					break;
			}
			root=stack.pop();
			root =root.getRight(); 
		}
	}
	
	public void preOrdNonRecTraversal(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Stack<BinaryTreeNode> stack = new 	Stack<BinaryTreeNode>() ; 
		
		//this stack stores node of binary tree
	//	Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while (true) {
			while (root != null) {
				printElement(root.getData());       //  Time  O(n)
				stack.push(root);					//	Space O(n)
				root = root.getLeft();
			}
			if (stack.isEmpty()) {
					break;
			}
			root=stack.pop();
			root =root.getRight(); 
		}
	}

	
	
	public void  inOrderNonRecursiveTraversal(BinaryTreeNode root) { //	Time O(n), Space O(n)
		if(root==null)
			return;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(true){
			while(root!=null){					
				stack.push(root);				
				root = root.getLeft();
			}
			if(stack.isEmpty())
				break;
			root= stack.pop();
			printElement(root.getData());
			root=root.getRight();
		}
		return;
	} 
	
	public void postOrderRecursiveTraversal(BinaryTreeNode root){ // Time O(n), Space O(n)
		if(root==null)
			return;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(true){
			if(root!=null){
				stack.push(root);
				root= root.getLeft();
			}
			else{
				if(stack.isEmpty()){
					System.out.println("Empty Stack");
					return;
				}
				else{
					if(stack.peek().getRight()==null){
						root = stack.pop();
						printElement(root.getData());
						if(root==stack.peek().getRight()){
							printElement(stack.peek().getData());
							stack.pop();
						}
					}
				if(!stack.isEmpty())
					root = stack.peek().getRight();
				else
					root= null;
				}
			}
		}
	
	}
}
