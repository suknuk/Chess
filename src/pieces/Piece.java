package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

/*
 * Abstact class because 'new Piece' should be disallowed
 */
public abstract class Piece implements PieceInterface{
	
	/*
	 * private X and Y positions of the piece
	 */
	private int posX;
	private int posY;
	
	/*
	 * private enum color variable
	 */
	private PieceColor color;

	/*
	 * Constructor
	 */
	public Piece(int x, int y, PieceColor color){
		this.posX = x;
		this.posY = y;
		this.color = color;
	}

	/*
	 * Getters for the position of the piece
	 */
	@Override
	public int getPoisitonX() {
		return this.posX;
	}

	@Override
	public int getPositionY() {
		return this.posY;
	}

	/*
	 * (non-Javadoc)
	 * @see pieces.PieceInterface#possibleMoves()
	 */
	@Override
	public ArrayList<Move> possibleMoves(Board board) {
		return null;
	}

	/*
	 * Enum type of the piece's color
	 */
	@Override
	public PieceColor color(){
		return this.color;
	}
}
