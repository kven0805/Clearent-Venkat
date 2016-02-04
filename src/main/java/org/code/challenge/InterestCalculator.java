package org.code.challenge;

import org.code.challenge.types.Card;
import org.code.challenge.types.Person;
import org.code.challenge.types.Wallet;

public interface InterestCalculator {

	double calculateInterest(Person p);

	double calculateInterest(Wallet w);

	double calculateInterest(Card c);

}