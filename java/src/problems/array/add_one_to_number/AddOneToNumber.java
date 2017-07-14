package    problems.array.add_one_to_number;

import java.util.ArrayList;
import java.util.Iterator;

import problems.link_list.single_LL.node.ListNode;

public class AddOneToNumber {

/*	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		ArrayList<Integer> rsltList = new ArrayList<Integer>() ;
		
		
		
		return rsltList ;
	}
*/	
    
	public ArrayList<Integer> plusOne(ArrayList<Integer> digits) {

		ArrayList<Integer> sumArr = new  ArrayList<Integer>();
		int carry = 1; // Add one to number

		for (int i = digits.size() - 1; i >= 0; i--) {
			  int sum = carry + digits.get(i);
			 sumArr.add(findOnesDigit(sum));
			   carry = findCarry(sum);
		}
		
		if(carry!=0 ){
			ArrayList<Integer> newSumArr = new ArrayList<Integer>() ; //[digits.length+1];
			newSumArr.add( carry );
			
			int indx = 1 ;
			
			for(int i :  reverseList(sumArr) ){
				newSumArr.add( i );//copy all digits
			}
			
			return newSumArr;
		}
		
		

		return removeZeroes(reverseList(sumArr));

	}
	
    
	private  ArrayList<Integer>  removeZeroes(ArrayList<Integer>  list ){
		
		Iterator<Integer> itr = list.iterator() ;
				
		while(itr.hasNext() ){
			if(itr.next()==0){
				 itr.remove() ;
			}
			else 
				break ;	
		}
			
		return list ;
		
	}
	
    
//	private  ArrayList<Integer>  reverseList (ArrayList<Integer>  list ){
//		ArrayList<Integer>  nlist  = new ArrayList<Integer>() ;
//		for(int i = list.size()-1 ; i>=0 ; i--) {
//			nlist.add(list.get(i)) ;
//		}
//		return nlist ;
//		
//	}

	private  ArrayList<Integer>  reverseList (ArrayList<Integer>  list ){

		for(int i = list.size()/2 ; i>=0 ; i--) {
			int temp = list.get(i) ;
			list.set(i, list.get(list.size()-1-i )) ;
			list.set(list.size()-1-i , temp ) ;
		}
		return list ;
		
	}
	
	
	
    
	public int[] plusOne(int[] digits) {

		int[] sumArr = new int[digits.length];
		int carry = 1; // Add one to number

		for (int i = digits.length - 1; i >= 0; i--) {
			  int sum = carry + digits[i];
			 sumArr[i] = findOnesDigit(sum);
			   carry = findCarry(sum);
		}
		
		if(carry!=0 ){
			int[] newSumArr = new int[digits.length+1];
			newSumArr[0] = carry ;
			
			int indx = 1 ;
			for(int i : sumArr ){
				newSumArr[indx] = i ;//copy all digits
			}
			return newSumArr ;
		}
		
		

		return sumArr;

	}
    
	/**
	 * Return least significant digit from a number.
	 * @param n
	 * 			input integer
	 * @return
	 * 			integer at one's place
	 */
    private int findOnesDigit(int n){
        return n > 9 ? n % 10 : n ;
    }
    
    
    private int findCarry(int n){
        if(n <= 9)
            return 0 ;
        if(n == 10)
            return 1 ;
        else {
            return n % 10 ;
        }    
    }
    

	

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

			String s = "0 0 4 4 6 0 9 6 5 1" ;
			String s1 = "9 9 9" ;

			callThis(  s ) ;
			System.out.println();
			callThis(  s1 ) ;			
			
			
			
			
		}
	 
		private  static void callThis(String s ){
			ArrayList<Integer > lst = new ArrayList<Integer>() ;
			for(String sk : s.split("\\ ")  ){
				lst.add(Integer.parseInt(sk)) ; 
			}
			
			AddOneToNumber c=  new AddOneToNumber() ;
			ArrayList<Integer > rslt = c.plusOne(lst) ;
//			ListNode revHead = s.reverseList(a) ;
		
		
			for(Integer i : rslt){
				System.out.print(i+" ");
			}

		}	

		
		
		
}