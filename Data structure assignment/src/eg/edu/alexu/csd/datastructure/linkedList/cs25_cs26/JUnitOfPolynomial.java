package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

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
	public void testSolveAdd() {
		final IPolynomialSolver instance = (IPolynomialSolver) new Polynomial();
		instance.setPolynomial('C', new int[][] {{3, 7 }, {45, 5 }, {176, 3 }, {128, 1 } });
		instance.setPolynomial('B', new int[][] {{-120, 5 }, {-1, 3 }, {27, 2 }, {1, 1 }, {-1, 0 } });
		assertNull("Polynomial R is not set yet", instance.print('R'));
		assertEquals("3x^7+45x^5+176x^3+128x", instance.print('C'));
	}

	/**
	 * TO TEST POLY2.
	 */
	@Test
	public void testSolveMULTIBLY() {
		final IPolynomialSolver instance = (IPolynomialSolver) new Polynomial();
		instance.setPolynomial('A', new int[][] {{0, 7 }, {0, 5 }, {0, 3 }, {0, 1 } });
		instance.setPolynomial('B', new int[][] {{0, 5 }, {-1, 3 }, {0, 2 }, {1, 1 }, {-1, 0 } });
		instance.multiply('A', 'B');
		assertEquals("", instance.print('R'));
	}
}
