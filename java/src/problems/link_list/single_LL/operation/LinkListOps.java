package problems.link_list.single_LL.operation;
import problems.link_list.single_LL.node.ListNode;
 
public class LinkListOps {

	private ListNode listNode;

	public ListNode insertInLinkList(ListNode headNode, ListNode nodeToInsert, int position) {
		if (headNode == null) { // insert in beginning
			return nodeToInsert;
		}
		int size = listNode.lengthLinkList(headNode);
		if (position > size + 1 || position < 1) { // invalid size
			System.out.println("Invalid position for insertion");
			return headNode;
		}
		if(position==1){ // insert at position 1
			nodeToInsert.setNextNode(headNode);
			return nodeToInsert;
		}
		else {				// insert in middle or end
			ListNode previous = headNode;
			int count = 1;
			while (count < position - 1) {
				previous = previous.getNextNode();
				count++;
			}
			ListNode current = previous.getNextNode();
			nodeToInsert.setNextNode(current);
			previous.setNextNode(nodeToInsert);
		}
		return headNode;
	}

	public void deleteLinkList(ListNode head){ //delete link list 
	ListNode aux, iterator = head;	
		while(iterator != null){
			aux = iterator.getNextNode();
			iterator = null;//GARBAGE COLLECTION, NEED NOT do this as JAVA does this automatically 
			iterator = aux ;
		}
	}
	public ListNode deleteNodeFromLinkList(ListNode head,int pos) {// delete node from link list
		int size = listNode.lengthLinkList(head);
		if(size < 1 || pos > size){
			System.out.println("Invalid position for delete");
			return head;
		}
		if(pos==1){ // delete from first position
			ListNode current = head.getNextNode();
			head= null;
			return current;
		}
		else{		// delete from somewhere else 
			ListNode previous = head;
			int count = 1;
			while(count < pos){
				previous =previous.getNextNode();
				count++;
			}
			ListNode currentNode = previous.getNextNode();
			previous.setNextNode(currentNode);
			currentNode = null;
		}
		return head;
	}
}
  