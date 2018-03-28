package ui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class View extends JFrame {

	public JButton customer;
	public JButton order;
	public JButton product;

	public View() {

		customer = new JButton("Customers");
		customer.setBounds(30, 110, 100, 40);
		customer.setBackground(Color.lightGray);
		customer.setBorder(new LineBorder(Color.DARK_GRAY));
		this.getContentPane().add(customer);
		
		order = new JButton("Orders");
		order.setBounds(180, 110, 100, 40);
		order.setBackground(Color.lightGray);
		order.setBorder(new LineBorder(Color.DARK_GRAY));
		this.getContentPane().add(order);
		
		product = new JButton("Products");
		product.setBounds(330, 110, 100, 40);
		product.setBackground(Color.lightGray);
		product.setBorder(new LineBorder(Color.DARK_GRAY));
		this.getContentPane().add(product);

		this.getContentPane().setBackground(new Color(34, 139, 150));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	
	public void addCustomerListener(ActionListener e) {
		customer.addActionListener(e);
	}
	
	public void addOrderListener(ActionListener e) {
		order.addActionListener(e);
	}
	
	public void addProductListener(ActionListener e) {
		product.addActionListener(e);
	}
	
	
	
}
