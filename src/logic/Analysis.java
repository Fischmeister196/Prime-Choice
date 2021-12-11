package logic;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Analysis {

	private Deck deck;

	public Analysis(int numberOfCards) {
		this.deck = new Deck(numberOfCards);
	}

	public void testAllCombinations() {

		long counter = 0;
		double allcombinations = Math.pow(deck.getNumberOfCards(), deck.getNumberOfCards());
		boolean sameNumbers;
		boolean[] check = new boolean[deck.getNumberOfCards()];
		int carry;
		int[] indices = new int[deck.getNumberOfCards()];
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);

		do {
			counter++;
			sameNumbers = false;

			for (int i = 0; i < check.length; i++) {
				check[i] = false;
			}

			for (int index : indices) {
				if (check[index] == true) {
					sameNumbers = true;
				} else {
					check[index] = true;
				}
			}

			if (!sameNumbers) {

				Card[] newDeck = new Card[deck.getNumberOfCards()];
				for(int i = 0; i < indices.length; i++) {
					newDeck[i] = deck.getCardWithIndex(indices[i]);
				}
				
				for (int index : indices) {
					
					
				}
				
				System.out.print("\tTreffer!!!\n");

			} else {
				System.out.println(
						"Durchlaufene Kombinationen: " + numberFormat.format(100 / allcombinations * counter) + "%");
			}

			carry = 1;
			for (int i = indices.length - 1; i >= 0; i--) {
				if (carry == 0)
					break;

				indices[i] += carry;
				carry = 0;

				if (indices[i] == deck.getNumberOfCards()) {
					carry = 1;
					indices[i] = 0;
				}
			}
		} while (carry != 1); // Call this method iteratively until a carry is left over
	}

	private boolean isDeckValidForPrimeChoice(Card[] newDeck) {
		boolean onTheSameNumberAgain = false;
		boolean reachEndofCardHit = false;
		int counter = 0;
		Card[] cardHit = initCardHitDeck();
		Card next = null;
		Card actual = newDeck[0];

		while (!onTheSameNumberAgain || !reachEndofCardHit) {
			actual = next;
			for (Card card : cardHit) {
				if (card.getValue() == actual.getValue()) {
					onTheSameNumberAgain = true;
					break;
				}
			}
			if (counter < deck.getNumberOfCards() && onTheSameNumberAgain == false) {
				cardHit[counter] = actual;
			} else {
				break;
			}
			next = newDeck[nextIndex(actual)];
			counter++;
		}

		return !onTheSameNumberAgain;
	}

	private int nextIndex(Card card) {

		int result = card.getIndex() + card.getValue();

		if (result >= deck.getNumberOfCards()) {
			return result - deck.getNumberOfCards();
		} else {
			return result;
		}
	}

	private Card[] initCardHitDeck() {
		int counter = 0;
		Card[] cardHit = new Card[deck.getNumberOfCards()];
		while (counter < deck.getNumberOfCards()) {
			cardHit[counter] = new Card(0, 0);
		}

		return cardHit;
	}
}
