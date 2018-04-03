package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

/**
 *
 * @author Abd El Fattah
 *
 */
public class Snode {

	/**
	 * to obtain value of node.
	 */
	Object value;
	/**
	 * to point next node.
	 */
	Snode next;

	/**
	 *
	 * @param element
	 *            element of the node.
	 * @param after
	 *            point to the next node.
	 */
	public Snode(final Object element,final Snode after) {
		value = element;
		next = after;
	}
}
