package testSuite;

import java.util.ArrayList;

import board.Board;
import board.Move;

public class MainTestClass {

	protected Board board;
	protected ArrayList<Move> moves;
	protected ArrayList<TestMove> testMoves;

	/*
	 * Useful method to reset these variables
	 */
	public void reset() {
		this.board = new Board();
		this.moves = new ArrayList<Move>();
		this.testMoves = new ArrayList<TestMove>();
	}
}
