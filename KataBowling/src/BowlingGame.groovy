
class BowlingGame {

	private def turns = []
	private def totalScore
	private def MAX_SCORE = 10
	private def GAME_FRAMES = 10
	
	public BowlingGame() {
		totalScore = 0
	}
	
	public addTurn (firstRoll, secondRoll) {
		
		int turnScore = 0
		
		turnScore += getFirstScore(firstRoll)
		turnScore += getSecondScore(secondRoll)
			
		boolean isSpare = '/'.equals(secondRoll)
		boolean isStrike = 'X'.equals(firstRoll)
		
		if(isStrike || isSpare) {
			totalScore += MAX_SCORE
		} else {
			totalScore += turnScore
		}
		
		boolean isLastTurn = turns.size() == GAME_FRAMES 
		
		if(!isLastTurn)
			totalScore += getPreviousSpareScore(turnScore)
			
		totalScore += getPreviousStrikesScore(turnScore)
		
		println turns.size()+1 + ' Turno: ' + turnScore + ' Total: ' + totalScore
				
		turns.add(["first":firstRoll, "second":secondRoll])
	}
	
	private getFirstScore(firstRoll) {
		
		if(!('-X'.contains(firstRoll))) {
			return firstRoll as Integer
		}
		
		0
	}
	
	private getSecondScore(secondRoll) {
		
		if(!('-/'.contains(secondRoll))) {
			return secondRoll as Integer
		}
		
		0
	}
	
	private getPreviousSpareScore(turnScore) {
		
		if(turns.size() > 0) {
			def lastTurn = turns.get(turns.size()-1)
			def isLastTurnSpare = lastTurn["second"].equals('/')

			if(isLastTurnSpare) {
				return turnScore
			}
		}
		
		0
	}
	
	private getPreviousStrikesScore(turnScore) {
		
		if(turns.size() > 1) {
			
			def lastTurn = turns.get(turns.size()-1)
			def isLastTurnStrike = 'X'.equals(lastTurn["second"])

			if(isLastTurnStrike) {
				return turnScore
			}
		}
		
		0
	}
	
	public getTotalScore() {
		totalScore
	}
}
