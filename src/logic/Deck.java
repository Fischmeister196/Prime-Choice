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
	private ArrayList<Card> listOfAllCards;
	
	public Deck(int numberOfCards) {
		this.numberOfCards = numberOfCards;
	}
	
	public List<Card> shuffle() {
		return null;
	}
	
	private void createDeck() {
		for(int i = 1; i <= numberOfCards; i++) {
			listOfAllCards.add(new Card(i));
		}
	}

}
