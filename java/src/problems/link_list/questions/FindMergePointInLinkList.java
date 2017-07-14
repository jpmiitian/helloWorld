package    problems.link_list.questions;

import java.util.Stack;

import problems.link_list.single_LL.node.ListNode;

public class FindMergePointInLinkList {
 /**
  * efficient solution Time O(n),Space O(1) 
  */
	public ListNode findMergePointIn_Time_Order_N_(ListNode list1,ListNode list2 ){
		
		if(list1==null || list2==null)
			return null;
//		else if((list1!=null && list1.next==null) && (list2!=null && list2.next==null) && (list1.val==list2.val) )) {
//		    return list1;
//		}	
//	
		else{
			int length1=0,length2=0,diff = 0;
			ListNode head1 =list1;
			ListNode head2 = list2;
			while(head1!=null){
				length1++;
				head1=head1.getNextNode();
			}
			while(head2!=null){
				length1++;
				head2=head2.getNextNode();
			}
			if(length1<length2){
				head1=list2;//bigger list in h1
				head2=list1;//smaller in h2
				diff= length2-length1;
			}
			else{
				head1=list1;//bigger list in h1
				head2=list2;//smaller list in h2
				diff= length2-length1;
			}
			int pos =0;
			while(pos<diff){ //till we are at (diff+1) position in larger list 
				head1=head1.getNextNode();
				pos++;
			}
			while(head1!=null && head2!=null){//increase till end of link list 
				if(head1==head2){
					return head1;
				}
				head1=head1.getNextNode();
				head2=head2.getNextNode();
			}
			return head1.getNextNode();
		}
	}
	
	/**
	 * Solution using Stack...
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		Stack<ListNode> stackA = new Stack<ListNode>();
		Stack<ListNode> stackB = new Stack<ListNode>();
		while (headA != null) {
			stackA.push(headA);
			headA = headA.next;
		}
		while (headB != null) {
			stackB.push(headB);
			headB = headB.next;
		}

		ListNode sANode = null;
		ListNode sBNode = null;
		ListNode lastCommonNode = null;

		while (sANode == sBNode && ( !stackA.isEmpty() && !stackA.isEmpty()) ) {
			sANode = stackA.pop();
			sBNode = stackB.pop();

			if (sANode == sBNode)
				lastCommonNode = sANode;
		}

		return lastCommonNode;
	}
	
		public static void main (String[] args){
			
			ListNode a = new ListNode(2) ;
			ListNode b = new ListNode(1) ;
			ListNode ca = new ListNode(5) ;
		
			a.setNextNode(b);
//			b.setNextNode(ca);		
			ReverseLinkList s =  new ReverseLinkList() ;
//			ListNode revHead = s.reverseList(a) ;
		
			ListNode revHead = s.reverseBetween(a,1,2) ;
		
			while(revHead !=null){
				System.out.print(revHead.getData() +" ");
				revHead = revHead.getNextNode() ;
			}
			
			
		}
	 
	

}
