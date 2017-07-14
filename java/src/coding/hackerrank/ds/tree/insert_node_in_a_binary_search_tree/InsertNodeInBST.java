package coding.hackerrank.ds.tree.insert_node_in_a_binary_search_tree;

import problems.tree.BinaryTreeNode;

public class InsertNodeInBST {


	
	public static BinaryTreeNode insertInBST(BinaryTreeNode root, int valueToInsert) {

		BinaryTreeNode returnNode = null;
		
		/*
		 * Base case add new node with required data.
		 * It will added as leaf node in BST.
		 * 
		 * ALERT : It won't add the node to parent, It will just return a node with data.
		 * 		   But will have to add this once this is returned.	
		 */
		if (root == null) {
			root = new BinaryTreeNode(valueToInsert);
			returnNode = root;
		}

		if (root.getData() <= valueToInsert) {
			if (root.getRight() != null) {
				returnNode = insertInBST(root.getRight(), valueToInsert);
			} else {
				root.setRight(new BinaryTreeNode(valueToInsert)); //setting new node 
				returnNode = root;
			}
		} else { // root.getData() > valueToInsert // insert in left subtree

			if (root.getLeft() != null) {
				returnNode = insertInBST(root.getLeft(), valueToInsert);
			} else {
				root.setLeft(new BinaryTreeNode(valueToInsert));
				returnNode = root;
			}
		}

		return returnNode;

	}
	

	
	/**
	 * Insert value in Binary search tree.
	 * <br> Note : After making new node, we will have to set this at appropriate position.
	 * 
	 * @param root
	 * @param valueToInsert
	 * @return
	 */
	public static BinaryTreeNode insertValueInBST(BinaryTreeNode root, int valueToInsert) {
		/*
		 * Base case add new node with required data. It will return new node with data.
		 * BUT TO SET THIS AT APPROPRIATE POSITION...SETTER METHOD NEEDS TO BE USED.
		 */
		if (root == null) {
			return new BinaryTreeNode(valueToInsert);
		}

		BinaryTreeNode nodeToInsert = null ;
		if (root.getData() <= valueToInsert ) {
			nodeToInsert = insertValueInBST(root.getRight(), valueToInsert);
			root.setRight(nodeToInsert);
			
		} else {
			nodeToInsert = insertValueInBST(root.getLeft(), valueToInsert);
			root.setLeft(nodeToInsert);
		}
		return root;

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
		
		deleteNodeFromBST(root,8) ;
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
	
	/**
	 * FUNDA : Delete largest leaf node from leaf sub-tree or delete smallest node in right subtree of required node. 
	 * 		Copy data to required node first.
	 */
	public static BinaryTreeNode deleteNodeFromBST(BinaryTreeNode root, int valueToDelete){
		BinaryTreeNode leftChild = root.getLeft() ;
		BinaryTreeNode rightChild = root.getRight() ;
		
		BinaryTreeNode rsltNode = root;
		int rootData = root.getData() ;
		
		
		if (root.getData()== valueToDelete){
			if(leftChild!=null && rightChild==null){
				root = root.getLeft() ;
				return root ;
			}
			else if(leftChild==null && rightChild!=null){
				root = root.getRight() ;
				return root ;
			}
			
		}
		
		if (rootData == valueToDelete){
			 BinaryTreeNode maxValNodInLST = findMaxValInBST(root,root.getLeft(),valueToDelete) ;	
			 root.setData(maxValNodInLST.getData()); // copying data to root
			 return root ;
		}
		
		if(root.getData() > valueToDelete){
			rsltNode =  deleteNodeFromBST(root.getLeft(), valueToDelete ) ;
			root.setLeft(rsltNode);
		}
		else if(root.getData() < valueToDelete){
			rsltNode = deleteNodeFromBST(root.getRight(), valueToDelete ) ;
			root.setRight(rsltNode);
		}
		
		
	 		return root ;
	}
	
	
	
	//Return node with max value in given BST. 
	private static BinaryTreeNode findMaxValInBST(BinaryTreeNode parentNode,BinaryTreeNode incomingNode, int orgValToDelete) {
		BinaryTreeNode prevNode = parentNode ;
 		
		while(incomingNode.getRight().getRight()!=null){
			prevNode = incomingNode ;
			incomingNode = incomingNode.getRight() ;	
		
		}
		
		if(incomingNode.getLeft()!=null){
			prevNode.setRight(incomingNode.getLeft());
		}
 		
		return incomingNode ; 

	}

 
	
	
}
