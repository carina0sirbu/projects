package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import logic.Operation;
import model.Polynomial;

public class Controller {

	View v;

	public Controller(View view) {

		this.v = view;

		v.addAddListener(new AddListener());
		v.addSubtrListener(new SubtrListener());
		v.addMultListener(new MultListener());
		v.addDivListener(new DivListener());
		v.addDiff1Listener(new Diff1Listener());
		v.addDiff2Listener(new Diff2Listener());
		v.addInteg1Listener(new Integ1Listener());
		v.addInteg2Listener(new Integ2Listener());

	}

	private class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Polynomial p1 = new Polynomial(v.getPoly1());
			Polynomial p2 = new Polynomial(v.getPoly2());

			v.setResult(Operation.addP(p1, p2).toString());

		}

	}

	private class SubtrListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Polynomial p1 = new Polynomial(v.getPoly1());
			Polynomial p2 = new Polynomial(v.getPoly2());

			v.setResult(Operation.subtrP(p1, p2).toString());

		}

	}

	private class MultListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Polynomial p1 = new Polynomial(v.getPoly1());
			Polynomial p2 = new Polynomial(v.getPoly2());

			v.setResult(Operation.multP(p1, p2).toString());

		}

	}

	private class DivListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Polynomial p1 = new Polynomial(v.getPoly1());
			Polynomial p2 = new Polynomial(v.getPoly2());
			Polynomial[] r = Operation.divP(p1, p2);

			v.setResult("Quotient: " + r[0].toString() + "Remainder: " + r[1].toString());

		}

	}

	private class Diff1Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Polynomial p1 = new Polynomial(v.getPoly1());

			v.setResult(Operation.diffP(p1).toString());

		}

	}

	private class Diff2Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Polynomial p2 = new Polynomial(v.getPoly2());

			v.setResult(Operation.diffP(p2).toString());

		}

	}

	private class Integ1Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Polynomial p1 = new Polynomial(v.getPoly1());

			v.setResult(Operation.intrP(p1).toString());

		}

	}

	private class Integ2Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			Polynomial p2 = new Polynomial(v.getPoly2());

			v.setResult(Operation.intrP(p2).toString());

		}

	}

}
