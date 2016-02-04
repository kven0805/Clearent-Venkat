package org.code.challenge.types;

import java.util.Collection;
import java.util.Collections;

public class Wallet {

	private Collection<Card> cards;
	
	public Wallet() {
		cards = Collections.emptyList();
	}

	public Collection<Card> getCards() {
		return cards;
	}

	public void setCards(Collection<Card> cards) {
		this.cards = Collections.unmodifiableCollection(cards);
	}
}
