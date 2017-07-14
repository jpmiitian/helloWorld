package    problems.link_list.questions.detect_cycle_in_link_list;

import java.util.Stack;

import problems.link_list.single_LL.node.ListNode;

public class DetectCycleInLinkList {


	public ListNode detectCycle(ListNode head) {
   
        if(head==null || head.next==null)
            return null;
            
        if(head==head.next || head==head.next.next)
            return head;
            
        ListNode headORG =head ;   
            
        ListNode slow = head ;
        ListNode fast = head.next ;
        
        if(fast==null)
            return null;
        /*
        * while both are not same  increse by two step
        * fast should not be null 
        */
        
        while(slow!=fast && fast.next!=null){
            fast =fast.next.next ;
            slow =slow.next ;
        
            if(fast==null || slow==null)
                return null ;//return null no cycle
        
            if(fast==slow){
                slow=headORG ;    // update slow to originial head
                fast = fast.next ;// update fast by ONE STEP ONLY
                break ;//from while loop
            }
        }
        
        if(fast==slow)  //to check if head is starting point in cyclic link list 
            return slow;//cycle begins
        /*
        * while both are not same  increse by one step
        * fast should not be null 
        */
        while(slow!=fast && fast!=null){
            fast =fast.next ;
            slow =slow.next ;
        }
        
        if(fast==slow)
            return slow;//cycle begins
        else
           return null; //default
    	
	    
	    
	    
	}

	
	
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
			DetectCycleInLinkList s =  new DetectCycleInLinkList() ;
//			ListNode revHead = s.reverseList(a) ;
		
		ListNode revHead = null ;//= s.reverseBetween(a,1,2) ;
		
			while(revHead !=null){
				System.out.print(revHead.getData() +" ");
				revHead = revHead.getNextNode() ;
			}
			
			
		}
	 
	

}
