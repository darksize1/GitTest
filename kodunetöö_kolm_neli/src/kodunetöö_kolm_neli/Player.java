package kodunet��_kolm_neli;

public class Player {
	/**
	 * m�ngija nimi.
	 */
	private String name;
	
	/**
	 * m�ngija praeguse k�e kaardid.
	 */
	private Card[] hand = new Card[10];
	
	/**
	 * mitu kaarti on m�ngijal praegusel k�el.
	 */
	private int numCards;
	
	/**
	 * m�nguri constructor.
	 */
	public Player(String theName) {
		
		this.name = theName;
		
		// t�hjendab m�ngija k�e
		this.emptyHand();
		
	}
	
	/**
	 * m�ngija k�e t�hjendamine.
	 */
	public void emptyHand() {
		
		for (int c = 0; c < 10; c++) {
			this.hand[c] = null;
		}
		this.numCards = 0;
		
	}
	
	/**
	 * lisab m�nijale k�tte kaarte.
	 * 
	 * @param aCard	kaart mille lisab
	 * @return		kas uue k�e summa on suurem v�i v�rdne 21 ga
	 */
	public boolean addCard(Card aCard) {
		
		// prindib errori kui m�ngijal on juba maksimaalne kodus kaarte , ei tohiks kunagi juhtuda 
		
		if (this.numCards == 10) {
			System.err.printf("%s's hand already has 10 cards; " + 
					"cannot add another\n", this.name);
			System.exit(1);
		}

		// lisab k�tte kaarte ja tagastab koguk�e summa
		this.hand[this.numCards] = aCard;
		this.numCards++;
		
		return (this.getHandSum() <= 21);
	}
	
	/**
	 * saam m�ngijal k�es olevate kaartide summa.
	 * 
	 * @return summa
	 */
	public int getHandSum() {
		
		int handSum = 0;
		int cardNum;
		int numAces = 0;
		
		// kalkuleerib iga kaardi osaluse kogu k�e summast
		for (int c = 0; c < this.numCards; c++) {
			
			// saab kaardi arvu
			cardNum = this.hand[c].getNumber();
			
			if (cardNum == 1) { // �ss
				numAces++;
				handSum += 11;
			} else if(cardNum > 10) { // pildiga kaart
				handSum += 10;
			} else {
				handSum += cardNum;
			}
		}
		
		// kui meil on �ssad ja meie summa on suurem kui 21 , muudab �ssa/de suuruse  hoopis 1
		
		while (handSum > 21 && numAces > 0) {
			handSum -= 10;
			numAces--;
		}
		
		return handSum;
		
	}
	
	/**
	 * prindib kaardid mis on m�ngija k�es
	 * 
	 * @param n�itab esimest kaarti olenemata kas see on peidetud v mitte
	 */
	public void printHand(boolean showFirstCard) {
		
		System.out.printf("%s's cards:\n", this.name);
		for (int c = 0; c < this.numCards; c++) {
			if (c == 0 && !showFirstCard) {
				System.out.println("  [hidden]");
			} else {
				System.out.printf("  %s\n", this.hand[c].toString());
			}
		}
		
	}

}
