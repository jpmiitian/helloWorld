package    problems.link_list.questions.add_two_lists_numbers;

import problems.link_list.single_LL.node.ListNode;

public class AddTwoListNums {


	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode newHead = new ListNode(0) ;
	        
	        ListNode rslt = newHead;
	        ListNode fRslt = newHead;
	        ListNode pointToNewNode = null ;
		       
	        
	        int pCarry = 0;
	        while(l1!=null || l2 !=null){
	            int sum = pCarry  ; //sum initialized to carry
	            if(l1!=null)
	                sum = sum+l1.getData() ;
	            
	            if(l2!=null)
	                sum = sum+l2.getData() ;
	            
	            int nCarry = sum > 9 ? 1 : 0 ;
	            
	            pCarry = nCarry ; 
	            
	            int sumToAdd = sum >9 ? sum-10 : sum ;  
	            
	            
	            
	    
	            ListNode newNode = new ListNode(sumToAdd) ;
	            
	            newHead.next = newNode ;
	            newHead = newNode ;
	            pointToNewNode  = newNode;
	            
	      //      newHead = newNode ;
	            l1 = l1 ==null ?  l1 : l1.next ;
	            l2 = l2 ==null ?  l2 : l2.next ;
	            if(l1==null && l2==null && pCarry!=0 ){
	            	 ListNode newNodeEnd = new ListNode(pCarry) ;
	 	            
	 	            newHead.next = newNodeEnd ;
	            }
	 	       
	        }
	            
	    return fRslt.next ;    
	    }
	  
	 
		public static void main (String[] args){
			
			ListNode a = new ListNode(1) ;
			ListNode b = new ListNode(9) ;
			ListNode ca = new ListNode(2) ;
			ListNode ca2 = new ListNode(3) ;
			ListNode ca3 = new ListNode(3) ;
			ListNode s3 = new ListNode(3) ;

			a.setNextNode(b);
//			b.setNextNode(ca);		
//			ca.setNextNode(ca2);
//			ca2.setNextNode(ca3);	
//			ca3.setNextNode(s3);

			AddTwoListNums s =  new AddTwoListNums() ;
//			ListNode revHead = s.reverseList(a) ;
		
		ListNode revHead  = s.addTwoNumbers(a,a) ;
		
			while(revHead !=null){
				System.out.print(revHead.getData() +" ");
				revHead = revHead.getNextNode() ;
			}
			
			
		}
	 
	

		
}