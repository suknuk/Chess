package kingTest;

import org.junit.Test;

import pieces.Bishop;
import pieces.King;
import pieces.Pawn;
import pieces.PieceColor;
import testSuite.MainTestClass;
import testSuite.TestExpectedMoves;
import testSuite.TestMove;

public class KingSimpleMovement extends MainTestClass {

	@Test
	public void KingInCorder() {
		this.reset();
		King king = new King(0, 0, PieceColor.WHITE, board);

		new TestMove(1, 1, testMoves);
		new TestMove(1, 0, testMoves);
		new TestMove(0, 1, testMoves);

		new TestExpectedMoves(board, king, testMoves);
	}

	@Test
	public void KingInMiddleNoObstacles() {
		this.reset();
		King king = new King(4, 4, PieceColor.WHITE, board);

		// expecting king to move around him
		for (int x = 3; x <= 5; x++) {
			for (int y = 3; y <= 5; y++) {
				if (!(x == 4 && y == 4)) {
					new TestMove(x, y, testMoves);
				}
			}
		}
		new TestExpectedMoves(board, king, testMoves);
	}

	@Test
	public void KingObstaclesAndHitting() {
		this.reset();
		King king = new King(4, 7, PieceColor.WHITE, board);
		new Pawn(3, 6, PieceColor.WHITE, board);
		new Pawn(4, 6, PieceColor.WHITE, board);
		new Pawn(5, 6, PieceColor.WHITE, board);
		
		new Bishop(5,7,PieceColor.BLACK,board);
		
		// Expecting to hit the enemy bishop and being able to go left
		new TestMove(5,7,testMoves);
		new TestMove(3,7,testMoves);

		new TestExpectedMoves(board, king, testMoves);
	}
}
