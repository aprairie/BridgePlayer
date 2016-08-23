package bridgePlayer;

public class Deck {
	
	Card[] myDeck;
	int lastCard;
	
	Deck(){
		this.myDeck = new Card[52];
		this.lastCard = 51;
		String suits = "shdc";
		int $index = 0;
		for( int i = 2; i <= 14; i++ ){
			for( int j = 0; j < suits.length(); j++ ){
				char suit = suits.charAt( j );
				myDeck[$index] = new Card( i, suit );
				$index++;
			}
		}
	}

	void printDeck(){
		for( int i = 0; i <= this.lastCard; i++ ){
			this.myDeck[i].printCard();
			System.out.print(" ");
		}
	}
	void shuffleDeck(){
		for( int i = lastCard; i > 0; i-- ){
			int swapWith = (int) (Math.random() * i);
			Card tempCard = this.myDeck[i];
			this.myDeck[i] = this.myDeck[swapWith];
			this.myDeck[swapWith] = tempCard;
		}
	}
	Card dealCard(){
		Card returnCard = this.myDeck[lastCard];
		this.lastCard = this.lastCard - 1;
		return returnCard;
	}
}
