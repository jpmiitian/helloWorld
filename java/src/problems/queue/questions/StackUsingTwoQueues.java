package problems.queue.questions;

import problems.queue.DynQueueCircArr;

public class StackUsingTwoQueues {

	DynQueueCircArr queue1;
	DynQueueCircArr queue2;
	
	public StackUsingTwoQueues(){
		queue1 = new DynQueueCircArr();
		queue2 = new DynQueueCircArr();
	}
	
	public void push(int data){
		if(queue1.isEmpty()==true){
			queue2.enQueue(data);
		}
		else{
			queue1.enQueue(data);
		}
	}
	
	public int pop (){
		int i =0;
		int size;
		if(queue1.isEmpty()==true){
			size = queue1.getQsize();
			i=0;
			while(i<size-1){
				queue2.enQueue(queue1.deQueue());
				i++;
			}
			return queue1.deQueue();
			
			
		}
		else{
			size = queue2.getQsize();
			while(i<size-1){
				queue1.enQueue(queue2.deQueue());
				i++;
			}
			return queue2.deQueue();
		}
	}
}
