package eg.edu.alexu.csd.datastructure.stack.cs26;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 *
 * @author Abd El Fattah
 *
 */
public class InfixPosfix implements IExpressionEvaluator {
	@Override
	public String infixToPostfix(final String expression) {
		// TODO Auto-generated method stub
		StringBuilder sbl = new StringBuilder(expression);
		StringBuilder exp = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			if (sbl.charAt(i) != ' ') {
				exp.append( Character.toString(expression.charAt(i)));
			}
		}
		Stack a = (Stack) new Stack();
		StringBuilder str1 = new StringBuilder();
		int i = 0;
		if (exp.length() == 0) {
			throw new RuntimeException();
		}
		if (operation(exp.charAt(exp.length() - 1))) {
			throw new RuntimeException();
		}
		if ((exp.charAt(0) < '0' || exp.charAt(0) > '9')
		 && (exp.charAt(0) < 'a' || exp.charAt(0) > 'z')
		 && (exp.charAt(0) < 'A' || exp.charAt(0) > 'Z')
		 && (exp.charAt(0) != '(')) {
			throw new RuntimeException();
		}
		for (; i < exp.length(); i++) {
			if (exp.charAt(i) == ' ') {
				i++;
			}
			if (!operation(exp.charAt(i))) {
				if (unary(exp.charAt(i))) {
					throw new RuntimeException();
				}
				if (braces(exp.charAt(i))) {
					if (exp.charAt(i) == '(') {
						a.push(exp.charAt(i));
					} else {
						str1 = addB(a, str1);
					}
				}
				if (!braces(exp.charAt(i))) {
					if ((str1.length() != 0)
						&& (i > 0)
						&& (operation(exp.charAt(i - 1))
						|| exp.charAt(i - 1) == ' '
						|| braces(exp.charAt(i - 1)))) {
						str1.append(" ");
					}
					str1.append(Character.toString(
							exp.charAt(i)));
				}
			} else {
				if ((i < exp.length() - 1)
					&& operation(exp.charAt(i + 1))) {
					throw new RuntimeException();
				}
				if (a.size > 0) {
					if (exp.charAt(i) == '+'
						|| exp.charAt(i) == '-') {
						while (a.size > 0) {
							if ((char) a.peek()
								!= '(') {
								str1.append(" ");
								str1.append(Character.toString((char) a.pop()));
							} else {
								break;
							}
						}
						a.push(exp.charAt(i));
					} else if (exp.charAt(i) == '*'
						|| exp.charAt(i) == '/') {
						if ((char) a.peek() == '*'
							|| (char) a.peek()
							== '/') {
							str1.append(" ");
							str1.append(Character.toString((char) a.pop()));
							a.push(exp.charAt(i));
						} else {
							a.push(exp.charAt(i));
						}
					}
				} else {
					a.push(exp.charAt(i));
				}
			}
		}
		while (a.size() > 1) {
			if ((char) a.peek() == '(') {
				throw new RuntimeException();
			}
			str1.append(" ");
			str1.append(Character.toString((char) a.pop()));
		}
		if (a.size() == 1) {
			if ((char) a.peek() == '(') {
				throw new RuntimeException();
			}
			str1.append(" ");
			str1.append(Character.toString((char) a.pop()));
		}
		if (str1.length() == 0) {
			throw new RuntimeException();
		}
		String str2 = str1.toString();
		return str2;
	}

	@Override
	public final int evaluate(final String expression) {
		// TODO Auto-generated method stub
		StringBuilder sbl = new StringBuilder(expression);
		if (!operation(
				sbl.charAt(sbl.length() - 1))) {
			return 0;
		}
		int size = 0;
		for (int i = 0; i < sbl.length(); i++) {
			if (sbl.charAt(i) == ' ') {
				size++;
			}
		}
		StringBuilder[] exp = new StringBuilder[size + 1];
		int co = 0;
		for (int i = 0; i < sbl.length(); i++) {
			if (exp[co] == null) {
				exp[co].insert(0, "");
			}
			if (sbl.charAt(i) != ' ') {
				exp[co].append(sbl.charAt(i));
			} else {
				co++;
			}
		}
		Stack a = (Stack) new Stack();
		float r, l;
		float t;
		for (int i = 0; i <= co; i++) {
			if (!operation(exp[i].charAt(0))) {
				if (exp[i].charAt(0) < '0'
					|| exp[i].charAt(0) > '9') {
					throw new RuntimeException();
				}
				a.push(exp[i]);
			} else {
				if (exp[i].charAt(0) == '+') {
					r = Float.parseFloat((String) a.pop());
					l = Float.parseFloat((String) a.pop());
					t = r + l;
					a.push(Float.toString(t));
				} else if (exp[i].charAt(0) == '*') {
					r = Float.parseFloat((String) a.pop());
					l = Float.parseFloat((String) a.pop());
					t = r * l;
					a.push(Float.toString(t));
				} else if (exp[i].charAt(0) == '-') {
					r = Float.parseFloat((String) a.pop());
					l = Float.parseFloat((String) a.pop());
					t = l - r;
					a.push(Float.toString(t));
				} else if (exp[i].charAt(0) == '/') {
					r = Float.parseFloat((String) a.pop());
					l = Float.parseFloat((String) a.pop());
					t = l / r;
					a.push(Float.toString(t));
				}
			}
		}
		return (int) Float.parseFloat((String) a.pop());
	}

	/**
	 *
	 * @param x
	 *            to check if char in operation.
	 * @return boolean.
	 */
	private boolean operation(final char x) {
		if (x == '+') {
			return true;
		} else if (x == '-') {
			return true;
		} else if (x == '/') {
			return true;
		} else if (x == '*') {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param x
	 *            to check if char in unary.
	 * @return boolean
	 */
	private boolean unary(final char x) {
		if (x == '~') {
			return true;
		} else if (x == '!') {
			return true;
		} else if (x == '&') {
			return true;
		} else if (x == '|') {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param x
	 *            to check braces.
	 * @return boolean.
	 */
	private boolean braces(final char x) {
		if (x == '(') {
			return true;
		} else if (x == ')') {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param a
	 *            to remove braces from stack.
	 * @param str1
	 *            to add character between braces.
	 * @return string after append.
	 */
	private StringBuilder addB(final Stack a, final StringBuilder str1) {
		// TODO Auto-generated method
		StringBuilder str = new StringBuilder(str1);
		boolean x = false;
		while (a.size > 0) {
			if ((char) a.peek() == '(') {
				a.pop();
				x = true;
				break;
			}
			str.append(" ");
			str.append(Character.toString((char) a.pop()));
		}
		if (!x) {
			throw new RuntimeException();
		}
		return str;
	}
}
