package eg.edu.alexu.csd.datastructure.stack.cs26;

/**
 *
 * @author Abd El Fattah
 *
 */
public class Dnode {

	/**
	 * value of node.
	 */
	Object value;
	/**
	 * point to next.
	 */
	Dnode next;
	/**
	 * point to previous.
	 */
	Dnode prev;

	/**
	 * 
	 * @param element
	 *            value of node.
	 * @param after
	 *            point to next node.
	 * @param before
	 *            point to previous node.
	 */
	public Dnode(final Object element,
			final Dnode after,
			final Dnode before) {
		// TODO Auto-generated constructor stub
		value = element;
		next = after;
		prev = before;
	}

}
