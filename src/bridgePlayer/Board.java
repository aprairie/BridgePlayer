package bridgePlayer;

public class Board {
	Deck myDeck;
	boolean EWVul, NSVul;
	
	Hand nHand, sHand, eHand, wHand;
	
	Board( boolean ewvul, boolean nsvul ){
		
		// setting up the deck
		Deck myDeck = new Deck();
		myDeck.shuffleDeck();
		//myDeck.printDeck();
		
		// setting up the vulnerabilities
		this.EWVul = ewvul;
		this.NSVul = nsvul;
		
		// setting up the hands
		nHand = new Hand();
		sHand = new Hand();
		eHand = new Hand();
		wHand = new Hand();
		for( int i = 0; i < 13; i++ ){
			nHand.putCard( myDeck.dealCard() );
			sHand.putCard( myDeck.dealCard() );
			eHand.putCard( myDeck.dealCard() );
			wHand.putCard( myDeck.dealCard() );
		}
		nHand.sortHand();
		nHand.printHandPretty();
		sHand.sortHand();
		sHand.printHandPretty();
		eHand.sortHand();
		eHand.printHandPretty();
		wHand.sortHand();
		wHand.printHandPretty();
		
	}

}
