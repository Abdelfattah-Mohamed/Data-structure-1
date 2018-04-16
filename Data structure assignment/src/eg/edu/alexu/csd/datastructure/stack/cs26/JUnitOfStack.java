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
		final String test = "5 4 + 3 *";
		Assert.assertEquals(0, post.evaluate(test));
	}

	/**
	 * @Test
	 */
	@Test
	public void test1() {
		IExpressionEvaluator post = new InfixPosfix();
		final String test = "b-c+d*e-a";
		final String ans = "b c - d e * + a -";
		Assert.assertEquals(ans, post.infixToPostfix(test));
	}
}
