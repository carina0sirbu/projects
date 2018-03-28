package model;

public class SpendingAccount extends Account {

	public SpendingAccount(int sum) {
		super(sum);
		
	}

	public void deposit(int s) {
		
		int oldSum = sum;
		sum = sum + s;
		this.notifyObserver(oldSum, sum, "deposit");
	}
	
	public void withdraw(int s) {
		
		if (sum < s) {
			System.out.println("Not enough money!");
			return;
		}
		
		int oldSum = sum;
		sum = sum - s;
		this.notifyObserver(oldSum, sum, "withdraw");
		
	}
}
