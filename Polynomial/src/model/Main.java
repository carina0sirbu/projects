package model;

import logic.Operation;
import ui.Controller;
import ui.View;

public class Main {

	public static void main(String[] args) {

		Polynomial a = new Polynomial();
		Polynomial b = new Polynomial();

		for (int i = 0; i < 3; i++) {
			Term t1 = new Term(i + 1, i + 2); //       x^2 2x^3 3x^4
			Term t2 = new Term(i + 2, i + 1); // 2x^1 3x^2 4x^3
			a.addTerm(t1);
			b.addTerm(t2);

		}

		System.out.println("Additon: ");
		Polynomial result = Operation.addP(a, b);
		System.out.println(result);

		System.out.println("Subtraction: ");
		System.out.println(Operation.subtrP(a, b));

		System.out.println("Differentiation: ");
		System.out.println(Operation.diffP(a));

		System.out.println("Integration: ");
		System.out.println(Operation.intrP(a));

		System.out.println("Multiplication: ");
		System.out.println(Operation.multP(a, b));

		System.out.println("Division: ");
		System.out.println(Operation.divP(a, b)[0]);
		System.out.println(Operation.divP(a, b)[1]);

		View v = new View();
		
		Controller c = new Controller(v);

	}

}
