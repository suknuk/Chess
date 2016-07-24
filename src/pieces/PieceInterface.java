package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

/*
 * Piece interface with methods all pieces must have
 */
public interface PieceInterface {

	/**
	 * @return Vertical position of the piece on the field
	 */
	public int getPoisitonX();

	/**
	 * @return Horizontal position of the piece on the field
	 */
	public int getPositionY();

	/**
	 * @return all possible moves this piece is able to do
	 */
	public ArrayList<Move> possibleMoves(Board board);

	/**
	 * @return Enum type of the piece's color
	 */
	public PieceColor color();

	/**
	 * @return the piece value
	 */
	public int pieceValue();

	/**
	 * Setting a new x position
	 * 
	 * @param x
	 *            new x position
	 * @param y
	 *            new y position
	 */
	public void setPosition(int x, int y);

}
