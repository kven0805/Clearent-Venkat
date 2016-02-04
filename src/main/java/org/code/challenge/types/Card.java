/**
 * 
 */
package org.code.challenge.types;

import java.math.BigDecimal;

import org.code.challenge.misc.InterestProvider;

/**
 * Using doubles since this test is for object oriented principles
 *
 */
public abstract class Card implements InterestProvider {
	private double balance = 0;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	// if we take domain approach
	public double getInterest() {
		return BigDecimal.valueOf(getBalance()).multiply(BigDecimal.valueOf(getInterestRate())).doubleValue();
	}

	public abstract double getInterestRate();
}
