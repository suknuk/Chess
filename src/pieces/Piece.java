package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

/*
 * Abstact class because 'new Piece' should be disallowed
 */
public abstract class Piece implements PieceInterface {

	/*
	 * private X and Y positions of the piece
	 */
	private int posX;
	private int posY;

	/*
	 * private enum color variable
	 */
	private PieceColor color;

	/*
	 * Constructor
	 */
	public Piece(int x, int y, PieceColor color) {
		this.posX = x;
		this.posY = y;
		this.color = color;
	}

	public Piece(int x, int y, PieceColor color, Board board) {
		this(x, y, color);
		board.addPiece(this);
	}

	/*
	 * Returning the piece value (non-Javadoc)
	 * 
	 * @see pieces.PieceInterface#pieceValuer()
	 */
	@Override
	public int pieceValue() {
		return 0;
	}

	/*
	 * Getters for the position of the piece
	 */
	@Override
	public int getPoisitonX() {
		return this.posX;
	}

	@Override
	public int getPositionY() {
		return this.posY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pieces.PieceInterface#possibleMoves()
	 */
	@Override
	public ArrayList<Move> possibleMoves(Board board) {
		return null;
	}

	/*
	 * Moving a piece to a field
	 */
	public void hitMove(int toX, int toY, Board board, ArrayList<Move> moves) {
		// Boundary check
		if (toX >= 0 && toX <= 7 && toY >= 0 && toY <= 7) {
			Piece piece = board.getPieceAt(toX, toY);
			if (piece == null || piece.color != this.color) {
				new Move(this, board, toX, toY, moves);
			}
		}
	}

	/*
	 * Enum type of the piece's color
	 */
	@Override
	public PieceColor color() {
		return this.color;
	}
}
