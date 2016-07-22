package board;

import pieces.Piece;

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
		// update board and new copy
		this.board[move.toX()][move.toY()] = movingPiece;
		movingPiece.setX(move.toX());;
		movingPiece.setY(move.toY());
		// destroy old copy
		this.board[move.fromX()][move.fromY()] = null;
		
	}
}
