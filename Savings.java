/**
 * 
 */
package bankAccountSystem;

/**
 * @author ynfor
 *
 */
public class Savings extends Account {
	
	// List properties specific to a savings account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	// Constructor to initialize savings account properties
	public Savings(String accountHolder, String socialSecurityNumber, double initialDeposit) {
		super(accountHolder, socialSecurityNumber, initialDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}
	
	@Override
	public void setInterestRate() {
		interestRate = getBaseInterestRate() - 0.25;
	}
		
	/**
	 * List any methods specific to the savings account
	 */
	
	//safety deposit box is identified by a safety deposit box ID (3-digit number) and accessed by a safety deposit box key (4-digit code).
	private void setSafetyDepositBox() {
		safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
		safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showAccountInfo() {
		System.out.println("ACCOUNT TYPE: Savings");
		super.showAccountInfo();
		System.out.println(
				"  ACCOUNT FEATURES" +
		        "\nSafety Deposit Box ID: " + safetyDepositBoxID +
		        "\nSafety Deposit Box Key: " + safetyDepositBoxKey
		        );
	}

}
