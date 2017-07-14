package problems.tree.questions.sum_root_to_leaf_numbers;

import problems.tree.BinaryTreeNode;

public class SumRootToLeaf {
	
	public static int calSumNumbers(BinaryTreeNode root ){
		int fSum = 0 ;
		
		return  fSum = recursiveCalSum(root, fSum , 0)  ;
	}
	
	
	private static int recursiveCalSum(BinaryTreeNode root, int fSum , int sum ){
		
		sum = 10*sum + root.data ;
		
		if(root.left != null ){
			fSum = 	recursiveCalSum(root.left,fSum ,sum );
		}
		if(root.right != null ){
			fSum = 	recursiveCalSum(root.left,fSum ,sum );
		}
		
		if(root.left==null && root.right==null ){
			fSum = sum ;
		}
		
		
		return  fSum ;
		
	}
	

	public static int sumNumbers(BinaryTreeNode root) {
				int 	sumL = 0 ;
				int 	sumR = 0 ;
				
	            if(root == null)
					return 0 ;
				
				int data = root.data ;

				if(root.left== null && root.right == null )
						return data ;
						
				if(root.left!= null ){ 
				    root.left.data = 10*data + root.left.data ;
				    root.data = 0 ; 
				    sumL = sumNumbers(root.left)  ;
				}
					
				if(root.right != null ){
					root.right.data = 10*data + root.right.data ;
				    root.data = 0 ; 
				    sumR =  sumNumbers(root.right)  ;
				}
						
					return sumL + sumR ;
	    }
	public static void main(String[] args){
		BinaryTreeNode root = new BinaryTreeNode();
		root.setData(0);
		BinaryTreeNode node1 = new BinaryTreeNode();
		node1.setData(1);
		BinaryTreeNode node3 = new BinaryTreeNode();
		node3.setData(3);
		BinaryTreeNode node4 = new BinaryTreeNode();
		node4.setData(4);

		BinaryTreeNode node5 = new BinaryTreeNode();
		node4.setData(5);
		root.setLeft(node1);
//		root.setRightChild(node3);
//		
//		node2.setLeftChild(node4);
//		node2.setRightChild(node5);
		
		int a = (int) Math.pow(10, 5) ;
		
	System.out.println("AYS OfTree : "+ sumNumbers(root )  +"\n");
 		
//		System.out.println("minDepthOfTree : "+String.valueOf(04) +"\n");

		Integer n = 100 ;
	  	System.out.println(String.valueOf(100) + " n : " +n.toString());
		
	  	String nu = "100" ;
	  	
	  	
	//  	System.out.println(reverse(-1234567891));
	  	
	  	System.out.println(Integer.MAX_VALUE);
		
//	  	if(-5827646411 < Integer.MIN_VALUE){
//	  		
//	  	}
	  	
	}

	
	
	/*
	 * Given a tree and an input sum,
	 * We need to find if a path exists in Binary Tree with input sum.
	 */
	
	public static boolean hasPathSum(BinaryTreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null)
			return root.data == sum ? true : false;
		
		boolean isLP = hasPathSum(root.left, sum - root.data);
		boolean isRP = hasPathSum(root.right, sum - root.data);
		
		return (isLP || isRP) ? true : false;
	}
	
	  
	  
}
