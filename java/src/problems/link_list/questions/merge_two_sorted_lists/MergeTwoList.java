package    problems.link_list.questions.merge_two_sorted_lists;

import problems.link_list.single_LL.node.ListNode;

public class MergeTwoList {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0) ;
        ListNode itr = head ;
           
        ListNode oitr = itr ;        
           
         while(l1!=null || l2!=null){
             
             if(l1!=null && l2!=null) {
                 if(l1.getData() < l2.getData()){
                     itr.next = l1 ;
                     l1 = l1.next ;
                 }
                 else {
                     itr.next = l2 ;
                     l2 = l2.next ;
                 }
                itr =  itr.next  ; 
             }
             else if(l2==null) {
               itr.next = l1 ;
              break ;
             }
             else if(l1==null) {
               itr.next = l2 ;
               break ;
             }
             
             
         }
         
             
         return oitr.next ;
         
         
         
     }
	 
		public static void main (String[] args){
			
			ListNode a = new ListNode(1) ;
			ListNode b = new ListNode(9) ;
			ListNode ca = new ListNode(2) ;
			ListNode ca2 = new ListNode(3) ;
			ListNode ca3 = new ListNode(3) ;
			ListNode s3 = new ListNode(3) ;

			a.setNextNode(null);
//			b.setNextNode(ca);		
//			ca.setNextNode(ca2);
//			ca2.setNextNode(ca3);	
//			ca3.setNextNode(s3);

			MergeTwoList s =  new MergeTwoList() ;
//			ListNode revHead = s.reverseList(a) ;
		
		ListNode revHead  = s.mergeTwoLists(a,ca) ;
		
			while(revHead !=null){
				System.out.print(revHead.getData() +" ");
				revHead = revHead.getNextNode() ;
			}
			
			
		}
	 
	

		
}