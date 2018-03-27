package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 *
 * @author Abd El Fattah
 * @auther Abd El Rahman
 *
 */
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
		Snode<Object> nptr = new Snode<Object>(element, null);

		if (head == null) {
			head = nptr;
			tail = head;
		} else {
			tail.next = nptr;
			tail = nptr;
		}
		size++;
	}

	@Override
	public Object get(final int index) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size) {
			throw new IndexOutOfBoundsException();
		}
		if (head == null) {
			return null;
		}
		Snode<Object> q = head;
		for (; q != null;) {
			if (x == 0) {
				return q.value;
			}
			q = q.next;
			x--;
		}
		return null;
	}

	@Override
	public void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size) {
			throw new IndexOutOfBoundsException();
		}
		new Snode<Object>(element, null);
		Snode<Object> q = head;
		for (; q != null;) {
			if (x == 0) {
				q.value = element;
				break;
			}
			q = q.next;
			x--;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head.next = null;
		head = null;
		tail = head;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head == null) {
			return true;
		}
		return false;

	}

	@Override
	public void remove(final int index) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size) {
			throw new IndexOutOfBoundsException();
		}
		if (x == 0) {
			head = head.next;
		}
		Snode<Object> q = head;
		for (; q != null;) {
			if (x == 1) {
				Snode<Object> temp = q.next;
				Snode<Object> temp1 = temp.next;
				q.next = temp1;
				temp.next = null;
				break;
			}
			q = q.next;
			x--;
		}
		size--;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public ILinkedList sublist(final int fromIndex, final int toIndex) {
		// TODO Auto-generated method stub
		int counter = toIndex;
		Snode<Object> head1 = head;
		ILinkedList sub = (ILinkedList) new SingleLinkedList(null, null);
		if (fromIndex > toIndex || fromIndex > size || toIndex > size) {
			throw new IndexOutOfBoundsException();
		}
		while (counter >= 0) {
			if (counter <= fromIndex) {
				sub.add(head1.value);
			}
			head1 = head1.next;
			counter--;
		}

		return (ILinkedList) sub;

	}

	@Override
	public boolean contains(final Object o) {
		// TODO Auto-generated method stub
		Snode<Object> q = head;
		for (; q != null;) {
			if (q.value.equals(o)) {
				return true;
			}
			q = q.next;
		}
		return false;
	}

}
