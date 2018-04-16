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
		String exp = "";
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) != ' ') {
				exp += Character.toString(expression.charAt(i));
			}
		}
		Stack a = (Stack) new Stack();
		String str1 = "";
		int i = 0;
		if (exp.length() == 0) {
			throw new RuntimeException();
		}
		if (operation(exp.charAt(exp.length() - 1))) {
			throw new RuntimeException();
		}
		if ((exp.charAt(0) < '0' || exp.charAt(0) > '9') && (exp.charAt(0) < 'a' || exp.charAt(0) > 'z')
				&& (exp.charAt(0) < 'A' || exp.charAt(0) > 'Z') && (exp.charAt(0) != '(')) {
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
					if ((str1.length() != 0) && (i > 0) && (operation(exp.charAt(i - 1)) || exp.charAt(i - 1) == ' '
							|| braces(exp.charAt(i - 1)))) {
						str1 += " ";
					}
					str1 += Character.toString(exp.charAt(i));
				}
			} else {
				if ((i < exp.length() - 1) && operation(exp.charAt(i + 1))) {
					throw new RuntimeException();
				}
				if (a.size > 0) {
					if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
						if ((char) a.peek() != '(') {
							str1 += " ";
							str1 += Character.toString((char) a.pop());
						}
						a.push(exp.charAt(i));
					} else if (exp.charAt(i) == '*' || exp.charAt(i) == '/') {
						if ((char) a.peek() == '*' || (char) a.peek() == '/') {
							str1 += " ";
							str1 += Character.toString((char) a.pop());
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
			str1 += " ";
			str1 += Character.toString((char) a.pop());
		}
		if (a.size() == 1) {
			if ((char) a.peek() == '(') {
				throw new RuntimeException();
			}
			str1 += " ";
			str1 += Character.toString((char) a.pop());
		}
		return str1;
	}

	@Override
	public int evaluate(final String expression) {
		// TODO Auto-generated method stub
		if (!operation(expression.charAt(expression.length() - 1))) {
			return 0;
		}
		int size = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == ' ') {
				size++;
			}
		}
		String[] exp = new String[size + 1];
		int co = 0;
		for (int i = 0; i < expression.length(); i++) {
			if (exp[co] == null) {
				exp[co] = "";
			}
			if (expression.charAt(i) != ' ') {
				exp[co] = exp[co] + expression.charAt(i);
			} else {
				co++;
			}
		}
		Stack a = (Stack) new Stack();
		int r, l;
		int t;
		for (int i = 0; i <= co; i++) {
			if (!operation(exp[i].charAt(0))) {
				a.push(exp[i]);
			} else {
				if (exp[i].charAt(0) == '+') {
					r = convert((String) a.pop());
					l = convert((String) a.pop());
					t = r + l;
					a.push(Integer.toString(t));
				} else if (exp[i].charAt(0) == '*') {
					r = convert((String) a.pop());
					l = convert((String) a.pop());
					t = r * l;
					a.push(Integer.toString(t));
				} else if (exp[i].charAt(0) == '-') {
					r = convert((String) a.pop());
					l = convert((String) a.pop());
					t = l - r;
					a.push(Integer.toString(t));
				} else if (exp[i].charAt(0) == '/') {
					r = convert((String) a.pop());
					l = convert((String) a.pop());
					t = l / r;
					a.push(Integer.toString(t));
				}
			}
		}
		return convert((String) a.pop());
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
	private String addB(final Stack a, final String str1) {
		// TODO Auto-generated method
		String str = str1;
		boolean x = false;
		while (a.size > 0) {
			if ((char) a.peek() == '(') {
				a.pop();
				x = true;
				break;
			}
			str += " ";
			str += Character.toString((char) a.pop());
		}
		if (!x) {
			throw new RuntimeException();
		}
		return str;
	}

	/**
	 * 
	 * @param x
	 *            string want to convert to integer.
	 * @return string in integer.
	 */
	private int convert(String x) {
		int total = 0;
		for (int i = 0; i < x.length(); i++) {
			if (x.charAt(i) != '-') {
				total = total * 10 + ((int) x.charAt(i) - '0');
			}
		}
		if (x.charAt(0) == '-') {
			total = -total;
		}
		return total;

	}
}
