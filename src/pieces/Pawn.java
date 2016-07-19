package pieces;

import java.util.ArrayList;

public class Pawn implements Piece{
	
	/*
	 * private X and Y positions of the piece
	 */
	private int posX;
	private int posY;
	
	/*
	 * private color variable
	 * true = White
	 * false = Black
	 */
	private boolean color;

	/*
	 * Constructor
	 */
	public Pawn(int x, int y, boolean color){
		this.posX = x;
		this.posY = y;
		this.color = color;
	}

	/*
	 * Getters for the position of the piece
	 */
	@Override
	public int getPoisitonX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPositionY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Move> possibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * True if the piece belongs to the white player
	 */
	@Override
	public boolean isWhite() {
		return this.color;
	}

	/*
	 * True if the piece belongs to the black player
	 */
	@Override
	public boolean isBlack() {
		return !(this.color);
	}

	
}
