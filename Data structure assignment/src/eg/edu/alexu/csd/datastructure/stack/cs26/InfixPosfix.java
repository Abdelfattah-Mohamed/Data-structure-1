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
		char[] store = new char[2 * expression.length()];
		Stack a = (Stack) new Stack();
		int i = 0;
		if (expression.charAt(0) == '-') {
			store[0] = expression.charAt(0);
			i++;
		}
		for (; i < 2 * expression.length(); i++) {
			if (expression.charAt(i) != '+' || expression.charAt(i) != '-' || expression.charAt(i) != '/'
					|| expression.charAt(i) != '*') {
				store[i] = expression.charAt(i);
			} else {
				if (a.size > 0) {
					if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
						store[i] = (char) a.pop();
						a.push(expression.charAt(i));
					} else {
						a.push(expression.charAt(i));
					}
				} else {
					a.push(expression.charAt(i));
				}
			}
		}
		String str = "";
		for (int j = 0; i < store.length; i++) {
			str = str + store[j] + " ";
		}
		return str;
	}

	@Override
	public int evaluate(final String expression) {
		// TODO Auto-generated method stub
		return 0;
	}

}
