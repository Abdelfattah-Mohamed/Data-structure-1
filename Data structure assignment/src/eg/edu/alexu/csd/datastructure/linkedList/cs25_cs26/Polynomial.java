package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
import static java.lang.Math.pow;

public class Polynomial implements IPolynomialSolver {

	Snode head = null;
	Snode tail = head;
	int size = 0;
	public ILinkedList A = (ILinkedList) new SingleLinkedList();
	public ILinkedList B = (ILinkedList) new SingleLinkedList();
	public ILinkedList C = (ILinkedList) new SingleLinkedList();
	public ILinkedList R = (ILinkedList) new SingleLinkedList();
	int[][] firstLast = new int[2][4];
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
			if (A.isEmpty() == false) {
				A.clear();
			}
			firstLast[0][0] = terms[0][1];
			firstLast[1][0] = terms[terms.length - 1][1];
			A.add(terms[0][0]);
			for (int i = 0; i < terms.length - 1; i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					A.set(counter, (int) A.get(counter)
							+ terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					A.add(terms[i + 1][0]);
					counter++;
					// a.set(i + 1, terms[i + 1][0]);
				} else {
					for (int j = terms[i][1] - 1; j
							> terms[i + 1][1]; j--) {
						A.add(0);
						counter++;
						// a.set(i + 1, 0);
					}
					A.add(terms[i + 1][0]);
				}
			}

		} else if (poly == 'B') {
			if (B.isEmpty() == false) {
				B.clear();
			}
			firstLast[0][1] = terms[0][1];
			firstLast[1][1] = terms[terms.length - 1][1];
			B.add(terms[0][0]);
			for (int i = 0; i < terms.length - 1; i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					B.set(counter, (int) B.get(counter)
							+ terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					B.add(terms[i + 1][0]);
					// b.set(i + 1, terms[i + 1][0]);
					counter++;
				} else {
					for (int j = terms[i][1] - 1;
							j > terms[i + 1][1]; j--) {
						B.add(0);
						// b.set(i + 1, 0);
						counter++;
					}
					B.add(terms[i + 1][0]);
				}
			}
		} else if (poly == 'C') {
			if (B.isEmpty() == false) {
				B.clear();
			}
			firstLast[0][2] = terms[0][1];
			firstLast[1][2] = terms[terms.length - 1][1];
			C.add(terms[0][0]);
			for (int i = 0; i < terms.length - 1; i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					C.set(counter, (int) C.get(counter)
							+ terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					C.add(terms[i + 1][0]);
					// c.set(i + 1, terms[i + 1][0]);
					counter++;
				} else {
					for (int j = terms[i][1] - 1;
							j > terms[i + 1][1]; j--) {
						C.add(0);
						// c.set(i + 1, 0);
						counter++;
					}
					C.add(terms[i + 1][0]);
				}
			}
		} else if (poly == 220) {
			if (R.isEmpty() == false) {
				R.clear();
			}
			firstLast[0][3] = terms[0][1];
			firstLast[1][3] = terms[terms.length - 1][1];
			R.add(terms[0][0]);
			for (int i = 0; i < terms.length - 1; i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					R.set(counter, (int) R.get(counter)
							+ terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					R.add(terms[i + 1][0]);
					// r.set(i + 1, terms[i + 1][0]);
					counter++;
				} else {
					for (int j = terms[i][1] - 1;
							j > terms[i + 1][1]; j--) {
						R.add(0);
						// r.set(i + 1, 0);
						counter++;
					}
					R.add(terms[i + 1][0]);
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
			if (A.size() == 0) {
				return null;
			}
			maxExp = firstLast[0][0];
			leastExp = firstLast[1][0];
			int i = 0;
			while (maxExp >= leastExp) {
				if (A.get(i) != null &&
						(int) A.get(i) != 0) {
					if (maxExp == 0) {
						print = print + "A.get(i)";
						System.out.print(A.get(i) + " ");
					} else if (maxExp == 1) {
						print = print + "A.get(i)" + "X";
					} else {
						print = print + "A.get(i)"
					+ "X^" + "maxExp";
						System.out.print(A.get(i)
								+ "X^" + maxExp + " ");
					}
					if (maxExp != leastExp) {
						System.out.print("+" + " ");
					}
				}
				i++;
				maxExp--;
			}
		} else if (poly == 'B') {

			if (B.size() == 0) {
				return null;
			}

			maxExp = firstLast[0][1];
			leastExp = firstLast[1][1];
			int i = 0;
			print = "";
			while (maxExp >= leastExp) {
				if (B.get(i) != null && (int) B.get(i) != 0) {
					if (maxExp == 0) {
						print = print + "B.get(i)";
						System.out.print(B.get(i) + " ");
					} else if (maxExp == 1) {
						print = print + "B.get(i)" + "X";
					} else {
						print = print + "B.get(i)"
					+ "X^" + "maxExp";
						System.out.print(B.get(i)
								+ "X^" + maxExp + " ");
					}
					if (maxExp != leastExp) {
						System.out.print("+" + " ");
					}
				}
				i++;
				maxExp--;
			}
		} else if (poly == 'C') {
			if (C.size() == 0) {
				return null;
			}
			maxExp = firstLast[0][2];
			leastExp = firstLast[1][2];
			int i = 0;
			print = "";
			while (maxExp >= leastExp) {
				if (C.get(i) != null && (int) C.get(i) != 0) {
					if (maxExp == 0) {
						print = print + "C.get(i)";
						System.out.print(C.get(i)
								+ " ");
					} else if (maxExp == 1) {
						print = print + "C.get(i)"
					+ "X";
					} else {
						print = print + "C.get(i)"
					+ "X^" + "maxExp";
						System.out.print(C.get(i)
								+ "X^" + maxExp + " ");
					}
					if (maxExp != leastExp) {
						System.out.print("+" + " ");
					}
				}
				i++;
				maxExp--;
			}
		} else if (poly == 'R') {
			if (R.size() == 0) {
				return null;
			}
			maxExp = firstLast[0][3];
			leastExp = firstLast[1][3];
			int i = 0;
			print = "";
			while (maxExp >= leastExp) {
				if (R.get(i) != null
						&& (int) R.get(i) != 0) {
					if (maxExp == 0) {
						print = print + R.get(i);
						System.out.print(R.get(i) + " ");
					} else if (maxExp == 1) {
						print = print + R.get(i) + "X";
					} else {
						print = print + R.get(i) + "X^" + maxExp;
						System.out.print(R.get(i) + "X^" + maxExp + " ");
					}
					if (maxExp != leastExp) {
						System.out.print("+" + " ");
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
			throw new IllegalArgumentException("Operation on polynomial "
		+ poly + " is not permitted");
		}
		if (poly == 'A') {
			A.clear();
		} else if (poly == 'B') {
			B.clear();
		} else if (poly == 'C') {
			C.clear();
		}
	}

	@Override
	public float evaluatePolynomial(final char poly, final float value) {
		// TODO Auto-generated method stub
		if (poly != 'A' && poly != 'B' && poly != 'C') {
			throw new IllegalArgumentException("Operation on polynomial " 
		+ poly + " is not permitted");
		}
		int maxExp = 0;
		int leastExp = 0;
		float evaluate = 0;
		if (poly == 'A') {
			if (A.size() == 0) {
				return 0;
			}
			maxExp = firstLast[0][0];
			leastExp = firstLast[1][0];
			int i = 0;
			int get = 0;
			float get1 = 0;
			if (leastExp < 0 && value == 0) {
				throw new IllegalArgumentException();
			}
			while (maxExp >= leastExp) {
				if (A.get(i) != null || (int) B.get(i) != 0) {
					get = (int) A.get(i);
					get1 = (float) get;
					evaluate = (float) (evaluate +
							(get1 * (pow(value, maxExp))));
				}
				i++;
				maxExp--;
			}
			return (float) evaluate;
		} else if (poly == 'B') {

			if (B.size() == 0) {
				return 0;
			}

			maxExp = firstLast[0][1];
			leastExp = firstLast[1][1];
			int i = 0;
			int get = 0;
			float get1 = 0;
			while (maxExp >= leastExp) {
				if (maxExp < 0 && value == 0) {
					throw new IllegalArgumentException();
				}
				if (B.get(i) != null || (int) B.get(i) != 0) {
					get = (int) B.get(i);
					get1 = (float) get;
					evaluate = (float) (evaluate +
							(get1 * (pow(value, maxExp))));
				}
				i++;
				maxExp--;
			}
			return (float) evaluate;
		} else if (poly == 'C') {
			if (C.size() == 0) {
				return 0;
			}
			maxExp = firstLast[0][2];
			leastExp = firstLast[1][2];
			int i = 0;
			int get = 0;
			float get1;
			while (maxExp >= leastExp) {
				if (maxExp < 0 && value == 0) {
					throw new IllegalArgumentException();
				}
				if (C.get(i) != null || (int) C.get(i) != 0) {
					get = (int) C.get(i);
					get1 = (float) get;
					evaluate = (float) (evaluate +
							(get1 * (pow(value, maxExp))));
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
			throw new IllegalArgumentException("Operation on polynomial " +
		poly1 + " is not permitted");
		}
		if (poly2 != 'A' && poly2 != 'B' && poly2 != 'C') {
			throw new IllegalArgumentException("Operation on polynomial " +
		poly2 + " is not permitted");
		}
		int maxExp1 = 0;
		int maxExp2 = 0;
		int i = 0;
		if (R.isEmpty() == false) {
			R.clear();
		}
		int add[][] = new int[A.size() + B.size() + C.size()][2];
		if (poly1 == 'A') {
			if (A.isEmpty() == true) {
				System.out.println("Solver evaluated unseted polynomial");
				throw new IllegalArgumentException("Solver "
						+ "evaluated unseted polynomial");
			}
			maxExp1 = firstLast[0][0];
			for (i = 0; i < A.size(); i++) {
				add[i][0] = (int) A.get(i);
				add[i][1] = maxExp1;
				maxExp1--;
			}
			if (poly2 == 'A') {
				maxExp2 = firstLast[0][0];
				for (; i < A.size() + A.size(); i++) {
					add[i][0] = (int) A.get(i - A.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'B') {
				if (B.isEmpty() == true) {
					System.out.println("Solver evaluated unseted polynomial");
					throw new IllegalArgumentException("Solver "
							+ "evaluated unseted polynomial");
				}
				maxExp2 = firstLast[0][1];
				for (; i < A.size() + B.size(); i++) {
					add[i][0] = (int) B.get(i - A.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'C') {
				if (C.isEmpty() == true) {
					System.out.println("Solver evaluated unseted polynomial");
					throw new IllegalArgumentException("Solver "
							+ "evaluated unseted polynomial");
				}
				maxExp2 = firstLast[0][2];
				for (; i < A.size() + C.size(); i++) {
					add[i][0] = (int) C.get(i - A.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			setPolynomial((char) 220, add);
		} else if (poly1 == 'B') {
			if (B.isEmpty() == true) {
				System.out.println("Solver evaluated unseted polynomial");
				throw new IllegalArgumentException("Solver "
						+ "evaluated unseted polynomial");
			}
			maxExp1 = firstLast[0][1];
			for (i = 0; i < B.size(); i++) {
				add[i][0] = (int) B.get(i);
				add[i][1] = maxExp1;
				maxExp1--;
			}
			if (poly2 == 'A') {
				if (A.isEmpty() == true) {
					System.out.println("Solver evaluated unseted polynomial");
					throw new IllegalArgumentException("Solver "
							+ "evaluated unseted polynomial");
				}
				maxExp2 = firstLast[0][0];
				for (; i < B.size() + A.size(); i++) {
					add[i][0] = (int) A.get(i - B.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'B') {
				maxExp2 = firstLast[0][1];
				for (; i < B.size() + B.size(); i++) {
					add[i][0] = (int) B.get(i - B.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'C') {
				if (C.isEmpty() == true) {
					System.out.println("Solver evaluated unseted polynomial");
					throw new IllegalArgumentException("Solver "
							+ "evaluated unseted polynomial");
				}
				maxExp2 = firstLast[0][2];
				for (; i < B.size() + C.size(); i++) {
					add[i][0] = (int) C.get(i - B.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			setPolynomial((char) 220, add);
		} else if (poly1 == 'C') {
			if (C.isEmpty() == true) {
				System.out.println("Solver evaluated unseted polynomial");
				throw new IllegalArgumentException("Solver "
						+ "evaluated unseted polynomial");
			}
			maxExp1 = firstLast[0][2];
			for (i = 0; i < C.size(); i++) {
				add[i][0] = (int) C.get(i);
				add[i][1] = maxExp1;
				maxExp1--;
			}
			if (poly2 == 'A') {
				if (A.isEmpty() == true) {
					System.out.println("Solver evaluated unseted polynomial");
					throw new IllegalArgumentException("Solver "
							+ "evaluated unseted polynomial");
				}
				maxExp2 = firstLast[0][0];
				for (; i < C.size() + A.size(); i++) {
					add[i][0] = (int) A.get(i - C.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'B') {
				if (B.isEmpty() == true) {
					System.out.println("Solver evaluated unseted polynomial");
					throw new IllegalArgumentException("Solver "
							+ "evaluated unseted polynomial");
				}
				maxExp2 = firstLast[0][1];
				for (; i < C.size() + B.size(); i++) {
					add[i][0] = (int) B.get(i - C.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'C') {
				if (C.isEmpty() == true) {
					System.out.println("Solver evaluated unseted polynomial");
					throw new IllegalArgumentException("Solver "
							+ "evaluated unseted polynomial");
				}
				maxExp2 = firstLast[0][2];
				for (; i < C.size() + C.size(); i++) {
					add[i][0] = (int) C.get(i - C.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			setPolynomial((char) 220, add);
		}

		int[][] re_arr = new int[R.size()][2];
		int l = 0;
		for (int j = 0; j < R.size(); j++) {
			if (R.get(j) != (Object) 0) {
				re_arr[l][0] = (int) R.get(j);
				re_arr[l][1] = firstLast[0][3] - j;
				l++;
			}
		}
		return re_arr;
	}

	@Override
	public int[][] subtract(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		if (poly1 != 'A' && poly1 != 'B' && poly1 != 'C') {
			throw new IllegalArgumentException("Operation on polynomial "
		+ poly1 + " is not permitted");
		}
		if (poly2 != 'A' && poly2 != 'B' && poly2 != 'C') {
			throw new IllegalArgumentException("Operation on polynomial "
		+ poly2 + " is not permitted");
		}
		int i = 0;
		if (R.isEmpty() == false) {
			R.clear();
		}
		if (poly2 == 'A') {
			if (A.isEmpty() == true) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException();
			}
			negative = 'A';
			while (A.get(i) != null) {
				A.set(i, -1 * (int) A.get(i));
				i++;
			}
		} else if (poly2 != 'B') {
			if (B.isEmpty() == true) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException();
			}
			negative = 'B';
			while (B.get(i) == null) {
				B.set(i, -1 * (int) B.get(i));
				i++;
			}
		} else if (poly2 != 'C') {
			if (C.isEmpty() == true) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException();
			}
			negative = 'C';
			while (C.get(i) == null) {
				C.set(i, -1 * (int) C.get(i));
				i++;
			}
		}
		add(poly1, poly2);
		return null;
	}

	@Override
	public int[][] multiply(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		if (poly1 != 'A' && poly1 != 'B' && poly1 != 'C') {
			throw new IllegalArgumentException("Operation on polynomial "
		+ poly1 + " is not permitted");
		}
		if (poly2 != 'A' && poly2 != 'B' && poly2 != 'C') {
			throw new IllegalArgumentException("Operation on polynomial "
		+ poly2 + " is not permitted");
		}
		int counter = 0;
		int muliExp = 0;
		int multiMax = 0;
		int multi[][] = new int[(A.size() + 1) * (B.size() + 1)
		                        * (C.size() + 1) * (A.size() + 1)
		                        * (B.size() + 1)
				* (C.size() + 1)][2];
		if (R.isEmpty() == false) {
			R.clear();
		}
		// check if poly2 insert to subtraction.
		if (negative != '0') {
			int i = 0;
			if (R.isEmpty() == false) {
				R.clear();
			}
			if (negative == 'A') {
				while (A.get(i) != null) {
					A.set(i, -1 * (int) A.get(i));
					i++;
				}
			} else if (negative == 'B') {
				while (B.get(i) == null) {
					B.set(i, -1 * (int) B.get(i));
					i++;
				}
			} else if (negative == 'C') {
				while (C.get(i) == null) {
					C.set(i, -1 * (int) C.get(i));
					i++;
				}
			}
		}
		negative = '0';
		if (poly1 == 'A' && poly2 == 'B') {
			muliExp = firstLast[0][0] + firstLast[0][1];
			for (int i = 0; i < A.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < B.size(); j++) {
					multi[counter][0] = (int) A.get(i) * (int) B.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'A' && poly2 == 'C') {
			muliExp = firstLast[0][0] + firstLast[0][2];
			for (int i = 0; i < A.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < C.size(); j++) {
					multi[counter][0] = (int) A.get(i) * (int) C.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'A' && poly2 == 'A') {
			muliExp = firstLast[0][0] + firstLast[0][0];
			for (int i = 0; i < A.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < A.size(); j++) {
					multi[counter][0] = (int) A.get(i) * (int) A.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'B' && poly2 == 'A') {
			muliExp = firstLast[0][1] + firstLast[0][0];
			for (int i = 0; i < B.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < A.size(); j++) {
					multi[counter][0] = (int) B.get(i) * (int) A.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'B' && poly2 == 'B') {
			muliExp = firstLast[0][1] + firstLast[0][1];
			for (int i = 0; i < B.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < B.size(); j++) {
					multi[counter][0] = (int) B.get(i) * (int) B.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'B' && poly2 == 'C') {
			muliExp = firstLast[0][1] + firstLast[0][2];
			for (int i = 0; i < B.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < C.size(); j++) {
					multi[counter][0] = (int) B.get(i) * (int) C.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'C' && poly2 == 'A') {
			muliExp = firstLast[0][2] + firstLast[0][0];
			for (int i = 0; i < C.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < A.size(); j++) {
					multi[counter][0] = (int) C.get(i) * (int) A.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'C' && poly2 == 'B') {
			muliExp = firstLast[0][2] + firstLast[0][1];
			for (int i = 0; i < C.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < B.size(); j++) {
					multi[counter][0] = (int) C.get(i) * (int) B.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		} else if (poly1 == 'C' && poly2 == 'C') {
			muliExp = firstLast[0][2] + firstLast[0][2];
			for (int i = 0; i < C.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < C.size(); j++) {
					multi[counter][0] = (int) C.get(i) * (int) C.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		}
		return multi;
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
