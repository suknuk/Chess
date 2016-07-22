package knightTest;

import org.junit.Test;

import pieces.Knight;
import pieces.Pawn;
import pieces.PieceColor;
import pieces.Tower;
import testSuite.MainTestClass;
import testSuite.TestExpectedMoves;
import testSuite.TestMove;

public class KnightSimpleMovement extends MainTestClass {
	
	@Test
	public void knightInCorner() {
		this.reset();
		Knight knight = new Knight(0, 0, PieceColor.WHITE, board);

		// expecting knight to move to 2,1 and 1,2
		new TestMove(2,1,testMoves);
		new TestMove(1,2,testMoves);
		
		new TestExpectedMoves(board, knight, testMoves);
	}
	
	@Test
	public void knightMiddleNoObstacles() {
		this.reset();
		Knight knight = new Knight(4, 4, PieceColor.WHITE, board);

		// expecting knight to move to 8 places around him
		// up
		new TestMove(3,2,testMoves);
		new TestMove(5,2,testMoves);
		
		// down
		new TestMove(3,6,testMoves);
		new TestMove(5,6,testMoves);
		
		// left
		new TestMove(2,3,testMoves);
		new TestMove(2,5,testMoves);
		
		// right
		new TestMove(6,3,testMoves);
		new TestMove(6,5,testMoves);
		
		new TestExpectedMoves(board, knight, testMoves);
	}
	
	@Test
	public void knightOnSideWithObstacles() {
		this.reset();
		Knight knight = new Knight(0, 3, PieceColor.WHITE, board);
		new Pawn(1,1,PieceColor.WHITE,board);
		new Pawn(1,5,PieceColor.WHITE,board);

		new Tower(2,2,PieceColor.BLACK,board);
		
		// expecting knight to hit 2,2 and move to 2,4
		new TestMove(2,2,testMoves);
		new TestMove(2,4,testMoves);
		
		new TestExpectedMoves(board, knight, testMoves);
	}
}
