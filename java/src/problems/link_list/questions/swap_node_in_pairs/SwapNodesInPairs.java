package    problems.link_list.questions.swap_node_in_pairs;

import problems.link_list.single_LL.node.ListNode;

public class SwapNodesInPairs {


    public ListNode swapPairs(ListNode head) { 

    	ListNode dummy = new ListNode(0) ;
    			 dummy.next = head ;	
    	
      ListNode dummyTwo = head ;
    			 
    		ListNode nxtNode = 	head.next ;
    		ListNode nxtOfNxt = 	nxtNode.next  ;
    		nxtNode.next = head ;
    		head.next = nxtOfNxt ;
    		
    	//	head = nxtNode ;	
    		
    		
    	
    	return dummy.next  ;
    }
	 
		public static void main (String[] args){
			
			ListNode a = new ListNode(1) ;
			ListNode b = new ListNode(9) ;
			ListNode ca = new ListNode(2) ;
			ListNode ca2 = new ListNode(3) ;
			ListNode ca3 = new ListNode(3) ;
			ListNode s3 = new ListNode(3) ;

			a.setNextNode(b);
//			b.setNextNode(n);		
//			ca.setNextNode(ca2);
//			ca2.setNextNode(ca3);	
//			ca3.setNextNode(s3);

			SwapNodesInPairs s =  new SwapNodesInPairs() ;
//			ListNode revHead = s.reverseList(a) ;
		
		ListNode revHead  = s.swapPairs(a) ;
		
			while(revHead !=null){
				System.out.print(revHead.getData() +" ");
				revHead = revHead.getNextNode() ;
			}
			
			
		}
	 
	

		
}