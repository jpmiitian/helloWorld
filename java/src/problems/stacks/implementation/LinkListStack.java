package problems.stacks.implementation;

import problems.link_list.single_LL.node.ListNode;

public class LinkListStack {

	private ListNode headNode;

	public LinkListStack() {
		this.headNode = new ListNode((Integer) null);
	}

	public boolean isEmptyStack() {
		if (headNode == null)
			return true;
		else
			return false;
	}

	public void push(int nodeData) {
		if (headNode == null) {// if no node
			headNode = new ListNode(nodeData);
		} else if (headNode.getData() == (Integer) null) {// if node with null
															// data
			headNode.setData(nodeData);
		} else {// add new node if some node with data already exists
			ListNode newNode = new ListNode(nodeData);
			newNode.setNextNode(headNode);
			headNode = newNode;
		}
	}

	public int pop() {
		int data = (Integer) null;
		if (headNode != null) {
			while (headNode.getNextNode() != null) {
				headNode = headNode.getNextNode();

			}
			data = headNode.getData();
		} else {
			System.out.println("Empty Link List Stack");
		}
		return data;
	}
	
	public int top (){
		int data = (Integer) null;
		if(headNode!=null){
			while(headNode.getNextNode()!=null){
				headNode = headNode.getNextNode();
			}
			data = headNode.getData();
		}
		return data; 
	}

}
