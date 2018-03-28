package ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFramePopUp extends JFrame {

	private JButton add;
	private JLabel firstNamel;
	private JLabel lastNamel;
	private JTextField firstName;
	private JTextField lastName;

	public JFramePopUp() {

		firstNamel = new JLabel("First Name:");
		firstNamel.setBounds(20, 10, 150, 40);
		this.getContentPane().add(firstNamel);

		firstName = new JTextField();
		firstName.setBounds(20, 55, 150, 40);
		this.getContentPane().add(firstName);

		lastNamel = new JLabel("Last Name:");
		lastNamel.setBounds(20, 100, 150, 40);
		this.getContentPane().add(lastNamel);

		lastName = new JTextField();
		lastName.setBounds(20, 145, 150, 40);
		this.getContentPane().add(lastName);

		add = new JButton("OK");
		add.setBounds(200, 105, 60, 40);
		this.getContentPane().add(add);

		this.setSize(300, 250);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);

	}

	public void addAddListener(ActionListener e) {
		add.addActionListener(e);
	}

	public String getFirstName() {

		return firstName.getText();
	}

	public String getLastName() {

		return lastName.getText();
	}

}
