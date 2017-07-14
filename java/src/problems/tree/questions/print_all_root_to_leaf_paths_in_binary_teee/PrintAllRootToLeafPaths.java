package problems.tree.questions.print_all_root_to_leaf_paths_in_binary_teee;

import problems.tree.BinaryTreeNode;

public class PrintAllRootToLeafPaths {
/**
 * Given a binary tree, print all root to leaf paths 
 * TODO verify this 
 */
	public void printAllRootToLeafPaths(BinaryTreeNode root,int path[],int pathLength) {
		if(root==null){ 
			System.out.println("No Node in Binary Tree");
			return;
		}
		else{
			path[pathLength] = root.getData();
			pathLength++;
		}
		
		/**If leaf node then Print Path */	
		if(root.getLeft()==null && root.getRight()==null){
			printArray(path,pathLength);
		}
		else{/** try both subtrees*/
			printAllRootToLeafPaths(root.getLeft(), path, pathLength);
			printAllRootToLeafPaths(root.getRight(), path, pathLength);
		}
	}
	
	public void printAllRootToLeafPaths(){//TODO why this definition
		int[] path = new int[256];
		BinaryTreeNode root = null;
		printAllRootToLeafPaths(root ,path,0);
	} {
		
	}
	
	public void  printArray(int[] arr,int length) {
		for(int i=0;i<length-1;i++){
			System.out.println(arr[i] + " \n");
		}
	}
}
