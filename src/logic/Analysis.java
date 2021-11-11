package logic;

import java.util.ArrayList;

public class Analysis {

	private Deck deck;

	public Analysis(int numberOfCards) {
		this.deck = new Deck(numberOfCards);
	}

	public void testAllCombinations() {
		generateCombinations(deck.getNumberOfCards(), deck.getDeck());
	}

	private void generateCombinations(int arraySize, ArrayList<Card> possibleValues) {
		boolean posibleCombination;
		int carry;
		int[] indices = new int[arraySize];
		do {
			posibleCombination = true;
			for (int Xindex : indices) {
				for (int Yindex : indices) {
					if(possibleValues.get(Xindex).getValue() == possibleValues.get(Yindex).getValue()) {
						posibleCombination = false;
					}
				}
			}
			
			if(posibleCombination) {
				for (int index : indices) {
					System.out.print(possibleValues.get(index).getValue() + " ");
				}
				System.out.println("");
			}
			
			

			carry = 1;
			for (int i = indices.length - 1; i >= 0; i--) {
				if (carry == 0)
					break;

				indices[i] += carry;
				carry = 0;

				if (indices[i] == possibleValues.size()) {
					carry = 1;
					indices[i] = 0;
				}
			}
		} while (carry != 1); // Call this method iteratively until a carry is left over
	}
}
