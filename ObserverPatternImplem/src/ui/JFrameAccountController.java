package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Account;
import model.Bank;
import model.SavingAccount;
import model.SpendingAccount;

public class JFrameAccountController {
	
	private JFrameAccount frame;
	private Bank bank;
	private View v;
	
	public JFrameAccountController(JFrameAccount frame, View v, Bank bank) {
		
		this.frame = frame;
		this.v = v;
		this.bank = bank;
		
		frame.addOkListener(new OkListener());
		
	}

	private class OkListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (frame.getComboText().equals("SpendingAccount")) {
				bank.addHolderAccount(bank.findPersonById(v.getPersonId()), new SpendingAccount(Integer.parseInt(frame.getSum())));
			}
			if (frame.getComboText().equals("SavingAccount")) {
				bank.addHolderAccount(bank.findPersonById(v.getPersonId()), new SavingAccount(Integer.parseInt(frame.getSum())));
			}
			
			List<Account> list = new ArrayList<Account>();
			list.addAll(bank.getList().get(bank.findPersonById(v.getPersonId())));
			
			DefaultTableModel table = new TableFiller().createAccountTable(list);
			v.getAccountTable().setModel(table);
			
			frame.dispose();
		}
		
	}
}
