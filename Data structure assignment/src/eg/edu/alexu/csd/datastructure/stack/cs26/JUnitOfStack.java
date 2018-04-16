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
		final String test = "16 4 *";
		// final String ans = "a*b/c";
		Assert.assertEquals(4, post.evaluate(test));
		// System.out.print(post.evaluate(test));
	}
}
