package chess;

import board.Board;
import board.Move;
import pieces.Bishop;
import pieces.PieceColor;
import pieces.Tower;

public class test {

	public static void main(String[] args) {
		/*
		Board board = new Board();
		
		King king = new King(4,7, PieceColor.WHITE, board);
		king.setMoved(false);;
		Tower tower = new Tower(7,7,PieceColor.WHITE,board);
		tower.setMoved(false);
		Move mv = new Move(king,board,6,7);
		board.applyMove(mv);
		
		System.out.println(board.getPieceAt(5, 7));
		System.out.println(board.getPieceAt(6, 7));
		System.out.println(board.getPieceAt(7, 7));
		*/
		
		Board board = new Board();
		Tower towerw = new Tower(7,7,PieceColor.WHITE,board);
		new Bishop(7,0,PieceColor.BLACK,board);
		
		System.out.println("before board evaluation: " + board.getPieceAt(7,0) + " " + board.getPieceAt(7, 7) );
		
		Move mv2 = new Move(towerw,board,7,0);
		board.applyMove(mv2);
		
		System.out.println("after board evaluation: " + board.getPieceAt(7,0) + " " + board.getPieceAt(7, 7) );

		//System.out.println(BoardEvaluation.scoreEvaluation(board, PieceColor.WHITE));
		//System.out.println(Chess.allPossibleMoves(board, PieceColor.WHITE).size());
	}

}
