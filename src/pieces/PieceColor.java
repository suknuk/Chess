package pieces;

public enum PieceColor {
	WHITE, BLACK;

	/*
	 * method to change to opposite color. Used in MoveEvaluation class
	 */
	public static PieceColor opposite(PieceColor color) {
		if (color == PieceColor.WHITE) {
			return PieceColor.BLACK;
		} else {
			return PieceColor.WHITE;
		}
	}
}
