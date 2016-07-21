package testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import pawnTest.PawnTestSuite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	PawnTestSuite.class
})

public class JUnitTestSuite {
}
