package problems.tree.questions.find_LCA_of_two_nodes_in_binary_tree;


import problems.tree.BinaryTreeNode;

public class LCAofTwoNodes {

	public static BinaryTreeNode findLCAofTwoNodesInBinaryTree(BinaryTreeNode root , BinaryTreeNode node1 , BinaryTreeNode node2) {
		
		BinaryTreeNode left , right ;
		
		if (root == null) {
			return root ;
		}
		if(root.getData()== node1.getData() || root.getData()== node2.getData() ){
			return root ;
		}
		left = findLCAofTwoNodesInBinaryTree( root.getLeft(), node1,node2) ;
		right = findLCAofTwoNodesInBinaryTree( root.getRight(), node1, node2) ;		
		
		if(left!=null && right!=null){
			return root ;
		} 
		else {
			return (left!=null ? left : right ) ;
		}
		
			
	}

	public static void main(String[] args){
		BinaryTreeNode root = new BinaryTreeNode();
		root.setData(1);
		BinaryTreeNode node2 = new BinaryTreeNode();
		node2.setData(2);
		BinaryTreeNode node3 = new BinaryTreeNode();
		node3.setData(3);
		BinaryTreeNode node4 = new BinaryTreeNode();
		node4.setData(4);
		
		root.setLeft(node2);
		root.setRight(node3);
		node3.setLeft(node4);
		
		BinaryTreeNode lstCommAncstNode = findLCAofTwoNodesInBinaryTree(root, node3,node4) ;
		
		System.out.println("Data of Least Common Ancestor is : "+lstCommAncstNode.getData());
		
		System.out.println("Data of LCA Node using Method  : "+ findLCA(root, node3,node4).getData());

		
	}

	public static BinaryTreeNode findLCA(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
		if (root == null)
			return null;

		// root data matches with input data
		if (root.getData() == a.getData() || root.getData() == b.getData())
			return  root; 

		/*
		 * find LCA of nodes in Left & Right Sub tree.
		 */
		BinaryTreeNode lcaInLeftSubTree = findLCA(root.getLeft(), a, b);
		BinaryTreeNode lcaInRightSubTree = findLCA(root.getRight(), a, b);

		if (lcaInLeftSubTree != null && lcaInRightSubTree != null) {
			return root;
		}

		return lcaInLeftSubTree != null ? lcaInLeftSubTree : lcaInRightSubTree;
		
	}

}
