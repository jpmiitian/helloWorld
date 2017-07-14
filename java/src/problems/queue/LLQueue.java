package problems.queue;


public class LLQueue {

	private Object item;
	public LLQueue next;

	public LLQueue() {
		item = new Object();
	}
	
	public void enQueue( Object itemObject){
		//next = new LLQueue();
		next.setNext((LLQueue)itemObject);
	}
	
	public boolean isEmpty(){
		if(this.item==null && this.next==null)
			return  true;
		else 
			return false;
					
	}
	
	public Object deQue(){
		while(next!=null){
			next=next.getNext();
		}
		return next.getItem();
		
	}
	
	public void deleteQ(){//TODO check implementation
		while(next!=null){
			deleteQ();
		}
		next.item = null;
		next = null;
		
	}
	
	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public LLQueue getNext() {
		return next;
	}

	public void setNext(LLQueue next) {
		this.next = next;
	}


	
}
