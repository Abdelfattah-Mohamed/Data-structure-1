package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.stack.cs26.Stack;

public class BinarySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ILinkedList instance = (ILinkedList) new SingleLinkedList();
		instance.add(1);
		instance.add(2);
		instance.add(3);
		instance.add(4);
		instance.add(5);
		instance.add(6);
		int index = binarySearch(instance, 5, 0, instance.size());
		if (index == -1) {
			System.out.println("null");
		} else {
			System.out.println(index);
		}
	}

	public static int binarySearch(ILinkedList list, Object search, int start, int end) {
		Stack front = (Stack) new Stack();
		Stack back = (Stack) new Stack();
		front.push(start);
		back.push(end);
		if (end >= start) {
			int mid = start + (end - start) / 2;

			if (list.get(mid) == search)
				return mid;

			while ((int) back.peek() >= (int) front.peek()) {
				mid = (int) front.peek() + ((int) back.peek() - (int) front.peek()) / 2;
				if (list.get(mid) == search) {
					return mid;
				} else if ((Integer) list.get(mid) > (Integer) search) {
					back.push(mid - 1);
				} else {
					front.push(mid + 1);
				}
			}
		}
		return -1;
	}
}
