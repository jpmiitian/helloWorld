package problems.array.next_greater;

import java.util.ArrayList;
import java.util.Collections;

public class NextGreater {
 

	public static void main(String[] args) {
		NextGreater d = new NextGreater();

		int arr[] = { 4, 3, 9, 1, 5, 3, 6 };
		
		 ArrayList<Integer> newList = new ArrayList<>() ;
		for(int i : arr)
			newList.add(i) ;

		System.out.println("nextGreater list :  ");
		for(Integer i :	d.nextGreater(newList )) 
			System.out.print(i+" "); 
		
	}
	
 
	
	public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
		ArrayList<Integer> rsltList = new ArrayList<Integer>() ;
		
		Collections.sort(a); 
		
		for(int i= 0 ; i< a.size()-1 ; i++){
			int nextIndx = i+1 ;
			while(nextIndx < a.size() &&  a.get(nextIndx) == a.size() ){
				nextIndx++ ;
			}
			
			if(nextIndx < a.size()) {
				rsltList.add(a.get(nextIndx)) ;
			}
			else 
				rsltList.add(-1) ;
		}
		
	    
	 return rsltList ;   
	}
	

}
