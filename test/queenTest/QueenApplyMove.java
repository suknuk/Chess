package queenTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import board.Move;
import pieces.Bishop;
import pieces.PieceColor;
import pieces.Queen;
import pieces.Tower;
import testSuite.MainTestClass;
import testSuite.TestExpectedMoves;
import testSuite.TestMove;

public class QueenApplyMove extends MainTestClass {

	@Test
	public void QueenHitEnemyApplyMove1() {
		this.reset();
		Queen queen = new Queen(0, 0, PieceColor.WHITE, board);

		new Tower(0, 1, PieceColor.WHITE, board);
		new Tower(1, 1, PieceColor.WHITE, board);

		new Bishop(1, 0, PieceColor.BLACK, board);

		// test-hitting the piece
		new TestMove(1, 0, testMoves);
		new TestExpectedMoves(board, queen, testMoves);

		Move move = new Move(queen, board, 1, 0);
		board.applyMove(move);
		
		assertEquals(null, board.getPieceAt(0, 0));
		// getDeclaringClass since Queen uses 2 subclasses of Tower and Bishop for its moves
		assertEquals(Queen.class, board.getPieceAt(1, 0).getClass().getDeclaringClass());
	}
	
	@Test
	public void QueenHitEnemyApplyMove2() {
		this.reset();
		Queen queen = new Queen(4, 1, PieceColor.WHITE, board);

		new Tower(4, 0, PieceColor.BLACK, board);

		Move move = new Move(queen, board, 4, 0);
		board.applyMove(move);
		
		System.out.println(board.getPieceAt(4, 0) + " " + board.getPieceAt(4, 1));
		
		assertEquals(null, board.getPieceAt(4, 1));
		assertEquals(Queen.class, board.getPieceAt(4, 0).getClass());
	}

}
