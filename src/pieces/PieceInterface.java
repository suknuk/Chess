package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

/*
 * Piece interface with methods all pieces must have
 */
public interface PieceInterface {

	/*
	 * Vertical position of the piece on the field
	 */
	public int getPoisitonX();

	/*
	 * Horizontal position of the piece on the field
	 */
	public int getPositionY();

	/*
	 * Returning all possible moves this piece is able to do
	 */
	public ArrayList<Move> possibleMoves(Board board);

	/*
	 * Enum type of the piece's color
	 */
	public PieceColor color();
}
