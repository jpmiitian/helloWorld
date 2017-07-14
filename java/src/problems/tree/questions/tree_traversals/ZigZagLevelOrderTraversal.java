package problems.tree.questions.tree_traversals;

import java.util.ArrayList;
import java.util.Stack;

import problems.tree.BinaryTreeNode;

/**
 * It has methods for ZIG ZAG level order traversals in Binary Tree.
 * 
 * @author jay.prakash
 */
public class ZigZagLevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> zigZagTraversalOfBinaryTreeUsingStacks(BinaryTreeNode root) {
			if (root == null)
				return null;
			ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
			Stack<BinaryTreeNode> pStack = new Stack<BinaryTreeNode>() ;
			Stack<BinaryTreeNode> nStack = new  Stack<BinaryTreeNode>() ; 
			
			pStack.push(root) ;
			
			while (!pStack.isEmpty()  || ! nStack.isEmpty()  ) {
				ArrayList<Integer> list = new ArrayList<>() ; 
				while( ! pStack.isEmpty() ){
					BinaryTreeNode node = pStack.pop() ;
					list.add(node.data) ;
					
					if(node.left != null) nStack.push(node.left) ; 				
					if(node.right != null) nStack.push(node.right) ;
				}
				if(! list.isEmpty() )   listOfLists.add( list ) ;
				list = null ;
				ArrayList<Integer>   listNext = new ArrayList<>() ;
				while( ! nStack.isEmpty()  ){
					BinaryTreeNode node = nStack.pop() ;
					listNext.add(node.data) ;
					
					if(node.right != null)  pStack.push(node.right) ;
					if(node.left != null)  pStack.push(node.left) ; 				
				}
				if(! listNext.isEmpty() )   listOfLists.add( listNext ) ;
			}
			return listOfLists;
		    
		}

 	
 
}
