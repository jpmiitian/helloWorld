package coding.interview_bit.find_kth_smallest_element_in_array;

public class KthHeap {
	
	public int[] arr ;
	public int maxCapacity ;
	public int countSize ;
	
	
	public int heapType ; // 0-> minHeap or 1-> maxHeap 
	public int left ;
	public int right ;
	public int parent ;
	
	public KthHeap(int[] arr, int maxCapacity) {
		super();
		this.arr = arr;
		this.maxCapacity = maxCapacity;
		
		int i  = (maxCapacity -1)/2 ;
		while (i >= 0){
			percolateDownForMinHeap(i);
			i-- ;
		}
	}
	
	public KthHeap(int[] arr, int maxCapacity , int countSize) {
		super();
		this.arr = arr;
		this.maxCapacity = maxCapacity;
		this.countSize = countSize ;
		int i  = (maxCapacity -1)/2 ;
		while (i >= 0){
			percolateDownForMinHeap(i);
			i-- ;
		}

	
	}
	
	public KthHeap( ) {
		super();
	}
		
	
	public int  left(int iTh) {
		if(isInvalidIndex(iTh))
			return -1 ;
		else
			return 2*iTh +1 ;
	}
	
	public int  right(int iTh) {
		if(isInvalidIndex(iTh))
			return -1 ;
		else
			return 2*iTh +2 ;
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
	 * for min Heap
	 */
	public void percolateDownForMinHeap(int i) {
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
			percolateDownForMinHeap(minIndx);
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
			percolateDownForMinHeap( 0 );
		}
	}
	
	//insert in heap
	public void insertInMaxHeap(int data) {
		if(this.countSize < this.maxCapacity) {
	//		this.arr[countSize] = data ; // Not needed, we are inserting after finding appropriate position 
			countSize++ ;				 // see while loop
	//		percolateDown(0); // 
			/*
			 * p = (i-1)/2
			 * 
			 */
   //percolateUp code block	
   //for max heap, moving the data up..percolating up to make parent greater than child in max heap 	 	
			int i = countSize - 1  ;
			while(i>=0 && data > this.arr[(i-1)/2]){
				this.arr[i] =   this.arr[(i-1)/2] ;
				i = (i-1)/2 ;
			}
			this.arr[i] = data ;
   // percolateUp code block ends here for max heap  			
		}
	}
	
	
	public void insertInMinHeap(int data){
		if(this.countSize <  this.maxCapacity ){
			int insPos = this.countSize -1 ;
		
			//while present node data is less than parent[data] 
			while(insPos>=0 && data < this.arr[(insPos-1) / 2 ] ){
				this.arr[insPos] = this.arr[(insPos-1) / 2 ] ; //copy from parent
				insPos = (insPos-1) / 2 ;	//update parent
			}
			this.arr[insPos] = data ;
		/* above line to copy data at parent location after finding appropriate position for input data 
		 */
		}
		
		
	}
	
	public int  checkMinimum() {
		if(this.countSize>0)
			return this.arr[0] ;
		
		return Integer.MIN_VALUE ;
	}
}
