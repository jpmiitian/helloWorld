package problems.tree.questions.find_distance_bw_two_nodes_in_binary_tree;


import problems.tree.BinaryTreeNode;

public class DistanceBwTwoNodes {

	/**
	 * Distance between two nodes in Binary Tree 
	 * 		= [ Distance of nodeOne from root +Distance of nodeTwo from root ] 
	 * 			-  (minus) [twice distance of LCA from root node]    
	 */					
	public static  int findDistanceBwTwoNodesInBT(BinaryTreeNode root, BinaryTreeNode nodeA,BinaryTreeNode nodeB  ) {
		
		BinaryTreeNode lcaNode = findLCAOfTwoNodes(root, nodeA, nodeB) ;
		
		int lcaDist = findDistanceFromRoot(root, lcaNode) ;
		int nodeADist = findDistanceFromRoot(root, nodeA) ;
		int nodeBDist = findDistanceFromRoot(root, nodeB) ;
		
		return  nodeADist+nodeBDist - 2*lcaDist ;
	}
	
	private static int findDistanceFromRoot(BinaryTreeNode root, BinaryTreeNode nodeToFind) {
		int pathInLST = -1;
		int pathInRST = -1;
		boolean pathExistsLST = false;
		boolean pathExistsRST = false;

		if (root == null || nodeToFind == null)
			return -1; // null nodes
		
		else if (root.getData() == nodeToFind.getData())
			return 0; // same as root node
		
		else {
			if (findDistanceFromRoot(root.getLeft(), nodeToFind) != -1) {
				pathInLST = 1 + findDistanceFromRoot(root.getLeft(), nodeToFind);
				pathExistsLST = true;
			}
			if (findDistanceFromRoot(root.getRight(), nodeToFind) != -1) {
				pathInRST = 1 + findDistanceFromRoot(root.getRight(), nodeToFind);
				pathExistsRST = true;
			}
			
			//path exists in both sub trees return shorter path
			if(pathExistsLST && pathExistsRST)
				return pathInLST < pathInRST ? pathInLST : pathInRST ;
			
			return pathExistsLST ? pathInLST : pathInRST;
		}
		
	}

	/*
	 * 
	 */
	public static BinaryTreeNode findLCAOfTwoNodes(BinaryTreeNode root, BinaryTreeNode nodeOne, BinaryTreeNode nodeTwo) {
		/*
		 * root is null, so returning root. 
		 */
		if(root == null)
			return root ;
		/*
		 * If root's data is same as one of the nodes.
		 */
		if (root.getData() == nodeOne.getData() || root.getData() == nodeTwo.getData()) {
			return root;
		}
		
		BinaryTreeNode leftLCA = findLCAOfTwoNodes(root.getLeft(), nodeOne, nodeTwo);
		BinaryTreeNode rightLCA = findLCAOfTwoNodes(root.getRight(), nodeOne, nodeTwo);
		
		/*
		 * LCA exists in both left & right sub trees.
		 * leftLCA and rightLCA are not common ancestor. 
		 * Therefore root is the least common ancestor.
		 */
		if(leftLCA!=null && rightLCA!=null)
			return root  ;
		
		if (leftLCA != null) {
			return leftLCA;
		} else {
			return rightLCA;
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
		
	 	 
		System.out.println("Distance between given nodes is : "+findDistanceBwTwoNodesInBT(root,node2,node4)) ;

		
	}


}
