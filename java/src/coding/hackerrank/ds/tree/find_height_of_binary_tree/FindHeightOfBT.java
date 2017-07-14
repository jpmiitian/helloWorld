package coding.hackerrank.ds.tree.find_height_of_binary_tree;

public class FindHeightOfBT {

	/*
	 * Node : Inner Class 
	 */
	public  class Node {
		int data;
		Node left;
		Node right;
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		
	}

	/**
	 * This method returns height of B.T. as no. of edges between root node and
	 * deepest leaf node. <br>
	 * In this case the depths of the root node is 0 (ZERO) .
	 * 
	 * @param root
	 * @return intHeightOfBinaryTree
	 */
	public static int height(Node root) {
		if(root==null)
			return -1;
	
		/*
		 * Max of height of left subtree, right subtree 
		 */
		return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
		
	}
	
	
	/*
	 * To create object of inner class we need object of outer class.
	 * Then only we can , create instance of inner class.
	 * 
	 */
	public static void main(String[] args){
		 
		FindHeightOfBT outr = new FindHeightOfBT() ;
		FindHeightOfBT.Node root = outr. new Node();
		
		FindHeightOfBT.Node node2 = outr. new Node();
		FindHeightOfBT.Node node3 = outr. new Node();
		FindHeightOfBT.Node node4 = outr. new Node();
		
		//Node root = rootOtr.
		root.setData(1);
		node2.setData(2); 
		node3.setData(3);
		node4.setData(4);
		
		root.setLeft(node2);
		node2.setLeft(node3);
		node3.setLeft(node4);
		
	//	int height = height(root, 0) ;
		
	//	System.out.println("Method 1 : "+height);
		
		System.out.println("Method 2 : "+height(root));
		System.out.println("findHeightOfBinaryTreeConsiderNoOfEdges method 3 : "+ height(root));
		
		
	}
	

}
