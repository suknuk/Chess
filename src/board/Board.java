package board;

import pieces.Piece;
/*
 * This class holds all the board information
 */
public class Board {
	
	/*
	 * 2D-Array which holds the pieces
	 */
	private Piece[][] board;
	
	/*
	 * Board constructor
	 */
	public Board(){
		this.board = new Piece[8][8];
	}
	
	/*
	 * Returning status of the board
	 */
	public Piece[][] getBoard(){
		return this.board;
	}
	
	/*
	 * Returning piece at X/Y position
	 */
	public Piece getPieceAt(int x, int y){
		return board[x][y];
	}
	
	/*
	 * Adding a piece to the board
	 */
	public void addPiece(Piece piece){
		this.board[piece.getPoisitonX()][piece.getPositionY()] = piece;
	}
	
	public void applyMove(){
		
	}
}
