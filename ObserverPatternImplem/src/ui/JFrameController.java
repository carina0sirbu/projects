package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Bank;
import model.Person;

public class JFrameController {

	private JFramePopUp frame;
	private View v;
	private Bank bank;

	public JFrameController(JFramePopUp frame, View v, Bank bank) {

		this.frame = frame;
		this.v = v;
		this.bank = bank;

		frame.addAddListener(new AddListener());
	}

	private class AddListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			bank.addPerson(new Person(frame.getFirstName(), frame.getLastName()));
			
			List<Person> list = new ArrayList<Person>();
			list.addAll(bank.getList().keySet());
			
			DefaultTableModel table = new TableFiller().createPersonTable(list);
			v.getPersonTable().setModel(table);  // this will return the person table from the main frame and set a new model to it
													// which is the defaultModelTable table
			
			frame.dispose();
		}
	}
}
