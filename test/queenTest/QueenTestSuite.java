package queenTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	QueenSimpleMovement.class,
	QueenApplyMove.class
})

public class QueenTestSuite {
}
