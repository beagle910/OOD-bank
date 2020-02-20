package package1;

public class SavingAccount extends Account {
	private double interest;
	public SavingAccount(int userid, int ID, double amount) {
		super(userid, ID, amount);
		balance += amount;
	}

	// withdraw from account till 0
	public void withdraw(double w) {
		if (w <= balance) {
			balance -= w;
		} else if (w > balance) {
			balance = 0;
		}
	}

	// get interest and add to balance
	public void getInt(double r) {
		double i = this.getBalance() * r;
		balance += i;
		System.out.println("Interest got: $" + i);
	}

}
