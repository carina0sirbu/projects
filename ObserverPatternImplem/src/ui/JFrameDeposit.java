package ui;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JFrameDeposit extends JFrame {
	
	private JLabel sum;
	private JTextField sumText;
	private JButton ok;
	
	public JFrameDeposit() {
		
		sum = new JLabel("SUM");
		sum.setBounds(30, 30, 90, 40);
		this.getContentPane().add(sum);
		
		sumText = new JTextField();
		sumText.setBounds(30, 80, 90, 40);
		this.getContentPane().add(sumText);
		
		ok = new JButton("OK");
		ok.setBounds(125, 125, 60, 40);
		this.getContentPane().add(ok);
		
		this.setLayout(null);
		this.setSize(300, 250);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public void addOkListener(ActionListener e) {
		ok.addActionListener(e);
	}
	
	public String getSum() {
		return sumText.getText();
	}
}
