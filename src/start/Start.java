package start;

import logic.Analysis;

public class Start {

	public static void main(String[] args) {
		Analysis analysis = new Analysis(6);
		analysis.testAllCombinations();
	}

}
