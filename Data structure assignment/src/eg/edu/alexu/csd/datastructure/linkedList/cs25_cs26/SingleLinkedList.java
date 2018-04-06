package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 *
 * @author Abd El Fattah
 *
 */
public class SingleLinkedList implements ILinkedList {
	/**
	 * to implement liked list with head node.
	 */
	Snode head = null;
	/**
	 * to point last node.
	 */
	Snode tail = null;
	/**
	 * size of linked list.
	 */
	int size = 0;

	@Override
	public void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size || x < 0) {
			throw new RuntimeException("null");
		}
		Snode nptr = new Snode(element, null);
		Snode q = head;
		if (q == null && x == 0) {
			nptr.next = head;
			head = nptr;
			tail = head;
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
	public void add(final Object element) {
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
	public Object get(final int index) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size || x < 0) {
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
	public void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size || x < 0) {
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
	public void remove(final int index) {
		// TODO Auto-generated method stub
		int x = index;
		if (x > size || x < 0) {
			throw new IllegalArgumentException(
					"Remove from invalid index passed!");
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
	public ILinkedList sublist(final int fromIndex, final int toIndex) {
		// TODO Auto-generated method stub
		int counter = 0;
		Snode head1 = head;
		ILinkedList sub = (ILinkedList) new SingleLinkedList();
		if (fromIndex > toIndex
				|| fromIndex > size || toIndex > size
				|| fromIndex < 0) {
			throw new IndexOutOfBoundsException();
		}
		while (counter <= toIndex) {
			if (counter >= fromIndex) {
				sub.add(head1.value);
			}
			head1 = head1.next;
			counter++;
		}
		return (ILinkedList) sub;
	}

	@Override
	public boolean contains(final Object o) {
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
