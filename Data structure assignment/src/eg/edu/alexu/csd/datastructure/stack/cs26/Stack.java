package eg.edu.alexu.csd.datastructure.stack.cs26;

import eg.edu.alexu.csd.datastructure.stack.IStack;

public class Stack implements IStack {

	Dnode head = null;
	Dnode tail = head;
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
		head.prev = null;
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
	public void push(Object element) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
