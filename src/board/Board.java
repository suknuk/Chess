package board;

import pieces.King;
import pieces.Pawn;
import pieces.Piece;
import pieces.PieceColor;
import pieces.Queen;
import pieces.Tower;

/*
 * This class holds all the board information
 */
public class Board {

	/*
	 * 2D-Array which holds the pieces
	 */
	private Piece[][] board;

	/**
	 * Board constructor
	 */
	public Board() {
		this.board = new Piece[8][8];
	}

	/**
	 * Copy constructor
	 * 
	 * @param copyMe
	 *            copying a board instance
	 */
	public Board(Board copyMe) {
		this();
		for (int y = 0; y <= 7; y++) {
			for (int x = 0; x <= 7; x++) {
				this.board[x][y] = copyMe.board[x][y];
			}
		}
	}

	/**
	 * Returning status of the board
	 * 
	 * @return the board instance
	 */
	public Piece[][] getBoard() {
		return this.board;
	}

	/**
	 * Returning piece at X/Y position
	 * 
	 * @param x
	 *            x position of the piece
	 * @param y
	 *            y position of the piece
	 * @return Piece at the indicated position
	 */
	public Piece getPieceAt(int x, int y) {
		return board[x][y];
	}

	/**
	 * @param piece
	 *            piece to be added to the board
	 */
	public void addPiece(Piece piece) {
		this.board[piece.getPoisitonX()][piece.getPositionY()] = piece;
	}

	/**
	 * Applying a move to the board
	 * 
	 * @param move
	 *            The to applied move on the board
	 */
	public void applyMove(Move move) {
		// get copy
		Piece movingPiece = move.getMovingPiece();

		/*
		 * Error handling
		 */
		if (movingPiece == null) {
			throw new java.lang.IllegalArgumentException("Trying to move non-existant piece");
		}

		/*
		 * special case to change pawn into queen white pawn reaches black side
		 */
		if (move.toY() == 0 && movingPiece.getClass().equals(Pawn.class) && movingPiece.color() == PieceColor.WHITE) {
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
		 * special case: castling when kings moves over more than 1 field
		 */
		else if (movingPiece.getClass().equals(King.class) && (Math.pow(move.toX() - move.fromX(), 2)) > 1
				&& !((King) movingPiece).getMoved()) {

			/*
			 * y variable for the side of the castling move.
			 */
			int y;
			if (movingPiece.color() == PieceColor.WHITE) {
				y = 7;
			} else {
				y = 0;
			}

			// right castling move
			if (move.toX() == 6 && this.getPieceAt(7, y) != null && this.getPieceAt(7, y).getClass().equals(Tower.class)
					&& !((Tower) this.getPieceAt(7, y)).getMoved()) {

				// Moving the king
				this.board[6][y] = movingPiece;
				((King) this.board[6][y]).setMoved(true);
				// Moving the tower
				this.board[5][y] = this.board[7][y];
				((Tower) this.board[5][y]).setMoved(true);
				((Tower) this.board[5][y]).setPosition(5, y);
				// setting old field to null
				this.board[7][y] = null;
			}
			// left castling move
			else if (move.toX() == 2 && this.getPieceAt(0, y) != null
					&& this.getPieceAt(0, y).getClass().equals(Tower.class)
					&& !((Tower) this.getPieceAt(0, y)).getMoved()) {
				// Moving the king
				this.board[2][y] = movingPiece;
				((King) this.board[2][y]).setMoved(true);
				// Moving the tower
				this.board[3][y] = this.board[0][y];
				((Tower) this.board[3][y]).setMoved(true);
				((Tower) this.board[3][y]).setPosition(3, y);
				// setting old field to null
				this.board[4][y] = null;
				this.board[0][y] = null;
			} else {
				throw new java.lang.IllegalArgumentException("Illegal King move");
			}

			System.out.println("Detecting castling move");
		}
		/*
		 * otherwise just move the piece
		 */
		else {
			System.out.println("toX:" + move.toX() + ", toY:" + move.toY());
			this.board[move.toX()][move.toY()] = this.board[move.fromX()][move.fromY()];

			/*
			 * Special case for towers and kings, to set the moved flat
			 */

			if (this.board[move.toX()][move.toY()].getClass().equals(Tower.class)) {
				((Tower) this.board[move.toX()][move.toY()]).setMoved(true);
			} else if (this.board[move.toX()][move.toY()].getClass().equals(King.class)) {
				((King) this.board[move.toX()][move.toY()]).setMoved(true);
			}
		}
		// destroy old copy
		this.board[move.fromX()][move.fromY()] = null;
		// set new position to class
		this.board[move.toX()][move.toY()].setPosition(move.toX(), move.toY());
	}
}
