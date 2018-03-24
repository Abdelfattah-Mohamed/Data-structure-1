package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import java.awt.Point;
import java.util.Scanner;
import java.util.Vector;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class P_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPolynomialSolver instance = (IPolynomialSolver) new polynomial(null);

		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1- Set a polynomial variable");
		System.out.println("2- Print the value of a polynomial variable");
		System.out.println("3- Add two polynomials");
		System.out.println("4- Subtract two polynomials");
		System.out.println("5- Multiply two polynomials");
		System.out.println("6- Evaluate a polynomial at some point");
		System.out.println("7- Clear a polynomial variable");
		System.out.println("====================================================================");
		Scanner scan = new Scanner(System.in);
		int Choice = scan.nextInt();
		if (Choice == 1) {
			System.out.println("Insert the variable name: A, B or C");
			char poly;
			poly = scan.next().charAt(0);
			Vector<Point> arrayOfSet = new Vector<Point>();
			int[][] terms = null;
			int i = 0;
			System.out.println("Insert the polynomial terms in the form:");
			System.out.println("(coeff1, exponent1), (coeff2, exponent2), ..");
			scan.useDelimiter("[\\s\\(\\),]+");
			while (scan.hasNext() == true) {
				int coff = scan.nextInt();
				int exp = scan.nextInt();
				arrayOfSet.add(new Point(coff, exp));
			}
			terms = new int[arrayOfSet.size()][2];
			while (i < arrayOfSet.size()) {
				terms[i][0] = arrayOfSet.elementAt(i).x;
				terms[i][1] = arrayOfSet.elementAt(i).y;
				i++;
			}

			instance.setPolynomial(poly, terms);
			System.out.println("Polynomial " + poly + " is set");
			return;

		} else if (Choice == 2) {
			System.out.println("Insert the variable name: A, B, C, R");
			char poly = scan.next().charAt(0);
			instance.print(poly);

		} else if (Choice == 3) {
			System.out.println("Insert the first variable name: A, B or C");
			char poly1 = scan.next().charAt(0);
			System.out.println("Insert the second variable name: A, B or C");
			char poly2 = scan.next().charAt(0);
			instance.add(poly1, poly2);

		} else if (Choice == 4) {
			System.out.println("Insert the first variable name: A, B or C");
			char poly1 = scan.next().charAt(0);
			System.out.println("Insert the second variable name: A, B or C");
			char poly2 = scan.next().charAt(0);
			instance.subtract(poly1, poly2);
			
		} else if (Choice == 5) {
			System.out.println("Insert the first variable name: A, B or C");
			char poly1 = scan.next().charAt(0);
			System.out.println("Insert the second variable name: A, B or C");
			char poly2 = scan.next().charAt(0);
			instance.multiply(poly1, poly2);

		} else if (Choice == 6) {
			System.out.println("Insert the first variable name: A, B or C");
			char poly = scan.next().charAt(0);
			float x = 0 ;
			System.out.println("Insert the point");
			x = scan.nextFloat();
			instance.evaluatePolynomial(poly, x);
		} else if (Choice == 7) {
			System.out.println("Insert the first variable name: A, B or C");
			char poly = scan.next().charAt(0);
			instance.clearPolynomial(poly);
		}

		/*
		 * instance.setPolynomial('A', new int[][] { { 3, 2 }, { 45, 3 }, { 176, 3 }, {
		 * 128, 2 } }); instance.setPolynomial('B', new int[][] { { 4, 2 }, { 45, 3 }, {
		 * 176, 3 }, { 128, 2 } }); instance.print('B'); System.out.println();
		 * instance.print('A'); //instance.setPolynomial('A', new int[][] { { 4, 1 }, {
		 * 3, 2 }, { 2, 3 }, { 1, 0 } }); System.out.println(); //instance.print('A');
		 * System.out.println(); /* float eval = instance.evaluatePolynomial('A', 0);
		 * System.out.println(eval); eval = instance.evaluatePolynomial('B', 0);
		 * System.out.print(eval);
		 * 
		 * instance.add('B', 'A'); System.out.println(); instance.subtract('B', 'A');
		 * System.out.println(); instance.multiply('A', 'B');
		 */}

}
