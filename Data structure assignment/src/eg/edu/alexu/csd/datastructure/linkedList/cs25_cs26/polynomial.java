package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
import static java.lang.Math.pow;

public class polynomial implements IPolynomialSolver {

	Snode<Object> head = null;
	Snode<Object> tail = head;
	int size = 0;
	public ILinkedList a = (ILinkedList) new SingleLinkedList(null);
	public ILinkedList b = (ILinkedList) new SingleLinkedList(null);
	public ILinkedList c = (ILinkedList) new SingleLinkedList(null);
	public ILinkedList r = (ILinkedList) new SingleLinkedList(null);
	int first_last[][] = new int[2][4];
	char negative = '0';

	public polynomial(Snode<Object> head) {
		// TODO Auto-generated constructor stub
		this.head = head;
	}

	@Override
	public void setPolynomial(char poly, int[][] terms) {
		// TODO Auto-generated method stub
		int counter = 0;
		order(terms);
		if (poly == 'A') {
			if (a.isEmpty() == false) {
				a.clear();
			}
			first_last[0][0] = terms[0][1];
			first_last[1][0] = terms[terms.length - 1][1];
			a.add(terms[0][0]);
			for (int i = 0; i < terms.length - 1; i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					a.set(counter, (int) a.get(counter) + terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					a.add(terms[i + 1][0]);
					counter++;
					// a.set(i + 1, terms[i + 1][0]);
				} else {
					for (int j = terms[i][1] - 1; j > terms[i + 1][1]; j--) {
						a.add(0);
						counter++;
						// a.set(i + 1, 0);
					}
					a.add(terms[i + 1][0]);
				}
			}

		} else if (poly == 'B') {
			if (b.isEmpty() == false) {
				b.clear();
			}
			first_last[0][1] = terms[0][1];
			first_last[1][1] = terms[terms.length - 1][1];
			b.add(terms[0][0]);
			for (int i = 0; i < terms.length - 1; i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					b.set(counter, (int) b.get(counter) + terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					b.add(terms[i + 1][0]);
					// b.set(i + 1, terms[i + 1][0]);
					counter++;
				} else {
					for (int j = terms[i][1] - 1; j > terms[i + 1][1]; j--) {
						b.add(0);
						// b.set(i + 1, 0);
						counter++;
					}
					b.add(terms[i + 1][0]);
				}
			}
		} else if (poly == 'C') {
			if (b.isEmpty() == false) {
				b.clear();
			}
			first_last[0][2] = terms[0][1];
			first_last[1][2] = terms[terms.length - 1][1];
			c.add(terms[0][0]);
			for (int i = 0; i < terms.length - 1; i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					c.set(counter, (int) c.get(counter) + terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					c.add(terms[i + 1][0]);
					// c.set(i + 1, terms[i + 1][0]);
					counter++;
				} else {
					for (int j = terms[i][1] - 1; j > terms[i + 1][1]; j--) {
						c.add(0);
						// c.set(i + 1, 0);
						counter++;
					}
					c.add(terms[i + 1][0]);
				}
			}
		} else if (poly == 220) {
			if (r.isEmpty() == false) {
				r.clear();
			}
			first_last[0][3] = terms[0][1];
			first_last[1][3] = terms[terms.length - 1][1];
			r.add(terms[0][0]);
			for (int i = 0; i < terms.length - 1; i++) {
				if (terms[i][1] == terms[i + 1][1]) {
					r.set(counter, (int) r.get(counter) + terms[i + 1][0]);
				} else if (terms[i][1] - terms[i + 1][1] == 1) {
					r.add(terms[i + 1][0]);
					// r.set(i + 1, terms[i + 1][0]);
					counter++;
				} else {
					for (int j = terms[i][1] - 1; j > terms[i + 1][1]; j--) {
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
	public String print(char poly) {
		// TODO Auto-generated method stub
		int maxExp = 0;
		int leastExp = 0;
		if (poly == 'A') {
			if (a.size() == 0) {
				return null;
			}
			maxExp = first_last[0][0];
			leastExp = first_last[1][0];
			int i = 0;
			while (maxExp >= leastExp) {
				if (a.get(i) != null && (int) a.get(i) != 0) {
					if (maxExp == 0) {
						System.out.print(a.get(i) + " ");
					} else {
						System.out.print(a.get(i) + "X^" + maxExp + " ");
					}
					if (maxExp != leastExp) {
						System.out.print("+" + " ");
					}
				}
				i++;
				maxExp--;
			}
		} else if (poly == 'B') {

			if (b.size() == 0) {
				return null;
			}

			maxExp = first_last[0][1];
			leastExp = first_last[1][1];
			int i = 0;
			while (maxExp >= leastExp) {
				if (b.get(i) != null && (int) b.get(i) != 0) {
					if (maxExp == 0) {
						System.out.print(b.get(i) + " ");
					} else {
						System.out.print(b.get(i) + "X^" + maxExp + " ");
					}
					if (maxExp != leastExp) {
						System.out.print("+" + " ");
					}
				}
				i++;
				maxExp--;
			}
		} else if (poly == 'C') {
			if (c.size() == 0) {
				return null;
			}
			maxExp = first_last[0][2];
			leastExp = first_last[1][2];
			int i = 0;
			while (maxExp >= leastExp) {
				if (c.get(i) != null && (int) c.get(i) != 0) {
					if (maxExp == 0) {
						System.out.print(c.get(i) + " ");
					} else {
						System.out.print(c.get(i) + "X^" + maxExp + " ");
					}
					if (maxExp != leastExp) {
						System.out.print("+" + " ");
					}
				}
				i++;
				maxExp--;
			}
		} else if (poly == 'R') {
			if (r.size() == 0) {
				return null;
			}
			maxExp = first_last[0][3];
			leastExp = first_last[1][3];
			int i = 0;
			while (maxExp >= leastExp) {
				if (r.get(i) != null && (int) r.get(i) != 0) {
					if (maxExp == 0) {
						System.out.print(r.get(i) + " ");
					} else {
						System.out.print(r.get(i) + "X^" + maxExp + " ");
					}
					if (maxExp != leastExp) {
						System.out.print("+" + " ");
					}
				}
				i++;
				maxExp--;
			}
		}

		return null;
	}

	@Override
	public void clearPolynomial(char poly) {
		// TODO Auto-generated method stub
		if (poly == 'A') {
			a.clear();
		} else if (poly == 'B') {
			b.clear();
		} else if (poly == 'C') {
			c.clear();
		}
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		// TODO Auto-generated method stub
		int maxExp = 0;
		int leastExp = 0;
		float evaluate = 0;
		if (poly == 'A') {
			if (a.size() == 0) {
				return 0;
			}
			maxExp = first_last[0][0];
			leastExp = first_last[1][0];
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
					evaluate = (float) (evaluate + (get1 * (pow(value, maxExp))));
				}
				i++;
				maxExp--;
			}
			return (float) evaluate;
		} else if (poly == 'B') {

			if (b.size() == 0) {
				return 0;
			}

			maxExp = first_last[0][1];
			leastExp = first_last[1][1];
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
					evaluate = (float) (evaluate + (get1 * (pow(value, maxExp))));
				}
				i++;
				maxExp--;
			}
			return (float) evaluate;
		} else if (poly == 'C') {
			if (c.size() == 0) {
				return 0;
			}
			maxExp = first_last[0][2];
			leastExp = first_last[1][2];
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
					evaluate = (float) (evaluate + (get1 * (pow(value, maxExp))));
				}
				i++;
				maxExp--;
			}
			return (float) evaluate;
		}
		return 0;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		// TODO Auto-generated method stub
		int maxExp1 = 0;
		int maxExp2 = 0;
		int i = 0;
		if (r.isEmpty() == false) {
			r.clear();
		}
		int add[][] = new int[a.size() + b.size() + c.size()][2];
		if (poly1 == 'A') {
			if (a.isEmpty() == true) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException();
			}
			maxExp1 = first_last[0][0];
			for (i = 0; i < a.size(); i++) {
				add[i][0] = (int) a.get(i);
				add[i][1] = maxExp1;
				maxExp1--;
			}
			if (poly2 == 'A') {
				maxExp2 = first_last[0][0];
				for (; i < a.size() + a.size(); i++) {
					add[i][0] = (int) a.get(i - a.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'B') {
				if (b.isEmpty() == true) {
					System.out.println("Variable not set");
					throw new IllegalArgumentException();
				}
				maxExp2 = first_last[0][1];
				for (; i < a.size() + b.size(); i++) {
					add[i][0] = (int) b.get(i - a.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'C') {
				if (c.isEmpty() == true) {
					System.out.println("Variable not set");
					throw new IllegalArgumentException();
				}
				maxExp2 = first_last[0][2];
				for (; i < a.size() + c.size(); i++) {
					add[i][0] = (int) c.get(i - a.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			setPolynomial((char) 220, add);
		} else if (poly1 == 'B') {
			if (b.isEmpty() == true) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException();
			}
			maxExp1 = first_last[0][1];
			for (i = 0; i < b.size(); i++) {
				add[i][0] = (int) b.get(i);
				add[i][1] = maxExp1;
				maxExp1--;
			}
			if (poly2 == 'A') {
				if (a.isEmpty() == true) {
					System.out.println("Variable not set");
					throw new IllegalArgumentException();
				}
				maxExp2 = first_last[0][0];
				for (; i < b.size() + a.size(); i++) {
					add[i][0] = (int) a.get(i - b.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'B') {
				maxExp2 = first_last[0][1];
				for (; i < b.size() + b.size(); i++) {
					add[i][0] = (int) b.get(i - b.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'C') {
				if (c.isEmpty() == true) {
					System.out.println("Variable not set");
					throw new IllegalArgumentException();
				}
				maxExp2 = first_last[0][2];
				for (; i < b.size() + c.size(); i++) {
					add[i][0] = (int) c.get(i - b.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			setPolynomial((char) 220, add);
		} else if (poly1 == 'C') {
			if (c.isEmpty() == true) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException();
			}
			maxExp1 = first_last[0][2];
			for (i = 0; i < c.size(); i++) {
				add[i][0] = (int) c.get(i);
				add[i][1] = maxExp1;
				maxExp1--;
			}
			if (poly2 == 'A') {
				if (a.isEmpty() == true) {
					System.out.println("Variable not set");
					throw new IllegalArgumentException();
				}
				maxExp2 = first_last[0][0];
				for (; i < c.size() + a.size(); i++) {
					add[i][0] = (int) a.get(i - c.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'B') {
				if (b.isEmpty() == true) {
					System.out.println("Variable not set");
					throw new IllegalArgumentException();
				}
				maxExp2 = first_last[0][1];
				for (; i < c.size() + b.size(); i++) {
					add[i][0] = (int) b.get(i - c.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			if (poly2 == 'C') {
				maxExp2 = first_last[0][2];
				for (; i < c.size() + c.size(); i++) {
					add[i][0] = (int) c.get(i - c.size());
					add[i][1] = maxExp2;
					maxExp2--;
				}
			}
			setPolynomial((char) 220, add);
		}
		return null;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		// TODO Auto-generated method stub
		int i = 0;
		if (r.isEmpty() == false) {
			r.clear();
		}
		if (poly2 == 'A') {
			if (a.isEmpty() == true) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException();
			}
			negative = 'A';
			while (a.get(i) != null) {
				a.set(i, -1 * (int) a.get(i));
				i++;
			}
		} else if (poly2 != 'B') {
			if (b.isEmpty() == true) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException();
			}
			negative = 'B';
			while (b.get(i) == null) {
				b.set(i, -1 * (int) b.get(i));
				i++;
			}
		} else if (poly2 != 'C') {
			if (c.isEmpty() == true) {
				System.out.println("Variable not set");
				throw new IllegalArgumentException();
			}
			negative = 'C';
			while (c.get(i) == null) {
				c.set(i, -1 * (int) c.get(i));
				i++;
			}
		}
		add(poly1, poly2);
		return null;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		// TODO Auto-generated method stub
		int counter = 0;
		int muliExp = 0; // first_last[0][0] + first_last[0][1];
		int multiMax = 0;// first_last[0][0] + first_last[0][1];
		int multi[][] = new int[(a.size() + 1) * (b.size() + 1) * (c.size() + 1) * (a.size() + 1) * (b.size() + 1)
				* (c.size() + 1)][2];
		if (r.isEmpty() == false) {
			r.clear();
		}
		// check if poly2 insert to subtraction.
		if (negative != '0') {
			int i = 0;
			if (r.isEmpty() == false) {
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
			muliExp = first_last[0][0] + first_last[0][1];
			for (int i = 0; i < a.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < b.size(); j++) {
					multi[counter][0] = (int) a.get(i) * (int) b.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		}

		else if (poly1 == 'A' && poly2 == 'C') {
			muliExp = first_last[0][0] + first_last[0][2];
			for (int i = 0; i < a.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < c.size(); j++) {
					multi[counter][0] = (int) a.get(i) * (int) c.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		}

		else if (poly1 == 'A' && poly2 == 'A') {
			muliExp = first_last[0][0] + first_last[0][0];
			for (int i = 0; i < a.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < a.size(); j++) {
					multi[counter][0] = (int) a.get(i) * (int) a.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		}

		else if (poly1 == 'B' && poly2 == 'A') {
			muliExp = first_last[0][1] + first_last[0][0];
			for (int i = 0; i < b.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < a.size(); j++) {
					multi[counter][0] = (int) b.get(i) * (int) a.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		}

		else if (poly1 == 'B' && poly2 == 'B') {
			muliExp = first_last[0][1] + first_last[0][1];
			for (int i = 0; i < b.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < b.size(); j++) {
					multi[counter][0] = (int) b.get(i) * (int) b.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		}

		else if (poly1 == 'B' && poly2 == 'C') {
			muliExp = first_last[0][1] + first_last[0][2];
			for (int i = 0; i < b.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < c.size(); j++) {
					multi[counter][0] = (int) b.get(i) * (int) c.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		}

		else if (poly1 == 'C' && poly2 == 'A') {
			muliExp = first_last[0][2] + first_last[0][0];
			for (int i = 0; i < c.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < a.size(); j++) {
					multi[counter][0] = (int) c.get(i) * (int) a.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		}

		else if (poly1 == 'C' && poly2 == 'B') {
			muliExp = first_last[0][2] + first_last[0][1];
			for (int i = 0; i < c.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < b.size(); j++) {
					multi[counter][0] = (int) c.get(i) * (int) b.get(j);
					multi[counter][1] = multiMax;
					multiMax--;
					counter++;
				}
				muliExp--;
				// multiMax = multiMax + first_last[0][1] - 1;
			}
			setPolynomial((char) 220, multi);
		}

		else if (poly1 == 'C' && poly2 == 'C') {
			muliExp = first_last[0][2] + first_last[0][2];
			for (int i = 0; i < c.size(); i++) {
				multiMax = muliExp;
				for (int j = 0; j < c.size(); j++) {
					multi[counter][0] = (int) c.get(i) * (int) c.get(j);
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

	private void order(int[][] terms) {
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
