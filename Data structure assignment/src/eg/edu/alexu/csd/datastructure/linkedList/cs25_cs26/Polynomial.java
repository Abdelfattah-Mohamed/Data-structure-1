package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
import static java.lang.Math.pow;

/**
 *
 * @author Abd El Fattah
 *
 */
public class Polynomial implements IPolynomialSolver {

	/**
	 * to implement linked list with first node.
	 */
	Snode head = null;
	/**
	 * to point last node.
	 */
	Snode tail = head;
	/**
	 * size of linked list.
	 */
	int size = 0;
	/**
	 * A_linked list.
	 */
	public ILinkedList a = (ILinkedList) new SingleLinkedList();
	/**
	 * B_linked list.
	 */
	public ILinkedList b = (ILinkedList) new SingleLinkedList();
	/**
	 * C_linked list.
	 */
	public ILinkedList c = (ILinkedList) new SingleLinkedList();
	/**
	 * D_linked list.
	 */
	public ILinkedList r = (ILinkedList) new SingleLinkedList();
	/**
	 * to store max & minimum exponent.
	 */
	final int[][] firstLast = new int[2][4];
	/**
	 * to know if polynomial multiply with -1.
	 */
	char negative = '0';

	@Override
	public void setPolynomial(final char poly, final int[][] terms) {
		// TODO Auto-generated method stub
		int counter = 0;
		order(terms);

		if (poly != 'A' && poly != 'B' && poly != 'C' && poly != 220) {
			throw new IllegalArgumentException("Operation "
					+ "on polynomial "
		+ poly + " is not permitted");
		}

		if (poly == 'A') {
			if (!a.isEmpty()) {
				a.clear();
			}
			firstLast[0][0] = terms[0][1];
			firstLast[1][0] = terms[terms.length - 1][1];
			a.add(terms[0][0]);
			for (int i = 0; i < terms.length - 1; i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					a.set(counter, (int) a.get(counter)
							+ terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					a.add(terms[i + 1][0]);
					counter++;
					// a.set(i + 1, terms[i + 1][0]);
				} else {
					for (int j = terms[i][1] - 1;
							j > terms[i + 1][1];
							j--) {
						a.add(0);
						counter++;
						// a.set(i + 1, 0);
					}
					a.add(terms[i + 1][0]);
				}
			}

		} else if (poly == 'B') {
			if (!b.isEmpty()) {
				b.clear();
			}
			firstLast[0][1] = terms[0][1];
			firstLast[1][1] = terms[terms.length - 1][1];
			b.add(terms[0][0]);
			for (int i = 0; i < terms.length - 1; i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					b.set(counter, (int) b.get(counter)
							+ terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					b.add(terms[i + 1][0]);
					// b.set(i + 1, terms[i + 1][0]);
					counter++;
				} else {
					for (int j = terms[i][1] - 1;
							j > terms[i + 1][1];
							j--) {
						b.add(0);
						// b.set(i + 1, 0);
						counter++;
					}
					b.add(terms[i + 1][0]);
				}
			}
		} else if (poly == 'C') {
			if (!b.isEmpty()) {
				b.clear();
			}
			firstLast[0][2] = terms[0][1];
			firstLast[1][2] = terms[terms.length - 1][1];
			c.add(terms[0][0]);
			for (int i = 0;
					i < terms.length - 1;
					i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					c.set(counter, (int) c.get(counter)
							+ terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					c.add(terms[i + 1][0]);
					// c.set(i + 1, terms[i + 1][0]);
					counter++;
				} else {
					for (int j = terms[i][1] - 1;
							j > terms[i + 1][1];
							j--) {
						c.add(0);
						// c.set(i + 1, 0);
						counter++;
					}
					c.add(terms[i + 1][0]);
				}
			}
		} else if (poly == 220) {
			if (!r.isEmpty()) {
				r.clear();
			}
			firstLast[0][3] = terms[0][1];
			firstLast[1][3] = terms[terms.length - 1][1];
			r.add(terms[0][0]);
			for (int i = 0;
					i < terms.length - 1;
					i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					r.set(counter, (int) r.get(counter)
							+ terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					r.add(terms[i + 1][0]);
					// r.set(i + 1, terms[i + 1][0]);
					counter++;
				} else {
					for (int j = terms[i][1] - 1;
							j > terms[i + 1][1];
							j--) {
						r.add(0);
						// r.set(i + 1, 0);
						counter++;
					}
					r.add(terms[i + 1][0]);
				}
			}
		}
	}

