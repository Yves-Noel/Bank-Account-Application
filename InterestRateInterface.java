/**
 * 
 */
package bankAccountSystem;

/**
 * @author ynfor
 *
 */
public interface InterestRateInterface {
	
	// Write a method that returns a base rate
	default double getBaseInterestRate() {
		return 2.5;
	}

}
