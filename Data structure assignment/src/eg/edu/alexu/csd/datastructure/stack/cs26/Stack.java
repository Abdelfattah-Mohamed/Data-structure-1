package eg.edu.alexu.csd.datastructure.stack.cs26;

import eg.edu.alexu.csd.datastructure.stack.IStack;


class SNodes<T> {

	T value;
	SNodes<T> next;
	SNodes<T> prev;

	public SNodes(final T value,
			final SNodes<T> next, final SNodes<T> prev) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

}

public class Stack implements IStack {

	SNodes<Object> head = null;
	SNodes<Object> tail = null;
	int size = 0;

	public Stack(final SNodes<Object> head, final SNodes<Object> tail) {
		// TODO Auto-generated constructor stub
		this.head = head;
		this.tail = tail;
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		SNodes<Object> q = head;
		head = q.next;
		q.next = null;
		return null;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return head.next.value;
	}

	@Override
	public void push(final Object element) {
		// TODO Auto-generated method stub
		SNodes<Object> nptr = new SNodes<Object>(element, null, null);
		nptr.next = head;
		head = nptr;
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
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
