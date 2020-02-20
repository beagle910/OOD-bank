package package1;

public class CheckingAccount extends Account {

	public CheckingAccount(int userid, int ID, double amount) {
		super(userid, ID, amount);
		balance += amount;
	}

	// withdraw from account, may be negative
	public void withdraw(double w) {
		balance -= w;
	}

	@Override
	protected void getInt(double r) {
		// TODO Auto-generated method stub
		
	}

}
