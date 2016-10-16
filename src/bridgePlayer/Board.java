package bridgePlayer;

public class Board {
	boolean ewVul;
	boolean nsVul;
	int boardNumber;
	Player[] player = new Player[4];
	Deck deck;
	int dealer;
	Auction auction;
	
	// creating the array for vulnerability
	public static final boolean[] EWVUL = {false, // dealing with index 0
										   false, false, true,  true,
										   false, true,  true,  false,
										   true,  true,  false, false,
										   true,  false, true,  false};
	public static final boolean[] NSVUL = {false, // dealing with index 0
									       false, true,  false, true,
										   true,  false, true,  false,
										   false, true,  false, true,
										   true,  false, true,  false};

	// north 0 e 1 s 2 w 3
	public Board(int boardNumber){
		this.boardNumber = boardNumber;
		
		// set dealer and vulnerability
		dealer = (boardNumber - 1) % 4; // this is how the ACBL sets dealer, just rotates between the four
		ewVul = EWVUL[boardNumber];
		nsVul = NSVUL[boardNumber];
		
		// create deck
		deck = new Deck();
		deck.shuffleDeck();
		
		// create players
		for(int i = 0; i <= 3; i++) {
			player[i] = new Player(deck.dealCards(13), i);
		}
		// Create the Auction
		auction = new Auction(dealer);
	}
	
	public void executeAuction() {
		
		while(!auction.getIsAuctionOver()) {
			System.out.println(auction.toString());
			
			auction.getLegalCalls();
			boolean status = auction.acceptCall(player[auction.getCurrentBidder()].makeCall());
			System.out.println(status);
		}
		
		System.out.println(auction.toString());
	}
	
	
}
