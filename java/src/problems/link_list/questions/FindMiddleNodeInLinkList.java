package problems.link_list.questions;

import problems.link_list.single_LL.node.ListNode;

public class FindMiddleNodeInLinkList {
/**
 * Time O(n)
 * Space O(1)
 * NOTE : for even no of nodes, middle node will be n/2 
 */
	public ListNode middleNode(ListNode head) {
		if (head == null) {
			System.out.println("Has No node");
			return head;
		} else if (head.getNextNode() == null) {
			System.out.println("Has Single Node");
			return head;
		} else {
			ListNode slow_1xPtr = head;
			ListNode fast_2xPtr = head;
			int flag = 0;
			while (fast_2xPtr.getNextNode() != null) {
				if (flag == 0) {
					fast_2xPtr = fast_2xPtr.getNextNode();
					flag = 1;
				} else if (flag == 1) {
					fast_2xPtr = fast_2xPtr.getNextNode();
					slow_1xPtr = slow_1xPtr.getNextNode();
					flag = 0;
				}
			}
			return slow_1xPtr;
		}

	}

}
