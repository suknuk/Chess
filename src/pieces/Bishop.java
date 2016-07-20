package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

public class Bishop extends Piece {

	/*
	 * Constructor
	 */
	public Bishop(int x, int y, Color color) {
		super(x, y, color);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see pieces.Piece#possibleMoves(board.Board)
	 */
	@Override
	public ArrayList<Move> possibleMoves(Board board) {
		ArrayList<Move> moves = new ArrayList<Move>();

		checkNorthEast(board, moves);
		checkSouthEast(board, moves);
		checkNorthWest(board, moves);
		checkSouthWest(board, moves);

		return moves;
	}

	/*
	 * Moves possible to the north-west
	 */
	private void checkNorthWest(Board board, ArrayList<Move> moves) {
		for (int distance = 1; (this.getPositionY() - distance >= 0)
				&& (this.getPoisitonX() - distance >= 0); distance++) {
			Piece piece = board.getPieceAt(this.getPoisitonX() - distance, this.getPositionY() - distance);
			/*
			 * empty field, we can move there
			 */
			if (piece == null) {
				new Move(this, board, this.getPoisitonX() - distance, this.getPositionY() - distance, moves);
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
				new Move(this, board, this.getPoisitonX() - distance, this.getPositionY() - distance, moves);
				break;
			}
		}
	}

	/*
	 * Moves possible to the south-west
	 */
	private void checkSouthWest(Board board, ArrayList<Move> moves) {
		for (int distance = 1; (this.getPositionY() + distance <= 7)
				&& (this.getPoisitonX() - distance >= 0); distance++) {
			Piece piece = board.getPieceAt(this.getPoisitonX() - distance, this.getPositionY() + distance);
			/*
			 * empty field, we can move there
			 */
			if (piece == null) {
				new Move(this, board, this.getPoisitonX() - distance, this.getPositionY() + distance, moves);
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
				new Move(this, board, this.getPoisitonX() - distance, this.getPositionY() + distance, moves);
				break;
			}
		}
	}

	/*
	 * Moves possible to the north-east
	 */
	private void checkNorthEast(Board board, ArrayList<Move> moves) {
		for (int distance = 1; (this.getPositionY() - distance >= 0)
				&& (this.getPoisitonX() + distance <= 7); distance++) {
			Piece piece = board.getPieceAt(this.getPoisitonX() + distance, this.getPositionY() - distance);
			/*
			 * empty field, we can move there
			 */
			if (piece == null) {
				new Move(this, board, this.getPoisitonX() + distance, this.getPositionY() - distance, moves);
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
				new Move(this, board, this.getPoisitonX() + distance, this.getPositionY() - distance, moves);
				break;
			}
		}
	}

	/*
	 * Moves possible to the south-east
	 */
	private void checkSouthEast(Board board, ArrayList<Move> moves) {
		for (int distance = 1; (this.getPositionY() + distance <= 7)
				&& (this.getPoisitonX() + distance <= 7); distance++) {
			Piece piece = board.getPieceAt(this.getPoisitonX() + distance, this.getPositionY() + distance);
			/*
			 * empty field, we can move there
			 */
			if (piece == null) {
				new Move(this, board, this.getPoisitonX() + distance, this.getPositionY() + distance, moves);
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
				new Move(this, board, this.getPoisitonX() + distance, this.getPositionY() + distance, moves);
				break;
			}
		}
	}
}
