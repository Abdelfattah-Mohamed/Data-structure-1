package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author Abd El Fattah
 * @author Abdelrahman
 *
 */
public class JUnitOfLinkedList {

	/**
	 * test of size and contain.
	 */
	@Test
	public void cs55TestSizeContains() {
		final ILinkedList object = (ILinkedList) new SingleLinkedList();
		object.add(0, '0');
		object.add(1, "1"); // line 365
		object.add(2, 2);
		object.remove(1);
		assertEquals(2, object.get(1));
	}

	/**
	 * test of contain.
	 */

	@Test
	public void cs58TestContains() {
		ILinkedList c = (ILinkedList) new SingleLinkedList();
		for (int i = 0; i <= 2; i++) {
			c.add(i);
		}
		c.add(0, 2);
		c.add(2, '4');
		assertTrue(c.contains('4'));
		assertTrue(c.contains(0));
		assertTrue(c.contains(1));
		assertTrue(c.contains(2));
		assertTrue(c.contains(2));
		assertFalse(c.contains('9'));
		assertFalse(c.contains("19"));
	}

	/**
	 * test of size.
	 */
	@Test
	public void cs56TestSizeContains1() {
		ILinkedList test = (ILinkedList) new SingleLinkedList();
		final int x = 10;
		for (int i = 0; i < x; ++i) {
			test.add(i);
		}
		test.add("1000000");
		assertEquals(x + 1, test.size());
		assertEquals(true, test.contains("1000000"));
		assertEquals(true, test.contains(1));
	}

	/**
	 * test of add.
	 */
	@Test
	public void cs65TestSet() {
		ILinkedList instance = (ILinkedList) new SingleLinkedList();
		instance.add(1);
		instance.add('3');
		instance.add("5");
		instance.set(1, 'F');
		assertEquals('F', instance.get(1));
	}

	/**
	 * test of add in invalid index.
	 */
	@Test
	public void cs65TestSetError() {
		ILinkedList instance = (ILinkedList) new SingleLinkedList();
		try {
			instance.add(1);
			instance.set(2, 'F');
			fail("You should throw an "
			+ "exception when trying "
					+ "to set in a wrong index");
		} catch (RuntimeException f) {
			System.out.print("index must be "
		+ "in litter than size");
		}
	}

	/**
	 * test of sub list.
	 */
	@Test
	public void cs65TestSubList() {
		ILinkedList instance = (ILinkedList) new SingleLinkedList();
		instance.add('a');
		instance.add('b');
		instance.add('c');
		instance.add('d');
		ILinkedList temp = instance.sublist(1, 2);
		assertEquals(temp.get(0), instance.get(1));
		assertEquals(temp.get(1), instance.get(2));

	}

	/**
	 * test of add and remove.
	 */
	@Test
	public void cs56TestAddRemoveTwoLists5() {
		ILinkedList c = (ILinkedList) new SingleLinkedList();
		c.add(0, '3');
		c.add(1, '7');
		c.set(1, '5');
		ILinkedList d = (ILinkedList) new SingleLinkedList();
		d.add('3');
		d.add('5');
		for (int i = 0; i < 2; i++) {
			assertEquals(c.get(i), d.get(i));
		}
	}

}
