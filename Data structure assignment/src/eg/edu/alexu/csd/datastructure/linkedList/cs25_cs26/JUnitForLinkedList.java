/**
 * 
 */
package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * @author Abd El Fattah
 * @author Abdelrahman
 *
 */
public class JUnitForLinkedList {

	@Test
	public void cs55TestSizeContains() {
		ILinkedList object = (ILinkedList) new SingleLinkedList(null);
		object.add(0, 0);
		object.add(1, 1); // line 365
		object.add(2, 2);
		object.add(3, 3);
		object.add(4, 4);
		object.add(5, 5);
		object.set(1, 10);
		object.set(4, 40);
		object.remove(1);

		assertEquals(object.get(1), 2);

		object.sublist(1, 3);

		object.clear();

		assertEquals(object.get(1), null);

	}

	@Test
	public void cs58TestContains() {
		ILinkedList c = (ILinkedList) new SingleLinkedList(null);
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
	}

	@Test
	public void cs56TestSizeContains1() {
		ILinkedList test = (ILinkedList) new SingleLinkedList(null);
		for (int i = 5; i < 15; ++i) {
			test.add(Integer.valueOf(i));
		}
		test.add(Integer.valueOf(100000000));
		assertEquals(11, test.size());
		assertEquals(true, test.contains(Integer.valueOf(100000000)));
		assertEquals(false, test.contains(Integer.valueOf(4)));
	}

	@Test
	public void cs65TestSet() {
		ILinkedList instance = (ILinkedList) new SingleLinkedList(null);
		instance.add(1);
		instance.add(3);
		instance.add(5);
		instance.set(1, 'F');
		assertEquals('F', instance.get(1));
	}

	@Test
	public void cs65TestSetError() {
		ILinkedList instance = (ILinkedList) new SingleLinkedList(null);
		try {
			instance.add(1);
			instance.add(2);
			instance.set(4, 'F');
			fail("You should throw an exception when trying to set in a wrong index");
		} catch (RuntimeException f) {
		}
	}

	@Test
	public void cs65TestSubList() {
		ILinkedList instance = (ILinkedList) new SingleLinkedList(null);
		instance.add('a');
		instance.add('b');
		instance.add('c');
		instance.add('d');
		ILinkedList temp = instance.sublist(1, 2);
		assertEquals(temp.get(0), instance.get(1));
		assertEquals(temp.get(1), instance.get(2));

	}

	@Test
	public void cs56TestContains() {
		ILinkedList c = (ILinkedList) new SingleLinkedList(null);
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
	}

	@Test
	public void cs56TestAddRemoveTwoLists5() {
		ILinkedList c = (ILinkedList) new SingleLinkedList(null);
		for (int i = 0; i < 3; i++) {
			c.add(i);
		}
		c.add(0, 3);
		c.add(4, 4);
		c.set(1, 7);
		c.set(4, 9);
		ILinkedList d = (ILinkedList) new SingleLinkedList(null);
		d.add(3);
		d.add(7);
		d.add(1);
		d.add(2);
		d.add(9);
		for (int i = 0; i < 5; i++) {
			assertEquals(c.get(i), d.get(i));
		}
	}

}
