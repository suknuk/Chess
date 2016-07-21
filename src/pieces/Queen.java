package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

/*
 * Queen class
 */
public class Queen extends Piece {

	/*
	 * Public constructors
	 */
	public Queen(int x, int y, PieceColor color) {
		super(x, y, color);
	}

	public Queen(int x, int y, PieceColor color, Board board) {
		super(x, y, color, board);
	}

	/*
	 * As this piece is basically the tower and the bishop, we simple use
	 * the already written methods by these classes to find the moves
	 * (non-Javadoc)
	 * @see pieces.Piece#possibleMoves(board.Board)
	 */
	@Override
	public ArrayList<Move> possibleMoves(Board board) {
		ArrayList<Move> moves = new ArrayList<Move>();

		Tower tower = new Tower(this.getPoisitonX(),this.getPositionY(),this.color(),board);
		Bishop bishop = new Bishop(this.getPoisitonX(),this.getPositionY(),this.color(),board);
		
		tower.possibleMoves(board);
		bishop.possibleMoves(board);
		
		return moves;
	}
}
