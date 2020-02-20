package package1;

public abstract class Account {
	protected int ID;
	protected int userID;
	protected double balance;

	public Account(int userid, int ID, double amount) {
		this.ID = ID;
		userID = userid;

	}

	// withdraw from account
	public abstract void withdraw(double w);

	// Deposit to account
	public void deposite(double d) {
		balance += d;
	}

	// get account ID
	public int getID() {
		return ID;
	}

	public int getUserID() {
		return userID;
	}

	// get account balance
	public double getBalance() {
		return balance;
	}

	protected abstract void getInt(double r);

}
