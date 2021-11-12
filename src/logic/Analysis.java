package logic;

public class Analysis {

	private Deck deck;

	public Analysis(int numberOfCards) {
		this.deck = new Deck(numberOfCards);
	}

	public void testAllCombinations() {

		int counter = 0;
		boolean sameNumbers;
		boolean[] check = new boolean[deck.getNumberOfCards()];
		int carry;
		int[] indices = new int[deck.getNumberOfCards()];

		do {
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
				System.out.print("Index:\t");
				for (int index : indices) {
					System.out.print(index);
				}
				System.out.print(" | Value:\t");
				for (int index : indices) {					
					System.out.print(deck.getDeck().get(index).getValue());
				}
				System.out.print("\tTreffer!!!\n");
			} /*else {
				for (int index : indices) {					
					System.out.print(deck.getDeck().get(index).getValue());
				}
				System.out.print("\n");
			}*/
			
			
			carry = 1;
			for (int i = indices.length - 1; i >= 0; i--) {
				if (carry == 0)
					break;

				indices[i] += carry;
				carry = 0;

				if (indices[i] == deck.getDeck().size()) {
					carry = 1;
					indices[i] = 0;
				}
			}
		} while (carry != 1); // Call this method iteratively until a carry is left over
	}
}
