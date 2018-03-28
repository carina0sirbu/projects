package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logger implements Runnable {

	private static List<String> log = new ArrayList<String>();
	private View v;

	public Logger(View v) {
		this.v = v;
	}

	public static void addInLog(String s) {
		log.add(s);
	}
	
	public static void addInFile(String fileName) {
		try {
			FileWriter file = new FileWriter(fileName);
			BufferedWriter buf = new BufferedWriter(file);
			
			for (String s: log) {
				buf.append(s);
				buf.newLine();
			}
			buf.close();
			file.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		while (true) {
			v.clearLog();
			for (int i = 0; i < log.size(); i++){
				v.setLog(log.get(i));
				v.setLog("\n");
			}
			try {
				Thread.sleep(999);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
