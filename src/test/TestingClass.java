package test;

import pieces.Pawn;
import pieces.PieceColor;
import board.Board;

public class TestingClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Board b = new Board();
		Pawn p = new Pawn(PieceColor.BLACK);
		
		b.board[0][0] = p;
		
		System.out.println(b.board[0][0] + " " + b.board[1][0]);

	}

}
