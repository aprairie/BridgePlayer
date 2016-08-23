package bridgePlayer;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Library;
import com.sun.jna.Structure;
import com.sun.jna.Native;

public class DDS {
	public interface DDSLibrary extends Library {
		DDSLibrary INSTANCE = (DDSLibrary) Native.loadLibrary("dds", DDSLibrary.class);

		public static final int MAXNOOFBOARDS = 200;
		
		class dealPBN extends Structure {
			public static class ByValue extends dealPBN implements Structure.ByValue { }

			public int trump;
			public int first;
			public int[] currentTrickSuit = new int[3];
			public int[] currentTrickRank = new int[3];
			public byte[] remainCards     = new byte[80];
			
			protected List<String> getFieldOrder() {
				return Arrays.asList(new String[] { "trump", "first", "currentTrickSuit", "currentTrickRank", "remainCards" });
			}
		}
		class futureTricks extends Structure {
			public int nodes;
			public int cards;
			public int[] suit   = new int[13];
			public int[] rank   = new int[13];
			public int[] equals = new int[13];
			public int[] score  = new int[13];
			
			protected List<String> getFieldOrder() {
				return Arrays.asList(new String[] { "nodes", "cards", "suit", "rank", "equals", "score" });
			}
		}
		
		class boardsPBN extends Structure {
			public int noOfBoards;
			public dealPBN[] deals = new dealPBN[MAXNOOFBOARDS];
			public int[] target    = new int[MAXNOOFBOARDS];
			public int[] solutions = new int[MAXNOOFBOARDS];
			public int[] mode      = new int[MAXNOOFBOARDS];
			
			protected List<String> getFieldOrder() {
				return Arrays.asList(new String[] { "noOfBoards", "deals", "target", "solutions", "mode" });
			}
		}
		
		class solvedBoards extends Structure {
			public int noOfBoards;
			public futureTricks[] solvedBoard = new futureTricks[MAXNOOFBOARDS];

			protected List<String> getFieldOrder() {
				return Arrays.asList(new String[] { "noOfBoards", "solvedBoard" });
			}
		}
		
		int SolveBoardPBN(dealPBN.ByValue dl, int target, int solutions, int mode, futureTricks futp, int threadIndex);
		int SolveAllBoards(boardsPBN bop, solvedBoards solvedp);
	}
}
