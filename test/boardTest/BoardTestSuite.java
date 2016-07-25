package boardTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import kingTest.KingApplyMove;
import kingTest.KingCastling;
import kingTest.KingSimpleMovement;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	BoardCreation.class
})


public class BoardTestSuite {

}
