package problems.link_list.circular_LL.cirLinkList_ops;

import problems.link_list.circular_LL.node.CLLNode;

public class CirLinkListOps {

	public int getCircularLinkListLength(CLLNode headNode) {

		int i = 0;
		CLLNode cNode = headNode.getNext();
		while (cNode != null) {
			i++;
			if (cNode == headNode) {
				break;
			}
		}
		return i;
	}

	public void printCircularLinkListData(CLLNode head) {
		CLLNode current = head;
		while (current != null) {
			System.out.println("data for node is " + current.getData());
			current = current.getNext();
			if (current == head) {
				break;
			}

		}
	}

	// Insert node at end of circular link list
	public CLLNode insertAtEndCllNode(CLLNode head, CLLNode insertThisNode) {
		if (head == null)
			return head = insertThisNode;
		else {
			CLLNode current = head;
			while (current != null) {
				if (current.getNext() == head) {// Time O(n) for scanning list
					insertThisNode.setNext(current.getNext());// Space : O(1)
					current.setNext(insertThisNode);
					break;
				}
				current = current.getNext();
			}
			return head;
		}
	}

	/**
	 * Insert at front of Circular link list
	 */
	public CLLNode inserAtFront(CLLNode head, CLLNode insertThisNode) {
		if (head == null) {
			insertThisNode.setNext(insertThisNode);
			return insertThisNode;
		} else {
			insertThisNode.setNext(head);
			return head = insertThisNode;

		}
	}

	/**
	 * delete last node from Circular link list
	 */
	public CLLNode deleteLastNode(CLLNode head) {
		if (head == null)
			return head;
		else {
			CLLNode previous;
			CLLNode next = head.getNext();
			while (next != null) {
				previous = next;
				next = next.getNext();
				if (next == head) {
					previous.setNext(head);
					next = null;
					break;
				}
			}
			return head;
		}
	}

	/**delete front node from Circular link list
	 */
	public CLLNode deleteFrontNodeCirculrLinkList(CLLNode head){
		if(head==null){
			System.out.println("Circular Link List is Empty");
			return head;
		}
		else{
			CLLNode current=head;
			while(current.getNext()!=head){
				current.setNext(current.getNext());
			}
			current.setNext(head.getNext());
			head=null;
			return current.getNext();
		}
	}


}