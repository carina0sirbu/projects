package test;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import logic.Operation;
import model.Polynomial;
import model.Term;
import model.TermComp;

public class TestPoly {

	Polynomial p1 = new Polynomial();
	Polynomial p2 = new Polynomial();

	@Before
	public void initV() {

		for (int i = 0; i < 3; i++) {
			Term t1 = new Term(i + 1, i + 2); //	   x^2 2x^3 3x^4
			Term t2 = new Term(i + 2, i + 1); // 2x^1 3x^2 4x^3
			p1.addTerm(t1);
			p2.addTerm(t2);

		}
	}

	@Test
	public void addPoly() {

		Polynomial actualResult = Operation.addP(p1, p2);
		Polynomial expectedResult = new Polynomial();

		Term t1 = new Term(3, 4);
		Term t2 = new Term(6, 3);
		Term t3 = new Term(4, 2);
		Term t4 = new Term(2, 1);
		
		System.out.println(actualResult);


		expectedResult.addTerm(t1);
		expectedResult.addTerm(t2);
		expectedResult.addTerm(t3);
		expectedResult.addTerm(t4);
		
		Collections.sort(actualResult.getTerms(), new TermComp());
		Collections.sort(expectedResult.getTerms(), new TermComp());
		
		
		System.out.println(expectedResult);

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void subtrPoly() {
		
		Polynomial actualResult = Operation.subtrP(p1, p2);
		Polynomial expectedResult = new Polynomial();

		Term t1 = new Term(2, 1);
		Term t2 = new Term(2, 2);
		Term t3 = new Term(2, 3);
		Term t4 = new Term(-3, 4);
		
		System.out.println(actualResult);


		expectedResult.addTerm(t1);
		expectedResult.addTerm(t2);
		expectedResult.addTerm(t3);
		expectedResult.addTerm(t4);
		
		Collections.sort(actualResult.getTerms(), new TermComp());
		Collections.sort(expectedResult.getTerms(), new TermComp());
		
		
		System.out.println(expectedResult);

		assertEquals(expectedResult, actualResult);

	}
	
	@Test
	public void multPoly() {
		
		Polynomial actualResult = Operation.multP(p1, p2);
		Polynomial expectedResult = new Polynomial();

		Term t1 = new Term(2, 3);
		Term t2 = new Term(7, 4);
		Term t3 = new Term(16, 5);
		Term t4 = new Term(17, 6);
		Term t5 = new Term(12, 7);
		
		System.out.println(actualResult);


		expectedResult.addTerm(t1);
		expectedResult.addTerm(t2);
		expectedResult.addTerm(t3);
		expectedResult.addTerm(t4);
		expectedResult.addTerm(t5);
		
		Collections.sort(actualResult.getTerms(), new TermComp());
		Collections.sort(expectedResult.getTerms(), new TermComp());
		
		
		System.out.println(expectedResult);

		assertEquals(expectedResult, actualResult);

		
	}
	
	@Test
	public void diffPoly() {
		
		Polynomial actualResult = Operation.diffP(p1);
		Polynomial expectedResult = new Polynomial();

		Term t1 = new Term(2, 1);
		Term t2 = new Term(6, 2);
		Term t3 = new Term(12, 3);
		
		System.out.println(actualResult);


		expectedResult.addTerm(t1);
		expectedResult.addTerm(t2);
		expectedResult.addTerm(t3);
		
		Collections.sort(actualResult.getTerms(), new TermComp());
		Collections.sort(expectedResult.getTerms(), new TermComp());
		
		
		System.out.println(expectedResult);

		assertEquals(expectedResult, actualResult);

		
	}
	
	@Test
	public void integPoly() {
		
		Polynomial actualResult = new Polynomial(Operation.intrP(p1).toString());
		Polynomial expectedResult = new Polynomial("0.333x^3 0.5x^4 0.6x^5");

		/*Term t1 = new Term(0.333, 3);
		Term t2 = new Term(0.5, 4);
		Term t3 = new Term(0.6, 5);
		
		System.out.println(actualResult);


		expectedResult.addTerm(t1);
		expectedResult.addTerm(t2);
		expectedResult.addTerm(t3);*/
		System.out.println(actualResult);
		
		Collections.sort(actualResult.getTerms(), new TermComp());
		Collections.sort(expectedResult.getTerms(), new TermComp());
		
		
		System.out.println(expectedResult);

		assertEquals(expectedResult, actualResult);

		
	}
	
	/*@Test
	public void divPoly() {
		
		Polynomial actualResult = Operation.divP(p1, p2);
		Polynomial expectedResult = new Polynomial();

		Term t1 = new Term(3, 4);
		Term t2 = new Term(6, 3);
		Term t3 = new Term(4, 2);
		Term t4 = new Term(2, 1);
		
		System.out.println(actualResult);


		expectedResult.addTerm(t1);
		expectedResult.addTerm(t2);
		expectedResult.addTerm(t3);
		expectedResult.addTerm(t4);
		
		Collections.sort(actualResult.getTerms(), new TermComp());
		Collections.sort(expectedResult.getTerms(), new TermComp());
		
		
		System.out.println(expectedResult);

		assertEquals(expectedResult, actualResult);

		
	}*/
	
}
