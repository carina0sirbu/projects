package ui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class OrderFrame extends JFrame {

	private JButton addOrder;
	private JButton backOrder;
	private JLabel id;
	private JLabel clients_id;
	private JLabel product_id;
	private JLabel quantity;
	private JTextField idText;
	private JTextField clients_idText;
	private JTextField product_idText;
	private JTextField quantityText;
	private JScrollPane table;

	public OrderFrame(JTable t) {

		table = new JScrollPane(t);
		table.setBounds(120, 60, 500, 150);
		this.getContentPane().add(table);

		idText = new JTextField();
		idText.setBounds(30, 290, 150, 40);
		this.getContentPane().add(idText);

		clients_idText = new JTextField();
		clients_idText.setBounds(200, 290, 150, 40);
		this.getContentPane().add(clients_idText);

		product_idText = new JTextField();
		product_idText.setBounds(370, 290, 150, 40);
		this.getContentPane().add(product_idText);
		
		quantityText = new JTextField();
		quantityText.setBounds(540, 290, 150, 40);
		this.getContentPane().add(quantityText);

		id = new JLabel("ID");
		id.setForeground(Color.WHITE);
		id.setBounds(100, 250, 80, 40);
		this.getContentPane().add(id);

		clients_id = new JLabel("CLIENT ID");
		clients_id.setForeground(Color.WHITE);
		clients_id.setBounds(250, 250, 80, 40);
		this.getContentPane().add(clients_id);
		
		product_id = new JLabel("PRODUCT ID");
		product_id.setForeground(Color.WHITE);
		product_id.setBounds(420, 250, 80, 40);
		this.getContentPane().add(product_id);
		
		quantity = new JLabel("QUANTITY");
		quantity.setForeground(Color.WHITE);
		quantity.setBounds(580, 250, 80, 40);
		this.getContentPane().add(quantity);

		addOrder = new JButton("ADD");
		addOrder.setBounds(300, 400, 100, 30);
		this.getContentPane().add(addOrder);

		backOrder = new JButton("BACK TO MENU");
		backOrder.setBounds(570, 400, 200, 30);
		this.getContentPane().add(backOrder);

		this.getContentPane().setBackground(new Color(2, 26, 96));
		this.setLayout(null);
		this.setSize(800, 500);
		this.setVisible(true);

	}

	public void addAddOrderListener(ActionListener e) {
		addOrder.addActionListener(e);
	}

	public void addBackOrderListener(ActionListener e) {
		backOrder.addActionListener(e);
	}

	public String getId() {
		return idText.getText();
	}

	public String getClints_id() {
		return clients_idText.getText();
	}
	
	public String getProduct_id() {
		return product_idText.getText();
	}

	public String getQuantity() {
		return quantityText.getText();
	}

}
