package kingTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import board.Move;
import pieces.Bishop;
import pieces.King;
import pieces.PieceColor;
import pieces.Tower;
import testSuite.MainTestClass;
import testSuite.TestExpectedMoves;
import testSuite.TestMove;

/*
 * Checking the castling move
 */
public class KingCastling extends MainTestClass {

	/*
	 * Testing white castling move to the right
	 */
	@Test
	public void WhiteKingCastlingRight() {
		this.reset();
		King king = new King(4, 7, PieceColor.WHITE, board);
		king.setMoved(false);
		Tower tower = new Tower(7, 7, PieceColor.WHITE, board);
		tower.setMoved(false);

		new TestMove(3, 6, testMoves);
		new TestMove(4, 6, testMoves);
		new TestMove(5, 6, testMoves);
		new TestMove(3, 7, testMoves);
		new TestMove(5, 7, testMoves);
		// the castling move
		new TestMove(6, 7, testMoves);

		new TestExpectedMoves(board, king, testMoves);
		
		// testing applying move to board
		Move mv = new Move(king,board,6,7);
		board.applyMove(mv);
		
		assertEquals(null,board.getPieceAt(4, 7));
		assertEquals(Tower.class,board.getPieceAt(5, 7).getClass());
		assertEquals(King.class,board.getPieceAt(6, 7).getClass());		
		assertEquals(null,board.getPieceAt(7, 7));
	}

	/*
	 * Testing white castling move to the left
	 */
	@Test
	public void WhiteKingCastlingLeft() {
		this.reset();
		King king = new King(4, 7, PieceColor.WHITE, board);
		king.setMoved(false);
		Tower tower = new Tower(0, 7, PieceColor.WHITE, board);
		tower.setMoved(false);

		new TestMove(3, 6, testMoves);
		new TestMove(4, 6, testMoves);
		new TestMove(5, 6, testMoves);
		new TestMove(3, 7, testMoves);
		new TestMove(5, 7, testMoves);
		// the castling move
		new TestMove(2, 7, testMoves);

		new TestExpectedMoves(board, king, testMoves);
		
		// testing applying move to board
		Move mv = new Move(king,board,2,7);
		board.applyMove(mv);
		
		assertEquals(null,board.getPieceAt(0, 7));
		assertEquals(null,board.getPieceAt(1, 7));
		assertEquals(King.class,board.getPieceAt(2, 7).getClass());	
		assertEquals(Tower.class,board.getPieceAt(3, 7).getClass());
		assertEquals(null,board.getPieceAt(4, 7));
	}

	/*
	 * Testing black castling move to the right
	 */
	@Test
	public void BlackKingCastlingRight() {
		this.reset();
		King king = new King(4, 0, PieceColor.BLACK, board);
		king.setMoved(false);
		Tower tower = new Tower(7, 0, PieceColor.BLACK, board);
		tower.setMoved(false);

		new TestMove(3, 1, testMoves);
		new TestMove(4, 1, testMoves);
		new TestMove(5, 1, testMoves);
		new TestMove(3, 0, testMoves);
		new TestMove(5, 0, testMoves);
		// the castling move
		new TestMove(6, 0, testMoves);

		new TestExpectedMoves(board, king, testMoves);
		
		// testing applying move to board
		Move mv = new Move(king,board,6,0);
		board.applyMove(mv);
		
		assertEquals(null,board.getPieceAt(4, 0));
		assertEquals(Tower.class,board.getPieceAt(5, 0).getClass());
		assertEquals(King.class,board.getPieceAt(6, 0).getClass());		
		assertEquals(null,board.getPieceAt(7, 0));
	}

	/*
	 * Testing black castling move to the left
	 */
	@Test
	public void BlackKingCastlingLeft() {
		this.reset();
		King king = new King(4, 0, PieceColor.BLACK, board);
		king.setMoved(false);
		Tower tower = new Tower(0, 0, PieceColor.BLACK, board);
		tower.setMoved(false);

		new TestMove(3, 1, testMoves);
		new TestMove(4, 1, testMoves);
		new TestMove(5, 1, testMoves);
		new TestMove(3, 0, testMoves);
		new TestMove(5, 0, testMoves);
		// the castling move
		new TestMove(2, 0, testMoves);

		new TestExpectedMoves(board, king, testMoves);
		
		// testing applying move to board
		Move mv = new Move(king,board,2,0);
		board.applyMove(mv);
		
		assertEquals(null,board.getPieceAt(0, 0));
		assertEquals(null,board.getPieceAt(1, 0));
		assertEquals(King.class,board.getPieceAt(2, 0).getClass());	
		assertEquals(Tower.class,board.getPieceAt(3, 0).getClass());
		assertEquals(null,board.getPieceAt(4, 0));
	}

	/*
	 * White king right no castling, objects in the way
	 */
	@Test
	public void WhiteKingCastlingRightObjectsInTheWay() {
		this.reset();
		King king = new King(4, 7, PieceColor.WHITE, board);
		king.setMoved(false);
		Tower tower = new Tower(7, 7, PieceColor.WHITE, board);
		tower.setMoved(false);

		new Bishop(5, 7, PieceColor.WHITE, board);

		new TestMove(3, 6, testMoves);
		new TestMove(4, 6, testMoves);
		new TestMove(5, 6, testMoves);
		new TestMove(3, 7, testMoves);

		new TestExpectedMoves(board, king, testMoves);
	}

	/*
	 * White king left no castling, objects in the way
	 */
	@Test
	public void WhiteKingCastlingLeftObjectsInTheWay() {
		this.reset();
		King king = new King(4, 7, PieceColor.WHITE, board);
		king.setMoved(false);
		Tower tower = new Tower(0, 7, PieceColor.WHITE, board);
		tower.setMoved(false);

		new Bishop(1, 7, PieceColor.WHITE, board);

		new TestMove(3, 6, testMoves);
		new TestMove(4, 6, testMoves);
		new TestMove(5, 6, testMoves);
		new TestMove(3, 7, testMoves);
		new TestMove(5, 7, testMoves);

		new TestExpectedMoves(board, king, testMoves);
	}

	/*
	 * black king right no castling, objects in the way
	 */
	@Test
	public void BlackKingCastlingRightObjectsInTheWay() {
		this.reset();
		King king = new King(4, 0, PieceColor.BLACK, board);
		king.setMoved(false);
		Tower tower = new Tower(7, 0, PieceColor.BLACK, board);
		tower.setMoved(false);

		new Bishop(5, 0, PieceColor.BLACK, board);

		new TestMove(3, 1, testMoves);
		new TestMove(4, 1, testMoves);
		new TestMove(5, 1, testMoves);
		new TestMove(3, 0, testMoves);

		new TestExpectedMoves(board, king, testMoves);
	}

	/*
	 * Black king left no castling, objects in the way
	 */
	@Test
	public void BlackKingCastlingLeftObjectsInTheWay() {
		this.reset();
		King king = new King(4, 0, PieceColor.BLACK, board);
		king.setMoved(false);
		Tower tower = new Tower(0, 0, PieceColor.BLACK, board);
		tower.setMoved(false);

		new Bishop(1, 0, PieceColor.BLACK, board);

		new TestMove(3, 1, testMoves);
		new TestMove(4, 1, testMoves);
		new TestMove(5, 1, testMoves);
		new TestMove(3, 0, testMoves);
		new TestMove(5, 0, testMoves);

		new TestExpectedMoves(board, king, testMoves);
	}

}
