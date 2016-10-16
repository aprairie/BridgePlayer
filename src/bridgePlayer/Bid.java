package bridgePlayer;
///////////////////////////////GET RID OF THIS CLASS///////////////////////////////////////////
public class Bid {
	private int rank;
	private int suit;
	private char special;
	
	private String description;
	
	public Bid(int rank, int suit, String description) {
		this.rank = rank;
		this.suit = suit;
		this.description = description;
		special = 'b';
	}
	
	public Bid(char special, String description) {
		// check if valid
		
		this.special = special;
		this.rank = -1;
		this.suit = -1;
		this.description = description;
	}
	
	public char getSpecial() {
		return special;
	}
	public int getRank() {
		return rank;
	}
	public int getSuit() {
		return suit;
	}
	public String getDescription() {
		return description;
	}
}
