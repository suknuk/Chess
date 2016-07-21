package board;

import java.util.ArrayList;

import pieces.Piece;

public class Move {

	private Piece movingPiece;
	private int toX;
	private int toY;

	public Move(Piece piece, Board board, int toX, int toY){
		if (toX >= 0 && toX <= 7 && toY >= 0 && toY <= 7) {
			this.movingPiece = piece;
			this.toX = toX;
			this.toY = toY;
			System.out.println("new move from : " + piece.getClass() + ", from x: " + piece.getPoisitonX() + ", y: "
					+ piece.getPositionY() + ", to x: " + toX + ", y: " + toY );
		}
	}
	
	public Move(Piece piece, Board board, int toX, int toY, ArrayList<Move> moves) {
		this(piece,board,toX,toY);
		moves.add(this);
	}

	/*
	 * public getters
	 */
	public int toX(){
		return this.toX;
	}
	
	public int toY(){
		return this.toY;
	}
	
	public int fromX() {
		return this.movingPiece.getPoisitonX();
	}

	public int fromY() {
		return this.movingPiece.getPositionY();
	}
}
