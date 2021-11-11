package logic;

public class Card {
	
	private Integer value;
	private boolean visibility;
	
	public Card(int value) {
		this.value = value;
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
	
	
}
