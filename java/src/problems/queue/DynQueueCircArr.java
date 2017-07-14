package problems.queue;

public class DynQueueCircArr {

	private int front;
	private int rear;
	private int capacity;
	private int[] arr;

	public DynQueueCircArr() {
		front = -1;
		rear = -1;
		capacity = 1;
		arr = new int[capacity];
	}

	public static DynQueueCircArr createDynamicQ() {
		return new DynQueueCircArr();
	}

	public boolean isEmpty() {
		return (front == -1);
	}

	public boolean isFull() {
		return ((rear + 1) % capacity == front);
	}

	public int getQsize() {
		if (front == -1)
			return 0;
		else
			return (capacity - front + rear + 1);
	}

	private void qResize() {
		int initCapacity = capacity;
		capacity *= 2;
		int[] oldarr = arr;
		int[] newarr = new int[this.capacity];
		for (int i = 0; i < oldarr.length; i++) {
			newarr[i] = oldarr[i];
		}

		if (rear < front) {
			for (int i = 0; i < front; i++) {
				arr[i + initCapacity] = this.arr[i];
				arr[i] = (Integer) null;
			}
			rear += initCapacity;
		}
	}

	public void enQueue(int data) {
		if (isFull() == true) {
			qResize();
		}
		rear = ((rear + 1) % capacity);
		arr[rear] = data;
		if (front == -1)
			front = rear;
	}

	public int deQueue() {
		int data = (Integer) null;
		if (isEmpty() == true)
			System.out.println("empty Q");
		else {
			data = arr[front];
			front = (front + 1) % capacity;
		}
		return data;

	}
}
