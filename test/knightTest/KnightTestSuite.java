package knightTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	KnightSimpleMovement.class,
	KnightApplyMove.class
})

public class KnightTestSuite {
}
