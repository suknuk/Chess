package chess;

import board.Board;
import board.Move;
import pieces.Pawn;
import pieces.PieceColor;

public class test {

	public static void main(String[] args) {
		Board board = new Board();
		
		Pawn pawn = new Pawn(4,4, PieceColor.WHITE, board);
		Move mv = new Move(pawn,board,4,3);
		board.applyMove(mv);
		
		System.out.println(BoardEvaluation.scoreEvaluation(board, PieceColor.WHITE));
		System.out.println(Chess.allPossibleMoves(board, PieceColor.WHITE).size());
	}

}
