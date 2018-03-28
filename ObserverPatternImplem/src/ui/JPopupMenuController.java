package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Bank;
import model.Person;

public class JPopupMenuController {

	private PopupMenu frame;
	private View v;
	private Bank bank;
	
	public JPopupMenuController (PopupMenu frame, View v, Bank bank) {
		
		this.frame = frame;
		this.v = v;
		this.bank = bank;
		
		frame.addDeleteListener(new DeleteListener());
	}
	
	private class DeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			bank.removePerson(bank.findPersonById(v.getPersonId()));
			
			List<Person> list = new ArrayList<Person>();
			list.addAll(bank.getList().keySet());
			list.remove(bank.findPersonById(v.getPersonId()));
			
			DefaultTableModel table = new TableFiller().createPersonTable(list);
			v.getPersonTable().setModel(table);
			
			v.getAccountTable().setVisible(false);
		}
		
	}
	
}
