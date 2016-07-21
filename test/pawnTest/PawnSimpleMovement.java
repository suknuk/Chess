package pawnTest;

import org.junit.Test;

import pieces.Pawn;
import pieces.PieceColor;
import testSuite.MainTestClass;
import testSuite.TestExpectedMoves;
import testSuite.TestMove;

/*
 * Test class to check for the basic pawn movements
 */
public class PawnSimpleMovement extends MainTestClass {
	
	/*
	 * Following are single white movement checks without other pieces on the
	 * board
	 */
	@Test
	public void simpleWhiteMoveNoOtherPiecesTest1() {
		this.reset();
		Pawn pawn = new Pawn(4, 4, PieceColor.WHITE, board);

		// Expecting pawn can only move to 4,3
		new TestMove(4, 3, testMoves);
		new TestExpectedMoves(board, pawn, testMoves);
	}

	@Test
	public void simpleWhiteMoveNoOtherPiecesTest2() {
		this.reset();
		Pawn pawn = new Pawn(0, 5, PieceColor.WHITE, board);

		// Expecting pawn can only move to 0,4
		new TestMove(0, 4, testMoves);
		new TestExpectedMoves(board, pawn, testMoves);
	}

	@Test
	public void simpleWhiteMoveNoOtherPiecesTest3() {
		this.reset();
		Pawn pawn = new Pawn(7, 3, PieceColor.WHITE, board);

		// Expecting pawn can only move to 7,2
		new TestMove(7, 2, testMoves);
		new TestExpectedMoves(board, pawn, testMoves);
	}

	/*
	 * Simple black pawn movements
	 */
	@Test
	public void simpleBlackMoveNoOtherPiecesTest1() {
		this.reset();
		Pawn pawn = new Pawn(0, 2, PieceColor.BLACK, board);

		// Expecting pawn can only move to 0,3
		new TestMove(0, 3, testMoves);
		new TestExpectedMoves(board, pawn, testMoves);
	}

	@Test
	public void simpleBlackMoveNoOtherPiecesTest2() {
		this.reset();
		Pawn pawn = new Pawn(5, 4, PieceColor.BLACK, board);

		// Expecting pawn can only move to 5,5
		new TestMove(5, 5, testMoves);
		new TestExpectedMoves(board, pawn, testMoves);
	}

	@Test
	public void simpleBlackMoveNoOtherPiecesTest3() {
		this.reset();
		Pawn pawn = new Pawn(7, 5, PieceColor.BLACK, board);

		// Expecting pawn can only move to 7,6
		new TestMove(7, 6, testMoves);
		new TestExpectedMoves(board, pawn, testMoves);
	}

	/*
	 * Simple movement when there is a piece in front of the pawn
	 */
	@Test
	public void simpleWhiteMoveBlockedByFriendlyPiece() {
		this.reset();
		Pawn pawn = new Pawn(4, 4, PieceColor.WHITE, board);
		new Pawn(4, 3, PieceColor.WHITE,board);
		
		// Expecting pawn can move nowhere
		new TestExpectedMoves(board, pawn, testMoves);
	}

	@Test
	public void simpleWhiteMoveBlockedByEnemyPiece() {
		this.reset();
		Pawn pawn = new Pawn(4, 4, PieceColor.WHITE, board);
		new Pawn(4, 3, PieceColor.BLACK,board);
		
		// Expecting pawn can move nowhere
		new TestExpectedMoves(board, pawn, testMoves);
	}

	@Test
	public void simpleBlackMoveBlockedByFriendlyPiece() {
		this.reset();
		Pawn pawn = new Pawn(4, 3, PieceColor.BLACK, board);
		new Pawn(4, 4, PieceColor.BLACK,board);
		
		// Expecting pawn can move nowhere
		new TestExpectedMoves(board, pawn, testMoves);
	}

	@Test
	public void simpleBlackMoveBlockedByEnemyPiece() {
		this.reset();
		Pawn pawn = new Pawn(4, 3, PieceColor.BLACK, board);
		new Pawn(4, 4, PieceColor.WHITE,board);
		
		// Expecting pawn can move nowhere
		new TestExpectedMoves(board, pawn, testMoves);
	}
}
