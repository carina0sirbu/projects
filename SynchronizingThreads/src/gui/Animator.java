package gui;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JLabel;

import model.Server;
import model.SimulationManager;

public class Animator implements Runnable {

	private View v;
	private SimulationManager s;

	public Animator(View v, SimulationManager s) {

		this.v = v;
		this.s = s;
	}

	@Override
	public void run() {
		
		while (true) {
			v.getQueuesDisplay().removeAll();
			
			int x = 20;
			for (Server serv : s.getServerList()) {

				int y = 20;
				for (int i = 0; i < serv.getNumberOfTasks(); i++) {

					y += 40;
					JLabel j = new JLabel();
					j.setBounds(x, y, 30, 30);
					j.setBackground(Color.BLACK);
					j.setOpaque(true);
					v.getQueuesDisplay().add(j);
				}
				x += 40;
			}			
			v.getQueuesDisplay().repaint();

			try {
				Thread.sleep(999);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
