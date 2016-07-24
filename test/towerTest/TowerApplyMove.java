package towerTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import board.Move;
import pieces.PieceColor;
import pieces.Queen;
import pieces.Tower;
import testSuite.MainTestClass;

public class TowerApplyMove extends MainTestClass{

	@Test
	public void TowerHitEnemyApplyMove1() {
		this.reset();
		Tower queen = new Tower(0, 0, PieceColor.BLACK, board);

		new Tower(0, 7, PieceColor.WHITE, board);

		Move move = new Move(queen, board, 0, 7);
		board.applyMove(move);
		
		assertEquals(null, board.getPieceAt(0, 0));
		// getDeclaringClass since Queen uses 2 subclasses of Tower and Bishop for its moves
		assertEquals(Tower.class, board.getPieceAt(0, 7).getClass());
		assertEquals(PieceColor.BLACK,board.getPieceAt(0, 7).color());
	}
	
	@Test
	public void TowerHitEnemyApplyMove2() {
		this.reset();
		Tower queen = new Tower(4, 3, PieceColor.WHITE, board);

		new Queen(4, 0, PieceColor.BLACK, board);

		Move move = new Move(queen, board, 4, 0);
		board.applyMove(move);
		
		assertEquals(null, board.getPieceAt(4, 3));
		// getDeclaringClass since Queen uses 2 subclasses of Tower and Bishop for its moves
		assertEquals(Tower.class, board.getPieceAt(4, 0).getClass());
		assertEquals(PieceColor.WHITE,board.getPieceAt(4, 0).color());
	}

}
