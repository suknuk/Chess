package testSuite;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import board.Board;
import board.Move;
import pieces.Piece;

/*
 * Class to make test easier by testing automatically all possible moves by 
 * taking the board, the to be checked piece and iterate all expecting moves
 */
public class TestExpectedMoves {
	//private Board board;
	private Piece piece;
	private ArrayList<TestMove> testMoves;
	private ArrayList<Move> moves;

	/*
	 * Constructor
	 */
	public TestExpectedMoves(Board board, Piece piece, ArrayList<TestMove> testMoves) {
		//this.board = board;
		this.piece = piece;
		this.testMoves = testMoves;
		this.moves = this.piece.possibleMoves(board);

		// do the test
		this.test();
	}

	/*
	 * do all the testing
	 */
	@Test
	public void test() {
		/*
		 * testing number of expected moves
		 */
		assertEquals(testMoves.size(), moves.size());

		// Iterating every move, takes O(n²) time
		for (int i = 0; i < this.moves.size(); i++) {
			Move move = moves.get(i);
			// Find move in expected moves, throw error otherwise
			for (int j = 0; j < this.testMoves.size(); j++) {
				TestMove tm = this.testMoves.get(j);
				/*
				 * entry was found -> correct -> iterate next entry in
				 * this.moves
				 */
				if (move.toX() == tm.toX() && move.toY() == tm.toY()) {
					break;
				} else {
					/*
					 * if entry was not found at the last iteration, the
					 * expected move does not exist in the moves found by the
					 * possibleMoves method, hence throw an error
					 */
					if (j == this.moves.size() - 1) {
						fail("Expected move not found in possibleMoves method");
					}
				}
			}
		} // end for
	}
}
