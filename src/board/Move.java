package board;

import java.util.ArrayList;

import pieces.Piece;

/*
 * This class deals with the movement of pieces on the chess board
 */
public class Move {

	/*
	 * private variables necessary for the class
	 */
	private Piece movingPiece;
	private int toX;
	private int toY;

	/*
	 * constructor
	 */
	public Move(Piece piece, Board board, int toX, int toY) {
		if (toX >= 0 && toX <= 7 && toY >= 0 && toY <= 7) {
			this.movingPiece = piece;
			this.toX = toX;
			this.toY = toY;

			System.out.print("New move from : " + piece.getClass() + ", from x: " + piece.getPoisitonX() + ", y: "
					+ piece.getPositionY() + ", to x: " + toX + ", y: " + toY);
			/*
			 * Moving to empty place
			 */
			Piece toPiece = board.getPieceAt(toX, toY);
			if (toPiece == null) {
				System.out.println(". Moved successfully");
			}
			/*
			 * Moving to same color piece
			 */
			else if (toPiece.color() == piece.color()) {
				throw new java.lang.IllegalArgumentException("Trying to move onto existing same color piece");
			}
			/*
			 * Hitting enemy piece
			 */
			else if (toPiece.color() != piece.color()) {
				System.out.println(". Enemy piece hit");
			}
		} else {
			throw new java.lang.IllegalArgumentException("Trying to move out of board");
		}
	}

	/*
	 * constructor that adds the move automatically to an ArrayList<Move>
	 */
	public Move(Piece piece, Board board, int toX, int toY, ArrayList<Move> moves) {
		this(piece, board, toX, toY);
		moves.add(this);
	}

	/*
	 * public getters
	 */
	public Piece getMovingPiece() {
		return this.movingPiece;
	}

	public int toX() {
		return this.toX;
	}

	public int toY() {
		return this.toY;
	}

	public int fromX() {
		return this.movingPiece.getPoisitonX();
	}

	public int fromY() {
		return this.movingPiece.getPositionY();
	}
}
