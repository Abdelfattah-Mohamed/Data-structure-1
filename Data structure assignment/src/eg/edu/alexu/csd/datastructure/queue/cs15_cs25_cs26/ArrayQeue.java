package eg.edu.alexu.csd.datastructure.queue.cs15_cs25_cs26;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
/**
 *
 * @author super
 * @author Abd Elrahman
 * @author Abd Elfattah
 *
 */
public class ArrayQeue implements IQueue, IArrayBased {
	/**
	 * queue is an array holding elements of queue.
	 */
	Object[] queue;
	/**
	 * this is the size of queue.
	 */
	int size;
	/**
	 * front points to the first element.
	 */
	int front;
	/**
	 * rear points to the last element.
	 */
	int rear;
/**
 *
 * @param n the size of queue.
 */
	public ArrayQeue(final int n) {
		queue = new Object[n];
		size = 0;
		front = 0;
		rear = 0;
	}

	@Override
	public void enqueue(final Object item) {
		if (size == queue.length) {
			throw new RuntimeException();
		}
		queue[rear] = item;
		rear = (rear + 1) % queue.length;
		size++;
	}

	@Override
	public Object dequeue() {
		if (size == 0) {
			throw new RuntimeException();
		}
		Object item = queue[front];
		front = (front + 1) % queue.length;
		size--;
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

}
