package eg.edu.alexu.csd.datastructure.stack.cs26;

import eg.edu.alexu.csd.datastructure.stack.IStack;

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
		return head.value;
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
