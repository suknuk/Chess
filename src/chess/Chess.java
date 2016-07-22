package chess;

import board.Board;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
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
		new Tower(0, 0, PieceColor.BLACK, board);
		new Tower(7, 0, PieceColor.BLACK, board);
		new Tower(0, 7, PieceColor.WHITE, board);
		new Tower(7, 7, PieceColor.WHITE, board);
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
		new King(4, 0, PieceColor.BLACK, board);
		new King(4, 7, PieceColor.WHITE, board);
	}

	/*
	 * Display board on console
	 */
	public static void displayBoardText(Board board) {
		for (int y = 0; y <= 7; y++) {
			String line = "";
			for (int x = 0; x <= 7; x++) {
				Piece piece = board.getPieceAt(x, y);
				if (piece != null) {
					line += " " + piece.getClass();
				}
			}
			System.out.println(line);
		}
	}
}
