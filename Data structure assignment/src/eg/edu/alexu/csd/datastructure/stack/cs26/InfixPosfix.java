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
		Stack a = (Stack) new Stack();
		String str1 = "";
		int i = 0;
		if (expression.length() == 0) {
			throw new RuntimeException();
		}
		if ((expression.charAt(0) < '0' || expression.charAt(0) > '9')
				&& (expression.charAt(0) < 'a' || expression.charAt(0) > 'z')
				&& (expression.charAt(0) < 'A' || expression.charAt(0) > 'Z') && (expression.charAt(0) != '(')) {
			throw new RuntimeException();
		}
		for (; i < expression.length(); i++) {
			if (expression.charAt(i) == ' ') {
				i++;
			}
			if (!operation(expression.charAt(i))) {
				if (unary(expression.charAt(i))) {
					throw new RuntimeException();
				}
				if (braces(expression.charAt(i))) {
					if (expression.charAt(i) == '(') {
						a.push(expression.charAt(i));
					} else {
						str1 = addB(a, str1);
					}
				}
				if (!braces(expression.charAt(i))) {
					if ((str1.length() != 0) && (i > 0)
							&& (operation(expression.charAt(i - 1)) || expression.charAt(i - 1) == ' ')) {
						str1 += " ";
					}
					str1 += Character.toString(expression.charAt(i));
				}
			} else {
				if ((i < expression.length() - 1) && operation(expression.charAt(i + 1))) {
					throw new RuntimeException();
				}
				if (a.size > 0) {
					if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
						if ((char) a.peek() != '(') {
							str1 += " ";
							str1 += Character.toString((char) a.pop());
						}
						a.push(expression.charAt(i));
					} else if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
						if ((char) a.peek() == '*' || (char) a.peek() == '/') {
							str1 += " ";
							str1 += Character.toString((char) a.pop());
							a.push(expression.charAt(i));
						} else {
							a.push(expression.charAt(i));
						}
					}
				} else {
					a.push(expression.charAt(i));
				}
			}
		}
		while (a.size() > 1) {
			str1 += " ";
			str1 += Character.toString((char) a.pop());
		}
		if (a.size() == 1) {
			str1 += " ";
			str1 += Character.toString((char) a.pop());
		}
		if (str1.length() == 0) {
			str1 += " ";
		}
		return str1;
	}

	@Override
	public int evaluate(final String expression) {
		// TODO Auto-generated method stub
		return 0;
	}

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

	private boolean braces(final char x) {
		if (x == '(') {
			return true;
		} else if (x == ')') {
			return true;
		}
		return false;
	}

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

}
