package eg.edu.alexu.csd.datastructure.stack.cs26;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * @author Abd El Fattah
 */
public class JUnitOfStack {
	/**
	 * @Test
	 */
	@Test
	public void test() {
		IExpressionEvaluator post = new InfixPosfix();
		final String test = "16 3 / 5 -";
		// final String ans = "a*b/c";
		Assert.assertEquals(0, post.evaluate(test));
		// System.out.print(post.evaluate(test));
	}
	/**
	 * @Test
	 */
	@Test
	public void test1() {
		IExpressionEvaluator post = new InfixPosfix();
		final String test = "()";
		final String ans = "";
		Assert.assertEquals(ans, post.infixToPostfix(test));
	}
}
