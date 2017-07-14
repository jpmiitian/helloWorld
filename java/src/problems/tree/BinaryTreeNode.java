package problems.tree;

/**
 * Defining a binary tree.
 * Each node has at max 2 child in a binary tree
 * @field  data : stores integer element 
 * @field  leftChild : points to left sub tree
 * @field  rightChild : points to right sub tree
 * @author jay.prakash
 */
public class BinaryTreeNode {//Node

public int data;				// data for node
public BinaryTreeNode left;//points to left sub tree
public BinaryTreeNode right;// points to right sub tree

public BinaryTreeNode() {
}

public BinaryTreeNode(int data) {
	this.data = data ;
}


public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
public BinaryTreeNode getLeft() {
	return left;
}
public void setLeft(BinaryTreeNode leftChild) {
	this.left = leftChild;
}
public BinaryTreeNode getRight() {
	return right;
}
public void setRight(BinaryTreeNode rightChild) {
	this.right = rightChild;
}

	
}
