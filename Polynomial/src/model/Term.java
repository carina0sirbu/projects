package model;

public class Term {

	private double coeff;
	private int degree;

	public Term(double coeff, int degree) {
		this.coeff = coeff;
		this.degree = degree;
	}

	public double getCoeff() {
		return coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return String.format("%.1f", coeff) + "x^" + degree;
	}

	public boolean equals(Object obj) {

		if (obj == this)
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof Term))
			return false;

		Term that = (Term) obj;

		return (this.degree == that.degree) && (this.coeff == that.coeff);

	}

	public Term multT(Term t1) {

		return new Term(t1.getCoeff() * this.getCoeff(), t1.getDegree() + this.getDegree());

	}

	public Term divT(Term t1) {

		return new Term(this.getCoeff() / t1.getCoeff(), this.getDegree() - t1.getDegree());

	}

}