	@Override
	public String print(final char poly) {
		// TODO Auto-generated method stub
		String print = "";
		int maxExp = 0;
		int leastExp = 0;
		if (poly != 'A' && poly != 'B'
				&& poly != 'C' && poly != 'R') {
			throw new IllegalArgumentException("Operation"
					+ " on polynomial "
		+ poly + " is not permitted");
		}
		if (poly == 'A') {
			if (a.size() == 0) {
				return null;
			}
			maxExp = firstLast[0][0];
			leastExp = firstLast[1][0];
			int i = 0;
			while (maxExp >= leastExp) {
				if (a.get(i) != null
						&& (int) a.get(i) != 0) {
					if (maxExp == 0) {
						print = print + a.get(i);
						System.out.print(a.get(i)
								+ " ");
					} else if (maxExp == 1) {
						if ((int) a.get(i) != 1) {
							System.out.print(
									a.get(i)
									+ "x"
									+ " ");
							print = print
						+ a.get(i)
						+ "x";
						} else {
							System.out.print(
							a.get(i)
							+ "x"
							+ " ");
							print = print
							+ "x";
						}
					} else {
						if ((int) a.get(i) != 1) {
							System.out.print(
							a.get(i)
							+ "x^"
							+ maxExp
							+ " ");
							print = print
							+ a.get(i)
							+ "x^"
							+ maxExp;
						} else {
							print = print
							+ "x^"
							+ maxExp;
							System.out.print("x^"
							+ maxExp
							+ " ");
						}
					}
				}
				if (maxExp != leastExp) {
					if ((int) a.get(i + 1) > 0) {
						print = print
								+ "+";
						System.out.print("+"
								+ " ");
					}
				}
				i++;
				maxExp--;
			}
		} else if (poly == 'B') {
			if (b.size() == 0) {
				return null;
			}
			maxExp = firstLast[0][1];
			leastExp = firstLast[1][1];
			int i = 0;
			print = "";
			while (maxExp >= leastExp) {
				if (b.get(i) != null
						&& (int) b.get(i) != 0) {
					if (maxExp == 0) {
						print = print
								+ b.get(i);
						System.out.print(
								b.get(i)
								+ " ");
					} else if (maxExp == 1) {
						if ((int) b.get(i) != 1) {
							System.out.print(
									b.get(i)
									+ "x"
									+ " ");
							print = print
						+ b.get(i)
						+ "x";
						} else {
							System.out.print(
							b.get(i)
							+ "x"
							+ " ");
							print = print
									+ "x";
						}
					} else {
						if ((int) b.get(i) != 1) {
							System.out.print(
									b.get(i)
									+ "x^"
									+ maxExp
									+ " ");
							print = print
							+ b.get(i)
							+ "x^"
							+ maxExp;
						} else {
							print = print
							+ "x^"
							+ maxExp;
							System.out.print(
							"x^"
							+ maxExp
							+ " ");
						}
					}
				}
				if (maxExp != leastExp) {
					if ((int) b.get(i + 1) > 0) {
						print = print
						+ "+";
						System.out.print(
						"+"
						+ " ");
					}
				}
				i++;
				maxExp--;
			}
		} else if (poly == 'C') {
			if (c.size() == 0) {
				return null;
			}
			maxExp = firstLast[0][2];
			leastExp = firstLast[1][2];
			int i = 0;
			print = "";
			while (maxExp >= leastExp) {
				if (c.get(i) != null
						&& (int) c.get(i) != 0) {
					if (maxExp == 0) {
						print = print
						+ c.get(i);
						System.out.print(
						c.get(i)
						+ " ");
					} else if (maxExp == 1) {
						if ((int) c.get(i) != 1) {
							System.out.print(
							c.get(i)
							+ "x" + " ");
							print = print
							+ c.get(i)
						+ "x";
						} else {
							System.out.print(
							c.get(i)
							+ "x"
							+ " ");
							print = print
							+ "x";
						}
					} else {
						if ((int) c.get(i) != 1) {
							System.out.print(
							c.get(i)
							+ "x^" + maxExp
							+ " ");
							print = print
							+ c.get(i)
							+ "x^"
							+ maxExp;
						} else {
							print = print
							+ "x^"
							+ maxExp;
							System.out.print("x^"
							+ maxExp
							+ " ");
						}
					}
				}
				if (maxExp != leastExp) {
					if ((int) c.get(i + 1) > 0) {
						print = print + "+";
						System.out.print("+"
								+ " ");
					}
				}
				i++;
				maxExp--;
			}
		} else if (poly == 'R') {
			if (r.size() == 0) {
				return null;
			}
			maxExp = firstLast[0][3];
			leastExp = firstLast[1][3];
			int i = 0;
			print = "";
			while (maxExp >= leastExp) {
				if (r.get(i) != null
						&& (int) r.get(i) != 0) {
					if (maxExp == 0) {
						print = print
								+ r.get(i);
						System.out.print(
								r.get(i)
								+ " ");
					} else if (maxExp == 1) {
						if ((int) r.get(i) != 1) {
							System.out.print(
									r.get(i)
									+ "x"
									+ " ");
							print = print
							+ r.get(i)
						+ "x";
						} else {
							System.out.print(
								r.get(i)
									+ "x"
								+ " ");
							print = print
									+ "x";
						}
					} else {
						if ((int) r.get(i) != 1) {
							System.out.print(
									r.get(i)
									+ "x^"
									+ maxExp
									+ " ");
							print = print
							+ r.get(i)
							+ "x^" + maxExp;
						} else {
							print = print
							+ "x^"
							+ maxExp;
							System.out.print(
								"x^"
							+ maxExp
							+ " ");
						}
					}
				}
				if (maxExp != leastExp) {
					if ((int) r.get(i + 1) > 0) {
						print = print
							+ "+";
						System.out.print("+"
						+ " ");
					}
				}
				i++;
				maxExp--;
			}
		}
		return print;
	}

