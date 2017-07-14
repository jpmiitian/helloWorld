package problems.link_list.questions;

import problems.link_list.single_LL.node.ListNode;

public class NthNode {

	/**
	 *<br> find nth node from last in single link list Time : O(n),  Space: O(1) <br>
	 * 
	 * <br>Keep two pointers(references) <br>
	 * Start traversing from head <br>
	 * 1.Move iterator pointer untill it reaches nth node from begining <br>
	 * 2.After that move both pointers unless iterator is at last node <br>
	 * At this point the other pointer which we started moving later is at nth node from last<br>
	 */
	public ListNode findNthNodeFromLastInOneScan(ListNode liHeadNode, int n) {
		ListNode node1 = liHeadNode;
		if (liHeadNode == null) {
			System.out.println("Empty link list");
			return node1;
		} else {
			
			ListNode iteratorNode = liHeadNode;
			int count = 1;
			while (iteratorNode.getNextNode() != null) { 
				count++;
				if (count < n) {
					System.out.println("Not enough nodes in link list");
					break;

				} else {
					node1=node1.getNextNode();
					if(iteratorNode.getNextNode()==null){
						 return node1;
					}

				}
			}
			return node1;
		}
	}

}
