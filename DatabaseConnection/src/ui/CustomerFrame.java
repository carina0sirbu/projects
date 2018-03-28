package ui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CustomerFrame extends JFrame {
	
	private JButton addCustomer;
	private JButton deleteCustomer;
	private JButton updateCustomer;
	private JButton backCustomer;
	private JLabel id;
	private JLabel name;
	private JLabel age;
	private JTextField idText;
	private JTextField nameText;
	private JTextField ageText;
	private JScrollPane table;
	private JTable t;
	
	
	public CustomerFrame(JTable t) {
		
		this.t = t;
		
		table = new JScrollPane(t);
		table.setBounds(120, 60, 500, 150);
		this.getContentPane().add(table);
		
		idText = new JTextField();
		idText.setBounds(30, 290, 200, 40);
		this.getContentPane().add(idText);
		
		nameText = new JTextField();
		nameText.setBounds(250, 290, 200, 40);
		this.getContentPane().add(nameText);
		
		ageText = new JTextField();
		ageText.setBounds(470, 290, 200, 40);
		this.getContentPane().add(ageText);
		
		id = new JLabel("ID");
		id.setForeground(Color.WHITE);
		id.setBounds(115, 250, 80, 40);
		this.getContentPane().add(id);
		
		name = new JLabel("NAME");
		name.setForeground(Color.WHITE);
		name.setBounds(335, 250, 80, 40);
		this.getContentPane().add(name);
		
		age = new JLabel("AGE");
		age.setForeground(Color.WHITE);
		age.setBounds(555, 250, 80, 40);
		this.getContentPane().add(age);
		
		
		addCustomer = new JButton("ADD");
		addCustomer.setBounds(30, 400, 100, 30);
		this.getContentPane().add(addCustomer);
		
		deleteCustomer = new JButton("DELETE");
		deleteCustomer.setBounds(160, 400, 100, 30);
		this.getContentPane().add(deleteCustomer);
		
		updateCustomer = new JButton("UPDATE");
		updateCustomer.setBounds(290, 400, 100, 30);
		this.getContentPane().add(updateCustomer);
		
		backCustomer = new JButton("BACK TO MENU");
		backCustomer.setBounds(570, 400, 200, 30);
		this.getContentPane().add(backCustomer);
		
		
		this.getContentPane().setBackground(new Color(11, 15, 50));
		this.setLayout(null);
		this.setSize(800, 500);
		this.setVisible(true);
	}
	
	
	public void addAddCustomerListener(ActionListener e) {
		addCustomer.addActionListener(e);
	}
	
	public void addDeleteCustomerListener(ActionListener e) {
		deleteCustomer.addActionListener(e);
	}
	
	public void addUpdateCustomerListener(ActionListener e) {
		updateCustomer.addActionListener(e);
	}
	
	public void addBackCustomerListener(ActionListener e) {
		backCustomer.addActionListener(e);
	}
	
	public String getId() {
		return idText.getText();
	}
	
	public String getName() {
		return nameText.getText();
	}
	
	public String getAge() {
		return ageText.getText();
	}

}
