package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**
 *
 * @author Abdelrahman
 *@author Abdelfattah
 */
public class Dlinkedlist implements ILinkedList {

/**
 *
 */

public Dnode header;

	/**
	 *
	 */

public Dnode trailer;

	/**
	 *
	 */
private long size;

/**
 *
 */

	public Dlinkedlist() {
		/**
		 *
		 */
		size = 0;
		/**
		 *
		 */
		header = new Dnode(null, null, null);
		/**
		 *
		 */
		trailer = new Dnode(null, null, header);
		/**
		 *
		 */
		header.setNext(trailer);
	}

	@Override
	/**
	 *
	 */
	public void add(final int index, final Object element) {
		Dnode first = header;
		if (index < 0 || index > size) {
			throw new RuntimeException();
		}
		for (int counter = 0;
		counter < index; counter++) {
			first = first.getNext();
		}
		Dnode second = first.getNext();
		Dnode newEle =
		new Dnode(element, second, first);
		second.setPrev(newEle);
		first.setNext(newEle);
		size++;
	}

	@Override
	/**
	 *
	 */
	public void add(final Object element) {
		Dnode last = trailer.getPrev();
		Dnode newEle =
		new Dnode(element, trailer, last);
		trailer.setPrev(newEle);
		last.setNext(newEle);
		size++;
	}

	@Override
	/**
	 *
	 */
	public Object get(final int index) {
		if (index < 0 || index >= size) {
			throw new RuntimeException();
		}
		Dnode first = header.getNext();
		
		if(index == size - 1) {
			return trailer.getPrev().getElement();
		}
		
		for (int counter = 0;
		counter < index; counter++) {
			first = first.getNext();
		}
		return first.getElement();
	}

	@Override
	/**
	 *
	 */
	public void set(final int index, final Object element) {
		if (index < 0 || index >= size) {
			throw new RuntimeException();
		}
		Dnode first = header.getNext();
		for (int counter = 0;
		counter < index; counter++) {
			first = first.getNext();
		}
		first.setElement(element);

	}

	@Override
	/**
	 *
	 */
	public void clear() {
		header.setNext(trailer);
		trailer.setPrev(header);
		size = 0;
	}

	@Override
	/**
	 *
	 */
	public boolean isEmpty() {
		return (size == 0);

	}

	@Override
	/**
	 *
	 */
	public void remove(final int index) {
		if (index < 0 || index >= size) {
			throw new RuntimeException();
		}
		Dnode first = header.getNext();
		for (int counter = 0;
		counter < index; counter++) {
			first = first.getNext();
		}
		size--;
		Dnode p = first.getPrev();
		Dnode n = first.getNext();
		first.setNext(null);
		first.setPrev(null);
		p.setNext(n);
		n.setPrev(p);
	}

	@Override
	/**
	 *
	 */
	public int size() {
		return (int) size;
		/**
		 * or/ size=0; Dnode v=Header.get_next();
		 *  while(v.get_next!=null){ size++;
		 * v=v.get_next(); } return (int) size;
		 */
	}

	@Override
	/**
	 *
	 */
	public ILinkedList sublist(
	final int fromIndex, final int toIndex) {
		if (fromIndex < 0
			|| fromIndex >= size) {
			throw new RuntimeException();
		}
		if (toIndex < 0 || toIndex >= size) {
			throw new RuntimeException();
		}
		if (fromIndex > toIndex) {
			throw new RuntimeException();
		}
		Dlinkedlist dLL = new Dlinkedlist();
		Dnode first = header.getNext();
		Object ele;
		for (int counter = 0;
		counter < fromIndex - 1; counter++) {
			first = first.getNext();
		}
		for (int counter = 0; counter
		< toIndex - fromIndex + 1; counter++) {
			first = first.getNext();
			ele = first.getElement();
			dLL.add(ele);
		}
		return dLL;
	}

	@Override
	/**
	 *
	 */
	public boolean contains(final Object o) {
		Dnode v = header.getNext();
		while (v.getNext() != null) {
			if (v.getElement().equals(o)) {
				return true;
			} else {
				v = v.getNext();
			}

		}
		return false;
	}

}
