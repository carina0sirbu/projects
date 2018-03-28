package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Account;
import model.Bank;
import model.Person;

public class JPopupMenuAcController {

	private PopupMenu frame;
	private View v;
	private Bank b;
	
	public JPopupMenuAcController (PopupMenu frame, View v, Bank b) {
		
		this.frame = frame;
		this.v = v;
		this.b = b;
		
		frame.addDeleteListener(new DeleteListener());
	}
	
	private class DeleteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Person p = b.findPersonById(v.getPersonId());
			
			b.removeHolderAccount(p, b.findAccountById(v.getAccountId(), p));
			
			List<Account> list = new ArrayList<Account>();
			list.addAll(b.getList().get(p));
			
			DefaultTableModel table = new TableFiller().createAccountTable(list);
			v.getAccountTable().setModel(table);
			
		}
		
	}
}
