package bridgePlayer;

public abstract class Call {
	
	private final static int hashCodeSeed = 85066143; // set to an arbitrary integer
	
	private Call() {}
	
	public boolean isPass() {
		return false;
	}
	
	public boolean isBid() {
		return false;
	}

	public boolean isDouble() {
		return false;
	}
	
	public boolean isRedouble() {
		return false;
	}
	
	public static final class Pass extends Call {

		@Override
		public String toString() {
			return "P ";
		}
		
		@Override
		public boolean isPass() {
			return true;
		}

		@Override
		public boolean equals(Object o) {
			return (o instanceof Pass);
		}

		@Override
		public int hashCode() {
			return 1 + hashCodeSeed;
		}
		
	}
	
	public static final class Double extends Call {

		@Override
		public String toString() {
			return "X ";
		}
		
		@Override
		public boolean isDouble() {
			return true;
		}

		@Override
		public boolean equals(Object o) {
			return (o instanceof Double);
		}

		@Override
		public int hashCode() {
			return 2 + hashCodeSeed;
		}
	}
	
	public static final class Redouble extends Call {

		@Override
		public String toString() {
			return "XX";
		}
		
		@Override
		public boolean isRedouble() {
			return true;
		}
		
		@Override
		public boolean equals(Object o) {
			return (o instanceof Redouble);
		}

		@Override
		public int hashCode() {
			return 3 + hashCodeSeed;
		}
	}

//public class Card implements Comparable<Card> {
	public static final class Bid extends Call implements Comparable<Bid> {
		public final Level level;
		public final Suit suit;
		
		public static enum Suit {
			CLUBS, DIAMONDS, HEARTS, SPADES, NOTRUMP;
		}
		public static enum Level {
			ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN;
		}
		
		public Bid(Level level, Suit suit) {
			this.level = level;
			this.suit = suit;
		}

		public int compareTo(Bid b) {
			return (this.suit.ordinal() + this.level.ordinal() * 10) - (b.suit.ordinal() + b.level.ordinal() * 10);
		}
		
		@Override
		public boolean isBid() {
			return true;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o instanceof Bid) {
				return (this.hashCode() == o.hashCode()); 
			}
			return false;
		}

		@Override
		public int hashCode() {
			// comment
			return 4 + this.suit.ordinal() + Suit.values().length * this.level.ordinal() + hashCodeSeed;
		}
		
		public static Level intToLevel(int level) {
			// kill if not 1-7
			return Call.Bid.Level.values()[level-1];
		}
		
		public static Suit charToSuit(char suit) {
			if(suit == 'C')      {return Call.Bid.Suit.CLUBS;}
			else if(suit == 'D') {return Call.Bid.Suit.DIAMONDS;}
			else if(suit == 'H') {return Call.Bid.Suit.HEARTS;}
			else if(suit == 'S') {return Call.Bid.Suit.SPADES;}
			else if(suit == 'N') {return Call.Bid.Suit.NOTRUMP;}

			// kill if not C/D/H/S/N
			// this is temporary until i have a kill command
			return Call.Bid.Suit.NOTRUMP;
		}
		
		@Override
		public String toString() {
			return (level.ordinal() + 1) + suit.toString().substring(0, 1);
		}
	}
}
