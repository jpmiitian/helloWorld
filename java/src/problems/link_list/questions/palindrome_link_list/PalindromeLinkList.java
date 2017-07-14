package problems.link_list.questions.palindrome_link_list;

import problems.link_list.single_LL.node.ListNode;

public class PalindromeLinkList {


    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next == null)
            return true ;
       
        
        ListNode mid = findMidNode(head) ;
        ListNode itr = mid.next;
        ListNode midORG = mid;
        
        
        ListNode temp = null ;
        while(itr !=null ){
            ListNode nxt = itr.next ;
            itr.next = temp;
            temp = itr; 
            itr = nxt ;
        }
        
        
        //to point mid to reversed list's END
        if(itr==null && midORG.next!=null){
            midORG.next=temp;//link mid to reverse list..                
        }
        
        ListNode parII = midORG.next ;
        
        boolean isPal = false ;
       
        while(parII!=null){
            if(parII.getData()!=head.getData())
                return false;
            else{
                isPal = true ;
                parII = parII.next ;
                head = head.next ;
             //   return false ;
            }    
        }
        
         return isPal ;
    }
    
    //Assume proper list
    public ListNode findMidNode(ListNode head) {
        if(head==null || head.next == null)
            return head ;
        //1 2 3  
        ListNode slow = head ;
        ListNode fast = head.next ;
        
        //1 2 3 4
        // s=2,f=4
        //1 2 3 4 5
        // s=3, f=null
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next; //
        }
        return slow;//midposn
    }
    
    
	
	public static void main (String[] args){
		
		ListNode a = new ListNode(2) ;
		ListNode b = new ListNode(1) ;
		ListNode ca = new ListNode(5) ;
	
		a.setNextNode(b);
//		b.setNextNode(ca);		
		PalindromeLinkList s =  new PalindromeLinkList() ;
//		ListNode revHead = s.reverseList(a) ;
	
		boolean  revHead = s.isPalindrome(a) ;
	
//		while(revHead !=null){
//			System.out.print(revHead.getData() +" ");
//			revHead = revHead.getNextNode() ;
//		}
		
		
	}
	
	
}
