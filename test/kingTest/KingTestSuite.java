package kingTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	KingSimpleMovement.class,
	KingCastling.class,
	KingApplyMove.class
})

public class KingTestSuite {
}
