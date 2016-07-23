package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;
import chess.BoardEvaluation;

/*
 * King piece class
 */
public class King extends Piece {

	final int pieceValue = BoardEvaluation.kingValue;

	/*
	 * variable used for the castling move
	 */
	private boolean moved = true;

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
	 * @see pieces.Piece#pieceValue()
	 */
	@Override
	public int pieceValue() {
		return this.pieceValue;
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
		 * The king can move in every direction one field and hit enemies
		 */
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				if ((this.getPoisitonX() + x >= 0 && this.getPoisitonX() + x <= 7)
						&& (this.getPositionY() + y >= 0 && this.getPositionY() + y <= 7) && !(x == 0 && y == 0)) {
					if ((board.getPieceAt(this.getPoisitonX() + x, this.getPositionY() + y) == null) || board
							.getPieceAt(this.getPoisitonX() + x, this.getPositionY() + y).color() != this.color()) {
						new Move(this, board, this.getPoisitonX() + x, this.getPositionY() + y, moves);
					}
				}
			}
		}

		/*
		 * special case: white castling move
		 */
		if (!this.getMoved() && this.getPositionY() == 7 && this.getPoisitonX() == 4
				&& this.color() == PieceColor.WHITE) {
			/*
			 * checking white king right move. Spots between have to be empty
			 */
			if (board.getPieceAt(5, 7) == null && board.getPieceAt(6, 7) == null && board.getPieceAt(7, 7) != null) {
				if (board.getPieceAt(7, 7).getClass().equals(Tower.class)) {
					Tower t = (Tower) board.getPieceAt(7, 7);
					if (!t.getMoved()) {
						new Move(this, board, 6, 7, moves);
					}
				}
			}
			/*
			 * checking white king left move
			 */
			else if (board.getPieceAt(3, 7) == null && board.getPieceAt(2, 7) == null && board.getPieceAt(1, 7) == null
					&& board.getPieceAt(0, 7) != null) {
				if (board.getPieceAt(0, 7).getClass().equals(Tower.class)
						&& board.getPieceAt(0, 7).color() == PieceColor.WHITE) {
					Tower t = (Tower) board.getPieceAt(0, 7);
					if (!t.getMoved()) {
						new Move(this, board, 2, 7, moves);
					}
				}
			}
		}
		/*
		 * black castling move
		 */
		else if (!this.getMoved() && this.getPositionY() == 0 && this.getPoisitonX() == 4
				&& this.color() == PieceColor.BLACK) {
			/*
			 * checking black king right move
			 */
			if (board.getPieceAt(5, 0) == null && board.getPieceAt(6, 0) == null && board.getPieceAt(7, 0) != null) {
				if (board.getPieceAt(7, 0).getClass().equals(Tower.class)
						&& board.getPieceAt(7, 0).color() == PieceColor.BLACK) {
					Tower t = (Tower) board.getPieceAt(7, 0);
					if (!t.getMoved()) {
						new Move(this, board, 6, 0, moves);
					}
				}
			}
			/*
			 * left move
			 */
			else if (board.getPieceAt(3, 0) == null && board.getPieceAt(2, 0) == null && board.getPieceAt(1, 0) == null
					&& board.getPieceAt(0, 0) != null) {
				if (board.getPieceAt(0, 0).getClass().equals(Tower.class)
						&& board.getPieceAt(0, 0).color() == PieceColor.BLACK) {
					Tower t = (Tower) board.getPieceAt(0, 0);
					if (!t.getMoved()) {
						new Move(this, board, 2, 0, moves);
					}
				}
			}
		}
		return moves;
	}

	/*
	 * used for the castling move
	 */
	public boolean getMoved() {
		return this.moved;
	}

	public void setMoved(boolean moved) {
		this.moved = moved;
	}
}
