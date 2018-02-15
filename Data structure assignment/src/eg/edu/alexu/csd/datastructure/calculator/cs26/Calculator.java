package eg.edu.alexu.csd.datastructure.calculator.cs26;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

/**
 *
 * @author Abd El Fattah
 *
 */

public class Calculator implements ICalculator {

	@Override
	public int add(final int x, final int y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public float divide(final int x, final int y) throws RuntimeException {
		// TODO Auto-generated method stub
		if (y == 0) {
			throw new RuntimeException("Division by zero!");
		}

		return (float) x / y;
	}
}
