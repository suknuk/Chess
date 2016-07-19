package pieces;

import java.util.ArrayList;

public interface Piece {
	/*
	 * Color of the piece
	 */
	enum color{
		White,Black
	}
	
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
	public ArrayList<Move> possibleMoves();
	
	/*
	 * True if the piece belongs to the white player
	 */
	public boolean isWhite();
	
	/*
	 * True if the piece belongs to the black player
	 */
	public boolean isBlack();
}
