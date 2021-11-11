package logic;

import java.util.ArrayList;
import java.util.Collections;

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
	}

	public void shuffle() {
		Collections.shuffle(allCards);
	}

	private void createDeck() {
		for (int i = 1; i <= numberOfCards; i++) {
			allCards.add(new Card(i));
		}
	}

}
