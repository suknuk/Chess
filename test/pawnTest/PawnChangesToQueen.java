package pawnTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import board.Move;
import pieces.Pawn;
import pieces.PieceColor;
import pieces.Queen;
import pieces.Tower;
import testSuite.MainTestClass;
import testSuite.TestExpectedMoves;
import testSuite.TestMove;

public class PawnChangesToQueen extends MainTestClass {

	/*
	 * white pawn reaches black side with a simple move and is swapped as a
	 * queen
	 */
	@Test
	public void whitePawnReachesBlackSide() {
		/*
		 * Testing over all x positions
		 */
		for (int x = 0; x <= 7; x++) {
			this.reset();
			Pawn pawn = new Pawn(x, 1, PieceColor.WHITE, board);

			// Expecting pawn can move to x,0
			new TestMove(x, 0, testMoves);
			new TestExpectedMoves(board, pawn, testMoves);

			Move move = new Move(pawn, board, x, 0);
			board.applyMove(move);

			// checking if queen is at the position
			assertEquals((Queen.class), board.getPieceAt(x, 0).getClass());
			// old location should be null
			assertEquals(null, board.getPieceAt(x, 1));
		}
	}

	/*
	 * black pawn reaches white side
	 */
	@Test
	public void blackPawnReachesWhiteSide() {
		/*
		 * Testing over all x positions
		 */
		for (int x = 0; x <= 7; x++) {
			this.reset();
			Pawn pawn = new Pawn(x, 6, PieceColor.BLACK, board);

			// Expecting pawn can move to x,0
			new TestMove(x, 7, testMoves);
			new TestExpectedMoves(board, pawn, testMoves);

			Move move = new Move(pawn, board, x, 7);
			board.applyMove(move);

			// checking if queen is at the position
			assertEquals((Queen.class), board.getPieceAt(x, 7).getClass());
			// old location should be null
			assertEquals(null, board.getPieceAt(x, 6));
		}
	}

	/*
	 * white paw reaches black side by hitting black piece
	 */
	@Test
	public void whitePawnReachesBlackSideByHitting() {

		this.reset();
		Pawn pawn = new Pawn(3, 1, PieceColor.WHITE, board);
		new Tower(2, 0, PieceColor.BLACK, board);

		// Expecting pawn can move to x,0
		new TestMove(2, 0, testMoves);
		new TestMove(3, 0, testMoves);
		new TestExpectedMoves(board, pawn, testMoves);

		Move move = new Move(pawn, board, 2, 0);
		board.applyMove(move);

		// checking if queen is at the position
		assertEquals((Queen.class), board.getPieceAt(2, 0).getClass());
		// old location should be null
		assertEquals(null, board.getPieceAt(3, 1));

	}

}
