package pawnTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import board.Board;
import board.Move;
import pieces.PieceColor;
import pieces.Pawn;

/*
 * Test class to check for the basic pawn movements: single move and double move when the Pawn is at the start position
 */
public class PawnSimpleMovement {

	Board board;
	ArrayList<Move> moves;

	/*
	 * Following are single white movement checks without other pieces on the board
	 */
	@Test
	public void simpleWhiteMoveNoOtherPiecesTest1() {
		board = new Board();
		moves = new ArrayList<Move>();
		Pawn pawn = new Pawn(4, 4, PieceColor.WHITE);

		board.addPiece(pawn);

		moves = pawn.possibleMoves(board);
		/*
		 * There should only be one move for the pawn
		 */
		assertEquals(1,moves.size());
		
		/*
		 * Since pawn is white, it's single move should be towards 4,3
		 */
		assertEquals(4,moves.get(0).toX());
		assertEquals(3,moves.get(0).toY());
	}

	@Test
	public void simpleWhiteMoveNoOtherPiecesTest2() {
		board = new Board();
		moves = new ArrayList<Move>();
		Pawn pawn = new Pawn(0, 5, PieceColor.WHITE);

		board.addPiece(pawn);

		moves = pawn.possibleMoves(board);
		/*
		 * There should only be one move for the pawn
		 */
		assertEquals(1,moves.size());
		
		/*
		 * Since pawn is white, it's single move should be towards 4,3
		 */
		assertEquals(0,moves.get(0).toX());
		assertEquals(4,moves.get(0).toY());
	}
	
	@Test
	public void simpleWhiteMoveNoOtherPiecesTest3() {
		board = new Board();
		moves = new ArrayList<Move>();
		Pawn pawn = new Pawn(7, 3, PieceColor.WHITE);

		board.addPiece(pawn);

		moves = pawn.possibleMoves(board);
		/*
		 * There should only be one move for the pawn
		 */
		assertEquals(1,moves.size());
		
		/*
		 * Since pawn is white, it's single move should be towards 4,3
		 */
		assertEquals(7,moves.get(0).toX());
		assertEquals(2,moves.get(0).toY());
	}
	
	/*
	 * Simple black pawn movements
	 */
	@Test
	public void simpleBlackMoveNoOtherPiecesTest1() {
		board = new Board();
		moves = new ArrayList<Move>();
		Pawn pawn = new Pawn(0, 2, PieceColor.BLACK);

		board.addPiece(pawn);

		moves = pawn.possibleMoves(board);
		/*
		 * There should only be one move for the pawn
		 */
		assertEquals(1,moves.size());
		
		/*
		 * Since pawn is white, it's single move should be towards 4,3
		 */
		assertEquals(0,moves.get(0).toX());
		assertEquals(3,moves.get(0).toY());
	}
	
	@Test
	public void simpleBlackMoveNoOtherPiecesTest2() {
		board = new Board();
		moves = new ArrayList<Move>();
		Pawn pawn = new Pawn(5, 4, PieceColor.BLACK);

		board.addPiece(pawn);

		moves = pawn.possibleMoves(board);
		/*
		 * There should only be one move for the pawn
		 */
		assertEquals(1,moves.size());
		
		/*
		 * Since pawn is white, it's single move should be towards 4,3
		 */
		assertEquals(5,moves.get(0).toX());
		assertEquals(5,moves.get(0).toY());
	}
	
	@Test
	public void simpleBlackMoveNoOtherPiecesTest3() {
		board = new Board();
		moves = new ArrayList<Move>();
		Pawn pawn = new Pawn(7, 5, PieceColor.BLACK);

		board.addPiece(pawn);

		moves = pawn.possibleMoves(board);
		/*
		 * There should only be one move for the pawn
		 */
		assertEquals(1,moves.size());
		
		/*
		 * Since pawn is white, it's single move should be towards 4,3
		 */
		assertEquals(7,moves.get(0).toX());
		assertEquals(6,moves.get(0).toY());
	}
}
