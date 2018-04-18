package eg.edu.alexu.csd.datastructure.queue.cs15_cs25_cs26;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.linkedList.*;
import eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26.SingleLinkedList;

public class QueueLinkedList implements IQueue,ILinkedBased {

	final ILinkedList object = (ILinkedList) new SingleLinkedList();

	public QueueLinkedList() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		object.add(item);
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		Object x = object.get(0);
		object.remove(0);
		return x;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return object.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return object.size();
	}

}
