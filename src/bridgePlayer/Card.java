package bridgePlayer;

import java.util.HashMap;

public class Card implements Comparable<Card> {
	private final int rank;
	private final int suit;
	private boolean played;

	// compareTo
	public int compareTo(Card c) {
		return (c.getRank() + c.getSuit() * -100) - (this.getRank() + this.getSuit() * -100);
	}
	
	// Suits (Hashmap)
	public static final HashMap<String, Integer> SUITS;
	static
	{
		SUITS = new HashMap<String, Integer>();
		SUITS.put("CLUBS",    0);		SUITS.put("C", 0);
		SUITS.put("DIAMONDS", 1);		SUITS.put("D", 1);
		SUITS.put("HEARTS",   2);		SUITS.put("H", 2);
		SUITS.put("SPADES",   3);		SUITS.put("S", 3);
		SUITS.put("NT",       4);		SUITS.put("N", 4);
	}
	
	// Ranks (Hashmap)
	public static final HashMap<String, Integer> RANKS;
	static
	{
		RANKS = new HashMap<String, Integer>();
		RANKS.put("DEUCE", 2);  	RANKS.put("2", 2);
		RANKS.put("THREE", 3);   	RANKS.put("3", 3);
		RANKS.put("FOUR",  4);  	RANKS.put("4", 4);
		RANKS.put("FIVE",  5);  	RANKS.put("5", 5);
		RANKS.put("SIX",   6);  	RANKS.put("6", 6);
		RANKS.put("SEVEN", 7);  	RANKS.put("7", 7);
		RANKS.put("EIGHT", 8);  	RANKS.put("8", 8);
		RANKS.put("NINE",  9);  	RANKS.put("9", 9);
		RANKS.put("TEN",   10); 	RANKS.put("T", 10);
		RANKS.put("JACK",  11); 	RANKS.put("J", 11);
		RANKS.put("QUEEN", 12); 	RANKS.put("Q", 12);
		RANKS.put("KING",  13); 	RANKS.put("K", 13);
		RANKS.put("ACE",   14); 	RANKS.put("A", 14);
	}

    public Card(int suit, int rank) {
        assert isValidSuit(suit);
        assert isValidRank(rank);
        this.suit = suit;
        this.rank = rank;
        this.played = false;
    }
    
    public Card(int suit, int rank, boolean played) {
        assert isValidSuit(suit);
        assert isValidRank(rank);
        this.suit = suit;
        this.rank = rank;
        this.played = played;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public boolean getPlayed() {
        return played;
    }
    
    public void setPlayed(boolean played){
    	this.played = played;
    }

    public static boolean isValidRank(int rank) {
        return RANKS.get("DEUCE") <= rank && rank <= RANKS.get("ACE");
    }

    public static boolean isValidSuit(int suit) {
        return SUITS.get("CLUBS") <= suit && suit <= SUITS.get("NT");
    }

    public static String rankToString(int rank) {
        switch (rank) {
        case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:
            return Integer.toString(rank);
        case 10:
            return "T";
        case 11:
            return "J";
        case 12:
            return "Q";
        case 13:
            return "K";
        case 14:
            return "A";
        default:
            //Handle an illegal argument.  There are generally two
            //ways to handle invalid arguments, throwing an exception
            //(see the section on Handling Exceptions) or return null
            return null;
        }    
    }
    
    public static String suitToString(int suit) {
        switch (suit) {
        case 0:
            return "C";
        case 1:
            return "D";
        case 2:
            return "H";
        case 3:
            return "S";
        case 4:
            return "N";
        default:
            return null;
        }    
    }
    
    public static String toString(Card c) {
    	return suitToString(c.suit) + rankToString(c.rank);
    }
}