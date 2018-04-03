package eg.edu.alexu.csd.datastructure.stack.cs26;

/**
 * 
 * @author Abd El Fattah
 *
 */
public class Dnode {

	Object value;
	Dnode next;
	Dnode prev;

	public Dnode(Object element, Dnode after, Dnode before) {
		// TODO Auto-generated constructor stub
		value = element;
		next = after;
		prev = before;
	}

}
