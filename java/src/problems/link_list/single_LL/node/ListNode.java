package problems.link_list.single_LL.node;

public class ListNode {

	private int data;
	public ListNode next;

	public ListNode(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNextNode() {
		return this.next;
	}
	public void setNextNode(ListNode nextNode) {
		this.next = nextNode;
	}
	
	//length of single link list
	public int lengthLinkList(ListNode listNode) {
		int l = 0;
		ListNode currentNode = listNode;
		while (currentNode != null) {
				currentNode =currentNode.getNextNode();
				l++;
			}
		return l;
	}

}
