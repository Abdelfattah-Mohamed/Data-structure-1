package eg.edu.alexu.csd.datastructure.queue.cs15_cs25_cs26;

import org.junit.jupiter.api.Test;

import eg.edu.alexu.csd.datastructure.queue.IQueue;

class J_A {

	@Test
	void test() {
		IQueue x = new ArrayQeue(5);
		x.enqueue(1);
		x.enqueue(1);
		x.enqueue(1);
		x.enqueue(1);
		x.enqueue(1);
	}

}
