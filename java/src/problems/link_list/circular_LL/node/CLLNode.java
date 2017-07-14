package problems.link_list.circular_LL.node;

public class CLLNode {

	private int data;
	private CLLNode next;
	private CLLNode(int data){
		this.setData(data);
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public CLLNode getNext() {
		return next;
	}
	public void setNext(CLLNode next) {
		this.next = next;
	}
}
