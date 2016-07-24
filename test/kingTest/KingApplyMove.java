package kingTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import board.Move;
import pieces.King;
import pieces.PieceColor;
import pieces.Tower;
import testSuite.MainTestClass;

public class KingApplyMove extends MainTestClass {

	@Test
	public void kingHittingPiece1() {
		this.reset();
		King king = new King(4, 7, PieceColor.WHITE, board);
		new Tower(3, 6, PieceColor.BLACK, board);

		Move mv = new Move(king, board, 3, 6);
		board.applyMove(mv);

		assertEquals(null, board.getPieceAt(4, 7));
		assertEquals(King.class, board.getPieceAt(3, 6).getClass());
		assertEquals(PieceColor.WHITE, board.getPieceAt(3, 6).color());
	}

	@Test
	public void kingHittingPiece2() {
		this.reset();
		King king = new King(4, 0, PieceColor.BLACK, board);
		new Tower(3, 1, PieceColor.WHITE, board);

		Move mv = new Move(king, board, 3, 1);
		board.applyMove(mv);

		assertEquals(null, board.getPieceAt(4, 0));
		assertEquals(King.class, board.getPieceAt(3, 1).getClass());
		assertEquals(PieceColor.BLACK, board.getPieceAt(3, 1).color());
	}

}
