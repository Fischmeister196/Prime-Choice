package logic;

import java.text.NumberFormat;
import java.util.ArrayList;

import org.junit.platform.commons.annotation.Testable;

public class Analysis {

	private Deck deck;

	public Analysis(int numberOfCards) {
		this.deck = new Deck(numberOfCards);
	}

	public void testAllCombinations() {

		long counter = 0;
		double lastpercent = 0;
		double allcombinations = Math.pow(deck.getNumberOfCards(), deck.getNumberOfCards());
		boolean sameNumbers;
		boolean[] check = new boolean[deck.getNumberOfCards()];
		int carry;
		int[] indices = new int[deck.getNumberOfCards()];
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(2);
		Card[] newDeck = new Card[deck.getNumberOfCards()];
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

				
				for (int i = 0; i < indices.length; i++) {
					newDeck[i] = deck.getCardWithIndex(indices[i]);
					newDeck[i].setIndex(i);
				}

				
				
				if (isDeckValidForPrimeChoice(newDeck)) {
					for (Card card : newDeck) {
						System.out.print(card.getValue() + " ");
					}
					System.out.print("\tTreffer!\n");
				} 
			} else {

				/*
				 * if (((100 / allcombinations * counter) - lastpercent) >= 0.01) { lastpercent
				 * = 100 / allcombinations * counter;
				 * System.out.println("Durchlaufene Kombinationen: " + numberFormat.format(100 /
				 * allcombinations * counter) + "%"); }
				 */
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

	public static boolean isDeckValidForPrimeChoice(Card[] newDeck) {
		boolean primeChoiceValid = true;
		int counter = 0;
		Card[] cardHit = initCardHitDeck(newDeck.length);
		Card next = newDeck[0];
		Card actual = null;

		while (counter < newDeck.length - 1) {
			actual = next;
			for (int i = 0; i < newDeck.length; i++) {
				if ((cardHit[i].getValue() == actual.getValue()) || actual.getValue() == newDeck.length ) {
					primeChoiceValid = false;
					break;

				}

			}

			if (primeChoiceValid) {
				cardHit[counter] = actual;
			} else {
				break;
			}

			next = newDeck[nextIndex(actual, newDeck.length)];
			counter++;
		}

		return primeChoiceValid;
	}

	public static int nextIndex(Card card, int length) {

		int result = card.getIndex() + card.getValue();

		if (result >= length) {
			return result - length;
		} else {
			return result;
		}
	}

	private static Card[] initCardHitDeck(int length) {
		int counter = 0;
		Card[] cardHit = new Card[length];
		while (counter < length) {
			cardHit[counter] = new Card(0, 0);
			counter++;
		}

		return cardHit;
	}
}
