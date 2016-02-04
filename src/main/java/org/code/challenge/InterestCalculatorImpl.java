package org.code.challenge;

import java.util.Collection;

import org.code.challenge.types.Card;
import org.code.challenge.types.Person;
import org.code.challenge.types.Wallet;

public class InterestCalculatorImpl implements InterestCalculator {
	
	/**
	 * @see org.code.challenge.misc.Calculator#calculateInterest(org.code.challenge.Person)
	 */
	@Override
	public double calculateInterest(Person p) {
		Collection<Wallet> wallets = p.getWallets();
		double interest = 0;
		for (Wallet w : wallets) {
			interest += calculateInterest(w);
		}
		return interest;
	}
	
	/**
	 * @see org.code.challenge.misc.Calculator#calculateInterest(org.code.challenge.Wallet)
	 */
	@Override
	public double calculateInterest(Wallet w) {
		Collection<Card> cards = w.getCards();
		double interest = 0;
		for (Card c : cards) {
			interest += calculateInterest(c);
		}
		return interest;
		
	}
	
	/**
	 * @see org.code.challenge.misc.Calculator#calculateInterest(org.code.challenge.Card)
	 */
	@Override
	public double calculateInterest(Card c) {
		return c.getInterestRate() * c.getBalance();
	}
	
	
}
