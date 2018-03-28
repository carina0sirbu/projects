package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank implements BankProc, Serializable {

	/*
	 * Each person in the bank has at least one account
	 */

	private Map<Person, List<Account>> list;

	public Bank() {

		list = new HashMap<Person, List<Account>>();
	}

	@Override
	public void addPerson(Person p) {

		assert p != null;
		assert isWellFormed();

		int noOfPerson = list.keySet().size();
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(new SpendingAccount(0));
		accountList.get(0).addObserver(p);

		list.put(p, accountList);

		assert list.keySet().size() == noOfPerson + 1;
		assert isWellFormed();
	}

	@Override
	public void removePerson(Person p) {

		assert p != null;
		assert isWellFormed();

		int noOfPerson = list.keySet().size();
		list.remove(p);

		assert list.keySet().size() == noOfPerson - 1;
		assert isWellFormed();
	}

	@Override
	public void addHolderAccount(Person p, Account a) {

		assert p != null && a != null;
		assert isWellFormed();

		int noOfAccounts = list.get(p).size();
		List<Account> l = list.get(p);

		a.addObserver(p);
		l.add(a);
		list.put(p, l);

		assert list.get(p).size() == noOfAccounts + 1;
		assert isWellFormed();
	}

	@Override
	public void removeHolderAccount(Person p, Account a) {

		assert p != null && a != null;
		assert isWellFormed();

		int noOfAccounts = list.get(p).size();
		List<Account> l = list.get(p);
		l.remove(a);
		list.put(p, l);
		
		int size = list.get(p).size(); 
		
		if (l.isEmpty()) {
			
			list.keySet().remove(p);
		}

		assert size == noOfAccounts - 1;
		assert isWellFormed();
	}

	public boolean isWellFormed() {

		for (Person p : list.keySet()) {

			if (list.keySet().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public Person findPersonById(String id) {

		for (Person p : list.keySet()) {

			if (id.equals(p.getSsn())) {

				return p;
			}
		}
		return null;
	}

	public Account findAccountById(String id, Person p) {

		for (Account a : list.get(p)) {

			if (id.equals(a.getId())) {

				return a;
			}
		}
		return null;
	}
	

	public Map<Person, List<Account>> getList() {
		return list;
	}

	public void setList(Map<Person, List<Account>> list) {
		this.list = list;
	}


}
