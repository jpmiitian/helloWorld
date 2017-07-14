package coding.interview_bit.find_kth_smallest_element_in_array;

import java.util.ArrayList;
import java.util.List;

import problems.tree.BinaryTreeNode;

public class KthSmallest {

	public class KthHeap {
		public int[] arr ;
		public int maxCapacity ;
		public int countSize ;
		public int heapType ; // 0-> minHeap or 1-> maxHeap 
		public int left ;	// index of left child in array
		public int right ;	// index of right child in array
		public int parent ; // index of parent in array 
		
		public KthHeap(int[] arr, int maxCapacity) {
			super();
			this.arr = arr;
			this.maxCapacity = maxCapacity;
			int i  = (maxCapacity -1)/2 ;
			while (i >= 0){
				percolateDown(i);
				i-- ;
			}
		}
		
		public KthHeap(int[] arr, int maxCapacity , int countSize) {
			super();
			this.arr = arr;
			this.maxCapacity = maxCapacity;
			this.countSize = countSize ;
			//code block to make the array minheap
			int i  = (maxCapacity -1)/2 ;
			while (i >= 0){
				percolateDown(i);
				i-- ;
			}
			//code block to make the array minheap ends 
		
		}
		
		public KthHeap( ) {
			super();
		}
			
		
		public int  left(int iTh) {
			if(isInvalidIndex(iTh))
				return -1 ;
			else
				return 2*iTh +1 ;// left child of heap node 
		}
		
		public int  right(int iTh) {
			if(isInvalidIndex(iTh))
				return -1 ;
			else
				return 2*iTh +2 ;//right child of heap node
		}
		
		public int  parent(int iTh) {
			if(isInvalidIndex(iTh)) 
				return -1 ;
			else
				return 2*iTh +2 ;
		}
			
		public boolean isInvalidIndex(int iTh) {
			if(iTh >= 0 && iTh < this.countSize)
				return false ;
			else 
				return true ;
		}
		
		/*
		 * for minimum Heap
		 */
		public void percolateDown(int i) {
			int ithItem = this.arr[i];
			int minIndx = i;
			int l = left(i);
			int r = right(i);
			int leftItem;
			int rightItem;

			if (!isInvalidIndex(l)) { // && !isInvalidIndex(r)){
				leftItem = this.arr[l];
				if (leftItem < ithItem)
					minIndx = l;
			}

			if (!isInvalidIndex(r)) {
				rightItem = this.arr[r];
				if (rightItem < this.arr[minIndx])
					minIndx = r;
			}

			if (minIndx != i) {
				swap(i, minIndx);
				percolateDown(minIndx);
			}
		}		
		
		public  void swap(int i , int minIndx){
			int temp = this.arr[i] ;	
			this.arr[i] = this.arr[minIndx] ;
			this.arr[minIndx] = temp ;
			
		}
		
		//delete from heap 
		public void extractMinFromMinHeap(){
			if(this.countSize>0){
				this.arr[0] = this.arr[countSize-1] ;
				countSize -- ;
				percolateDown( 0 );//call percolate at (0)
			}
		}
		
		//insert in heap
		public void insertInHeap(int data) {
			if(this.countSize < this.maxCapacity) {
				this.arr[countSize] = data ;
				countSize++ ;
		//		percolateDown(0); // 
				/*
				 * p = (i-1)/2
				 * 
				 */
	   //percolateUp code block		 	
				int i = countSize - 1  ;
				while(i>=0 && data > this.arr[(i-1)/2]){
					this.arr[i] =   this.arr[(i-1)/2] ;
					i = (i-1)/2 ;
				}
				this.arr[i] = data ;
	   // percolate code block ends here 			
			}
		}
		
		// checks the minimum value in minHeap
		public int  checkMinimum() {
			if(this.countSize>0)
				return this.arr[0] ;
			
			return Integer.MIN_VALUE ;
		}
	}
	
	
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static int kthsmallest(final List<Integer> a, int k) {
	
		int [] arr = new int[a.size()] ;
		for(int i =0 ;i < a.size() ;i++){
			arr[i] = a.get(i) ;
		}
		KthSmallest kthSmallest =  new KthSmallest() ;
		KthHeap minHeap =  kthSmallest.new KthHeap(arr, a.size(), a.size()) ;
		
		for(int j = 0 ;j<k-1 ;j++){
			minHeap.extractMinFromMinHeap();
		}
		
	//	System.out.println(minHeap.checkMinimum() );
		return minHeap.checkMinimum() ;
	}
	
	public static void main(String[] args){
  //  	String[] unSortedStringArray =  ("46 8 16 80 55 32 8 38 40 65 18 15 45 50 38 54 52 23 74 81 42 28 16 66 35 91 36 44 9 85 58 59 49 75 20 87 60 17 11 39 62 20 17 46 26 81 92").split(" ") ; 
		
		String[] unSortedStringArray =  ("46 8 16 1").split(" ") ; 
		int kthPosn = 2 ; // find nth smallest element from this unsorted array 
    	
    	ArrayList<Integer> finalList = new ArrayList<>(); 
    	
    	for(String num : unSortedStringArray  ){
    		finalList.add(Integer.parseInt(num)) ;
    	}
		
    	kthsmallest(finalList, kthPosn)  ;
		
	}
	
	/**Find k-smallest element in an array using Partition method 
	 * Algorithm:
	 * 1.Choose a pivot from the array
	 * 2.Partition the array so that A[low..pivot-1] <= pivotPoint <= A[pivot+1...high]
	 * 3.if k < pivotItem then it must be on left of pivot, so do same method recursively on LEFT part.
	 * 4.if k = pivotItem then it must be the pivot, print all elements from low to pivot..
	 * 5.if k > pivotItem then it must be on the right of pivot,so do same method recursively on RIGHT part     
	 * 
	 */
	//TODO : k smallest using Quick Select method  
	public void selection(int low,int high,int k ){
		
	}
	
	   public int kthsmallest(BinaryTreeNode root, int k) {
	   
		   int l =   countInBST(root.getLeft() , k);   
		   if(l==k-1){
			   return root.getData()  ;
 		   }
		   
		   if(l < k-1 ){
			   kthsmallest(  root.getRight(),   k - 1-  l) ;
		   }
		   else 
			   kthsmallest(root.getLeft(), k) ;
		   
		   return root.getData() ;
	   }
	
	   private int countInBST(BinaryTreeNode root, int k ){
		   if(root == null)
			   return 0 ;
		   
		int l =   countInBST(root.getLeft() , k);
		int r =   countInBST(root.getRight() , k);
		 
		return l + r + 1 ;
		   
	   } 
	
	
}
