package package1;

public class Test {

	public static void main(String[] args) {
		Bank myBank = new Bank("Bank of America", 0.02);

		CheckingAccount c1 = new CheckingAccount(1, 11, 10);
		SavingAccount s1 = new SavingAccount(1, 12, 100);

		CheckingAccount c2 = new CheckingAccount(2, 21, 10);
		SavingAccount s2 = new SavingAccount(2, 22, 10);

		CheckingAccount c3 = new CheckingAccount(3, 31, 20);
		SavingAccount s3 = new SavingAccount(3, 32, 1);

		CheckingAccount c4 = new CheckingAccount(4, 41, 30);
		SavingAccount s4 = new SavingAccount(4, 42, 10);

		CheckingAccount c5 = new CheckingAccount(5, 51, 30);
		SavingAccount s5 = new SavingAccount(5, 52, 10);

		myBank.addAccount(c1);
		myBank.addAccount(s1);
		myBank.addAccount(c2);
		myBank.addAccount(s2);
		myBank.addAccount(c3);
		myBank.addAccount(s3);
		myBank.addAccount(c4);
		myBank.addAccount(s4);
		myBank.addAccount(c5);
		myBank.addAccount(s5);

		// not enough from checking, get penalty from savings
		myBank.withdraw(c1, 20);
		System.out.println(c1.getBalance());
		System.out.println(s1.getBalance());
		System.out.println("---------------------");
		// withdrawl failed, got $25 penalty, but checkings not enough for $25, then
		// from savings
		myBank.withdraw(c1, 120);
		System.out.println(c1.getBalance());
		System.out.println(s1.getBalance());
		System.out.println("---------------------");

		// withdrawl failed, checkings and savings together not enough for $25, so got
		// negative checkings
		myBank.withdraw(c2, 30);
		System.out.println(c2.getBalance());
		System.out.println(s2.getBalance());
		System.out.println("---------------------");

		// withdrawl failed, checkings and savings together not enough for $25, so got
		// negative checkings
		myBank.withdraw(c3, 30);
		System.out.println(c3.getBalance());
		System.out.println(s3.getBalance());
		System.out.println("---------------------");

		// withdrwal failed, penalty from checkings
		myBank.withdraw(c4, 50);
		System.out.println(c4.getBalance());
		System.out.println(s4.getBalance());
		System.out.println("---------------------");

		// normal withdraw
		myBank.withdraw(c5, 10);
		System.out.println(c5.getBalance());
		System.out.println(s5.getBalance());
		System.out.println("---------------------");

		// Award interest
		myBank.awardInterest();
		System.out.println(s1.getBalance());
		System.out.println(s2.getBalance());
		System.out.println(s3.getBalance());
		System.out.println(s4.getBalance());
		System.out.println(s5.getBalance());
	}

}
