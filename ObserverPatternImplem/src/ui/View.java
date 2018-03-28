package ui;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

	private JButton addPerson;
	private JButton addAccount;
	private JButton withdraw;
	private JButton deposit;
	private JTable personTable;
	private JTable accountTable;
	private JScrollPane accountScrollPane;

	public View(JTable t) {

		this.personTable = t;

		JScrollPane personsTable = new JScrollPane(t);
		personsTable.setBounds(30, 30, 720, 160);
		this.getContentPane().add(personsTable);

		accountScrollPane = new JScrollPane();
		accountScrollPane.setBounds(30, 300, 600, 120);
		accountScrollPane.setVisible(false);
		this.getContentPane().add(accountScrollPane);

		addPerson = new JButton("ADD NEW PERSON");
		addPerson.setBounds(150, 220, 150, 40);
		this.getContentPane().add(addPerson);

		addAccount = new JButton("ADD NEW ACCOUNT");
		addAccount.setBounds(450, 220, 150, 40);
		addAccount.setVisible(false);
		this.getContentPane().add(addAccount);

		withdraw = new JButton("WITHDRAW");
		withdraw.setBounds(660, 300, 100, 40);
		withdraw.setVisible(false);
		this.getContentPane().add(withdraw);

		deposit = new JButton("DEPOSIT");
		deposit.setBounds(660, 380, 100, 40);
		deposit.setVisible(false);
		this.getContentPane().add(deposit);

		this.getContentPane().setBackground(new Color(0, 5, 52));
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800, 500);
		this.setVisible(true);
	}

	public void addAddPersonListener(ActionListener e) {
		addPerson.addActionListener(e);
	}

	public void addAddAccountListener(ActionListener e) {
		addAccount.addActionListener(e);
	}

	public void addWithdrawListener(ActionListener e) {
		withdraw.addActionListener(e);
	}

	public void addDepositListener(ActionListener e) {
		deposit.addActionListener(e);
	}

	public void addPersonTableListener(MouseListener e) {
		personTable.addMouseListener(e);
	}

	public void addAccountTableListener(MouseListener e) {
		if (accountTable != null) {
			accountTable.addMouseListener(e);
		}
	}

	public void setVisibleElements() {

		addAccount.setVisible(true);
		withdraw.setVisible(true);
		deposit.setVisible(true);
		this.getContentPane().repaint();
	}

	public void setTable(DefaultTableModel table) {

		JTable t = new JTable(table);
		accountTable = t;

		this.getContentPane().remove(accountScrollPane);

		accountScrollPane = new JScrollPane(accountTable);
		accountScrollPane.setBounds(30, 300, 600, 120);
		this.getContentPane().add(accountScrollPane);

	}

	public String getPersonId() {

		return personTable.getValueAt(personTable.getSelectedRow(), 0).toString();
	}

	public String getAccountId() {

		return accountTable.getValueAt(accountTable.getSelectedRow(), 0).toString();
	}

	public String getSort() {

		return accountTable.getValueAt(accountTable.getSelectedRow(), 2).toString();
	}

	public JTable getPersonTable() {

		return personTable;
	}

	public JTable getAccountTable() {

		return accountTable;
	}

}
