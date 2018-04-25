package eg.edu.alexu.csd.datastructure.mailServer.cs15_cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26.Dlinkedlist;
import eg.edu.alexu.csd.datastructure.mailServer.IPriorityQueue;

public class PriorityQueue implements IPriorityQueue {

	final ILinkedList object = (ILinkedList) new Dlinkedlist();

	@Override
	public void insert(Object item, int key) {
		// TODO Auto-generated method stub
		Pq obj = new Pq(item, key);
		Pq z = new Pq(0, 0);
		if (!object.isEmpty()) {
			z = (Pq) object.get(object.size() - 1);
		}
		if (object.isEmpty()) {
			object.add(obj);
		} else if (key > z.key) {
			object.add(obj);
		} else {
			for (int i = 0; i < object.size(); i++) {
				Pq carry = (Pq) object.get(i);
				if (key < carry.key) {
					object.add(i, obj);
					break;
				}
			}
		}
	}

	@Override
	public Object removeMin() {
		// TODO Auto-generated method stub
		Pq z = (Pq) object.get(0);
		object.remove(0);
		return z.element;
	}

	@Override
	public Object min() {
		// TODO Auto-generated method stub
		Pq z = (Pq) object.get(0);
		return z.element;
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
