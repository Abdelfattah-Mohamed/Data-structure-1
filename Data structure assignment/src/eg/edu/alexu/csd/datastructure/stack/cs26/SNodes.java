package eg.edu.alexu.csd.datastructure.stack.cs26;

public class SNodes<T> {

	T value;
	SNodes<T> next;
	SNodes<T> prev;

	public SNodes(T value, SNodes<T> next, SNodes<T> prev) {
		// TODO Auto-generated constructor stub
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

}