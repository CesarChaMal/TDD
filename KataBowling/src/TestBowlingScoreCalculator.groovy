import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test


class TestBowlingScoreCalculator {
	
	def score
	
	@Before
	public void setUp() throws Exception {
		score = new BowlingScoreCalculator()
	}

	@Test
	public void testSimpleFrames () {
		assertEquals 90, score.getTotalScore("9-9-9-9-9-9-9-9-9-9-")
		assertEquals 72, score.getTotalScore("7-7-7-727-7-7-7-7-7-")
		assertEquals 63, score.getTotalScore("6-6-636-6-6-6-6-6-6-")
	}
	
	@Test
	public void testSpare () {
		assertEquals 60, score.getTotalScore("5/5-5-5-5-5-5-5-5-5-")
		assertEquals 149, score.getTotalScore("5/5/5/5/5/5/5/5/5/5/4")
	}
	
	@Test
	public void testStrike () {
		assertEquals 300, score.getTotalScore("XXXXXXXXXXXX")
	}
	
//	@Test
//	public void testAllStrikes() {
//		assertEquals 300, BowlingScoreCalculator.getTotalScore("xxxxxxxxxx")
//	}
}
