package pawnTest;

import org.junit.Test;

import pieces.Pawn;
import pieces.PieceColor;
import testSuite.MainTestClass;
import testSuite.TestExpectedMoves;
import testSuite.TestMove;

/*
 * Testing the jump case for the pawn class. When the pawn is at the starting position, he can move 2 field instead of 1
 */
public class PawnStartingJump extends MainTestClass{

	/*
	Board board;
	ArrayList<Move> moves;
	ArrayList<TestMove> testMoves;
	*/

	@Test
	public void whitePawnStartingJumpEmptyMap1() {
		this.reset();
		Pawn pawn = new Pawn(0,6, PieceColor.WHITE,board);
		// Expecting pawn can move to 0,5 and 0,4
		new TestMove(0,5,testMoves);
		new TestMove(0,4,testMoves);
		new TestExpectedMoves(board,pawn,testMoves);
	}
	
	@Test
	public void whitePawnStartingJumpEmptyMap2() {
		this.reset();
		Pawn pawn = new Pawn(7,6, PieceColor.WHITE,board);
		// Expecting pawn can move to 7,5 and 7,4
		new TestMove(7,5,testMoves);
		new TestMove(7,4,testMoves);
		new TestExpectedMoves(board,pawn,testMoves);
	}
	
	@Test
	public void blackPawnStartingJumpEmptyMap1() {
		this.reset();
		Pawn pawn = new Pawn(0,1, PieceColor.BLACK,board);
		// Expecting pawn can move to 0,2 and 0,3
		new TestMove(0,2,testMoves);
		new TestMove(0,3,testMoves);
		new TestExpectedMoves(board,pawn,testMoves);
	}
	
	@Test
	public void blackPawnStartingJumpEmptyMap2() {
		this.reset();
		Pawn pawn = new Pawn(7,1, PieceColor.BLACK,board);
		// Expecting pawn can move to 0,2 and 0,3
		new TestMove(7,2,testMoves);
		new TestMove(7,3,testMoves);
		new TestExpectedMoves(board,pawn,testMoves);
	}

	/*
	 * Testing when the jump is blocked by friendly piece
	 */
	@Test
	public void whitePawnStartingJumpBlockedByFriendlyPiece() {
		this.reset();
		Pawn pawn = new Pawn(0, 6, PieceColor.WHITE,board);
		new Pawn (0, 4, PieceColor.WHITE,board);
		// Expecting pawn can move to 0,5
		new TestMove(0,5,testMoves);
		new TestExpectedMoves(board,pawn,testMoves);
	}
	
	@Test
	public void blackPawnStartingJumpBlockedByFriendlyPiece() {
		this.reset();
		Pawn pawn = new Pawn(0, 1, PieceColor.BLACK,board);
		new Pawn (0, 3, PieceColor.BLACK,board);
		// Expecting pawn can move to 0,2
		new TestMove(0,2,testMoves);
		new TestExpectedMoves(board,pawn,testMoves);
	}
	
	/*
	 * blocked by enemy piece
	 */
	@Test
	public void whitePawnStartingJumpBlockedByEnemyPiece() {
		this.reset();
		Pawn pawn = new Pawn(2, 6, PieceColor.WHITE,board);
		new Pawn (2, 4, PieceColor.BLACK,board);
		// Expecting pawn can move to 2,5
		new TestMove(2,5,testMoves);
		new TestExpectedMoves(board,pawn,testMoves);
	}
	
	@Test
	public void blackPawnStartingJumpBlockedByEnemyPiece() {
		this.reset();
		Pawn pawn = new Pawn(5, 1, PieceColor.BLACK,board);
		new Pawn (5, 3, PieceColor.WHITE,board);
		// Expecting pawn can move to 5,2
		new TestMove(5,2,testMoves);
		new TestExpectedMoves(board,pawn,testMoves);
	}

}
