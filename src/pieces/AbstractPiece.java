package pieces;

public abstract class AbstractPiece {
	private PieceColor color;
	
	public AbstractPiece(PieceColor color){
		this.color = color;
	}
	
	public abstract int getValue();

	public PieceColor getColor() {
		return color;
	}
	
}
