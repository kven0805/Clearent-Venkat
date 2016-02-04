package org.code.challenge;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.code.challenge.types.Card;
import org.code.challenge.types.Person;
import org.code.challenge.types.Wallet;
import org.code.challenge.types.card.DiscoverCard;
import org.code.challenge.types.card.MasterCard;
import org.code.challenge.types.card.VisaCard;
import org.junit.Test;

public class InterestCalculatorImplTest {
	private InterestCalculator calculator = new InterestCalculatorImpl();

	@Test
	public void testTotalInterestCaseOne() {
		Person p = new Person();
		Wallet w = new Wallet();
		p.setWallets(Arrays.asList(w));
		Card mc = new MasterCard();
		mc.setBalance(100.00);
		Card visa = new VisaCard();
		visa.setBalance(100.00);
		Card discover = new DiscoverCard();
		discover.setBalance(100.00);
		w.setCards(Arrays.asList(mc, visa, discover));

		assertEquals(16, calculator.calculateInterest(p), 0.00);
	}

	/**
	 * One person two wallets, first wallet with visa and discover and second with mc. 
	 */
	@Test
	public void testTotalInterestCaseTwo() {
		Person p = new Person();
		Card mc = new MasterCard();
		mc.setBalance(100.00);
		Card visa = new VisaCard();
		visa.setBalance(100.00);
		Card discover = new DiscoverCard();
		discover.setBalance(100.00);

		Wallet wallet1 = createWallet(visa, discover);
		Wallet wallet2 = createWallet(mc);
		
		assertEquals(11, calculator.calculateInterest(wallet1), 0.00);
		assertEquals(5, calculator.calculateInterest(wallet2), 0.00);
		
		
		p.setWallets(Arrays.asList(wallet1, wallet2));

		assertEquals(16, calculator.calculateInterest(p), 0.00);
		
	}

	@Test
	public void testTotalInterestCaseThree() {
		Person p = new Person();
		Card mc = new MasterCard();
		mc.setBalance(100.00);
		Card visa = new VisaCard();
		visa.setBalance(100.00);
		Card discover = new DiscoverCard();
		discover.setBalance(100.00);

		Wallet wallet1 = createWallet(visa, mc);
		assertEquals(15, calculator.calculateInterest(wallet1), 0.00);
		
		p.setWallets(Arrays.asList(wallet1));
		assertEquals(15, calculator.calculateInterest(p), 0.00);
		
		Person p2 = new Person();
		
		Wallet wallet2 = createWallet(visa, mc);
		assertEquals(15, calculator.calculateInterest(wallet2), 0.00);
		
		p2.setWallets(Arrays.asList(wallet2));
		assertEquals(15, calculator.calculateInterest(p2), 0.00);
		

		
	}


	private Wallet createWallet(Card... cards) {
		Wallet w = new Wallet();
		w.setCards(Arrays.asList(cards));
		return w;
	}

}
