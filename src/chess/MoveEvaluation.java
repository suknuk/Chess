package chess;

import board.Board;
import board.Move;
import pieces.PieceColor;

/*
 * This class deals with the various algorithms to evaluate moves
 */
public class MoveEvaluation {

	/*
	 * minimax evaluation, as seen here: https://en.wikipedia.org/wiki/Minimax
	 */
	public static int minimax(int depth, boolean maximisingPlayer, Board board, PieceColor maxPlayerColor) {
		if (depth == 0) {
			// return BoardEvaluation.scoreEvaluation(board, curPlayer);
		}
		int bestValue;
		if (maximisingPlayer) {
			bestValue = Integer.MIN_VALUE;
		} else {
			bestValue = Integer.MAX_VALUE;
		}
		for (Move move : Chess.allPossibleMoves(board, maxPlayerColor)) {
			Board boardWithMove = new Board(board);
			boardWithMove.applyMove(move);
			int v = minimax(depth - 1, !maximisingPlayer, boardWithMove, PieceColor.opposite(maxPlayerColor));
			bestValue = Math.max(bestValue, v);
		}
		return bestValue;
	}
}