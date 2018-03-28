package gui;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame {

	private JLabel timeLimitL;
	private JLabel maxProcessingTimeL;
	private JLabel minProcessingTimeL;
	private JLabel numberOfServersL;
	private JLabel numberOfTasksL;
	private JTextField timeLimitT;
	private JTextField maxProcessingTimeT;
	private JTextField minProcessingTimeT;
	private JTextField numberOfServersT;
	private JTextField numberOfTasksT;
	private JPanel queuesDisplay;
	private volatile JTextArea log;
	private JButton start;

	public View() {

		timeLimitL = new JLabel("     Sim time: ");
		timeLimitL.setBounds(30, 30, 100, 35);
		this.getContentPane().add(timeLimitL);

		timeLimitT = new JTextField();
		timeLimitT.setBounds(30, 70, 100, 35);
		this.getContentPane().add(timeLimitT);

		maxProcessingTimeL = new JLabel("Max Proc. time: ");
		maxProcessingTimeL.setBounds(30, 110, 100, 35);
		this.getContentPane().add(maxProcessingTimeL);

		maxProcessingTimeT = new JTextField();
		maxProcessingTimeT.setBounds(30, 150, 100, 35);
		this.getContentPane().add(maxProcessingTimeT);

		minProcessingTimeL = new JLabel("Min Proc. time: ");
		minProcessingTimeL.setBounds(30, 190, 100, 35);
		this.getContentPane().add(minProcessingTimeL);

		minProcessingTimeT = new JTextField();
		minProcessingTimeT.setBounds(30, 230, 100, 35);
		this.getContentPane().add(minProcessingTimeT);

		numberOfServersL = new JLabel("No of servers: ");
		numberOfServersL.setBounds(30, 270, 100, 35);
		this.getContentPane().add(numberOfServersL);

		numberOfServersT = new JTextField();
		numberOfServersT.setBounds(30, 310, 100, 35);
		this.getContentPane().add(numberOfServersT);

		numberOfTasksL = new JLabel("No of tasks: ");
		numberOfTasksL.setBounds(30, 350, 100, 35);
		this.getContentPane().add(numberOfTasksL);

		numberOfTasksT = new JTextField();
		numberOfTasksT.setBounds(30, 390, 100, 35);
		this.getContentPane().add(numberOfTasksT);

		queuesDisplay = new JPanel();
		queuesDisplay.setBackground(Color.GRAY);
		queuesDisplay.setOpaque(true);
		queuesDisplay.setBounds(140, 30, 315, 500);
		queuesDisplay.setVisible(true);
		this.getContentPane().add(queuesDisplay);

		log = new JTextArea();
		log.setBounds(455, 30, 315, 500);
		log.setEditable(false);
		JScrollPane scroll = new JScrollPane(log);
		scroll.setBounds(455, 30, 315, 500);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scroll);

		start = new JButton("START");
		start.setBounds(35, 450, 90, 50);
		this.getContentPane().add(start);

		this.getContentPane().setBackground(new Color(34, 139, 34));
		this.setLayout(null);
		this.setSize(800, 600);
		this.setVisible(true);

	}

	public void addStartListener(ActionListener e) {
		start.addActionListener(e);
	}

	public String getTimeLimit() {
		return timeLimitT.getText();
	}

	public String getMaxProcessingTime() {
		return maxProcessingTimeT.getText();
	}

	public String getMinProcessingTime() {
		return minProcessingTimeT.getText();
	}

	public String getNumberOfServers() {
		return numberOfServersT.getText();
	}

	public String getNumberOfTasks() {
		return numberOfTasksT.getText();
	}

	public void setLog(String s) {
		this.log.append(s);
	}

	public JPanel getQueuesDisplay() {
		return queuesDisplay;
	}
	
	public void clearLog() {
		this.log.setText("");
	}
}
