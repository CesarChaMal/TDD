package kata.roboexplorer;

import static org.junit.Assert.*

import org.junit.Assert;
import org.junit.Test

class MovementStrategyTest {
	
	@Test
	public void testDontRepeatPosition() {
		MovementStrategy strategy = new MovementStrategy()
		def previousMoves = []
		50.times {
			previousMoves.add(strategy.nextMove)
		}
		assertEquals 50, previousMoves.unique().size()
	}

}
