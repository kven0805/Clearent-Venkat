package org.code.challenge.types;

import java.util.Collection;
import java.util.Collections;

public class Person  {
	private Collection<Wallet> wallets;
	
	public Person() {
		wallets = Collections.emptyList();
	}

	public Collection<Wallet> getWallets() {
		return wallets;
	}

	public void setWallets(Collection<Wallet> wallets) {
		this.wallets = Collections.unmodifiableCollection(wallets);
	}


}
