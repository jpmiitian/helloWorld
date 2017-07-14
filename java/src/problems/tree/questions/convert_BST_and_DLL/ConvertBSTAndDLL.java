package problems.tree.questions.convert_BST_and_DLL;

import problems.tree.BinaryTreeNode;

public class ConvertBSTAndDLL {


	/**
	 * This method converts Binary Search Tree to sorted Doubly Linked List.
	 * @param root
	 * @return
	 */
	public static BinaryTreeNode convertBSTtoDLL(BinaryTreeNode root, boolean initialCall) {

		BinaryTreeNode headOfDLLNode = root;

		if (root == null) {
			return root;
		}

		if (initialCall) {
			headOfDLLNode = root;
			while (headOfDLLNode.getLeft() != null) {
				headOfDLLNode = headOfDLLNode.getLeft();
			}
		}

		convertBSTtoDLL(root.getLeft(), false);

		/*
		 * Process Root Node
		 */

		if (root.getLeft() == null && root.getRight() == null) {
			return root; // null node OR only leaf node
		}

		/*
		 * root has left child Set root.previous to rightMax of left sub tree.
		 */
		if (root.getLeft() != null) {
			BinaryTreeNode leftMax = root.getLeft();
			// while right child exists in left sub tree
			while (leftMax.getRight() != null) {
				leftMax = leftMax.getRight();
			}
			leftMax.setRight(root); // set root->prev = leftMax
			root.setLeft(leftMax); // set root->next = rootNode
		}

		/*
		 * root has right child Set root.next to leftMin of right sub tree
		 */
		if (root.getRight() != null) {
			BinaryTreeNode rightMin = root.getRight();

			while (rightMin.getLeft() != null) {
				rightMin = rightMin.getLeft();
			}

			rightMin.setLeft(root);
			root.setRight(rightMin);
		}

		/*
		 * Root Node Processing ends here
		 */
		convertBSTtoDLL(root.getRight(), false);

		return headOfDLLNode;

	}
	

	
	 
	
	
	public static void main(String[] args){
		BinaryTreeNode root = new BinaryTreeNode();
		root.setData(8);
		BinaryTreeNode node2 = new BinaryTreeNode();
		node2.setData(2);
		BinaryTreeNode node5 = new BinaryTreeNode();
		node5.setData(5);
		BinaryTreeNode node6 = new BinaryTreeNode();
		node6.setData(6);
		BinaryTreeNode node10 = new BinaryTreeNode();
		node10.setData(10);
		BinaryTreeNode node13 = new BinaryTreeNode();
		node13.setData(13);
	
		
		root.setLeft(node5);
		node5.setLeft(node2);
		node5.setRight(node6);
		
		root.setRight(node13);
		
		node13.setLeft(node10);
		
//		 root=  insertValueInBST(root, 12) ;
		
		convertBSTtoDLL(root,true) ;
		//System.out.println("Method 1 : "+height);
		
//		System.out.println("Method 2 : "+findHeightOfBinaryTree1(root));
	
		inoder(root);
		
		
	}




	private static void inoder(BinaryTreeNode root) {
		if(root!=null)
		{
			inoder(root.getLeft());
			System.out.print(root.getData()+ " " );
			inoder(root.getRight());
			
		}
			
	}
	
	public static BinaryTreeNode convertSortedDLLToBST(BinaryTreeNode headNode){
		
		BinaryTreeNode rootNode = null ;
		BinaryTreeNode rightChild = null ;
		
		rootNode = findMiddlePointOfDLL(headNode) ;
		rightChild = findMiddlePointOfDLL(rootNode) ;
		
		
		
		return rootNode ;
	}






	private static BinaryTreeNode findMiddlePointOfDLL(BinaryTreeNode headNode) {
		BinaryTreeNode slowPtr = headNode ;
		BinaryTreeNode fastPtr = headNode ;
		
		if(headNode.getRight()!=null){
			fastPtr = headNode.getRight() ;
		}
		
		while(fastPtr.getRight().getRight()!=null){
			slowPtr = slowPtr.getRight() ;
			fastPtr = fastPtr.getRight().getRight() ;; 
		}
		//fastPtr will be pointing to mid of DLL 
		return fastPtr;
	}
	
 
	
}
