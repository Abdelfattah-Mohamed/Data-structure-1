package eg.edu.alexu.csd.datastructure.stack.cs26;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

public class Postfix_Vs_Infix implements IExpressionEvaluator {

	SNodes<Object> head = null;
	SNodes<Object> tail = null;
	int size = 0;
	public IExpressionEvaluator operand =
			(IExpressionEvaluator) new Stack(null, null);

	public Postfix_Vs_Infix() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String infixToPostfix(final String expression) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public int evaluate(final String expression) {
		// TODO Auto-generated method stub
		return 0;
	}

}
