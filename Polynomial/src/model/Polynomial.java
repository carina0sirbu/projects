
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

	private List<Term> terms;

	public Polynomial() {

		terms = new ArrayList<Term>();

	}

	public Polynomial(String s) {
		
		this.terms = new ArrayList<Term>();
		Pattern p = Pattern.compile("(\\+|\\-)?((\\d*x\\^?\\d*)|(\\d+))");
		Matcher m = p.matcher(s);

		ArrayList<String> terms = new ArrayList<String>();

		while (m.find()) {

			terms.add(m.group());

		}

		for (String t : terms) {

			if (t.matches("^(\\+|\\-)?(\\d+x\\^\\d+)$")) { // ax^b
				String[] s1 = t.split("(x\\^)");
				this.addTerm(new Term(Integer.parseInt(s1[0]), Integer.parseInt(s1[1])));
			} else if (t.matches("(\\+|\\-)?(\\d+x)")) { // ax
				String[] s2 = t.split("x");
				this.addTerm(new Term(Integer.parseInt(s2[0]), 1));
			} else if (t.matches("(\\+)?(x)")) { // x
				this.addTerm(new Term(1, 1));
			} else if (t.matches("(\\-)(x)")) { // -x
				this.addTerm(new Term(-1, 1));
			} else if (t.matches("(\\+)?(x\\^\\d+)")) { // x^b
				String[] s3 = t.split("(x\\^)");
				this.addTerm(new Term(1, Integer.parseInt(s3[1])));
			} else if (t.matches("(\\-)(x\\^\\d+)")) { // -x^b
				String[] s4 = t.split("(x\\^)");
				this.addTerm(new Term(-1, Integer.parseInt(s4[1])));
			} else if (t.matches("^((\\+|\\-)?(\\d+))$")) { // a
				System.out.println(t);
				this.addTerm(new Term(Integer.parseInt(t), 0));
			} /*else if (t.matches("^(\\-)(\\d+)$")) { // -a
				this.addTerm(new Term(Integer.parseInt(t), 0));
			}*/
		}

	}

	public void addTerm(Term t) {

		boolean exists = false;
		for (Term r : terms) {

			if (t.getDegree() == r.getDegree()) {

				r.setCoeff(t.getCoeff() + r.getCoeff());
				exists = true;
			}

		}
		if (exists == false) {
			terms.add(t);
		}
		Collections.sort(terms, new TermComp());
	}

	public Polynomial copy() {

		Polynomial newP = new Polynomial();
		for (Term t : this.terms) {

			newP.addTerm(new Term(t.getCoeff(), t.getDegree()));
		}
		return newP;

	}

	public int getDegree() {

		int max = this.getTerms().get(0).getDegree();

		for (Term t : this.getTerms()) {
			if (t.getDegree() > max)
				max = t.getDegree();
		}

		return max;
	}

	public Term domTerm() {

		for (Term t : this.getTerms()) {

			if (t.getDegree() == this.getDegree())

				return t;

		}

		return null;
	}

	@Override
	public String toString() {
		return terms.toString();
	}

	public boolean equals(Object obj) {

		if (obj == this)
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof Polynomial))
			return false;

		Polynomial that = (Polynomial) obj;

		return this.terms.equals(that.terms);

	}

	public List<Term> getTerms() {
		return terms;
	}

	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}

}
