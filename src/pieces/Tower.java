package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

public class Tower extends Piece {

	/*
	 * Constructor
	 */
	public Tower(int x, int y, PieceColor color) {
		super(x, y, color);
	}
	public Tower(int x, int y, PieceColor color, Board board){
		super(x, y, color,board);
	}

	/*
	 * (non-Javadoc)
	 * @see pieces.Piece#possibleMoves(board.Board)
	 */
	@Override
	public ArrayList<Move> possibleMoves(Board board) {
		ArrayList<Move> moves = new ArrayList<Move>();

		checkNorth(board, moves);
		checkSouth(board, moves);
		checkWest(board,moves);
		checkEast(board,moves);

		return moves;
	}

	/*
	 * Moves possible to the north
	 */
	private void checkNorth(Board board, ArrayList<Move> moves) {
		for (int y = 1; this.getPositionY() - y >= 0; y++) {
			Piece piece = board.getPieceAt(this.getPoisitonX(), this.getPositionY() - y);
			/*
			 * empty field, we can move there
			 */
			if (piece == null) {
				new Move(this, board, this.getPoisitonX(), this.getPositionY() - y, moves);
			}
			/*
			 * friendly piece, we can't move there and can't move anymore in
			 * that direction
			 */
			else if (piece.color() == this.color()) {
				break;
			}
			/*
			 * Enemy piece, we can move there
			 */
			else {
				new Move(this, board, this.getPoisitonX(), this.getPositionY() - y, moves);
				break;
			}
		}
	}

	/*
	 * Moves possible to the south
	 */
	private void checkSouth(Board board, ArrayList<Move> moves) {
		for (int y = 1; this.getPositionY() + y <= 7; y++) {
			Piece piece = board.getPieceAt(this.getPoisitonX(), this.getPositionY() + y);
			if (piece == null) {
				new Move(this, board, this.getPoisitonX(), this.getPositionY() + y, moves);
			}
			/*
			 * friendly piece, we can't move there and can't move anymore in
			 * that direction
			 */
			else if (piece.color() == this.color()) {
				break;
			}
			/*
			 * Enemy piece, we can move there
			 */
			else {
				new Move(this, board, this.getPoisitonX(), this.getPositionY() + y, moves);
				break;
			}
		}
	}
	
	/*
	 * Moves possible to the west
	 */
	private void checkWest(Board board, ArrayList<Move> moves) {
		for (int x = 1; this.getPoisitonX() - x >= 0; x++) {
			Piece piece = board.getPieceAt(this.getPoisitonX() - x, this.getPositionY());
			/*
			 * empty field, we can move there
			 */
			if (piece == null) {
				new Move(this, board, this.getPoisitonX() - x, this.getPositionY(), moves);
			}
			/*
			 * friendly piece, we can't move there and can't move anymore in
			 * that direction
			 */
			else if (piece.color() == this.color()) {
				break;
			}
			/*
			 * Enemy piece, we can move there
			 */
			else {
				new Move(this, board, this.getPoisitonX() - x, this.getPositionY(), moves);
				break;
			}
		}
	}

	/*
	 * Moves possible to the east
	 */
	private void checkEast(Board board, ArrayList<Move> moves) {
		for (int x = 1; this.getPoisitonX() + x <= 7; x++) {
			Piece piece = board.getPieceAt(this.getPoisitonX() + x, this.getPositionY());
			/*
			 * empty field, we can move there
			 */
			if (piece == null) {
				new Move(this, board, this.getPoisitonX() + x, this.getPositionY(), moves);
			}
			/*
			 * friendly piece, we can't move there and can't move anymore in
			 * that direction
			 */
			else if (piece.color() == this.color()) {
				break;
			}
			/*
			 * Enemy piece, we can move there
			 */
			else {
				new Move(this, board, this.getPoisitonX() + x, this.getPositionY(), moves);
				break;
			}
		}
	}
}
