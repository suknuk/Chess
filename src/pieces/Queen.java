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
		
		QueenTowerMoves qtm = new QueenTowerMoves(this.getPoisitonX(), this.getPositionY(), this.color(), board);
		QueenBishopMoves qbm = new QueenBishopMoves(this.getPoisitonX(), this.getPositionY(), this.color(), board);
		
		moves.addAll(qtm.possibleMoves(board));
		moves.addAll(qbm.possibleMoves(board));
		
		return moves;
	}
	
	/*
	 * Private classes to reuse the possibleMoves method by te Tower and Bishop piece
	 */
	private class QueenTowerMoves extends Tower{
		public QueenTowerMoves(int x, int y, PieceColor color, Board board) {
			super(x, y, color, board);
		}
	}
	
	private class QueenBishopMoves extends Bishop{
		public QueenBishopMoves(int x, int y, PieceColor color, Board board) {
			super(x, y, color, board);
		}
		
	}
}



