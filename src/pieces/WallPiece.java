package pieces;

import java.util.ArrayList;

import board.Board;
import board.Move;

/*
 * Piece to define a wall outside the board
 */

public class WallPiece extends AbstractPiece{

	public WallPiece() {
		super(PieceColor.WHITE);
	}
	
	public WallPiece(PieceColor color) {
		super(color);
	}

	@Override
	public int getValue() {
		return 0;
	}

	@Override
	public ArrayList<Move> possibleMoves(int x, int y, Board board) {
		return null;
	}

}
