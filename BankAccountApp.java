/**
 * 
 */
package bankAccountSystem;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ynfor
 *
 */

public class BankAccountApp {
	
	public static void main(String[] args) {
		
		List<Account> accounts = new LinkedList<Account>();
		
		// Read a CSV File then create new accounts based on the data
		String file = "C:\\Users\\ynfor\\Desktop\\Back-End\\src\\bankAccountSystem\\NewBankAccounts.csv";
		List<String[]> newCustomers = utilities.CSV.read(file);
		for (String[] newCustomer : newCustomers) {
			String accountHolder = newCustomer[0];
			String socialSecurityNumber = newCustomer[1];
			String accountType = newCustomer[2];
			double initialDeposit = Double.parseDouble(newCustomer[3]);
			
			if (accountType.equals("Savings")) {
				accounts.add(new Savings(accountHolder, socialSecurityNumber, initialDeposit));
			
			}
			else if (accountType.equals("Checking")) {
				accounts.add(new Checking(accountHolder, socialSecurityNumber, initialDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
			
			
		}
		
		for (Account newAccount : accounts) {
			System.out.println("\n*******************************************");
			newAccount.showAccountInfo();
		}
	}

}
