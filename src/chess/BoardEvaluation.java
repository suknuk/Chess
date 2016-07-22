package chess;

import board.Board;
import pieces.Piece;
import pieces.PieceColor;

/*
 * This class deals with the evaluation of a board situation
 */
public class BoardEvaluation {
	/*
	 * value of each piece
	 */
	public static int pawnValue = 1;
	public static int towerValue = 5;
	public static int knightValue = 3;
	public static int bishopValue = 3;
	public static int queenValue = 10;
	public static int kingValue = Integer.MAX_VALUE;

	/*
	 * very simple evaluation by only counting the value of the pieces and
	 * subtracting enemy values
	 */
	public static int scoreEvaluation(Board board, PieceColor playersColor) {
		int score = 0;
		
		for (int y = 0 ; y <= 7; y++){
			for (int x = 0 ; x <= 7; x++){
				Piece curPiece = board.getPieceAt(x, y);
				if (curPiece != null) {
					if (curPiece.color() == playersColor){
						score += curPiece.pieceValue();
					} else {
						score -= curPiece.pieceValue();
					}
				}
			}
		}
		
		return score;
	}
}
