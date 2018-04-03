package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

public class Snode {

	Object value;
	Snode next;

	/**
	 * 
	 * @param value
	 *            element of the node.
	 * @param next
	 *            point to the next node.
	 */
	public Snode(final Object value, final Snode next) {
		this.value = value;
		this.next = next;
	}
}
