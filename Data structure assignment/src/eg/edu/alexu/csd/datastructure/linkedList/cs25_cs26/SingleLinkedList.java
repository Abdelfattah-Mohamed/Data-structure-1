package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * 
 * @author Abd El Fattah
 *
 */
public class SingleLinkedList implements ILinkedList {

	Snode<Object> head = null;
	Snode<Object> tail = head;
	int size = 0;

	public SingleLinkedList(Snode<Object> head) {
		this.head = head;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		Snode<Object> nptr = new Snode<Object>(element, null);
		Snode<Object> q = head;
		if (q == null || index == 0) {
			nptr.next = head;
			head = nptr;
		}
		for (; q != null;) {
			if (index == 1) {
				Snode<Object> temp = q.next;
				q.next = nptr;
				nptr.next = temp;
				break;
			}
			q = q.next;
			index--;
		}
		size++;
	}

	@Override
	public void add(Object element) {
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
	public Object get(int index) {
		// TODO Auto-generated method stub
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (head == null) {
			return null;
		}
		Snode<Object> q = head;
		for (; q != null;) {
			if (index == 0) {
				return q.value;
			}
			q = q.next;
			index--;
		}
		return null;
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		new Snode<Object>(element, null);
		Snode<Object> q = head;
		for (; q != null;) {
			if (index == 0) {
				q.value = element;
				break;
			}
			q = q.next;
			index--;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head.next = null;
		head = null;
		tail = head;
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
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			head = head.next;
		}
		Snode<Object> q = head;
		for (; q != null;) {
			if (index == 1) {
				Snode<Object> temp = q.next;
				Snode<Object> temp1 = temp.next;
				q.next = temp1;
				temp.next = null;
				break;
			}
			q = q.next;
			index--;
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
		Snode<Object> head1 = head;
		ILinkedList sub = (ILinkedList) new SingleLinkedList(null);
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
	public boolean contains(Object o) {
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
