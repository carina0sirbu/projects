package ui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Account;
import model.Person;

public class TableFiller {

	public DefaultTableModel createPersonTable(List<Person> o) {

		if ((o == null) || (o.isEmpty())) {
			return new DefaultTableModel(new Object[0][0], new String[] { "No", "First name", "Last Name" });
		}

		String[][] matrix = new String[o.size()][3];

		for (int i = 0; i < o.size(); i++) {

			matrix[i][0] = o.get(i).getSsn();
			matrix[i][1] = o.get(i).getFirstName();
			matrix[i][2] = o.get(i).getLastName();
		}

		return new DefaultTableModel(matrix, new String[] { "No", "First name", "Last Name" });
	}

	public DefaultTableModel createAccountTable(List<Account> a) {

		if ((a == null) || (a.isEmpty())) {
			return new DefaultTableModel(new Object[0][0], new String[] { "Account id", "Balance", "Account type" });
		}

		String[][] matrix = new String[a.size()][3];

		for (int i = 0; i < a.size(); i++) {

			matrix[i][0] = a.get(i).getId();
			matrix[i][1] = Integer.toString(a.get(i).getSum());
			matrix[i][2] = a.get(i).getClass().getSimpleName();
		}

		return new DefaultTableModel(matrix, new String[] { "Account id", "Balance", "Account type" });
	}

}
