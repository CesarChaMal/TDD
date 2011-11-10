package kata.roboexplorer

class Roboexplorer {

	MovementSender movementSender
	MovementStrategy movementStrategy

	private	Integer score
	private ServerResponse serverResponse
		
	void start() {
		initGame()
		
		while(!isEndOfGame()) {
			addScore()
			move()
		}
	}

	private initGame() {
		score = 0
		serverResponse = movementSender.initGame()
	}
	
	private boolean isEndOfGame() {
		serverResponse == null || isGameOver() || isYouWin()
	}
	
	private boolean isGameOver() {
		serverResponse.getStatus().equals("GameOver")
	}
	
	private boolean isYouWin() {
		serverResponse.getStatus().equals("YouWin")
	}
	
	private move() {		
		serverResponse = movementSender.move(getNextMove()) 
	}
	
	private addScore() {
		if(serverResponse.getScore() != null)
			score += serverResponse.getScore()
	}
	
	private int getNextMove() {
		movementStrategy.getNextMove()
	}
	
	String getStatus() {
		serverResponse.getStatus()
	}
	
	int getScore() {
		score
	}
}
