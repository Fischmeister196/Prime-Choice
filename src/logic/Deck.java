package logic;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 *
 */
public class Deck {

	private int numberOfCards;
	private ArrayList<Card> allCards;

	public Deck(int numberOfCards) {
		this.numberOfCards = numberOfCards;
		createDeck();
	}

	private void createDeck() {
		allCards = new ArrayList<Card>();
		for (int i = 1; i <= numberOfCards; i++) {
			allCards.add(new Card(i));
		}
	}

	public ArrayList<Card> getDeck() {
		return this.allCards;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.allCards = deck;
	}

	public int getNumberOfCards() {
		return this.numberOfCards;
	}
}
