package kata.roboexplorer

import org.apache.commons.lang.math.RandomUtils;

class MovementStrategy {

	private def previousMoves
	private int MAX_POSITION = 100
	
	public MovementStrategy() {
		this.previousMoves = [];
	}


	int getNextMove() {
		sleep(200)
		def nextMove = 0
		while (previousMoves.contains(nextMove)) {
			nextMove = RandomUtils.nextInt(MAX_POSITION)
		}		
		previousMoves.add(nextMove)
		nextMove
	}
}
