package eg.edu.alexu.csd.datastructure.mailServer.cs15_cs25_cs26;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.mailServer.IPriorityQueue;

/**
 * @author Abd El Fattah
 */
public class PriorityTest {
	/**
	 * @Test
	 */
	@Test
	public void test() {
		IPriorityQueue test = new PriorityQueue();
		for (int i = 0; i < 10; i++) {
			test.insert(i, i);
		}
	}
}
