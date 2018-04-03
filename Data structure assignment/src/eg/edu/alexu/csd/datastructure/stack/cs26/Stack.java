package eg.edu.alexu.csd.datastructure.stack.cs26;

import eg.edu.alexu.csd.datastructure.stack.IStack;

/**
 * 
 * @author Abd El Fattah
 *
 */
public class Stack implements IStack {

	/**
	 * point to first node in linked list.
	 */
	Dnode head = null;
	/**
	 * point to last node in linked list.
	 */
	Dnode tail = head;
	/**
	 * size of linked list.
	 */
	int size = 0;

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new RuntimeException();
		}
		Dnode q = head;
		head = head.next;
		q.next = null;
		size--;
		return q.value;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if (size == 0) {
			throw new RuntimeException();
		}
		return head.value;
	}

	@Override
	public void push(final Object element) {
		// TODO Auto-generated method stub
		Dnode q = new Dnode(element, null, null);
		if (size == 0) {
			head = q;
			tail = head;
			size++;
		} else {
			q.next = head;
			head.prev = q;
			head = q;
			size++;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size > 0) {
			return false;
		}
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
