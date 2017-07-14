package    problems.link_list.questions.rotate_list_by_k_position;

import problems.link_list.single_LL.node.ListNode;

public class RotateListByK {


    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0 || (head!=null && head.next==null && k==1)) //if k is 0 return original head
            return head ;
      
        int length = findLength(head) ;
        int rotByPos  = k % length    ; 
        
        if(rotByPos==0)
            return head ;
            
                k = rotByPos ;
            
        ListNode slow = head ;
        ListNode fast = head ;
        
        int count= 0;
        while(count < k ){ //while count less than k
            fast = fast.next ;//move fast 
            count ++; // increase counter    
        }
        
        while(fast!=null && fast.next!=null){
            slow = slow.next ;
            fast = fast.next ;//move fast 
        }
        
        ListNode nxtOfSlow = slow.next ;
       
        slow.next = null ;
        fast.next = head ;
        
    return nxtOfSlow ;    
        
    }
    
    private int findLength(ListNode head){
        if(head==null)
            return 0 ;
            
        int l=0 ;
        while(head!=null){
            head= head.next ;
            l++ ;
        }
        
        return l ;
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

			RotateListByK s =  new RotateListByK() ;
//			ListNode revHead = s.reverseList(a) ;
		
		ListNode revHead  = s.rotateRight(a,0) ;
		
			while(revHead !=null){
				System.out.print(revHead.getData() +" ");
				revHead = revHead.getNextNode() ;
			}
			
			
		}
	 
	

		
}