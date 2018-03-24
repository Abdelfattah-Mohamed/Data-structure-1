package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class P_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IPolynomialSolver instance = (IPolynomialSolver) new polynomial(null);
		instance.setPolynomial('A', new int[][] { { 3, 2 }, { 45, 3 }, { 176, 3 }, { 128, 2 } });
		instance.setPolynomial('B', new int[][] { { 4, 2 }, { 45, 3 }, { 176, 3 }, { 128, 2 } });
		instance.print('B');
		System.out.println();
		instance.print('A');
		//instance.setPolynomial('A', new int[][] { { 4, 1 }, { 3, 2 }, { 2, 3 }, { 1, 0 } });
		System.out.println();
		//instance.print('A');
		System.out.println();
		/*
		float eval = instance.evaluatePolynomial('A', 0);
		System.out.println(eval);
		eval = instance.evaluatePolynomial('B', 0);
		System.out.print(eval);
		*/
		instance.add('B', 'A');
		System.out.println();
		instance.subtract('B', 'A');
	}

}
