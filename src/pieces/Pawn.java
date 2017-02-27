package pieces;

import defaultConstants.DefaultConstants;

public class Pawn extends AbstractPiece{

	public Pawn(PieceColor color) {
		super(color);
	}

	@Override
	public int getValue() {
		return DefaultConstants.PAWN_VALUE;
	}


}
