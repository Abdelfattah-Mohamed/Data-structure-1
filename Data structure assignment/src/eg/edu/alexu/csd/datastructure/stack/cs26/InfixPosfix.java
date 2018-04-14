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
		exception(expression);
		return expression;
	}

	@Override
	public int evaluate(final String expression) {
		// TODO Auto-generated method stub
		exception(expression);
		return 0;
	}

	private void exception(final String expression) {
		// TODO Auto-generated method stub
		if (expression.length() == 0) {
			throw new RuntimeException();
		}
		if ((expression.charAt(0) < '0' || expression.charAt(0) > '9')
				) {
			throw new RuntimeException();
		}
		for (int i = 0; i < expression.length(); i++) {
			if ((expression.charAt(i) < '0' || expression.charAt(i) > '9')
					&& (expression.charAt(i) < 'a' || expression.charAt(i) > 'z')
					&& (expression.charAt(i) < 'A' || expression.charAt(i) > 'Z')) {
				if (expression.charAt(i) != '+' && expression.charAt(i) != '-' && expression.charAt(i) != '*'
						&& expression.charAt(i) != '/') {
					throw new RuntimeException();
				} else if (expression.charAt(i + 1) == '+' || expression.charAt(i + 1) == '-'
						|| expression.charAt(i + 1) == '*' || expression.charAt(i + 1) == '/') {
					throw new RuntimeException();
				}
			}
		}
	}
}
