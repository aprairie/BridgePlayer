package bridgePlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Auction {
	private ArrayList<Call> calls = new ArrayList<Call>();
	private int dealer;
	private int bidNumber = 0;
	private int currentBidder;
	private int consecutivePasses = 0;
	private boolean isAuctionOver = false;
	private int declarer = -1;
	private Call.Bid currentBid;
	private Call doubleStatus = new Call.Pass();
	
	public Auction(int dealer) {
		this.dealer = dealer;
		this.currentBidder = dealer;
	}
	
	public boolean acceptCall(Call call) {
		
		if(!this.isCallLegal(call)) {
			return false;
		}
		
		if(call.isBid()) {
			declarer = currentBidder;
			currentBid = (Call.Bid) call;
			doubleStatus = new Call.Pass();
			consecutivePasses = 0;
		} else if(call.isDouble()) {
			doubleStatus = new Call.Double();
			consecutivePasses = 0;
		} else if(call.isRedouble()) {
			doubleStatus = new Call.Redouble();
			consecutivePasses = 0;
		} else if(call.isPass()) {
			consecutivePasses++;
			isAuctionOver = checkIfAuctionOver();
		}
		
		calls.add(call);
		currentBidder++;
		currentBidder = currentBidder % 4;
		bidNumber++;
		return true;
	}

	public Set<Call> getLegalCalls() {
		Set<Call> legalCalls = new HashSet<Call>();
		legalCalls.add(new Call.Pass());
		if((currentBidder + declarer) % 2 == 1 && doubleStatus.isPass()) {
			legalCalls.add(new Call.Double());
		} else if((currentBidder + declarer) % 2 == 0 && doubleStatus.isDouble()) {
			legalCalls.add(new Call.Redouble());
		}
		for(Call.Bid.Level level : Call.Bid.Level.values()) {
			for(Call.Bid.Suit suit : Call.Bid.Suit.values()) {
				Call.Bid bid = new Call.Bid(level, suit);
				if(currentBid == null || bid.compareTo(currentBid) > 0) {
					legalCalls.add(bid);
				}
			}
		}
		
		System.out.println(Arrays.toString(legalCalls.toArray()));		
		return legalCalls;
	}
	
	public boolean isCallLegal(Call call) {
		Set<Call> legalCalls = getLegalCalls();
		return legalCalls.contains(call);
	}
	
	private boolean checkIfAuctionOver() {
		return(consecutivePasses >= 3 && bidNumber > 3);
	}
	
	// Returns a pretty string of the auction
	public String toString() {
		
		String returnString = "";
	
		for(int i = 0; i < dealer; i++) {
			returnString = returnString + "   ";
		}
		
		if( calls.size() == 0 ) {
			return "Empty Auction";
		}
		
		for(int i = 0; i < calls.size(); i++) {
			returnString = returnString + " " + calls.get(i).toString();
			if((i + dealer + 1) % 4 == 0) {
				returnString = returnString + "\n";
			}
		}
		return returnString;
	}
	
	public boolean getIsAuctionOver() {
		return isAuctionOver;
	}
	
	public int getDealer() {
		return dealer;
	}
	
	public int getCurrentBidder() {
		return currentBidder;
	}
}
