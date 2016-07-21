package bishopTest;

import org.junit.Test;

import pieces.Bishop;
import pieces.PieceColor;
import pieces.Tower;
import testSuite.MainTestClass;
import testSuite.TestExpectedMoves;
import testSuite.TestMove;

public class BishopSimpleMovement extends MainTestClass {

	/*
	 * Simple movements on an empty map
	 */
	@Test
	public void bishopEmptyMap1() {
		this.reset();
		Bishop bishop = new Bishop(0, 0, PieceColor.WHITE, board);
		// Expecting Bishop to move to 7,7
		for (int i = 1; i < 8; i++) {
			new TestMove(i, i, testMoves);
		}
		new TestExpectedMoves(board, bishop, testMoves);
	}

	@Test
	public void bishopEmptyMap2() {
		this.reset();
		Bishop bishop = new Bishop(4, 4, PieceColor.BLACK, board);
		// Expecting Bishop to move to 0,0 and 7,7
		for (int i = 0; i < 8; i++) {
			if (i != 4) {
				// diagonal up left and down right
				new TestMove(i, i, testMoves);
			}
		}
		for (int i = 1; i <= 3; i++) {
			// left down
			new TestMove(4 - i, 4 + i, testMoves);
			// up right
			new TestMove(4 + i, 4 - i, testMoves);
		}
		new TestExpectedMoves(board, bishop, testMoves);
	}

	/*
	 * Way blocked by friendly/enemy pieces
	 */
	@Test
	public void bishopMultipleObjectsInTheWay() {
		this.reset();
		Bishop bishop = new Bishop(2, 2, PieceColor.WHITE, board);

		// top left - Expecting Bishop to move to 1,1
		new Tower(1, 1, PieceColor.BLACK, board);
		new TestMove(1, 1, testMoves);

		// top right - One field empty between bishop and other bishop
		new Bishop(4, 0, PieceColor.WHITE, board);
		new TestMove(3, 1, testMoves);

		// down right - friendly Tower
		new Tower(3, 3, PieceColor.WHITE, board);
		
		// down left - 1 empty space and 1 enemy hit
		new Tower(0, 4, PieceColor.BLACK, board);
		new TestMove(1, 3, testMoves);
		new TestMove(0, 4, testMoves);

		new TestExpectedMoves(board, bishop, testMoves);
	}

	/*
	 * Hitting a enemy piece
	 */
	@Test
	public void bishopHittingEnemyPiece() {
		this.reset();
		Bishop bishop = new Bishop(0, 0, PieceColor.WHITE, board);
		new Tower(1, 1, PieceColor.BLACK, board);
		// Expecting Bishop to move to 1,1
		new TestMove(1, 1, testMoves);
		new TestExpectedMoves(board, bishop, testMoves);
	}
}
