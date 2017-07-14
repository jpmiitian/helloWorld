package problems.link_list.questions.reverse_doubly_link_list;

import problems.link_list.double_LL.node.DLLNode;
import problems.link_list.questions.ReverseLinkList;
import problems.link_list.single_LL.node.ListNode;

public class ReverseDLL {

	public DLLNode Reverse(DLLNode head) { // Time O(n) Space: O(1) 
		if (head == null || head.getNextNode() == null)
			return head;
		else {
			DLLNode temp = null;
			DLLNode nextNode;// =head;
			while (head.getNextNode() != null) {// continue till head is the
												// last node
				nextNode = head.getNextNode(); // store next node
				head.setNextNode(temp); // reverse next pointer of head
				temp = head; // update temp as needed for next iteration
								// reversal
				head = nextNode;// update head to next node
			}
			return temp;

		}
	}

	
	
	public ListNode reverseList(ListNode head) {
	     if(head==null || head.getNextNode() ==null)
	        return head ;
	        
	     ListNode temp = null ;
	     
	     while(head!=null){
	        ListNode next = head.getNextNode() ; //next node
	        
	        head.setNextNode( temp );//updating to previous node
	        temp = head ; //temp with head
	        head = next ;
	     }
	  //      head.setNextNode(temp) ;
	    return temp ; //return head node 
	        
	    }
	
	   public ListNode reverseBetween(ListNode head, int m, int n) {
	        
	        if(head==null || head.next==null ||m==n)
	            return head ;
	            

	        int pos=1;
	        ListNode prevToStart = null ;
	        ListNode startPosNode = null ;
	        ListNode orginalHead =head ;
	        
	        while(pos < m ){
	            prevToStart = head ; //store previous node 
	            head = head.next ;//increase head
	            pos++ ; //increase positon of current node
	        }
	        
	        startPosNode = head ; //starting pos for node to reverse..
	    
	        ListNode temp = null ;    
	        
	        while(pos <= n ) { //pos pointer less than end position
	            ListNode nxtNode = head.next ;
	            head.next = temp ;
	            temp = head ;
	            head = nxtNode ;
	            pos++ ;// increase pos counter
	        }

	      

	        startPosNode.next = head ;
	        
	        if(m==1){
	         //   startPosNode.next = null ;  
	        //    startPosNode.next = head ; 
	            return temp ; //temp is starting 
	        }
	        else {
	            prevToStart.next = temp ;
	        //    startPosNode.next = head ; 
	            return orginalHead ;
	        }

	        
	        
	    }
	
	
	public static void main (String[] args){
		
		ListNode a = new ListNode(2) ;
		ListNode b = new ListNode(1) ;
		ListNode ca = new ListNode(5) ;
	
		a.setNextNode(b);
//		b.setNextNode(ca);		
		ReverseLinkList s =  new ReverseLinkList() ;
//		ListNode revHead = s.reverseList(a) ;
	
		ListNode revHead = s.reverseBetween(a,1,2) ;
	
		while(revHead !=null){
			System.out.print(revHead.getData() +" ");
			revHead = revHead.getNextNode() ;
		}
		
		
	}
	
	
}
