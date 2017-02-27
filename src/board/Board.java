package board;

import pieces.AbstractPiece;
import pieces.WallPiece;

public class Board {
	private AbstractPiece[][] board;
	
	public Board(){
		this.board = new AbstractPiece[8][8];
	}
	
	public AbstractPiece getPieceAt(int x, int y) {
		
		// safety check when looking outside of bounds
		if (x < 0 || x > 7 || y < 0 || y > 7) {
			return new WallPiece();
		}
		
		return this.board[x][y];
	}
}
