package eg.edu.alexu.csd.datastructure.linkedList.cs25_cs26;

import java.awt.Point;
import java.util.Scanner;
import java.util.Vector;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class P_main {

	static IPolynomialSolver instance = (IPolynomialSolver) new polynomial(null);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		operation();
		while (true) {
			System.out.println();
			System.out.println("Press Y to Exist OR N to cntinous");
			Scanner scan = new Scanner(System.in);
			char x = scan.next().charAt(0);
			if (x == 'Y' || x == 'y') {
				break;
			} else if (x == 'N' || x == 'n') {
				operation();
			} else {
				System.out.println();
				System.out.println("please enter valid choise");
			}
		}
	}

	private static void operation() {

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
			int i = 0;
			int noOfTerms = 0;
			System.out.println("Insert the number of terms:");
			noOfTerms = scan.nextInt();
			int[][] terms = new int[noOfTerms][2];
			System.out.println("Insert the polynomial terms in the form:");
			System.out.println("(coeff1, exponent1), (coeff2, exponent2), ..");
			scan.useDelimiter("[\\s\\(\\),]+");
			while (noOfTerms > 0) {
				terms[i][0] = scan.nextInt();
				terms[i][1] = scan.nextInt();
				noOfTerms--;
				i++;

			}
			instance.setPolynomial(poly, terms);
			System.out.println("Polynomial " + poly + " is set");

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
			float x = 0;
			System.out.println("Insert the point");
			x = scan.nextFloat();
			instance.evaluatePolynomial(poly, x);
		} else if (Choice == 7) {
			System.out.println("Insert the first variable name: A, B or C");
			char poly = scan.next().charAt(0);
			instance.clearPolynomial(poly);
		}
	}
}
