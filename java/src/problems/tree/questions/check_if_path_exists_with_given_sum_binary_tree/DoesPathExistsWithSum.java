package problems.tree.questions.check_if_path_exists_with_given_sum_binary_tree;

import problems.tree.BinaryTreeNode;

/**For a given sum, check if there exists a path in binary tree from root to any of nodes  */
public class DoesPathExistsWithSum {

	
	
	public boolean hasPathSum(BinaryTreeNode root, int sum) {
		if(root==null ){
			return (sum==0);
		}
		else{
			int subSum = sum-root.getData();
			return hasPathSum(root.getLeft(), subSum) || hasPathSum(root.getRight(), subSum);
		}
		
	}
	
}
