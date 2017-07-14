package problems.heap;

public class Heap {
	
	public int [] array;
	public int count;    // no. of elements in heap
	public int capacity; // capacity of heap
	public int heapType; // minHeap or MaxHeap
	public int parent;   // refer below
	public int leftChild;
	public int rightChild; // minHeap or MaxHeap
	
	public Heap(int capacity,int heapType){
		this.capacity=capacity;
		this.heapType=heapType;
	} 
	
	public int parent(int iThPosition) {
		if (iThPosition <= 0 || iThPosition >= this.count)
			return -1;

		return iThPosition - 1 / 2;
	}
	
	public int leftChild(int iThPosition) {
		int left= 2*iThPosition+1;
		if(left>=this.count)
			return -1;
		
		return left;
	}
	
	public int rightChild(int i) {
		int right = 2*i+2;
		if(right >=this.count)
			return -1;
		
		return right;
	}
	
	public int getMaximum(){ // get max from maxHeap
		if(this.count==0)
			return -1;
		else
			return array[0]; // return first element of array
	}
	
	/**
	 *  This method is for heapifying an element at location i
	 * @param i
	 */
	public void percolateDown(int i){
		int l,r,temp;
		int max=-1;
		l=leftChild(i);
		r=rightChild(i);
		if(l!=-1 && this.array[l] > this.array[i])
			max=l;
		if(r!=-1 && this.array[r] > this.array[max])
			max=r;
		if(max!=i){
			//swap array[i] and array[max]
			temp=this.array[i];
			this.array[i]=this.array[max];
			this.array[max]=temp;
		}
	} 
	/**
	 * Delete max element from Heap
	 * @return
	 */
	public int deleteMax(){
		if(this.count==0)
			return -1;
		int data = this.array[0];
		this.count--; //reducing heap size
		percolateDown(0);
		return data;
	}
	
	public int insertData(int data){
		//TODO insert in Heap
		return -1;
	}
	public void resizeHeap(){
		
	}
}
 