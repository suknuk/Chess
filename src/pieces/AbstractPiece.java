package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

public abstract class AbstractPiece {
	private PieceColor color;
	private Boolean moved;
	
	public AbstractPiece(PieceColor color){
		this.color = color;
		this.moved = false;
	}
	
	/*
	 * Returning piece value
	 */
	public abstract int getValue();

	/*
	 * Calculating all possible moves
	 */
	public abstract ArrayList<Move> possibleMoves(int x, int y, Board board);
	
	public PieceColor getColor() {
		return color;
	}
	
	public Boolean hasPieceMoved() {
		return this.moved;
	}
	
	public void setPieceMoves() {
		this.moved = true;
	}
	
}
