package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

public class Snode<T> {

	T value;
	Snode<T> next;

	public Snode(final T value, final Snode<T> next) {
		this.value = value;
		this.next = next;
	}

}
