package chess;

import java.util.ArrayList;

import board.Board;
import board.Move;
import pieces.PieceColor;

/*
 * This class deals with the various algorithms to evaluate moves
 */
public class MoveEvaluation {

	/*
	 * minimax evaluation method which returns the best move
	 */
	public Move minimax(Board board, int depth, PieceColor currentPlayer){
		ArrayList<Move> allMoves = new ArrayList<Move>();
		allMoves.addAll(Chess.allPossibleMoves(board, currentPlayer));
		
		/*
		 * error handling: no moves possible
		 */
		if (allMoves.size() == 0){
			return null;
		}
		
		int curBestScore = Integer.MIN_VALUE;
		Move bestMove = allMoves.get(0);
		
		/*
		 * Iterating every move possible to find the move with the best score
		 */
		for (Move mv : allMoves){
			Board tmpBoard = new Board(board);
			tmpBoard.applyMove(mv);
			int tmpScore = minimax(depth,true,tmpBoard,currentPlayer);
			if (tmpScore > curBestScore){
				bestMove = mv;
				curBestScore = tmpScore;
			}
		}
		return bestMove;
	}
	
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