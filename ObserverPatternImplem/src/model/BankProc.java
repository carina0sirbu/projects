package model;

public interface BankProc {
	
	
	/* @Pre: p != null
	 * 
	 * @Post: list's size increased by 1
	 * */
	public void addPerson(Person p);
	
	/* @Pre: p!= null
	 * 
	 * @Post: list's size decreased by 1
	 * */
	public void removePerson(Person p);
	
	/* @Pre: p != null and a != null
	 * 
	 * @Post: p's list of accounts increased by 1
	 * */
	public void addHolderAccount(Person p, Account a);
	
	/* @Pre: p != null and a != null
	 * 
	 * @Post: p's list of accounts decreased by 1
	 * */	
	public void removeHolderAccount(Person p, Account a);
	
}
