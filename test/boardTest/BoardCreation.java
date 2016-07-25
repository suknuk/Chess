package boardTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chess.Chess;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.PieceColor;
import pieces.Queen;
import pieces.Tower;
import testSuite.MainTestClass;

public class BoardCreation extends MainTestClass {

	/*
	 * Testing if the board is being set up correctly
	 */
	@Test
	public void setingUpBoard() {
		this.reset();
		Chess.setupNormalMatch(board);

		/*
		 * from y = 2 to y= 5, everything should be null
		 */
		for (int x = 0; x <= 7; x++) {
			for (int y = 2; y <= 5; y++) {
				assertEquals(null, board.getPieceAt(x, y));
			}
		}

		/*
		 * checking pawns
		 */
		for (int x = 0; x <= 7; x++) {
			assertEquals(Pawn.class, board.getPieceAt(x, 1).getClass());
			assertEquals(Pawn.class, board.getPieceAt(x, 6).getClass());

			assertEquals(PieceColor.BLACK, board.getPieceAt(x, 1).color());
			assertEquals(PieceColor.WHITE, board.getPieceAt(x, 6).color());
		}
		/*
		 * checking towers
		 */
		assertEquals(Tower.class, board.getPieceAt(0, 0).getClass());
		assertEquals(Tower.class, board.getPieceAt(7, 0).getClass());
		assertEquals(Tower.class, board.getPieceAt(0, 7).getClass());
		assertEquals(Tower.class, board.getPieceAt(7, 7).getClass());

		assertEquals(PieceColor.BLACK, board.getPieceAt(0, 0).color());
		assertEquals(PieceColor.BLACK, board.getPieceAt(7, 0).color());
		assertEquals(PieceColor.WHITE, board.getPieceAt(0, 7).color());
		assertEquals(PieceColor.WHITE, board.getPieceAt(7, 7).color());
		
		/*
		 * checking knight
		 */
		assertEquals(Knight.class, board.getPieceAt(1, 0).getClass());
		assertEquals(Knight.class, board.getPieceAt(6, 0).getClass());
		assertEquals(Knight.class, board.getPieceAt(1, 7).getClass());
		assertEquals(Knight.class, board.getPieceAt(6, 7).getClass());

		assertEquals(PieceColor.BLACK, board.getPieceAt(1, 0).color());
		assertEquals(PieceColor.BLACK, board.getPieceAt(6, 0).color());
		assertEquals(PieceColor.WHITE, board.getPieceAt(1, 7).color());
		assertEquals(PieceColor.WHITE, board.getPieceAt(6, 7).color());
		
		/*
		 * checking bishop
		 */
		assertEquals(Bishop.class, board.getPieceAt(2, 0).getClass());
		assertEquals(Bishop.class, board.getPieceAt(5, 0).getClass());
		assertEquals(Bishop.class, board.getPieceAt(2, 7).getClass());
		assertEquals(Bishop.class, board.getPieceAt(5, 7).getClass());

		assertEquals(PieceColor.BLACK, board.getPieceAt(2, 0).color());
		assertEquals(PieceColor.BLACK, board.getPieceAt(5, 0).color());
		assertEquals(PieceColor.WHITE, board.getPieceAt(2, 7).color());
		assertEquals(PieceColor.WHITE, board.getPieceAt(5, 7).color());
		
		/*
		 * checking queen
		 */
		assertEquals(Queen.class, board.getPieceAt(3, 0).getClass());
		assertEquals(Queen.class, board.getPieceAt(3, 7).getClass());
		
		assertEquals(PieceColor.BLACK, board.getPieceAt(3, 0).color());
		assertEquals(PieceColor.WHITE, board.getPieceAt(3, 7).color());
		
		/*
		 * checking king
		 */
		assertEquals(King.class, board.getPieceAt(4, 0).getClass());
		assertEquals(King.class, board.getPieceAt(4, 7).getClass());
		
		assertEquals(PieceColor.BLACK, board.getPieceAt(4, 0).color());
		assertEquals(PieceColor.WHITE, board.getPieceAt(4, 7).color());
		
		/*
		 * white should be to go
		 */
		assertEquals(PieceColor.WHITE, board.whichPlayerToGo());
	}
}
