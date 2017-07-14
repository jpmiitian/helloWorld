package coding.crack_coding_interview.linked_lists._2_1_remove_duplicates;

import java.util.Hashtable;

public class RemoveDuplicatesFromLinkList {

	private class LinkListNode {
		private int data;
		private LinkListNode nextNode;

		public LinkListNode() {

		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public LinkListNode getNextNode() {
			return nextNode;
		}

		public void setNextNode(LinkListNode nextNode) {
			this.nextNode = nextNode;
		}
	}
 
	public static void main(String[] args) {
		RemoveDuplicatesFromLinkList rdFLL = new RemoveDuplicatesFromLinkList();
		LinkListNode node = rdFLL.new LinkListNode();
		LinkListNode head = node;

		for (int i = 0; i < 5; i++) {
			node.setData(i % 2);
			node.setNextNode(rdFLL.new LinkListNode());
			node = node.getNextNode();
		}

		removeDuplicateItems(head);
	}
	
	/**
	 * Removes dups from link list USES EXTRA SPACE .
	 * @param head
	 */
	public static void removeDuplicateItems(LinkListNode head) {
		Hashtable<Integer, Boolean> hashtable = new Hashtable<>();
		LinkListNode previous  = null  ;
		
		while (head != null) {
			if(hashtable.containsKey(head.getData())){
				previous.nextNode = head.nextNode ;
			}
			else {
				hashtable.put(head.getData(),true) ;
				previous = head ;
			}
			head = head.nextNode ;
		}
	}

	/**
	 * Remove dups without using extra space .
	 * @param head
	 */
	public static void removeDupsWithoutUsingExtraSpace(LinkListNode head) {
		LinkListNode previous  = head  ;
		LinkListNode current  = previous.nextNode  ;
			
		while (current != null) {
			LinkListNode runner  = head  ;
			
			if(runner.data == current.data){
				LinkListNode temp = current.nextNode ;
				previous.nextNode = temp ;
				current = temp ;
				break ;
			}
			
			runner = runner.nextNode ;
			
			if(runner == current){
				previous = current ;
				current = current.nextNode ;
			}
			
		}
	}

	
}
