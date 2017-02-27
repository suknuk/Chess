package board;

public class Move {
	private int toX;
	private int toY;
	
	public Move(int x, int y){
		this.toX = x;
		this.toY = y;
	}
	
	public int get_toX(){
		return this.toX;
	}
	
	public int get_toY(){
		return this.toY;
	}
}
