package pawnTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import board.Move;
import pieces.Pawn;
import pieces.PieceColor;
import testSuite.MainTestClass;

public class PawnApplyMove extends MainTestClass {

	@Test
	public void pawnHittingPawnFromStartingPosition() {
		this.reset();
		Pawn pawn = new Pawn(4, 6, PieceColor.WHITE, board);
		new Pawn(3, 5, PieceColor.BLACK, board);

		Move mv = new Move(pawn, board, 3, 5);
		board.applyMove(mv);

		assertEquals(null, board.getPieceAt(4, 6));
		assertEquals(Pawn.class, board.getPieceAt(3, 5).getClass());
		assertEquals(PieceColor.WHITE, board.getPieceAt(3, 5).color());
	}
	
	@Test
	public void pawnHittingPawnFromMiddleOfMap() {
		this.reset();
		Pawn pawn = new Pawn(4, 2, PieceColor.BLACK, board);
		new Pawn(3, 3, PieceColor.WHITE, board);

		Move mv = new Move(pawn, board, 3,3);
		board.applyMove(mv);

		assertEquals(null, board.getPieceAt(4,2));
		assertEquals(Pawn.class, board.getPieceAt(3, 3).getClass());
		assertEquals(PieceColor.BLACK, board.getPieceAt(3, 3).color());
	}

}
