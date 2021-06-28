/**
 * 
 */
package bankAccountSystem;

/**
 * @author ynfor
 *
 */

//Using the abstract means we will not be able to create objects from the account class but we can create objects from classes that inherit account
public abstract class Account implements InterestRateInterface {
	
	// List common properties for savings and checking accounts
	private String accountHolder;
	private String socialSecurityNumber;
	private double accountBalance;
	
	static int index = 10000;
	protected String accountNumber;
	protected double interestRate;
	
	
	//Constructor to set base properties and initialize the account (properties common to both accounts)
	public Account(String accountHolder, String socialSecurityNumber, double initialDeposit) {
		this.accountHolder = accountHolder;
		this.socialSecurityNumber = socialSecurityNumber;
		accountBalance = initialDeposit;
		
		// set account number
		// [1 or 2] + [last two digits of SSN] + [unique ID (5-digit number)] + [random 3-digit number]
		index++;
		this.accountNumber = setAccountNumber();
		
		setInterestRate();
	}
	
	// Method that generates the account number
	private String setAccountNumber() {
		String lastTwoDigitsOfSSN = socialSecurityNumber.substring(socialSecurityNumber.length()-2, socialSecurityNumber.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() + Math.pow(10, 3));
		return lastTwoDigitsOfSSN + uniqueID + randomNumber;
	}
	
	public void compoundInterest() {
		double accruedInterest = accountBalance * (interestRate/100);
		accountBalance = accountBalance + accruedInterest;
		System.out.println("Accrued Interest: $" + accruedInterest);
		System.out.println("______________________________");
		printAccountBalance();
	}
	
	// Methods common to both accounts
	public void deposit(double amount) {
		accountBalance = accountBalance + amount;
		System.out.println("Depositing $" + amount + " ...");
		System.out.println("______________________________");
		printAccountBalance();
	}
	
	public void withdraw(double amount) {
		accountBalance = accountBalance - amount;
		System.out.println("Withdrawing $" + amount + " ...");
		System.out.println("______________________________");
		printAccountBalance();
	}
	
	public void transfer(String accountLocation, double amount) {
		accountBalance = accountBalance - amount;
		System.out.println("Transfering $" + amount + " to " + accountLocation);
		System.out.println("______________________________");
		printAccountBalance();
	}
	
	public void printAccountBalance() {
		System.out.println("Your account balance is now $" + accountBalance);
	}
	
	// Abstract method ensures that the checking and savings account implement this method
	public abstract void setInterestRate();
	
	public void showAccountInfo() {
		System.out.println(
				"ACCOUNT HOLDER: " + accountHolder +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nACCOUNT BALANCE: " + accountBalance +
				"\nINTEREST RATE: " + interestRate + "%"
				);
	}

}
