package bridgePlayer;

public class Hand {
	
	Card[] myHand;
	boolean[] playedCards;
	int cardIndex;
	
	Hand(){
		this.myHand = new Card[13];
		this.playedCards = new boolean[13];
		
		for( int i = 0; i < 13; i++ ){
			this.playedCards[i] = false;
		}
		
		this.cardIndex = 0;
	}
	
	void putCard( Card a ){
		this.myHand[this.cardIndex] = a;
		this.cardIndex = this.cardIndex + 1;
	}

	// just insertion? sorting the hand, for now
	void sortHand(){
		for( int i = 0; i < this.myHand.length - 1; i++ ){
			for( int j = 1; j < this.myHand.length - 1 - i; j++ ){
				//System.out.println( this.myHand[i].getSortValue() + " " + this.myHand[i+j].getSortValue() );
				if( this.myHand[i].getSortValue() < this.myHand[i+j].getSortValue() ){
					//System.out.println( "hello" );
					Card tempcard = this.myHand[i];
					this.myHand[i] = this.myHand[i+j];
					this.myHand[i+j] = tempcard;
				}
			}
		}
	}
	
	void printHandPretty(){
		char suit = 'a';
		for( int i = 0; i < this.cardIndex; i++ ){
			if( suit != this.myHand[i].getSuit() ){
				suit = this.myHand[i].getSuit();
				System.out.print( "\n" + suit + ":" );
			}
			System.out.print( " " + this.myHand[i].getPrintValue() );
		}
		System.out.println();
	}
	
	void printHand(){
		for( int i = 0; i < this.cardIndex; i++ ){
			this.myHand[i].printCard();
			System.out.print(" ");
		}
		System.out.println();
	}
}