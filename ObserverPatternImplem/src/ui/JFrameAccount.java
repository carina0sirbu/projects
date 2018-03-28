package ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameAccount extends JFrame {
	
	private JLabel sum;
	private JTextField sumText;
	private JComboBox<String> type;
	private JButton ok;
	
	public JFrameAccount() {
		
		sum = new JLabel("SUM");
		sum.setBounds(120, 10, 240, 40);
		this.getContentPane().add(sum);
		
		sumText = new JTextField();
		sumText.setBounds(30, 60, 240, 40);
		this.getContentPane().add(sumText);
		
		type = new JComboBox<String>(new String[] {"", "SavingAccount", "SpendingAccount"});
		type.setBounds(30, 120, 240, 40);
		this.getContentPane().add(type);
		
		ok = new JButton("OK");
		ok.setBounds(120, 170, 60, 40);
		this.getContentPane().add(ok);
		
		this.setSize(300, 250);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
	}
	
	public void addOkListener(ActionListener e) {
		ok.addActionListener(e);
	}
	
	public String getSum() {
		
		return sumText.getText();
	}
	
	public String getComboText() {
		
		return type.getSelectedItem().toString();
	}
}
