package problems.tree.questions.print_left_view_of_a_binary_tree;

import problems.queue.LLQueue;
import problems.tree.BinaryTreeNode;

public class PrintLeftViewOfTree {

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
	
	
	public BinaryTreeNode getDummyBinaryTreeNode(){
		BinaryTreeNode rootNode = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node2 = new BinaryTreeNode() ;
		   			   node2.setData(2); 
		BinaryTreeNode node3 = new BinaryTreeNode() ;
					   node3.setData(1); 
		BinaryTreeNode node4 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node5 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node6 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node7 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node8 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node9 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node10 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node11 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node12 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node13 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node14 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node15 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		BinaryTreeNode node16 = new BinaryTreeNode() ;
		   			   rootNode.setData(1); 
		
		
		
		return rootNode ;
	}

}
