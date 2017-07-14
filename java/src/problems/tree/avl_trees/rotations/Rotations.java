package problems.tree.avl_trees.rotations;

import problems.tree.avl_trees.AVLTreeNode;

public class Rotations {
	
	/**CASE : 1, LL Rotation
	 * If we insert an element in left subtree of left child of X */
	public AVLTreeNode singleLeftRotate(AVLTreeNode x){
		AVLTreeNode w = x.getLeft();
		x.setLeft(w.getRight());
		w.setRight(x);
		x.setHeight(Math.max(x.getLeft().getHeight(), x.getRight().getHeight()) + 1);
		w.setHeight(Math.max(w.getLeft().getHeight(), w.getRight().getHeight()) + 1);
		return w;
	}
	
	/**CASE : 4, RR rotation
	 * If node is inserted in right subtree of right child of Node not satisfying AVL property */
	public AVLTreeNode singleRightRotate(AVLTreeNode w) {
		AVLTreeNode x = w.getRight();
		w.setRight(x.getLeft());
		x.setLeft(w);
		w.setHeight(Math.max(w.getLeft().getHeight(), w.getRight().getHeight()) + 1);
		x.setHeight(Math.max(x.getLeft().getHeight(), x.getRight().getHeight()) + 1);
		return x;
	}
	
	/**CASE : 2, LR Rotation
	 * If we insert into right subtree of right child of node not satisfying AVL property */
	// node inserted at right subtree of left child of z 
	public AVLTreeNode doubleRotateWithLeft(AVLTreeNode z){
	/*	1.single right rotation at right child of left child of first node not satisfying AVL property */
		AVLTreeNode newLeftChildOf_Z = singleRightRotate(z.getLeft());
		z.setLeft(newLeftChildOf_Z);
	/*  Its case 4 now
	2.single left rotation at new left child of z ( first node not satisfying AVL property ) */
		return singleLeftRotate(z);
	}
	
	/**case : 3. RL rotation  
	 * Insertion into left subtree of right child of x*/
	public AVLTreeNode doubleRotateWithRight(AVLTreeNode x) {
		x.setRight(singleLeftRotate(x.getRight()));
		return singleRightRotate(x);
		
	}
	
}
 