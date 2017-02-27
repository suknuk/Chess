package board;

import pieces.AbstractPiece;

public class Board {
	public AbstractPiece[][] board;
	
	public Board(){
		this.board = new AbstractPiece[8][8];
	}
}
