package bridgePlayer;

import java.util.Arrays;

import com.sun.jna.Native;

import bridgePlayer.DDS.DDSLibrary.boardsPBN;
import bridgePlayer.DDS.DDSLibrary.dealPBN;
import bridgePlayer.DDS.DDSLibrary.futureTricks;
import bridgePlayer.DDS.DDSLibrary.solvedBoards;
import bridgePlayer.DDS.DDSLibrary;

public class BridgeGame {

	static void printFutureTricks(futureTricks futp){
		System.out.println("Number of nodes explored: " + futp.nodes);
		System.out.println("cards: " + futp.cards);
		System.out.println("suit: " + Arrays.toString(futp.suit));
		System.out.println("rank: " + Arrays.toString(futp.rank));
		System.out.println("equals: " + Arrays.toString(futp.equals));
		System.out.println("score: " + Arrays.toString(futp.score));
	}
	
	public static void main(String[] args) {
		// Debugging tools
		//Native.setProtected(true);
		//System.setProperty("jna.debug_load", "true");
		//System.setProperty("jna.debug_load.jna", "true");
		
		System.setProperty("jna.library.path", ".\\lib");
		
		futureTricks futp = new futureTricks();
		dealPBN.ByValue dl = new dealPBN.ByValue();
		dl.trump = 4; // no trump
		dl.first = 3; // west
		byte[] remainCards = "N:QJ6.K652.J85.T98 873.J97.AT764.Q4 K5.T83.KQ9.A7652 AT942.AQ4.32.KJ3".getBytes();
		for( int i = 0; i < remainCards.length; i++){
			dl.remainCards[i] = remainCards[i];
		}
		DDSLibrary.INSTANCE.SolveBoardPBN(dl, -1, 3, 1, futp, 0 );
		printFutureTricks(futp);

		// create boardsPBN bop
		boardsPBN bop = new boardsPBN();
		bop.noOfBoards = 2;
		for( int i = 0; i < bop.noOfBoards; i++ ){
			bop.deals[i] = new dealPBN();
			bop.deals[i].trump = 4; // no trump
			bop.deals[i].first = i % 4; // modular
			bop.deals[i].remainCards = dl.remainCards;
			bop.target[i] = -1;
			bop.solutions[i] = 3;
			bop.mode[i] = 1;
		}
		
		// create solvedBoards solvedp
		solvedBoards solvedp = new solvedBoards();
		solvedp.noOfBoards = bop.noOfBoards;
		
		DDSLibrary.INSTANCE.SolveAllBoards(bop, solvedp);
		
		for( int i = 0; i < solvedp.noOfBoards; i++ ){
			printFutureTricks( solvedp.solvedBoard[i] );
		}
		
		
	}
	
}

/*
public class BridgeGame {

	public static void main(String[] args) {		
		Board myBoard = new Board( true, true );
	}

}
*/

/*
working on right now
1.) Fix sorting implementation
2.) implement array for elsifs on printvalue
3.) Figure out how to get user input
4.) Construct an auction

later
1.) implement comparable for cards

*/