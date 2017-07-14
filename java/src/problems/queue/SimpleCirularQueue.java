package problems.queue;

public class SimpleCirularQueue {

	private int front;
	private int rear;
	private int capacity;
	private int[] qArr;

	private SimpleCirularQueue(int qSize) {

		front = -1;
		rear = -1;
		capacity = qSize;
		qArr = new int[capacity];

	}

	private static SimpleCirularQueue createCircularQ(int size) {
		return new SimpleCirularQueue(size);
	}

	private boolean isQEmpty() {
		return (front == -1);// no need for && qCirularQueue.rear== -1
	}

	private boolean isQFull() {
		return ((rear + 1) % capacity == front);
	}

	private int getQSize() {
		return ((capacity - front + rear + 1) % capacity);
	}

	private void enQueue(int data) {
		if (isQFull() == true) {
			System.out.println("Q is Full");
		} else {
			// same as below,rear =rear+1;
			// qArr[rear%capacity] =data;
			qArr[++rear % capacity] = data;
			if(front == -1)
				front =rear;
		}
	}
	
	private int dQueue() {
		int data =(Integer)null;
		if(isQEmpty()==true){
			System.out.println("q is empty");
		}
		else{
			data=qArr[front];
			if(front==rear)
				front=rear-1;
			else{
				front=((front+1)%capacity);
			}
		}
		return data;
	}
}
