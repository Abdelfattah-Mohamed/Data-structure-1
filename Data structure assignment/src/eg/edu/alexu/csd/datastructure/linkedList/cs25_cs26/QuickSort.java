package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class QuickSort {	

	
	static void sort(ILinkedList list, int low, int high) {
		if (low < high) {
			int pivot = (int) list.get(high);
			int i = (low - 1); // index of smaller element
			for (int j = low; j < high; j++) {
				
				if ((int) list.get(j) <= pivot) {
					i++;

					Object temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
			Object temp = list.get(i + 1);
			list.set(i + 1, list.get(high));
			list.set(high, temp);
			
			int pi = i + 1;
			
			sort(list, low, pi - 1);
			sort(list, pi + 1, high);
		}
	}

	static void printArray(ILinkedList list) {
		for (int i = 0; i < list.size(); ++i)
			System.out.print(list.get(i) + " ");
		System.out.println();
	}

	// Driver program
	public static void main(String args[]) {
		ILinkedList instance = (ILinkedList) new SingleLinkedList();
		instance.add(5);
		instance.add(4);
		instance.add(1);
		instance.add(7);
		instance.add(12);
		instance.add(3);
		int n = instance.size();
		sort(instance, 0, n - 1);
		printArray(instance);
	}
}
