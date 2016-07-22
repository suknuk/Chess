package kingTest;

import org.junit.Test;

import pieces.King;
import pieces.PieceColor;
import pieces.Tower;
import testSuite.MainTestClass;
import testSuite.TestExpectedMoves;
import testSuite.TestMove;

/*
 * Checking the castling move
 */
public class KingCastling extends MainTestClass{

	/*
	 * Testing white castling move to the right
	 */
	@Test
	public void WhiteKingCastlingRight() {
		this.reset();
		King king = new King(4,7, PieceColor.WHITE, board);
		king.setNotMoved();
		Tower tower = new Tower(7,7,PieceColor.WHITE,board);
		tower.setNotMoved();
		
		
		new TestMove(3, 6, testMoves);
		new TestMove(4, 6, testMoves);
		new TestMove(5, 6, testMoves);
		new TestMove(3, 7, testMoves);
		new TestMove(5, 7, testMoves);
		// the castling move
		new TestMove(6, 7, testMoves);

		new TestExpectedMoves(board, king, testMoves);
	}
	
	/*
	 * Testing white castling move to the left
	 */
	@Test
	public void WhiteKingCastlingLeft() {
		this.reset();
		King king = new King(4,7, PieceColor.WHITE, board);
		king.setNotMoved();
		Tower tower = new Tower(0,7,PieceColor.WHITE,board);
		tower.setNotMoved();
		
		
		new TestMove(3, 6, testMoves);
		new TestMove(4, 6, testMoves);
		new TestMove(5, 6, testMoves);
		new TestMove(3, 7, testMoves);
		new TestMove(5, 7, testMoves);
		// the castling move
		new TestMove(2, 7, testMoves);

		new TestExpectedMoves(board, king, testMoves);
	}
	
	/*
	 * Testing black castling move to the right
	 */
	@Test
	public void BlackKingCastlingRight() {
		this.reset();
		King king = new King(4,0, PieceColor.BLACK, board);
		king.setNotMoved();
		Tower tower = new Tower(7,0,PieceColor.BLACK,board);
		tower.setNotMoved();
		
		
		new TestMove(3, 1, testMoves);
		new TestMove(4, 1, testMoves);
		new TestMove(5, 1, testMoves);
		new TestMove(3, 0, testMoves);
		new TestMove(5, 0, testMoves);
		// the castling move
		new TestMove(6, 0, testMoves);

		new TestExpectedMoves(board, king, testMoves);
	}
	
	/*
	 * Testing black castling move to the left
	 */
	@Test
	public void BlackKingCastlingLeft() {
		this.reset();
		King king = new King(4,0, PieceColor.BLACK, board);
		king.setNotMoved();
		Tower tower = new Tower(0,0,PieceColor.BLACK,board);
		tower.setNotMoved();
		
		
		new TestMove(3, 1, testMoves);
		new TestMove(4, 1, testMoves);
		new TestMove(5, 1, testMoves);
		new TestMove(3, 0, testMoves);
		new TestMove(5, 0, testMoves);
		// the castling move
		new TestMove(2, 0, testMoves);

		new TestExpectedMoves(board, king, testMoves);
	}

}
