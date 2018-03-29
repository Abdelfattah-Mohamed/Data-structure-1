package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SingleLinkedList implements ILinkedList {

	Snode<Object> head = null;
	Snode<Object> tail = null;
	int size = 0;

	public SingleLinkedList(final Snode<Object> head, final Snode<Object> tail) {
		this.head = head;
		this.tail = tail;
	}

	@Override
	public void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size) {
			throw new IndexOutOfBoundsException();
		}
		Snode<Object> nptr = new Snode<Object>(element, null);
		Snode<Object> q = head;
		if (q == null || x == 0) {
			nptr.next = head;
			head = nptr;
		}
		for (; q != null;) {
			if (x == 1) {
				Snode<Object> temp = q.next;
				q.next = nptr;
				nptr.next = temp;
				break;
			}
			q = q.next;
			x--;
		}
		size++;

	}

	@Override
	public void add(final Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(final int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(final int index, final Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(final int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ILinkedList sublist(final int fromIndex, final int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(final Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}
