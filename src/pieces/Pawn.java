package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

public class Pawn extends Piece {

	/*
	 * Constructor
	 */
	public Pawn(int x, int y, Color color) {
		super(x, y, color);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pieces.Piece#possibleMoves()
	 */
	@Override
	public ArrayList<Move> possibleMoves(Board board) {
		ArrayList<Move> moves = new ArrayList<Move>();

		/*
		 * left top is A8 - board[0][0], hence white pawns go towards 0 and
		 * black pawns toward 7
		 */
		int direction;
		if (this.color() == Color.WHITE) {
			direction = -1;
		} else {
			direction = 1;
		}

		int toX;
		int toY;
		Piece piece;

		/*
		 * moving 1 step towards enemy
		 */
		toX = this.getPoisitonX();
		toY = this.getPositionY() + direction;
		piece = board.getPieceAt(toX, toY);
		if (piece == null) {
			new Move(this, board, toX, toY, moves);
		}

		/*
		 * hitting left of the pawn
		 */
		toX = this.getPoisitonX() - 1;
		toY = this.getPositionY() + direction;
		piece = board.getPieceAt(toX, toY);
		if (piece != null && (this.color() != piece.color())) {
			new Move(this, board, toX, toY, moves);
		}

		/*
		 * hitting right of the pawn
		 */
		toX = this.getPoisitonX() + 1;
		toY = this.getPositionY() + direction;
		piece = board.getPieceAt(toX, toY);
		if (piece != null && (this.color() != piece.color())) {
			new Move(this, board, toX, toY, moves);
		}

		return moves;
	}
}
