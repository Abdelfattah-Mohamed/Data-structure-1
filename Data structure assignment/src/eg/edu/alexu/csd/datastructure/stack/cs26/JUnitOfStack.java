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
		final String test = "a*b/c";
		final String ans = "ab * c /";
		Assert.assertEquals(ans, post.infixToPostfix(test));
	}
}
