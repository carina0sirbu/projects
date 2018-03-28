package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import ui.Controller;
import ui.TableFiller;
import ui.View;

public class Main {
	
	public static void main (String[] args) {		
		
		SerialHandler sh = new SerialHandler();
		
		Bank bank = (Bank)sh.readObject();
		
		TableFiller t = new TableFiller();
		List<Person> list = new ArrayList<Person>();
		list.addAll(bank.getList().keySet());
		
		
		View v = new View(new JTable(t.createPersonTable(list)));
		new Controller(v, bank);
	}

}
