package eg.edu.alexu.csd.datastructure.stack.cs26;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26.SingleLinkedList;
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
		char[] store = new char[expression.length()];
		Stack a = (Stack) new Stack();
		int i = 0;
		int l = 0;
		if (expression.charAt(0) == '-') {
			store[0] = expression.charAt(0);
			i++;
		}
		for (; i < expression.length(); i++) {
			if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '/'
					&& expression.charAt(i) != '*') {
				store[l] = expression.charAt(i);
				l++;
			} else {
				if (a.size > 0) {
					if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
						store[l] = (char) a.pop();
						l++;
						a.push(expression.charAt(i));
					} else if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
						if ((Character) a.peek() == '*' || (Character) a.peek() == '*') {
							store[l] = (char) a.pop();
							l++;
						}
					} else {
						a.push(expression.charAt(i));
					}
				} else {
					a.push(expression.charAt(i));
				}
			}
		}
		while (a.size > 0) {
			store[l] = (char) a.pop();
			l++;
		}
		/*
		 * String str = ""; for (int j = 0; i < store.length; i++) { str = str +
		 * store[j] + " "; }
		 */
		String str = String.valueOf(store);
		return str.valueOf(store[3]);
	}

	@Override
	public int evaluate(final String expression) {
		// TODO Auto-generated method stub
		return 0;
	}

}
