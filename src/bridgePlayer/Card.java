package bridgePlayer;

public class Card {
	int value;
	char suit;
	String printValue;
	String printCard;
	int sortValue;
	
	final static String[] cardNames = { "?", "x", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A" };
	
	Card( int a, char b ){
		this.value = a;
		this.suit = b;
		
		printValue = cardNames[a];
		
		// setting the sort value for the cards
		this.sortValue = this.value;
		if( this.suit == 's' ){
			this.sortValue = this.sortValue + 200;
		} else if( this.suit == 'h' ){
			this.sortValue = this.sortValue + 300;
		} else if( this.suit == 'd' ){
			this.sortValue = this.sortValue + 100;
		}
	}
	void printCard(){
		System.out.print(this.suit + this.printValue);
	}
	
	String getPrintValue(){
		return cardNames[this.value];
	}
	
	char getSuit(){
		return this.suit;
	}
	
	int getSortValue(){
		return sortValue;
	}
}
