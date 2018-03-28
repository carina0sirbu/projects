package model;

import java.util.Comparator;

public class TermComp implements Comparator<Term> {

	@Override
	public int compare(Term a, Term b) {
		return b.getDegree() - a.getDegree();
	}

}
