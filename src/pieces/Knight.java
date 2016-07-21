package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

/*
 * The knight piece class
 */
public class Knight extends Piece {

	/*
	 * public constructors
	 */
	public Knight(int x, int y, PieceColor color) {
		super(x, y, color);
	}

	public Knight(int x, int y, PieceColor color, Board board) {
		super(x, y, color, board);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pieces.Piece#possibleMoves(board.Board)
	 */
	@Override
	public ArrayList<Move> possibleMoves(Board board) {
		ArrayList<Move> moves = new ArrayList<Move>();

		// top-left
		this.hitMove(this.getPoisitonX() - 1, this.getPositionY() - 2, board, moves);

		// top-right
		this.hitMove(this.getPoisitonX() + 1, this.getPositionY() - 2, board, moves);

		// left-top
		this.hitMove(this.getPoisitonX() - 2, this.getPositionY() + 1, board, moves);

		// left-down
		this.hitMove(this.getPoisitonX() - 2, this.getPositionY() - 1, board, moves);

		// down-left
		this.hitMove(this.getPoisitonX() - 1, this.getPositionY() + 2, board, moves);

		// down-right
		this.hitMove(this.getPoisitonX() + 1, this.getPositionY() + 2, board, moves);

		// right-down
		this.hitMove(this.getPoisitonX() + 2, this.getPositionY() + 1, board, moves);

		// right-top
		this.hitMove(this.getPoisitonX() + 2, this.getPositionY() - 1, board, moves);

		return moves;
	}

}
