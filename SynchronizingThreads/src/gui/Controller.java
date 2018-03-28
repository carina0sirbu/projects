package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import model.SimulationManager;

public class Controller {
	
	private View v;
	private SimulationManager s;
	
	public Controller(View v) {
		
		this.v = v;
		
		v.addStartListener(new StartListener());
	
	}
	
	private class StartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
	
			SimulationManager s = new SimulationManager(Integer.parseInt(v.getTimeLimit()), Integer.parseInt(v.getMinProcessingTime()),
					Integer.parseInt(v.getMaxProcessingTime()), Integer.parseInt(v.getNumberOfServers()), 
					Integer.parseInt(v.getNumberOfTasks()));	

			Thread t = new Thread(s);
			t.start();
			Thread t1 = new Thread(new Animator(v, s));
			t1.start();
			Thread t2 = new Thread(new Logger(v));
			t2.start();
		}		
	}

}
