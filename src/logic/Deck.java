package logic;

/**
 * 
 * 
 *
 */
public class Deck {

	private int numberOfCards;
	private Card[] allCards;

	public Deck(int numberOfCards) {
		this.numberOfCards = numberOfCards;
		createDeck();
	}

	private void createDeck() {
		setAllCards(new Card[this.numberOfCards]);
		for (int i = 0; i < numberOfCards; i++) {
			allCards[i] = new Card(i + 1, i);
		}
	}

	public int getNumberOfCards() {
		return this.numberOfCards;
	}

	public Card[] getAllCards() {
		return allCards;
	}

	public void setAllCards(Card[] allCards) {
		this.allCards = allCards;
	}
	
	public Card getCardWithIndex(int index) {
		return allCards[index];
	}
	
	public void setCardWithIndex(int index, Card card) {
		allCards[index] = card;
	}
}
