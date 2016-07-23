package chess;

import java.util.ArrayList;

import board.Board;
import board.Move;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.PieceColor;
import pieces.Queen;
import pieces.Tower;

public class Chess {
	
	/*
	 * Setting up the board for a normal game
	 */
	public static void setupNormalMatch(Board board) {
		// pawns
		for (int x = 0; x <= 7; x++) {
			new Pawn(x, 1, PieceColor.BLACK, board);
			new Pawn(x, 6, PieceColor.WHITE, board);
		}
		// Towers
		new Tower(0, 0, PieceColor.BLACK, board).setMoved(false);
		new Tower(7, 0, PieceColor.BLACK, board).setMoved(false);
		new Tower(0, 7, PieceColor.WHITE, board).setMoved(false);
		new Tower(7, 7, PieceColor.WHITE, board).setMoved(false);
		// Knights
		new Knight(1, 0, PieceColor.BLACK, board);
		new Knight(6, 0, PieceColor.BLACK, board);
		new Knight(1, 7, PieceColor.WHITE, board);
		new Knight(6, 7, PieceColor.WHITE, board);
		// Bishops
		new Bishop(2, 0, PieceColor.BLACK, board);
		new Bishop(5, 0, PieceColor.BLACK, board);
		new Bishop(2, 7, PieceColor.WHITE, board);
		new Bishop(5, 7, PieceColor.WHITE, board);
		// Queens
		new Queen(3, 0, PieceColor.BLACK, board);
		new Queen(3, 7, PieceColor.WHITE, board);
		// Kings
		new King(4, 0, PieceColor.BLACK, board).setMoved(false);
		new King(4, 7, PieceColor.WHITE, board).setMoved(false);
	}

	/*
	 * Display board on console
	 */
	public static void displayBoardText(Board board) {
		/*
		 * Iterating every field
		 */
		for (int y = 0; y <= 7; y++) {
			String line = "";
			for (int x = 0; x <= 7; x++) {
				if (board.getPieceAt(x, y) != null) {
					line += " " + board.getPieceAt(x, y).getClass();
				}
			}
			System.out.println(line);
		}
	}
	
	/*
	 * Every possible move from a player
	 */
	public static ArrayList<Move> allPossibleMoves(Board board, PieceColor color){
		ArrayList<Move> allMoves = new ArrayList<Move>();
		
		for (int y = 0; y <= 7; y++) {
			for (int x = 0; x <= 7; x++) {
				if ((board.getPieceAt(x, y) != null) && (board.getPieceAt(x, y).color() == color)) {
					allMoves.addAll(board.getPieceAt(x, y).possibleMoves(board));
				}
			}
		}
		return allMoves;
	}
	
}
