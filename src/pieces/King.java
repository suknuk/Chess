package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

/*
 * King piece class
 */
public class King extends Piece {

	/*
	 * public constructors
	 */
	public King(int x, int y, PieceColor color) {
		super(x, y, color);
	}

	public King(int x, int y, PieceColor color, Board board) {
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

		/*
		 * The king can move in every direction one field
		 */
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				if ((this.getPoisitonX() + x >= 0 && this.getPoisitonX() + x <= 7)
						&& (this.getPositionY() + y >= 0 && this.getPositionY() + y <= 7) && !(x == 0 && y == 0))
					try {
						new Move(this, board, this.getPoisitonX() + x, this.getPositionY() + y, moves);
					} catch (Exception ex){
						System.out.println(ex.toString());
					}
			}
		}

		return moves;
	}
}
