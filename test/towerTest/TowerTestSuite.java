package towerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	TowerSimpleMovement.class,
	TowerApplyMove.class
})

public class TowerTestSuite {
}
