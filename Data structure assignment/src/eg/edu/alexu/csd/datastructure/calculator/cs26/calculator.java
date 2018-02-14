package eg.edu.alexu.csd.datastructure.calculator.cs26;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

public class calculator implements ICalculator{

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public float divide(int x, int y) throws RuntimeException {
		// TODO Auto-generated method stub
		if( x== 0) {
			throw new RuntimeException("zero not valid");
		}
		
		return (float) x / y ;
	}
	
	
	

}
