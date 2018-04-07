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
		char[] store = new char[expression.length() + 2];
		String s = "";
		//System.out.print(expression.length());
		Stack a = (Stack) new Stack();
		int i = 0;
		int l = 0;
		if (expression.length() == 0) {
			throw new RuntimeException();
		}
		if (expression.charAt(0) == '~' || expression.charAt(0) == '!' || expression.charAt(0) == '&' || expression.charAt(0) == '+' || expression.charAt(0) == '-') {
			throw new RuntimeException();
		}
		for (; i < expression.length(); i++) {
			if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '/'
					&& expression.charAt(i) != '*') {
				if (expression.charAt(i) == '~' || expression.charAt(i) == '!' || expression.charAt(i) == '&') {
					throw new RuntimeException();
				}
				s = s + expression.charAt(i) + " ";
				store[l] = expression.charAt(i);
				l++;
				/*
				store[l] = ' ';
				l++;
				*/
			} else if (expression.charAt(i) != '+' || expression.charAt(i) != '-' || expression.charAt(i) != '/'
						|| expression.charAt(i) != '*') {
				if (expression.charAt(i + 1) == '+' || expression.charAt(i + 1) == '-' || expression.charAt(i + 1) == '/'
						|| expression.charAt(i + 1) == '*') {
					throw new RuntimeException();
				}
				if (a.size > 0) {
					if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
						s = s + (char) a.pop() + " ";
						store[l] = (char) a.pop();
						l++;
						if(l < 2 * expression.length() - 1) {
							store[l] = ' ';
							l++;
						}
						a.push(expression.charAt(i));
					} else if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
						if ((Character) a.peek() == '*' || (Character) a.peek() == '/') {
							s = s + (char) a.pop() + " ";
							store[l] = (char) a.pop();
							l++;
							if(l < 2 * expression.length() - 1) {
								store[l] = ' ';
								l++;
							}
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
			s = s + (char) a.pop();
			if(l < 2 * expression.length() - 1) {
				s = s + " ";
				store[l] = ' ';
				l++;
			}
			store[l] = (char) a.pop();
			l++;
		}
		/*
		 * i = 0; String str = ""; while (i < expression.length()) { str = str +
		 * store[i]; if (i + 1 != expression.length()) { str = str + " "; } i++; }
		 */
		/*
		 * String str = ""; for (int j = 0; i < store.length; i++) { str = str +
		 * store[j] + " "; }
		 */
		String str = new String(store);
		return s;
	}

	@Override
	public int evaluate(final String expression) {
		// TODO Auto-generated method stub
		return 0;
	}
}
