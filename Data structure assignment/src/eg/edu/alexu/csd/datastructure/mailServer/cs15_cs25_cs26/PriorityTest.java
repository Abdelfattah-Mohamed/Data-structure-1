package eg.edu.alexu.csd.datastructure.mailServer.cs15_cs25_cs26;

import org.junit.Test;
import eg.edu.alexu.csd.datastructure.mailServer.IPriorityQueue;

/**
 * @author Abd El Fattah
 */
public class PriorityTest {
/**
* @Test
**/
	@Test//(timeout = 300000)
	public void test() {
		IPriorityQueue test = new PriorityQueue();
		for (int i = 1; i < 100000; i++) {
			test.insert(i, i);
		}
	}
}
