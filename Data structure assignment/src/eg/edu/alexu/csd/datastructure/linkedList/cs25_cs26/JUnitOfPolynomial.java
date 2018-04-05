package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**
 * @author Abd El Fattah
 * @author Abdelrahman
 *
 */
public class JUnitOfPolynomial {

	/**
	 * TO TEST POLY.
	 */
	@Test
	public void cs55TestSizeContains() {
		IPolynomialSolver instance = (IPolynomialSolver) new Polynomial();
		ILinkedList object = (ILinkedList) new SingleLinkedList();
		instance.setPolynomial('C', new int[][] {{3, 7 }, {45, 5 }, {176, 3 }, {128, 1 } });
		instance.setPolynomial('B', new int[][] {{-120, 5 }, {-1, 3 }, {27, 2 }, {1, 1 }, {-1, 0 } });
		instance.setPolynomial('A', new int[][] {{27, 2 }, {1, 1 }, {-1, 0 } });
		assertNull("Polynomial R is not set yet", instance.print('R'));
		int[][] result1 = instance.add('C', 'B');
		float a = instance.evaluatePolynomial('A', 10);
		assertEquals("27x^2+x-1", instance.print('A'));
		int[][] expected = new int[][] {{3, 7 }, {-75, 5 }, {175, 3 }, {27, 2 }, {129, 1 }, {-1, 0 } };
		System.out.println();
		for (int i = 0; i < result1.length; i++) {
			System.out.println(result1[i][1]);
		}
		String x = instance.print('R');
		System.out.println();
		System.out.println(x);
	}

	/**
	 * TO TEST LINKED.
	 */
	@Test
	public void cs56TestAddRemoveTwoLists2() {
		ILinkedList c = (ILinkedList) new SingleLinkedList();
		for (int i = 0; i < 3; i++) {
			c.add(i);
		}
		c.add(0, 3);
		c.add(4, 4);

		assertTrue(c.contains(4));
		assertTrue(c.contains(0));
		assertTrue(c.contains(1));
		assertTrue(c.contains(2));
		assertTrue(c.contains(3));
		assertFalse(c.contains(9));
		assertFalse(c.contains(7));
		ILinkedList d = (ILinkedList) new SingleLinkedList();
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		d.add(3);
		assertTrue(d.contains(3));
		/*
		 * for (int i=0;i<5;i++){ assertEquals(c.get(i),d.get(i)); }
		 */
	}
}
