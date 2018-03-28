package model;

public class SavingAccount extends Account {

	private long startTime;
	
	public SavingAccount(int sum) {
		super(sum);
		this.startTime = System.currentTimeMillis();
		
	}
		
	public void withdraw() {
		
		if (sum == 0) {
			System.out.println("You cannot withdraw from this account anymore!");
			return;			
		}
		int interest = computeInterest(System.currentTimeMillis());
		int sumWith = sum + interest;
		
		sum = 0;
		this.notifyObserver(sumWith, 0, "withdraw");
	}
	
	public int computeInterest(long time) {
		
		return (sum * 5)/100 * (int)(time - startTime)/1000;
	}
	
}
