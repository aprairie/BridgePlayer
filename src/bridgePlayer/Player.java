package bridgePlayer;

import java.util.Scanner;

public class Player {
	private Hand hand;
	private int direction;

	public static final Scanner user_input = new Scanner(System.in);
	
	public Player(Card[] hand, int direction) {
		this.hand = new Hand();
		this.hand.putCards(hand);
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void getHand() {
		System.out.println(hand.toString());
	}
	
	public Call makeCall() {
		System.out.println("Your hand is: " + hand.toString() + "\nYour call: ");
		
		String input = user_input.next();
		System.out.println("Your input is: " + input);
		
		input = input.toUpperCase();
		
		Call call = new Call.Pass();
		if(input.equals("P")){ call = new Call.Pass(); }
		else if(input.equals("X")){ call = new Call.Double(); }
		else if(input.equals("XX")){ call = new Call.Redouble(); }
		else { 
			char charSuit = input.charAt(1);
			int rank = Integer.parseInt(input.substring(0,1));
			call = new Call.Bid(Call.Bid.intToLevel(rank), Call.Bid.charToSuit(charSuit));
		}
		return call;
	}
}