package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**
 * @author Abd El Fattah
 * @author Abdelrahman
 *
 */
public class JUnitOfPolynomial {

	@Test
	public void cs55TestSizeContains() {
		IPolynomialSolver instance = (IPolynomialSolver) new Polynomial();
		ILinkedList object = (ILinkedList) new SingleLinkedList();
		instance.setPolynomial('C', new int[][] { { 3, 7 }, { 45, 5 }, { 176, 3 }, { 128, 1 } });
		instance.setPolynomial('B', new int[][] { { -120, 5 }, { -1, 3 }, { 27, 2 }, { 1, 1 }, { -1, 0 } });
		//instance.setPolynomial('A', new int[][] { { 120, 5 }, { 1, 3 }, { -27, 2 }, { -1, 1 }, { 1, 0 } });
		assertNull("Polynomial R is not set yet", instance.print('R'));
		int[][] result1 = instance.add('B', 'B');
		float a = instance.evaluatePolynomial('A', 10);
		
		assertNotNull("Polynomial R must be set after evaluation", instance.print('R'));
		int[][] expected = new int[][] { { 3, 7 }, { -75, 5 }, { 175, 3 }, { 27, 2 }, { 129, 1 }, { -1, 0 } };
		System.out.println();
		for(int i = 0 ; i < result1.length ; i ++) {
			System.out.println(result1[i][0]);
		}
		instance.print('R');
	}
	
	@Test
	public void cs56TestAddRemoveTwoLists2() {
		ILinkedList c = (ILinkedList) new SingleLinkedList();
		c.add(0,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
        c.add(1,3);
    
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
        for(int i=0;i<5;i++){
            assertEquals(c.get(i),d.get(i));
        }
    }
}