	@Override
	public void clearPolynomial(final char poly) {
		// TODO Auto-generated method stub
		if (poly != 'A' && poly != 'B' && poly != 'C') {
			throw new IllegalArgumentException(
					"Operation"
					+ " on polynomial "
		+ poly + " is not permitted");
		}
		if (poly == 'A') {
			a.clear();
		} else if (poly == 'B') {
			b.clear();
		} else if (poly == 'C') {
			c.clear();
		}
	}

	@Override
	public float evaluatePolynomial(final char poly, final float value) {
		// TODO Auto-generated method stub
		if (poly != 'A' && poly != 'B' && poly != 'C') {
			throw new IllegalArgumentException("Operation"
					+ " on polynomial "
		+ poly + " is not permitted");
		}
		int maxExp = 0;
		int leastExp = 0;
		float evaluate = 0;
		if (poly == 'A') {
			if (a.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException("Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			/*
			if (a.size() == 0) {
				return 0;
			}
			*/
			maxExp = firstLast[0][0];
			leastExp = firstLast[1][0];
			int i = 0;
			int get = 0;
			float get1 = 0;
			if (leastExp < 0 && value == 0) {
				throw new IllegalArgumentException();
			}
			while (maxExp >= leastExp) {
				if (a.get(i) != null || (int) b.get(i) != 0) {
					get = (int) a.get(i);
					get1 = (float) get;
					evaluate = (float) (evaluate
							+ (get1
							* (pow(value,
							maxExp))));
				}
				i++;
				maxExp--;
			}
			return (float) evaluate;
		} else if (poly == 'B') {
			if (b.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException("Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			/*
			if (b.size() == 0) {
				return 0;
			}
			*/
			maxExp = firstLast[0][1];
			leastExp = firstLast[1][1];
			int i = 0;
			int get = 0;
			float get1 = 0;
			while (maxExp >= leastExp) {
				if (maxExp < 0 && value == 0) {
					throw new IllegalArgumentException();
				}
				if (b.get(i) != null || (int) b.get(i) != 0) {
					get = (int) b.get(i);
					get1 = (float) get;
					evaluate = (float) (evaluate
							+ (get1
							* (pow(value,
							maxExp))));
				}
				i++;
				maxExp--;
			}
			return (float) evaluate;
		} else if (poly == 'C') {
			if (a.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException("Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			/*
			if (c.size() == 0) {
				return 0;
			}
			*/
			maxExp = firstLast[0][2];
			leastExp = firstLast[1][2];
			int i = 0;
			int get = 0;
			float get1;
			while (maxExp >= leastExp) {
				if (maxExp < 0 && value == 0) {
					throw new IllegalArgumentException();
				}
				if (c.get(i) != null || (int) c.get(i) != 0) {
					get = (int) c.get(i);
					get1 = (float) get;
					evaluate = (float) (evaluate
							+ (get1
							* (pow(value,
							maxExp))));
				}
				i++;
				maxExp--;
			}
			return (float) evaluate;
		}
		return 0;
	}

	@Override
	public int[][] add(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		if (poly1 != 'A' && poly1 != 'B' && poly1 != 'C') {
			throw new IllegalArgumentException("Operation"
					+ " on polynomial "
					+ poly1 + " is not "
							+ "permitted");
		}
		if (poly2 != 'A' && poly2 != 'B' && poly2 != 'C') {
			throw new IllegalArgumentException("Operation"
					+ " on polynomial "
					+ poly2 + " is not"
							+ " permitted");
		}
		int maxExp1 = 0;
		int maxExp2 = 0;
		int i = 0;
		if (!r.isEmpty()) {
			r.clear();
		}
		int[][] add = new int[2 * a.size()
		                      + 2 * b.size()
		                      + 2 * c.size()][2];
		if (poly1 == 'A') {
			if (a.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException("Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			maxExp1 = firstLast[0][0];
			if (negative == 'A') {
				for (i = 0; i < a.size(); i++) {
					add[i][0] = (int) -1 * (int) a.get(i);
					add[i][1] = maxExp1;
					maxExp1--;
				}
			} else {
				for (i = 0; i < a.size(); i++) {
					add[i][0] = (int) a.get(i);
					add[i][1] = maxExp1;
					maxExp1--;
				}
			}
			if (poly2 == 'A') {
				maxExp2 = firstLast[0][0];
				for (; i < a.size() + a.size(); i++) {
					add[i][0] = (int) a.get(i - a.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'B') {
				if (b.isEmpty()) {
					System.out.println("Solver"
							+ " evaluated unseted"
							+ " polynomial");
					throw new IllegalArgumentException(
							"Solver "
							+ "evaluated unseted"
							+ " polynomial");
				}
				maxExp2 = firstLast[0][1];
				for (; i < a.size() + b.size(); i++) {
					add[i][0] = (int) b.get(i
							- a.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'C') {
				if (c.isEmpty()) {
					System.out.println("Solver"
							+ " evaluated unseted"
							+ " polynomial");
					throw new IllegalArgumentException(
							"Solver "
							+ "evaluated unseted"
							+ " polynomial");
				}
				maxExp2 = firstLast[0][2];
				for (; i < a.size() + c.size(); i++) {
					add[i][0] = (int) c.get(i - a.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			setPolynomial((char) 220, add);
		} else if (poly1 == 'B') {
			if (b.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			maxExp1 = firstLast[0][1];
			if (negative == 'B') {
				for (i = 0; i < b.size(); i++) {
					add[i][0] = (int) -1 * (int) b.get(i);
					add[i][1] = maxExp1;
					maxExp1--;
				}
			} else {
				for (i = 0; i < b.size(); i++) {
					add[i][0] = (int) b.get(i);
					add[i][1] = maxExp1;
					maxExp1--;
				}
			}
			if (poly2 == 'A') {
				if (a.isEmpty()) {
					System.out.println("Solver"
							+ " evaluated unseted"
							+ " polynomial");
					throw new IllegalArgumentException(
							"Solver "
							+ "evaluated unseted"
							+ " polynomial");
				}
				maxExp2 = firstLast[0][0];
				for (; i < b.size() + a.size(); i++) {
					add[i][0] = (int) a.get(i
							- b.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'B') {
				maxExp2 = firstLast[0][1];
				for (; i < b.size() + b.size(); i++) {
					add[i][0] = (int) b.get(i
							- b.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'C') {
				if (c.isEmpty()) {
					System.out.println("Solver"
							+ " evaluated unseted"
							+ " polynomial");
					throw new IllegalArgumentException(
							"Solver "
							+ "evaluated unseted"
							+ " polynomial");
				}
				maxExp2 = firstLast[0][2];
				for (; i < b.size() + c.size(); i++) {
					add[i][0] = (int) c.get(i - b.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			setPolynomial((char) 220, add);
		} else if (poly1 == 'C') {
			if (c.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			maxExp1 = firstLast[0][2];
			if (negative == 'C') {
				for (i = 0; i < c.size(); i++) {
					add[i][0] = (int) -1 * (int) c.get(i);
					add[i][1] = maxExp1;
					maxExp1--;
				}
			} else {
				for (i = 0; i < c.size(); i++) {
					add[i][0] = (int) c.get(i);
					add[i][1] = maxExp1;
					maxExp1--;
				}
			}
			if (poly2 == 'A') {
				if (a.isEmpty()) {
					System.out.println("Solver"
							+ " evaluated unseted"
							+ " polynomial");
					throw new IllegalArgumentException(
							"Solver "
							+ "evaluated unseted"
							+ " polynomial");
				}
				maxExp2 = firstLast[0][0];
				for (; i < c.size() + a.size(); i++) {
					add[i][0] = (int) a.get(i - c.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'B') {
				if (b.isEmpty()) {
					System.out.println("Solver"
							+ " evaluated unseted"
							+ " polynomial");
					throw new IllegalArgumentException(
							"Solver "
							+ "evaluated unseted"
							+ " polynomial");
				}
				maxExp2 = firstLast[0][1];
				for (; i < c.size() + b.size(); i++) {
					add[i][0] = (int) b.get(i - c.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'C') {
				if (c.isEmpty()) {
					System.out.println("Solver"
							+ " evaluated unseted"
							+ " polynomial");
					throw new IllegalArgumentException(
							"Solver "
							+ "evaluated unseted"
							+ " polynomial");
				}
				maxExp2 = firstLast[0][2];
				for (; i < c.size() + c.size(); i++) {
					add[i][0] = (int) c.get(i - c.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			setPolynomial((char) 220, add);
		}

		int[][] reArr = new int[r.size()][2];
		int l = 0;
		for (int j = 0; r.get(j) != null; j++) {
			if (r.get(j) != (Object) 0) {
				reArr[l][0] = (int) r.get(j);
				reArr[l][1] = firstLast[0][3] - j;
				l++;
			}
		}
		int count = 0;
		int maxExp = reArr[0][1];
		int[][] multi1 = new int[r.size()][2];
		for (int j = 0; j < r.size(); j++) {
			if ((int) r.get(j) != 0) {
				multi1[count][0] = (int) r.get(j);
				multi1[count][1] = maxExp;
				count++;
			}
			maxExp--;
		}
		return multi1;
		//return reArr;
	}

	@Override
	public int[][] subtract(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		if (poly1 != 'A' && poly1 != 'B' && poly1 != 'C') {
			throw new IllegalArgumentException("Operation"
					+ " on polynomial "
		+ poly1 + " is not permitted");
		}
		if (poly2 != 'A' && poly2 != 'B' && poly2 != 'C') {
			throw new IllegalArgumentException("Operation"
					+ " on polynomial "
		+ poly2 + " is not permitted");
		}
		int i = 0;
		if (!r.isEmpty()) {
			r.clear();
		}
		if (poly2 == 'A') {
			if (a.isEmpty()) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException(
						"Operation"
						+ " on polynomial "
			+ poly2 + " is not permitted");
			}
			negative = 'A';
			while (a.get(i) != null) {
				a.set(i, -1 * (int) a.get(i));
				i++;
			}
		} else if (poly2 == 'B') {
			if (b.isEmpty()) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException(
						"Operation"
						+ " on polynomial "
			+ poly2 + " is not permitted");
			}
			negative = 'B';
			while (b.get(i) != null) {
				b.set(i, -1 * (int) b.get(i));
				i++;
			}
		} else if (poly2 == 'C') {
			if (c.isEmpty()) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException(
						"Operation"
						+ " on polynomial "
			+ poly2 + " is not permitted");
			}
			negative = 'C';
			while (c.get(i) != null) {
				c.set(i, -1 * (int) c.get(i));
				i++;
			}
		}
		int[][] x = add(poly1, poly2);
		i = 0;
		if (negative == 'A') {
			while (a.get(i) != null) {
				a.set(i, -1 * (int) a.get(i));
				i++;
			}
		}
		if (negative == 'B') {
			while (b.get(i) != null) {
				b.set(i, -1 * (int) b.get(i));
				i++;
			}
		}
		if (negative == 'C') {
			while (c.get(i) != null) {
				c.set(i, -1 * (int) c.get(i));
				i++;
			}
		}
		int[][] y = new int[1][2];
		if (x.length == 0) {
			y[0][0] = 0;
			y[0][1] = 0;
			return y;
		}
		return x;
	}

	@Override
	public int[][] multiply(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		if (poly1 != 'A' && poly1 != 'B' && poly1 != 'C') {
			throw new IllegalArgumentException(
					"Operation"
					+ " on polynomial "
		+ poly1 + " is not permitted");
		}
		if (poly2 != 'A' && poly2 != 'B' && poly2 != 'C') {
			throw new IllegalArgumentException(
					"Operation"
					+ " on polynomial "
		+ poly2 + " is not permitted");
		}
		int counter = 0;
		int muliExp = 0;
		int multiMax = 0;
		int[][] multi = new int[(a.size() + 1)
		                        * (b.size() + 1)
		                        * (c.size() + 1)
		                        * (a.size() + 1)
		                        * (b.size() + 1)
				* (c.size() + 1)][2];
		if (!r.isEmpty()) {
			r.clear();
		}
		// check if poly2 insert to subtraction.
		if (negative != '0') {
			int i = 0;
			if (!r.isEmpty()) {
				r.clear();
			}
			if (negative == 'A') {
				while (a.get(i) != null) {
					a.set(i, -1 * (int) a.get(i));
					i++;
				}
			} else if (negative == 'B') {
				while (b.get(i) == null) {
					b.set(i, -1 * (int) b.get(i));
					i++;
				}
			} else if (negative == 'C') {
				while (c.get(i) == null) {
					c.set(i, -1 * (int) c.get(i));
					i++;
				}
			}
		}
		negative = '0';
		if (poly1 == 'A' && poly2 == 'B') {
			if (a.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			} else if (b.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			muliExp = firstLast[0][0] + firstLast[0][1];
			for (int i = 0; i < a.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < b.size(); j++) {
					multi[counter][0] = (int) a.get(i)
							* (int) b.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'A' && poly2 == 'C') {
			if (a.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			} else if (c.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			muliExp = firstLast[0][0] + firstLast[0][2];
			for (int i = 0; i < a.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < c.size(); j++) {
					multi[counter][0] = (int) a.get(i)
							* (int) c.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'A' && poly2 == 'A') {
			if (a.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			muliExp = firstLast[0][0] + firstLast[0][0];
			for (int i = 0; i < a.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < a.size(); j++) {
					multi[counter][0] = (int) a.get(i)
							* (int) a.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'B' && poly2 == 'A') {
			if (b.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			} else if (a.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			muliExp = firstLast[0][1] + firstLast[0][0];
			for (int i = 0; i < b.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < a.size(); j++) {
					multi[counter][0] = (int) b.get(i)
							* (int) a.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'B' && poly2 == 'B') {
			if (b.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			muliExp = firstLast[0][1] + firstLast[0][1];
			for (int i = 0; i < b.size(); i++) {
				multiMax = muliExp;
 				for (int j = 0; j < b.size(); j++) {
					multi[counter][0] = (int) b.get(i)
							* (int) b.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'B' && poly2 == 'C') {
			if (b.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			} else if (c.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			muliExp = firstLast[0][1] + firstLast[0][2];
			for (int i = 0; i < b.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < c.size(); j++) {
					multi[counter][0] = (int) b.get(i)
							* (int) c.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'C' && poly2 == 'A') {
			if (c.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			} else if (a.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			muliExp = firstLast[0][2] + firstLast[0][0];
			for (int i = 0; i < c.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < a.size(); j++) {
					multi[counter][0] = (int) c.get(i)
							* (int) a.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'C' && poly2 == 'B') {
			if (c.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			} else if (b.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			muliExp = firstLast[0][2] + firstLast[0][1];
			for (int i = 0; i < c.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < b.size(); j++) {
					multi[counter][0] = (int) c.get(i)
							* (int) b.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'C' && poly2 == 'C') {
			if (c.isEmpty()) {
				System.out.println("Solver"
						+ " evaluated unseted"
						+ " polynomial");
				throw new IllegalArgumentException(
						"Solver "
						+ "evaluated unseted"
						+ " polynomial");
			}
			muliExp = firstLast[0][2] + firstLast[0][2];
			for (int i = 0; i < c.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < c.size(); j++) {
					multi[counter][0] = (int) c.get(i)
							* (int) c.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		}
		int count = 0;
		int maxExp = multi[0][1];
		int c = 0;
		for (int ii = 0; ii < r.size(); ii++) {
			if ((int) r.get(ii) != 0) {
				c++;
			}
		}
		int[][] multi1 = new int[c][2];
		for (int i = 0; i < r.size(); i++) {
			if ((int) r.get(i) != 0) {
				multi1[count][0] = (int) r.get(i);
				multi1[count][1] = maxExp;
				count++;
			}
			maxExp--;
		}
		return multi1;
	}

	/**
	 *
	 * @param terms
	 *            array of [coefficients][exponents]
	 */
	private void order(final int[][] terms) {
		// TODO Auto-generated method stub
		for (int i = 0; i < terms.length - 1; i++) {
			for (int j = i + 1; j < terms.length; j++) {
				if (terms[j][1] > terms[i][1]) {
					terms[i][1] = terms[j][1] ^ terms[i][1];
					terms[j][1] = terms[j][1] ^ terms[i][1];
					terms[i][1] = terms[j][1] ^ terms[i][1];
					terms[i][0] = terms[j][0] ^ terms[i][0];
					terms[j][0] = terms[j][0] ^ terms[i][0];
					terms[i][0] = terms[j][0] ^ terms[i][0];
				}
			}
		}
	}
}
