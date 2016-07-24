package bishopTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import board.Move;
import pieces.Bishop;
import pieces.PieceColor;
import pieces.Queen;
import pieces.Tower;
import testSuite.MainTestClass;

public class BishopApplyMove extends MainTestClass {

	@Test
	public void bishopHittingPiece1() {
		this.reset();
		Bishop bishop = new Bishop(0, 0, PieceColor.WHITE, board);
		new Tower(1, 1, PieceColor.BLACK, board);

		Move mv = new Move(bishop, board, 7, 7);
		board.applyMove(mv);

		assertEquals(null, board.getPieceAt(0, 0));
		assertEquals(Bishop.class, board.getPieceAt(7, 7).getClass());
		assertEquals(PieceColor.WHITE, board.getPieceAt(7, 7).color());
	}

	@Test
	public void bishopHittingPiece2() {
		this.reset();
		Bishop bishop = new Bishop(3, 7, PieceColor.BLACK, board);
		new Queen(6, 4, PieceColor.WHITE, board);

		Move mv = new Move(bishop, board, 6, 4);
		board.applyMove(mv);

		assertEquals(null, board.getPieceAt(3, 7));
		assertEquals(Bishop.class, board.getPieceAt(6, 4).getClass());
		assertEquals(PieceColor.BLACK, board.getPieceAt(6, 4).color());
	}

}
