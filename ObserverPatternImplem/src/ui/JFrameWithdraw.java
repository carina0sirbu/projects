package ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameWithdraw extends JFrame {

	private JLabel withdraw;
	private JTextField withdrawt;
	private JButton ok;
	
	public JFrameWithdraw() {
		
		withdraw = new JLabel("SUM");
		withdraw.setBounds(30, 30, 90, 40);
		this.getContentPane().add(withdraw);
		
		withdrawt = new JTextField();
		withdrawt.setBounds(30, 80, 90, 40);
		this.getContentPane().add(withdrawt);
		
		ok = new JButton("OK");
		ok.setBounds(125, 125, 60, 40);
		this.getContentPane().add(ok);
		
		this.setSize(250, 300);
		this.setLayout(null);
		this.setVisible(true);
		
	}
	
	public void addOkListener(ActionListener e) {
		ok.addActionListener(e);
	}
	
	public String getSum() {
		
		return withdrawt.getText();
	}
	
}
