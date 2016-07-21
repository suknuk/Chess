package towerTest;

import org.junit.Test;

import pieces.Pawn;
import pieces.PieceColor;
import pieces.Tower;
import testSuite.MainTestClass;
import testSuite.TestExpectedMoves;
import testSuite.TestMove;

public class TowerSimpleMovement extends MainTestClass {

	/*
	 * Testing movements on an empty map
	 */
	@Test
	public void towerEmptyMap1() {
		this.reset();
		Tower tower = new Tower(0, 0, PieceColor.WHITE, board);
		// Expecting tower to move right to 7,0 and down 0,7
		for (int i = 1; i < 8; i++) {
			new TestMove(0, i, testMoves);
			new TestMove(i, 0, testMoves);
		}
		new TestExpectedMoves(board, tower, testMoves);
	}

	@Test
	public void towerEmptyMap2() {
		this.reset();
		Tower tower = new Tower(7, 7, PieceColor.BLACK, board);
		// Expecting tower to move left to 0,7 and up 7,0
		for (int i = 6; i >= 0; i--) {
			new TestMove(7, i, testMoves);
			new TestMove(i, 7, testMoves);
		}
		new TestExpectedMoves(board, tower, testMoves);
	}

	/*
	 * Movements with friendly obstacles
	 */
	@Test
	public void towerFriendlyObjectInTheWay() {
		this.reset();
		Tower tower = new Tower(0, 0, PieceColor.WHITE, board);
		new Pawn(1, 0, PieceColor.WHITE, board);
		// Expecting tower to move down 0,7
		for (int i = 1; i < 8; i++) {
			new TestMove(0, i, testMoves);
		}
		new TestExpectedMoves(board, tower, testMoves);
	}

	/*
	 * Movements with enemy obstacle
	 */
	@Test
	public void towerEnemyyObjectInTheWay() {
		this.reset();
		Tower tower = new Tower(0, 0, PieceColor.WHITE, board);
		new Pawn(1, 0, PieceColor.BLACK, board);
		// Expecting tower to move down 0,7 and 1,0
		new TestMove(1, 0, testMoves);
		for (int i = 1; i < 8; i++) {
			new TestMove(0, i, testMoves);
		}
		new TestExpectedMoves(board, tower, testMoves);
	}

	/*
	 * Test with multiple obstacles
	 */
	@Test
	public void towerMultipleObjectsInTheWay() {
		this.reset();
		Tower tower = new Tower(4, 4, PieceColor.WHITE, board);
		new Pawn(4, 6, PieceColor.WHITE, board);
		new Pawn(4, 3, PieceColor.BLACK, board);
		new Pawn(3, 4, PieceColor.WHITE, board);
		new Pawn(5, 4, PieceColor.WHITE, board);
		
		
		// Expecting tower to move to 4,5 , 4,3
		new TestMove(4, 5, testMoves);
		new TestMove(4, 3, testMoves);

		new TestExpectedMoves(board, tower, testMoves);
	}
}
