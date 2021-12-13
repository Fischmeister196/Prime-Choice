package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Analysis;
import logic.Card;
import logic.Deck;

public class TestAnalysis {

	Deck underTest;
	Card[] a_furry_kitten;
	Card[] eight_kings;
	Card[] high_five;

	@BeforeEach
	public void initTestDeck() {
		underTest = new Deck(13);
		a_furry_kitten = new Card[] { // ### A furry kitten ###
				new Card(1, 0), new Card(4, 1), new Card(13, 2), new Card(10, 3), //
				new Card(5, 4), new Card(7, 5), new Card(2, 6), new Card(3, 7), //
				new Card(8, 8), new Card(11, 9), new Card(9, 10), new Card(6, 11), //
				new Card(12, 12) //
		}; //

		eight_kings = new Card[] { // ### Eight Kings ###
				new Card(8, 0), new Card(13, 1), new Card(3, 2), new Card(10, 3), //
				new Card(2, 4), new Card(7, 5), new Card(9, 6), new Card(5, 7), //
				new Card(12, 8), new Card(4, 9), new Card(1, 10), new Card(6, 11), //
				new Card(11, 12) //
		}; //

		high_five = new Card[] { // ### High Five ###
				new Card(1, 0), new Card(3, 1), new Card(5, 2), new Card(2, 3), new Card(4, 4) //
		}; //

	}

	// ### testisDeckValidForPrimeChoice ###
	@Test
	public void testisDeckValidForPrimeChoice_a_furry_kitten() {
		underTest.setAllCards(a_furry_kitten);

		boolean result = Analysis.isDeckValidForPrimeChoice(underTest.getAllCards());
		assertTrue(result);

	}

	@Test
	public void testisDeckValidForPrimeChoice_eight_kings() {
		underTest.setAllCards(eight_kings);

		boolean result = Analysis.isDeckValidForPrimeChoice(underTest.getAllCards());
		assertFalse(result);

	}

	@Test
	public void testisDeckValidForPrimeChoice_high_five() {
		underTest.setAllCards(high_five);

		boolean result = Analysis.isDeckValidForPrimeChoice(underTest.getAllCards());
		assertTrue(result);

	}

	// ### testnextIndex ###
	@Test
	public void testNextIndex() {
		underTest.setAllCards(high_five);

		Card one = new Card(1, 1);
		Card seven = new Card(7, 11);

		int oneResult = 2;
		int sevenResult = 5;

		assertEquals(oneResult, Analysis.nextIndex(one, 13));
		assertEquals(sevenResult, Analysis.nextIndex(seven, 13));

	}

}
