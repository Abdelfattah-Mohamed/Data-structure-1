package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

/**
 *
 * @author Abdelrahman
 * @author Abdelfattah
 */
public class Dnode {
	/**
	*
	*/
	private Dnode next;
	/**
	 *
	 */
	private Dnode prev;
	/**
	 *
	 */
	private Object element;

	/**
	 * @param e
	 *            el object nfso.
	 * @param n
	 *            nesxt.
	 * @param p
	 *            prev.
	 */
	public Dnode(final Object e, final Dnode n, final Dnode p) {
		next = n;
		prev = p;
		element = e;
	}

	/**
	 *
	 * @param e
	 *            element.
	 */
	public void setElement(final Object e) {
		element = e;
	}

	/**
	 *
	 * @param n
	 *            next.
	 */
	public void setNext(final Dnode n) {
		next = n;
	}

	/**
	 *
	 * @param p
	 *            prev.
	 */
	public void setPrev(final Dnode p) {
		prev = p;
	}

	/**
	 *
	 * @return element
	 */
	public Object getElement() {
		return element;
	}

	/**
	 *
	 * @return next
	 */
	public Dnode getNext() {
		return next;
	}

	/**
	 *
	 * @return prev
	 */
	public Dnode getPrev() {
		return prev;
	}

}
