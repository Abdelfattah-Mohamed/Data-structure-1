package eg.edu.alexu.csd.datastructure.queue.cs15_cs25_cs26;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

public class ArrayQeue implements IQueue, IArrayBased {

	Object[] queue;
	int f;
	int l;
	int size;

	public ArrayQeue(final int n) {
		queue = new Object[n];
		size = 0;
		l = -1;
		f = -1;
	}

	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		l = (l + 1) % queue.length;
		if (l - 1 == f) {
			throw new RuntimeException("Queue Is Full! You should not be able to enqueue");
		} else {
			queue[l] = item;
			size++;
		}
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		f = (f + 1) % queue.length;
		size--;
		Object q = queue[f];
		if (l == f) {
			l = -1;
			f = -1;
		}
		return q;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (l == f && f != -1);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
}
