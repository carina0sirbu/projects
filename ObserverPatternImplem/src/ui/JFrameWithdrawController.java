package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Account;
import model.Bank;
import model.Person;
import model.SpendingAccount;

public class JFrameWithdrawController {

	private JFrameWithdraw frame;
	private View v;
	private Bank bank;

	public JFrameWithdrawController(JFrameWithdraw frame, View v, Bank bank) {

		this.frame = frame;
		this.v = v;
		this.bank = bank;

		frame.addOkListener(new OkListener());
	}

	private class OkListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			String person = v.getPersonId();
			String account = v.getAccountId();

			Person p = bank.findPersonById(person);
			Account a = bank.findAccountById(account, p);

			((SpendingAccount) a).withdraw(Integer.parseInt(frame.getSum()));
			
			
			
			
			List<Account> list = new ArrayList<Account>();
			list.addAll(bank.getList().get(p));
			
			DefaultTableModel table = new TableFiller().createAccountTable(list);
			v.getAccountTable().setModel(table);
			
			frame.dispose();
		}

	}
}
