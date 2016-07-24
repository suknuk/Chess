package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;
import chess.BoardEvaluation;

/*
 * Queen class
 */
public class Queen extends Piece {

	final int pieceValue = BoardEvaluation.queenValue;

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
	 * (non-Javadoc)
	 * 
	 * @see pieces.Piece#pieceValue()
	 */
	@Override
	public int pieceValue() {
		return this.pieceValue;
	}

	/*
	 * As this piece is basically the tower and the bishop, we simple use the
	 * already written methods by these classes to find the moves (non-Javadoc)
	 * 
	 * @see pieces.Piece#possibleMoves(board.Board)
	 */
	@Override
	public ArrayList<Move> possibleMoves(Board board) {
		ArrayList<Move> moves = new ArrayList<Move>();

		/*
		 * need to make a copy of the board instance, otherwise the queen is
		 * replace by the QueenBishopMoves class for some reason
		 */
		Board cloneBoard = new Board(board);

		QueenTowerMoves qtm = new QueenTowerMoves(this.getPoisitonX(), this.getPositionY(), this.color(), cloneBoard);
		QueenBishopMoves qbm = new QueenBishopMoves(this.getPoisitonX(), this.getPositionY(), this.color(), cloneBoard);

		moves.addAll(qtm.possibleMoves(cloneBoard));
		moves.addAll(qbm.possibleMoves(cloneBoard));

		return moves;
	}

	/*
	 * Private classes to reuse the possibleMoves method by the Tower and Bishop
	 * piece
	 */
	private class QueenTowerMoves extends Tower {
		public QueenTowerMoves(int x, int y, PieceColor color, Board board) {
			super(x, y, color, board);
		}
	}

	private class QueenBishopMoves extends Bishop {
		public QueenBishopMoves(int x, int y, PieceColor color, Board board) {
			super(x, y, color, board);
		}
	}
}
