package eg.edu.alexu.csd.datastructure.stack.cs26;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 *
 * @author Abd El Fattah
 *
 */
public class InfixPosfix implements IExpressionEvaluator {
	/**
	 * point to first node.
	 */
	Dnode head = null;
	/**
	 * point to last node.
	 */
	Dnode tail = null;
	/**
	 * size of stack.
	 */
	int size = 0;

	@Override
	public String infixToPostfix(final String expression) {
		// TODO Auto-generated method stub
		char[] store = new char[2 * expression.length()];
		Stack a = (Stack) new Stack();
		String str1 = "";
		int i = 0;
		int l = 0;
		if (expression.length() == 0) {
			throw new RuntimeException();
		}
		if ((expression.charAt(0) < '0' || expression.charAt(0) > '9')
				&& (expression.charAt(0) < 'a' || expression.charAt(0) > 'z')
				&& (expression.charAt(0) < 'A' || expression.charAt(0) > 'Z') && (expression.charAt(0) != '(')) {
			throw new RuntimeException();
		}
		for (; i < expression.length(); i++) {
			if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '/'
					&& expression.charAt(i) != '*') {
				if (expression.charAt(i) == '~' || expression.charAt(i) == '!' || expression.charAt(i) == '&'
						|| expression.charAt(i) == '|') {
					throw new RuntimeException();
				}
				str1 = str1 + expression.charAt(i) + " ";
				store[l] = expression.charAt(i);
				l++;
				store[l] = ' ';
				l++;
			} else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '/'
					|| expression.charAt(i) == '*') {
				if (expression.charAt(i + 1) == '+' || expression.charAt(i + 1) == '-'
						|| expression.charAt(i + 1) == '/' || expression.charAt(i + 1) == '*') {
					throw new RuntimeException();
				}
				if (a.size > 0) {
					if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
						store[l] = (char) a.pop();
						l++;
						store[l] = ' ';
						l++;
						a.push(expression.charAt(i));
					} else if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
						if ((char) a.peek() == '*' || (char) a.peek() == '/') {
							str1 = str1 + (char) a.pop() + " ";
							/*
							store[l] = (char) a.pop();
							l++;
							store[l] = ' ';
							l++;
							*/
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
		while (a.head != null) {
			str1 = str1 + (char) a.pop();
			if (a.head != null) {
				str1 = str1 + " ";
			}
			/*
			store[l] = (char) a.pop();
			l++;
			store[l] = ' ';
			l++;
			*/
		}
		i = 0;
		String str = "";
		while (i < 2 * expression.length() - 2) {
			str = str + store[i] + " ";
			i++;
			i++;
			/*
			 * if (i < 2 * expression.length()) { str = str + store[i]; i++; }
			 */
		}
		/*
		 * String str = ""; for (int j = 0; i < store.length; i++) { str = str +
		 * store[j] + " "; }
		 */
		str = str + store[i];
		return str1;
	}

	@Override
	public int evaluate(final String expression) {
		// TODO Auto-generated method stub
		return 0;
	}
}
