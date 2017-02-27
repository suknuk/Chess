package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;
import defaultConstants.DefaultConstants;

public class Pawn extends AbstractPiece {

	public Pawn(PieceColor color) {
		super(color);
	}

	@Override
	public int getValue() {
		return DefaultConstants.PAWN_VALUE;
	}

	@Override
	public ArrayList<Move> possibleMoves(int x, int y, Board board) {

		ArrayList<Move> moves = new ArrayList<Move>();

		int direction = 0;
		if (this.getColor() == PieceColor.WHITE) {
			direction = 1;
		} else {
			direction = -1;
		}

		// check before piece
		if (board.getPieceAt(x, y + direction) == null) {
			moves.add(new Move(x, y + direction));
		}

		// if piece did not yet move, it can jump
		if (!this.hasPieceMoved()) {
			if (board.getPieceAt(x, y + 2 * direction) == null) {
				moves.add(new Move(x, y + 2 * direction));
			}
		}

		return moves;
	}

}
