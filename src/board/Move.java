package board;

import java.util.ArrayList;

import pieces.Piece;

/**
 * This class deals with the movement of pieces on the chess board
 * 
 * @author Raymond Lochner
 *
 */
public class Move {

	/*
	 * private variables necessary for the class
	 */
	private Piece movingPiece;
	private int toX;
	private int toY;

	/**
	 * Constructs a <tt>Move</tt> with the specified coordinates
	 * 
	 * @param piece
	 *            piece to be moved
	 * @param board
	 *            board objects on which the piece is moved
	 * @param toX
	 *            x position of the move
	 * @param toY
	 *            y position of the move
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

	/**
	 * Constructor that adds the <tt>Move</tt> automatically to an
	 * <tt>ArrayList<Move></tt>
	 * 
	 * @param piece
	 *            piece to be moved
	 * @param board
	 *            board objects on which the piece is moved
	 * @param toX
	 *            x position of the move
	 * @param toY
	 *            y position of the move
	 * @param moves
	 *            ArrayList<Move> to which the move shall be added to
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

	/**
	 * @return Position of the x destination
	 */
	public int toX() {
		return this.toX;
	}

	/**
	 * @return Position of the y destination
	 */
	public int toY() {
		return this.toY;
	}

	/**
	 * @return Position of the x starting point
	 */
	public int fromX() {
		return this.movingPiece.getPoisitonX();
	}

	/**
	 * @return Position of the y starting point
	 */
	public int fromY() {
		return this.movingPiece.getPositionY();
	}
}
