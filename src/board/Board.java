package board;

import pieces.Pawn;
import pieces.Piece;
import pieces.PieceColor;
import pieces.Queen;

/*
 * This class holds all the board information
 */
public class Board {

	/*
	 * 2D-Array which holds the pieces
	 */
	private Piece[][] board;

	/*
	 * Board constructor
	 */
	public Board() {
		this.board = new Piece[8][8];
	}

	/*
	 * Copy constructor
	 */
	public Board(Board copyMe) {
		this();
		for (int y = 0; y <= 7; y++) {
			for (int x = 0; x <= 7; x++) {
				this.board[x][y] = copyMe.board[x][y];
			}
		}
	}

	/*
	 * Returning status of the board
	 */
	public Piece[][] getBoard() {
		return this.board;
	}

	/*
	 * Returning piece at X/Y position
	 */
	public Piece getPieceAt(int x, int y) {
		return board[x][y];
	}

	/*
	 * Adding a piece to the board
	 */
	public void addPiece(Piece piece) {
		this.board[piece.getPoisitonX()][piece.getPositionY()] = piece;
	}

	/*
	 * applying a move to the board
	 */
	public void applyMove(Move move) {
		// get copy
		Piece movingPiece = this.board[move.fromX()][move.fromY()];

		/*
		 * Error handling
		 */
		if (movingPiece == null) {
			throw new java.lang.IllegalArgumentException("Trying to move non-existant piece");
		}

		/*
		 * special case to change pawn into queen white pawn reaches black side
		 */
		if (move.toY() == 0 && movingPiece.getClass().equals(Pawn.class)
				&& movingPiece.color() == PieceColor.WHITE) {
			new Queen(move.toX(), move.toY(), PieceColor.WHITE, this);
		}
		/*
		 * black pawn reaches white side
		 */
		else if (move.toY() == 7 && movingPiece.getClass().equals(Pawn.class)
				&& movingPiece.color() == PieceColor.BLACK) {
			new Queen(move.toX(), move.toY(), PieceColor.BLACK, this);
		}
		/*
		 * otherwise just move the piece
		 */
		else {
			this.board[move.toX()][move.toY()] = movingPiece;
			movingPiece.setX(move.toX());
			movingPiece.setY(move.toY());
		}
		// destroy old copy
		this.board[move.fromX()][move.fromY()] = null;

	}
}
