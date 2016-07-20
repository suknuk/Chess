package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

public class test {

	public static void main(String[] args) {
		Board board = new Board();
		
		ArrayList<Move> moves = new ArrayList<Move>();
		//System.out.println(moves.size());
		
		Bishop t = new Bishop(4,4,Color.BLACK);
		board.addPiece(t);
		moves = t.possibleMoves(board);
		System.out.println(moves.size());
	}

}
