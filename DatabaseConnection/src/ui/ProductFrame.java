package ui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ProductFrame extends JFrame {
	
	private JButton addProduct;
	private JButton deleteProduct;
	private JButton backProduct;
	private JLabel id;
	private JLabel name;
	private JLabel price;
	private JLabel quantity;
	private JTextField idText;
	private JTextField nameText;
	private JTextField priceText;
	private JTextField quantityText;
	private JScrollPane table;

	
	public ProductFrame(JTable t) {
		
		table = new JScrollPane(t);
		table.setBounds(120, 60, 500, 150);
		this.getContentPane().add(table);
		
		idText = new JTextField();
		idText.setBounds(30, 290, 150, 40);
		this.getContentPane().add(idText);
		
		nameText = new JTextField();
		nameText.setBounds(200, 290, 150, 40);
		this.getContentPane().add(nameText);
		
		priceText = new JTextField();
		priceText.setBounds(370, 290, 150, 40);
		this.getContentPane().add(priceText);
		
		quantityText = new JTextField();
		quantityText.setBounds(540, 290, 150, 40);
		this.getContentPane().add(quantityText);
		
		id = new JLabel("ID");
		id.setBounds(100, 250, 80, 40);
		this.getContentPane().add(id);
		
		name = new JLabel("NAME");
		name.setBounds(250, 250, 80, 40);
		this.getContentPane().add(name);
		
		price = new JLabel("PRICE");
		price.setBounds(420, 250, 80, 40);
		this.getContentPane().add(price);
		
		quantity = new JLabel("QUANTITY");
		quantity.setBounds(580, 250, 80, 40);
		this.getContentPane().add(quantity);
		
		addProduct = new JButton("ADD");
		addProduct.setBounds(30, 400, 100, 30);
		this.getContentPane().add(addProduct);
		
		deleteProduct = new JButton("DELETE");
		deleteProduct.setBounds(160, 400, 100, 30);
		this.getContentPane().add(deleteProduct);
		
		backProduct = new JButton("BACK TO MENU");
		backProduct.setBounds(570, 400, 200, 30);
		this.getContentPane().add(backProduct);
		
		
		this.getContentPane().setBackground(new Color(111, 255, 100));
		this.setLayout(null);
		this.setSize(800, 500);
		this.setVisible(true);
		
	}
	
	public void addAddProductListener(ActionListener e) {
		addProduct.addActionListener(e);
	}
	
	public void addDeleteProductListener(ActionListener e) {
		deleteProduct.addActionListener(e);
	}
	
	public void addBackProductListener(ActionListener e) {
		backProduct.addActionListener(e);
	}
	
	public String getId() {
		return idText.getText();
	}
	
	public String getName() {
		return nameText.getText();
	}
	
	public String getPrice() {
		return priceText.getText();
	}
	
	public String getQuantity() {
		return quantityText.getText();
	}
	
}
