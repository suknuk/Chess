package queenTest;

import org.junit.Test;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.PieceColor;
import pieces.Queen;
import pieces.Tower;
import testSuite.MainTestClass;
import testSuite.TestExpectedMoves;
import testSuite.TestMove;

public class QueenSimpleMovement extends MainTestClass {

	/*
	 * Simple movement test when queen is in the corner
	 */
	@Test
	public void QueenInCornerNoObstacles() {
		this.reset();
		Queen queen = new Queen(0, 0, PieceColor.WHITE, board);

		for (int i = 1; i <= 7; i++) {
			new TestMove(0, i, testMoves);
			new TestMove(i, 0, testMoves);
			new TestMove(i, i, testMoves);
		}

		new TestExpectedMoves(board, queen, testMoves);
	}

	/*
	 * Movement test when queen is in the middle without obstacles
	 */
	@Test
	public void QueenInMiddleObstacles() {
		this.reset();
		Queen queen = new Queen(5, 5, PieceColor.WHITE, board);

		// diagonal up left - down right, straight up down/left right
		for (int i = 0; i <= 7; i++) {
			if (i != 5) {
				new TestMove(5, i, testMoves);
				new TestMove(i, 5, testMoves);
				new TestMove(i, i, testMoves);
			}
		}
		// diagonal up right - down left
		new TestMove(4, 6, testMoves);
		new TestMove(3, 7, testMoves);
		new TestMove(6, 4, testMoves);
		new TestMove(7, 3, testMoves);

		new TestExpectedMoves(board, queen, testMoves);
	}

	/*
	 * Queen is stuck between friendly pieces
	 */
	@Test
	public void QueenStuckInFriendlyPieces() {
		this.reset();
		Queen queen = new Queen(3, 7, PieceColor.WHITE, board);
		new Pawn(2, 6, PieceColor.WHITE, board);
		new Pawn(3, 6, PieceColor.WHITE, board);
		new Pawn(4, 6, PieceColor.WHITE, board);
		new King(4, 7, PieceColor.WHITE, board);
		new Knight(2, 7, PieceColor.WHITE, board);

		// no moves possible

		new TestExpectedMoves(board, queen, testMoves);
	}

	/*
	 * Hitting multiple enemy pieces
	 */
	@Test
	public void QueenMiddleHittingEnemy() {
		this.reset();
		Queen queen = new Queen(4, 4, PieceColor.WHITE, board);

		new Tower(5, 3, PieceColor.WHITE, board);
		new Tower(5, 4, PieceColor.WHITE, board);
		new Bishop(5, 5, PieceColor.WHITE, board);

		new Pawn(4, 3, PieceColor.BLACK, board);
		new Pawn(4, 5, PieceColor.BLACK, board);
		new Pawn(3, 3, PieceColor.BLACK, board);
		new Queen(3, 4, PieceColor.BLACK, board);
		new Knight(3, 5, PieceColor.BLACK, board);

		// hitting the pieces
		new TestMove(4, 3, testMoves);
		new TestMove(4, 5, testMoves);
		new TestMove(3, 3, testMoves);
		new TestMove(3, 4, testMoves);
		new TestMove(3, 5, testMoves);

		new TestExpectedMoves(board, queen, testMoves);
	}

}
