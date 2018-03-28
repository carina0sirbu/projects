package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Account;
import model.Bank;
import model.Person;
import model.SavingAccount;
import model.SerialHandler;

public class Controller {

	private View v;
	private Bank b;

	public Controller(View v, Bank b) {

		this.v = v;
		this.b = b;

		v.addAddPersonListener(new AddPersonListener());
		v.addAddAccountListener(new AccountListener());
		v.addWithdrawListener(new WithdrawListener());
		v.addDepositListener(new DepositListener());
		v.addPersonTableListener(new PersonTableListener());
		v.addWindowListener(new WinListener());
	}

	private class AddPersonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			new JFrameController(new JFramePopUp(), v, b);
		}
	}

	private class WinListener implements WindowListener {

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent arg0) {

			SerialHandler sh = new SerialHandler();

			sh.writeObject(b);
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	private class AccountListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new JFrameAccountController(new JFrameAccount(), v, b);
		}
	}

	private class WithdrawListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (v.getSort().equals("SpendingAccount")) {
				new JFrameWithdrawController(new JFrameWithdraw(), v, b);
				
				
				
			} else if (v.getSort().equals("SavingAccount")) {

				SavingAccount sa = ((SavingAccount) b.findAccountById(v.getAccountId(),
						b.findPersonById(v.getPersonId())));
				sa.withdraw();

				b.removeHolderAccount(b.findPersonById(v.getPersonId()), sa);

				List<Account> list = new ArrayList<Account>();
				list.addAll(b.getList().get(b.findPersonById(v.getPersonId())));

				DefaultTableModel table = new TableFiller().createAccountTable(list);
				v.getAccountTable().setModel(table);
			}

		}
	}

	private class DepositListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (v.getSort().equals("SavingAccount")) {
				JOptionPane.showMessageDialog(null, "No deposit allowed here!", "WARNING", JOptionPane.WARNING_MESSAGE);

			} else if (v.getSort().equals("SpendingAccount")) {
				new JFrameDepositController(new JFrameDeposit(), v, b);
			}
		}
	}

	private class PersonTableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {

			if (arg0.getButton() == MouseEvent.BUTTON1) {
				
				v.setVisibleElements();
				
				String s = v.getPersonId();
				Person p = b.findPersonById(s);
				v.setTable(new TableFiller().createAccountTable(b.getList().get(p)));
				v.addAccountTableListener(new AccountTableListener());
				
			} else if (arg0.getButton() == MouseEvent.BUTTON3) {

				new JPopupMenuController(new PopupMenu() {
					{

						this.show(arg0.getComponent(), arg0.getX(), arg0.getY());

					}
				}, v, b);
			}

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	private class AccountTableListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {

			if (arg0.getButton() == MouseEvent.BUTTON3) {

				new JPopupMenuAcController(new PopupMenu() {
					{

						this.show(arg0.getComponent(), arg0.getX(), arg0.getY());

					}
				}, v, b);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
