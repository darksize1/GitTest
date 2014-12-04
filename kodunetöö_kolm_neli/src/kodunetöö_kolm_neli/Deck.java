package kodunet��_kolm_neli;

import java.util.Random;

/**
 * kaardipakk.
 */
public class Deck {

	/**
	 * array kaarditest pakkis , kus �lemine kaart on esimese indeksiga.
	 */
	private Card[] myCards;
	
	/**
	 * number palju kaarte on hetkel pakkis.
	 */
	private int numCards;
	
	/**
	 * pakk kus tavaliselt on 52 kaarti ja ei segata pakki.
	 */
	public Deck(){
		
		// kutsub j�rgmise pakki ja m��rab defineerib �ra selle pakki ilma segamata
		this(1, false);
	}
	
	/**
	 *  m��rab �ra palju pake on �hes suures pakkis ja kas see peaks olema segatud v�i mitte 
	 * 
	 * @param numDecks	mitu �ksikut pakki on �hes suures pakkis
	 * @param shuffle	segada v�i mitte segada
	 */
	public Deck(int numDecks, boolean shuffle){
		
		this.numCards = numDecks * 52;
		this.myCards = new Card[this.numCards];
		
		// kaardi indeks
		int c = 0;
		
		// for igaks pakkiks
		for (int d = 0; d < numDecks; d++) {
			
			// for igaks mastiks
			for (int s = 0; s < 4; s++) {
				
				// for iga number
				for (int n = 1; n <= 13; n++) {
					
					// lisab uue kaardi kaardipakki
					this.myCards[c] = new Card(Suit.values()[s], n);
					
					// kaardi indeksi juurdekasv
					c++;
					
				}
			}
		}
		
		// segab kui vajalik
		if (shuffle) {
			this.shuffle();
		}
		
	}
	
	/**
	 * segab pakki suvaliselt vahetades kaardi paare
	 */
	public void shuffle(){
		
		// paneb random numbri generaatori t��le
		Random rng = new Random();
		
		// ajutine kaart
		Card temp;
		
		int j;
		for (int i = 0; i < this.numCards; i++){
			
			//saab kaardi millega ta kaardi i vahetab
			j = rng.nextInt(this.numCards);
			
			// teeb vahetuse
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;
		}
		
	}
	
	/**
	 *jagab uue kaardi kaardi algusest
	 * 
	 * @return	jagatud kaart
	 */
	public Card dealNextCard() {
		
		// v�tab �lemise kaardi
		Card top = this.myCards[0];
		
		// paneb �lej��nud kaardid �kshaaval vasakule 
		for (int c = 1; c < this.numCards; c++) {
			this.myCards[c-1] = this.myCards[c];
		}
		this.myCards[this.numCards-1] = null;
		
		// kaartide number
		this.numCards--;
		
		// return �lemise kaardi
		return top;
		
	}
	
	/**
	 * prindib �lemised kaardid.
	 * 
	 * @param numToPrint	kaartide number kaardi paki algusest mis tuleb printida
	 */
	public void printDeck(int numToPrint) {
		
		// prindib �lemised kaardid 
		for (int c = 0; c < numToPrint; c++) {
			System.out.printf("% 3d/%d) %s\n", c + 1, this.numCards, 
					this.myCards[c].toString());
		}
		
		System.out.printf("         [%d others]\n\n", this.numCards-numToPrint);
		
	}
	
}