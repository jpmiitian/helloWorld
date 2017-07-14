package problems.link_list.double_LL.node;

public class DLLNode {
	
	private int data;
	private DLLNode nextNode;
	private DLLNode previousNode;
	
	public  DLLNode(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DLLNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(DLLNode nextNode) {
		this.nextNode = nextNode;
	}
	public DLLNode getPreviousNode() {
		return previousNode;
	}
	public void setPreviousNode(DLLNode previousNode) {
		this.previousNode = previousNode;
	}
	
	

}
