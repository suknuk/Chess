package testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import pawnTest.PawnTestSuite;
import towerTest.TowerTestSuite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	PawnTestSuite.class,
	TowerTestSuite.class
})

public class JUnitTestSuite {
}
