package bishopTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	BishopSimpleMovement.class,
	BishopApplyMove.class
})

public class BishopTestSuite {
}
