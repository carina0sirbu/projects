package ui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View extends JFrame {

	private JTextField polynomial1;
	private JTextField polynomial2;
	private JTextField result;
	private JButton add;
	private JButton subtr;
	private JButton mult;
	private JButton div;
	private JButton diff1;
	private JButton diff2;
	private JButton integ1;
	private JButton integ2;
	private JLabel poly1;
	private JLabel poly2;
	private JLabel resultl;

	public View() {

		polynomial1 = new JTextField();
		polynomial1.setBounds(150, 20, 350, 48);
		this.getContentPane().add(polynomial1);

		polynomial2 = new JTextField();
		polynomial2.setBounds(150, 80, 350, 48);
		this.getContentPane().add(polynomial2);

		result = new JTextField();
		result.setBounds(150, 300, 350, 48);
		result.setEditable(false);
		this.getContentPane().add(result);

		poly1 = new JLabel("First polynomial: ");
		poly1.setBounds(20, 20, 120, 40);
		this.getContentPane().add(poly1);

		poly2 = new JLabel("Second polynomial: ");
		poly2.setBounds(20, 80, 120, 40);
		this.getContentPane().add(poly2);

		resultl = new JLabel("Result: ");
		resultl.setBounds(20, 300, 120, 40);
		this.getContentPane().add(resultl);

		add = new JButton("Add");
		add.setBounds(70, 140, 100, 60);
		this.getContentPane().add(add);

		subtr = new JButton("Subtract");
		subtr.setBounds(190, 140, 100, 60);
		this.getContentPane().add(subtr);

		mult = new JButton("Multiply");
		mult.setBounds(310, 140, 100, 60);
		this.getContentPane().add(mult);

		div = new JButton("Divide");
		div.setBounds(430, 140, 100, 60);
		this.getContentPane().add(div);

		diff1 = new JButton("Diff first");
		diff1.setBounds(70, 225, 100, 60);
		this.getContentPane().add(diff1);

		diff2 = new JButton("Diff second");
		diff2.setBounds(190, 225, 100, 60);
		this.getContentPane().add(diff2);

		integ1 = new JButton("Integr first");
		integ1.setBounds(310, 225, 100, 60);
		this.getContentPane().add(integ1);

		integ2 = new JButton("Integr sec");
		integ2.setBounds(430, 225, 100, 60);
		this.getContentPane().add(integ2);

		this.setLayout(null);
		this.setSize(600, 400);
		this.getContentPane().setBackground(Color.decode("#b266ff"));
		this.setVisible(true);

	}

	public void addAddListener(ActionListener e) {

		add.addActionListener(e);

	}

	public void addSubtrListener(ActionListener e) {

		subtr.addActionListener(e);

	}

	public void addMultListener(ActionListener e) {

		mult.addActionListener(e);

	}

	public void addDivListener(ActionListener e) {

		div.addActionListener(e);

	}

	public void addDiff1Listener(ActionListener e) {

		diff1.addActionListener(e);

	}

	public void addDiff2Listener(ActionListener e) {

		diff2.addActionListener(e);

	}

	public void addInteg1Listener(ActionListener e) {

		integ1.addActionListener(e);

	}

	public void addInteg2Listener(ActionListener e) {

		integ2.addActionListener(e);

	}

	public String getPoly1() {

		return polynomial1.getText();
	}

	public String getPoly2() {

		return polynomial2.getText();
	}

	public void setResult(String r) {

		result.setText(r);
	}

}
