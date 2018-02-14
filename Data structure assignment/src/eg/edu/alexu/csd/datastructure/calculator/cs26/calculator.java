package eg.edu.alexu.csd.datastructure.calculator.cs26;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

public class calculator implements ICalculator {

	@Override
   	public int add(final int x,final int y) {
		return x + y;
	}

	@Override
	public float divide(final int x,final int y) throws RuntimeException {
		if (y == 0) {
			throw new RuntimeException("Division by zero!");
		}

		return (float) x / y;
	}

}
