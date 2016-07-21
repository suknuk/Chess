package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

public class Pawn extends Piece {

	/*
	 * Constructor
	 */
	public Pawn(int x, int y, PieceColor color) {
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
		if (this.color() == PieceColor.WHITE) {
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
		if (toX >= 0 && toX <= 7 && toY >= 0 && toY <= 7) {
			piece = board.getPieceAt(toX, toY);
			if (piece == null) {
				new Move(this, board, toX, toY, moves);
			}
		}

		/*
		 * moving 2 steps towards other player when pawn sits at starting
		 * position this is true when: white pawn - y = 6, black pawn - y = 1
		 */
		if ((this.color() == PieceColor.BLACK && this.getPositionY() == 1)
				|| (this.color() == PieceColor.WHITE && this.getPositionY() == 6)) {
			toX = this.getPoisitonX();
			toY = this.getPositionY() + 2 * direction;
			piece = board.getPieceAt(toX, toY);
			if (piece == null) {
				new Move(this, board, toX, toY, moves);
			}
		}

		/*
		 * hitting left of the pawn
		 */
		toX = this.getPoisitonX() - 1;
		toY = this.getPositionY() + direction;
		if (toX >= 0 && toX <= 7 && toY >= 0 && toY <= 7) {
			piece = board.getPieceAt(toX, toY);
			if (piece != null && (this.color() != piece.color())) {
				new Move(this, board, toX, toY, moves);
			}
		}

		/*
		 * hitting right of the pawn
		 */
		toX = this.getPoisitonX() + 1;
		toY = this.getPositionY() + direction;
		if (toX >= 0 && toX <= 7 && toY >= 0 && toY <= 7) {
			piece = board.getPieceAt(toX, toY);
			if (piece != null && (this.color() != piece.color())) {
				new Move(this, board, toX, toY, moves);
			}
		}

		return moves;
	}
}
