/**
 * 
 */
package bankAccountSystem;

/**
 * @author ynfor
 *
 */
public class Checking extends Account{
	
	// List properties specific to a checking account
	private int debitCardNumber;
	private int debitCardPin;
	
// Constructor to initialize checking account properties
	public Checking(String accountHolder, String socialSecurityNumber, double initialDeposit) {
		super(accountHolder, socialSecurityNumber, initialDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	@Override
	public void setInterestRate() {
		interestRate = getBaseInterestRate() * 0.15;
	}
	
// List any methods specific to the checking account
	
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPin = (int) (Math.random() * Math.pow(10, 4));
	}
	public void showAccountInfo() {
		System.out.println("ACCOUNT TYPE: Checking");
		super.showAccountInfo();
		System.out.println(
				"  ACCOUNT FEATURES" +
		        "\nDebit Card Number: " + debitCardNumber +
		        "\nDebit Card Pin: " + debitCardPin
		        );
	}
}
