package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 *
 * @author Abd El Fattah
 * @auther Abd El Rahman
 *
 */
public class SingleLinkedList implements ILinkedList {

	Snode head = null;
	Snode tail = null;
	int size = 0;

	/*
	 * public SingleLinkedList(Snode head, Snode tail) { this.head = head; this.tail
	 * = tail; }
	 */
	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size) {
			throw new IndexOutOfBoundsException("Add with wrong index passed!");
		}
		Snode nptr = new Snode(element, null);
		Snode q = head;
		if (q == null || x == 0) {
			nptr.next = head;
			head = nptr;
		}
		for (; q != null;) {
			if (x == 1) {
				Snode temp = q.next;
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
	public void add(Object element) {
		// TODO Auto-generated method stub
		Snode nptr = new Snode(element, null);

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
	public Object get(int index) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size) {
			throw new IndexOutOfBoundsException();
		}
		if (head == null) {
			return null;
		}
		Snode q = head;
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
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size) {
			throw new IndexOutOfBoundsException();
		}
		new Snode(element, null);
		Snode q = head;
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
	public void remove(int index) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size) {
			throw new RuntimeException("Remove from invalid index passed!");
		}
		if (x == 0) {
			head = head.next;
		}
		Snode q = head;
		for (; q != null;) {
			if (x == 1) {
				Snode temp = q.next;
				Snode temp1 = temp.next;
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
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		int counter = toIndex;
		Snode head1 = head;
		ILinkedList sub = (ILinkedList) new SingleLinkedList();
		if (fromIndex > toIndex || fromIndex > size || toIndex > size || fromIndex < 0) {
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
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		Snode q = head;
		for (; q != null;) {
			if (q.value.equals(o)) {
				return true;
			}
			q = q.next;
		}
		return false;
	}

}
