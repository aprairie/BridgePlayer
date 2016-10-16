package bridgePlayer;

import java.util.Arrays;

public class Hand {
	Card[] cards;
	int cardIndex;
	private static final int handNumberOfCards = 13;
	
	public Hand(){
		this.cards = new Card[handNumberOfCards];
		this.cardIndex = 0;
	}
	
	public void putCards(Card[] c){
		for(int i = 0; i < c.length; i++){
			cards[cardIndex] = c[i];
			cardIndex++;
		}
	}
	
	public String toString() {
		Arrays.sort(cards);
		int suit = 0;
		String returnString = "";
		for(int i = 0; i < cardIndex; i++) {
			for(int j = 0; j < (cards[i].getSuit() - suit); j++ ) {
				returnString = returnString + ".";
			}
			returnString = returnString + Card.rankToString(cards[i].getRank());
			suit = cards[i].getSuit();
		}
		return(returnString);
	}
}