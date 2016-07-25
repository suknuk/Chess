package testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import bishopTest.BishopTestSuite;
import boardTest.BoardTestSuite;
import kingTest.KingTestSuite;
import knightTest.KnightTestSuite;
import pawnTest.PawnTestSuite;
import queenTest.QueenTestSuite;
import towerTest.TowerTestSuite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	PawnTestSuite.class,
	TowerTestSuite.class,
	BishopTestSuite.class,
	QueenTestSuite.class,
	KnightTestSuite.class,
	KingTestSuite.class,
	BoardTestSuite.class
})

public class JUnitTestSuite {
}
