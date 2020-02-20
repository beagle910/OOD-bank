package package1;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Account> arrli;
	private String bankName;
	private double r;

	public Bank(String name, double rate) {
		bankName = name;
		arrli = new ArrayList<Account>();
		r = rate;
	}

	// add account to account list
	public void addAccount(Account a) {
		arrli.add(a);
	}

	// get account list
	public ArrayList<Account> getList() {
		return arrli;
	}

	// award interest to savings account
	public void awardInterest() {
		for (Account a: arrli ) {
			a.getInt(r);
			
		}
	}

	// Deposit to an account
	public void deposite(Account a, double amount) {
		for (int i = 0; i < arrli.size(); i++) {
			if (arrli.get(i).getID() == a.getID()) {
				arrli.get(i).deposite(amount);
			}
		}
	}

	// Withdraw from checking account first then savings with penalty if savings has
	// enough
	// else get a negative checking balance
	public void withdraw(CheckingAccount c, double d) {
		int userID = c.getUserID();
		SavingAccount s = new SavingAccount(0, 0, 0);
		// get the saving account from the same user
		for (int i = 0; i < arrli.size(); i++) {
			if (arrli.get(i).getUserID() == userID && arrli.get(i) instanceof SavingAccount) {
				s = (SavingAccount) arrli.get(i);
			}
		}
		double cb = c.getBalance();
		double sb = s.getBalance();

		// checking account is enough
		if (d <= cb) {
			c.withdraw(d);
			System.out.println("Account " + c.getID() + " withdraw $" + d + ".");
		}
		// checking account is not enough, but it is enough with saving account
		else if (d > cb && d <= (cb + sb)) {
			System.out.println("Account " + c.getID() + " is not enough. Withdraw all $" + cb + ".");
			c.withdraw(cb);
			// amount needs from savings
			double tmp = d - cb;
			// saving account has enough besides $10 penalty
			if (tmp + 10 <= sb) {
				s.withdraw(tmp + 10);
				System.out.println("And then withdraw $" + tmp + " and $10 from savings account.");
			}
			// saving account does not have enough with $10 penalty, then checkings will
			// become negative
			else {
				c.withdraw(-sb + 10 + tmp);
				s.withdraw(sb);
				System.out.println(
						"Savings has not enough for $10 penalty, so -$" + (-sb + 10 + tmp) + " in checkings account.");
			}
		}

		// deposit failed
		else if (d > cb + sb) {
			System.out.println("Not enough! $25 fee!");
			// if checking has enough for $25
			if (cb >= 25) {
				c.withdraw(25);
				System.out.println("$25 fee from checkings!");
			}
			// if checking has not enough for $25
			else {
				// but savings has enough for the difference
				if (25 - cb < sb) {
					s.withdraw(25 - cb);
					c.withdraw(cb);
					System.out.println("Checkings has not enough of $25 fee, and " + (25 - cb) + " from savings.");
				}
				// even together with savings, they do not have $25, then checkings will become
				// negative.
				else {
					s.withdraw(sb);
					c.withdraw(cb);
					c.withdraw(25 - sb - cb);
					System.out.println("Checkings and savings together do not have enough! Checking has -$"
							+ (25 - sb - cb) + ".");
				}

			}

		}

	}

}
