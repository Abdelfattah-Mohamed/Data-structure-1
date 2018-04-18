package eg.edu.alexu.csd.datastructure.queue.cs15_cs25_cs26;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.linkedList.*;
import eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26.Dlinkedlist;

public class QueueLinkedList implements IQueue, ILinkedBased {

	final ILinkedList object = (ILinkedList) new Dlinkedlist();

	@Override
	public final void enqueue(final Object item) {
		// TODO Auto-generated method stub
		object.add(item);
	}

	@Override
	public final Object dequeue() {
		// TODO Auto-generated method stub
		Object x = object.get(0);
		object.remove(0);
		return x;
	}

	@Override
	public final boolean isEmpty() {
		// TODO Auto-generated method stub
		return object.isEmpty();
	}

	@Override
	public final int size() {
		// TODO Auto-generated method stub
		return object.size();
	}

}
