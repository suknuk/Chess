package pawnTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	PawnSimpleMovement.class,
	PawnStartingJump.class,
	PawnChangesToQueen.class
})

public class PawnTestSuite {
}
