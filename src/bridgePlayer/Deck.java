package bridgePlayer;

public class Deck {

	Card[] cards;
	int lastCard;
	private static final int deckNumberOfCards = 52;
	
	Deck(){
		this.cards = new Card[deckNumberOfCards];
		this.lastCard = deckNumberOfCards - 1;
		int $index = 0;
		for(int i = 2; i <= 14; i++) {  // this part of the code should be improved, talk to drodge about a clean way to do it
			for(int j = 0; j < 4; j++) {
				cards[$index] = new Card(j, i);
				$index++;
			}
		}
	}
	
	void shuffleDeck(){
		for( int i = lastCard; i > 0; i-- ){
			int swapWith = (int) (Math.random() * i);
			Card tempCard = this.cards[i];
			this.cards[i] = this.cards[swapWith];
			this.cards[swapWith] = tempCard;
		}
	}
	Card[] dealCards(int number){
		Card[] returnCards = new Card[number];
		for(int i = 0; i < number; i++){
			returnCards[i] = cards[lastCard];
			lastCard = lastCard - 1;
		}
		return returnCards;
	}	
}
