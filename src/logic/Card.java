package logic;

public class Card {
	
	private int value;
	private int index;
	private boolean visibility;
	
	public Card(int value, int index) {
		this.value = value;
		this.index = index;
		this.setVisibility(false);
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	
	public int getValue() {
		return this.value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
