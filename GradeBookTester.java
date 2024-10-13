import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

	private GradeBook myGradeBook1;
	private GradeBook myGradeBook2;
	
	@BeforeEach
	void setUp() throws Exception {
		myGradeBook1 = new GradeBook(5);
		myGradeBook2 = new GradeBook(5);
		
		myGradeBook1.addScore(76.5);
		myGradeBook1.addScore(92.5);
        
		myGradeBook2.addScore(70.8);
		myGradeBook2.addScore(88.2);
	}

	@AfterEach
	void tearDown() throws Exception {
		myGradeBook1 = null;
		myGradeBook2 = null;
	}

	@Test
	void testAddScore() {
		myGradeBook1.addScore(100.0);
		String expected1 = "76.5 92.5 100.0";
		assertTrue(myGradeBook1.toString().equals(expected1));
		assertEquals(3, myGradeBook1.getScoreSize());
		
		String expected2 = "70.8 88.2 78.5";
		myGradeBook2.addScore(78.5);
		assertTrue(myGradeBook2.toString().equals(expected2));
		assertEquals(3, myGradeBook2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(169, myGradeBook1.sum());
		assertEquals(159, myGradeBook2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(76.5, myGradeBook1.minimum());
		assertEquals(70.8, myGradeBook2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(92.5, myGradeBook1.finalScore());
		assertEquals(88.2, myGradeBook2.finalScore());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, myGradeBook1.getScoreSize());
		assertEquals(2, myGradeBook2.getScoreSize());
	}

	@Test
	void testToString() {
		assertEquals("76.5 92.5", myGradeBook1.toString());
		assertEquals("70.8 88.2", myGradeBook2.toString());
	}

}
