package testSuite;

import java.util.ArrayList;

/*
 * Class for an expected move
 */
public class TestMove {
	private int toX;
	private int toY;

	// constructor
	public TestMove(int toX, int toY,ArrayList<TestMove> testMoves) {
		this.toX = toX;
		this.toY = toY;
		testMoves.add(this);
	}

	/*
	 * getters and setters
	 */
	public int toX() {
		return this.toX;
	}

	public int toY() {
		return this.toY;
	}
}
