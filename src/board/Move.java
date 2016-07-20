package board;

import java.util.ArrayList;

import pieces.Piece;

public class Move {

	private Piece movingPiece;
	private int toX;
	private int toY;

	public Move(Piece piece, Board board, int toX, int toY, ArrayList<Move> moves) {
		if (toX >= 0 && toX <= 7 && toY >= 0 && toY <= 7) {
			this.movingPiece = piece;
			this.toX = toX;
			this.toY = toY;
			moves.add(this);
			System.out.println("new move from : " + piece.getClass() + ", from x: " + piece.getPoisitonX() + ", y: "
					+ piece.getPositionY() + ", to x: " + toX + ", y: " + toY );
		}

	}

	public int fromX() {
		return 0;
	}

	public int fromY() {
		return 0;
	}
}
