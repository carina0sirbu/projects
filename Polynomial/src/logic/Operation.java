package logic;

import model.Polynomial;
import model.Term;

public class Operation {

	public static Polynomial addP(Polynomial p1, Polynomial p2) {
		Polynomial result = p2.copy();

		for (Term t : p1.getTerms()) {
			result.addTerm(t);

		}

		return result;
	}

	public static Polynomial subtrP(Polynomial p1, Polynomial p2) {

		Polynomial result = p1.copy();
		Polynomial result1 = p2.copy();

		for (Term t : result1.getTerms()) {
			t.setCoeff(-t.getCoeff());

			result.addTerm(t);
		}

		return result;
	}

	public static Polynomial diffP(Polynomial p1) {

		Polynomial p2 = p1.copy();
		int i = -1;

		for (Term t : p2.getTerms()) {
			if (t.getDegree() != 0) {

				t.setCoeff(t.getCoeff() * t.getDegree());
				t.setDegree(t.getDegree() - 1);
			} else
				i = p2.getTerms().indexOf(t);
		}

		if (i != -1) {

			p2.getTerms().remove(i);
		}

		return p2;
	}

	public static Polynomial intrP(Polynomial p1) {

		Polynomial p2 = p1.copy();

		for (Term t : p2.getTerms()) {

			t.setCoeff(t.getCoeff() / (t.getDegree() + 1));
			t.setDegree(t.getDegree() + 1);
		}

		return p2;

	}

	public static Polynomial multP(Polynomial p1, Polynomial p2) {

		Polynomial result = new Polynomial();

		for (Term t1 : p1.getTerms()) {
			for (Term t2 : p2.getTerms()) {

				result.addTerm(t1.multT(t2));

			}
		}

		return result;

	}

	public static Polynomial[] divP(Polynomial p1, Polynomial p2) {

		Polynomial remainder = p1.copy();
		Polynomial quotient = new Polynomial();
		 
		
		while ((remainder.getDegree() >= p2.getDegree()) && !(remainder.getTerms().isEmpty())) {
			
			Term t = remainder.domTerm().divT(p2.domTerm());
			quotient.addTerm(t);
			Polynomial term = new Polynomial();
			term.addTerm(t);
			remainder = subtrP(remainder, multP(p2, term));
			remainder.getTerms().remove(remainder.domTerm());
		}
		
		Polynomial[] p = { quotient, remainder };

		return p;

	}

}
