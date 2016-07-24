package knightTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import board.Move;
import pieces.Bishop;
import pieces.Knight;
import pieces.Pawn;
import pieces.PieceColor;
import testSuite.MainTestClass;

public class KnightApplyMove extends MainTestClass{

	@Test
	public void knightHittingPiece1() {
		this.reset();
		Knight knight = new Knight(4, 4, PieceColor.WHITE, board);
		new Pawn(3, 6, PieceColor.BLACK, board);

		Move mv = new Move(knight, board, 3, 6);
		board.applyMove(mv);

		assertEquals(null, board.getPieceAt(4, 4));
		assertEquals(Knight.class, board.getPieceAt(3, 6).getClass());
		assertEquals(PieceColor.WHITE, board.getPieceAt(3, 6).color());
	}
	
	@Test
	public void knightHittingPiece2() {
		this.reset();
		Knight knight = new Knight(0, 0, PieceColor.BLACK, board);
		new Bishop(2, 1, PieceColor.WHITE, board);

		Move mv = new Move(knight, board, 2, 1);
		board.applyMove(mv);

		assertEquals(null, board.getPieceAt(0, 0));
		assertEquals(Knight.class, board.getPieceAt(2, 1).getClass());
		assertEquals(PieceColor.BLACK, board.getPieceAt(2, 1).color());
	}

}
