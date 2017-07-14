package    problems.link_list.questions.remove_dups_link_list;

import problems.link_list.single_LL.node.ListNode;

public class RemoveDups {


	  public ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null)
		  return head ;
		//  while next==current , delete next
		// update current .
		ListNode itr = head ;
		while(itr != null && itr.next != null ){
			if(itr.getData() == itr.next.getData() ){
				ListNode temp = itr.next.next ;
				itr.next = temp ;
			}
			else {
				itr = itr.next ;
			}
		}
	  return itr ;      
	  }
	  
	  public ListNode deleteDuplicatesII(ListNode head) {
		  
		  ListNode rsltList = new ListNode(0) ;
	
		  /*  Since we need to check for the first node if it has same value as next
		   *  Keeping head as next in new list */
		  rsltList.next = head ; // IMPORTANT 
		 
		  ListNode itr = rsltList ;
		  
		  /*
		   * While next && nextOfNext are not null..
		   */
		  while (itr.next!=null && itr.next.next != null) {
			  
			  /*
			   * if next & nextOfNext has same data.
			   * we need to update the next pointer of current itr 
			   * such that the new next pointer does not have same data as current node
			   */
			  if(itr.next.getData()== itr.next.next.getData() ){
				  int dupVal = itr.next.getData() ;
				  /*
				   * while loop to update next pointer until next node has same value as current node's value
				   */
				  while(itr.next !=null && itr.next.getData()==dupVal ){
					  	itr.next = itr.next.next ;//changing next of itr  
				  }
			  }
			  else {
				  itr = itr.next ; //update current iterator to next pointer
			  }
		  }
	
		  return rsltList.next ; // returning next as fistNode is dummy node which we inserted .
	  }
	  
	
	
	 
		public static void main (String[] args){
			
			ListNode a = new ListNode(1) ;
			ListNode b = new ListNode(1) ;
			ListNode ca = new ListNode(2) ;
			ListNode ca2 = new ListNode(3) ;
			ListNode ca3 = new ListNode(3) ;
			ListNode s3 = new ListNode(3) ;

			a.setNextNode(b);
			b.setNextNode(ca);		
			ca.setNextNode(ca2);
			ca2.setNextNode(ca3);	
			ca3.setNextNode(s3);

			RemoveDups s =  new RemoveDups() ;
//			ListNode revHead = s.reverseList(a) ;
		
		ListNode revHead  = s.deleteDuplicatesII(a) ;
		
			while(revHead !=null){
				System.out.print(revHead.getData() +" ");
				revHead = revHead.getNextNode() ;
			}
			
			
		}
	 
	

		
}