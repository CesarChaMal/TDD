
class BowlingScoreCalculator {

	public getTotalScore (String frames) {
		
		def game = new BowlingGame()
		
		while(frames.size() > 0) {
			
			def firstRoll = frames[0]
            def secondRoll = '-'			                    	   
			
			if(frames.size() > 1)
				secondRoll = frames[1]
			
			game.addTurn(firstRoll, secondRoll)
			
			if(frames.size() < 2) {
				frames = frames.substring(1)
			} else {
				frames = frames.substring(2)
			}
		}
		
		game.getTotalScore()
	}
}
