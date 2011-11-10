package kata.roboexplorer;

import static org.junit.Assert.*
import groovy.mock.interceptor.MockFor

import org.junit.Before
import org.junit.Test
import org.gmock.*

class RoboexplorerTest extends GMockTestCase {

	Roboexplorer roboexplorer
	MovementSender movementSender
	MovementStrategy movementStrategy
	ServerResponse initServerResponse
	ServerResponse gameOverServerResponse
	
	String YOU_WIN_MESSAGE = "YouWin"
	String GAME_OVER_MESSAGE = "GameOver"
	String INIT_OK_MESSAGE = "InitOk"
	String MOVE_OK_MESSAGE = "MoveOk"
	
	@Before
	public void setUp() throws Exception {
		roboexplorer = new Roboexplorer()
		movementSender = mock(MovementSender)
		movementStrategy = mock(MovementStrategy)
		initServerResponse = new ServerResponse(status:INIT_OK_MESSAGE, score:0)
		gameOverServerResponse = new ServerResponse(status:GAME_OVER_MESSAGE, score:0)
		movementSender.initGame().returns(initServerResponse).stub()
		roboexplorer.setMovementStrategy(movementStrategy)
		roboexplorer.setMovementSender(movementSender)
	}

	@Test
	public void testGameOver() {
		movementStrategy.getNextMove().returns(1).stub()
		movementSender.move(1).returns(gameOverServerResponse).stub()
		
		play {
			roboexplorer.start()
			assertEquals GAME_OVER_MESSAGE, roboexplorer.getStatus()
		}
	}
	
	@Test
	public void testScoreAdding() {
		ServerResponse scoreServerResponse = new ServerResponse(status:MOVE_OK_MESSAGE, score:10)
		
		movementStrategy.getNextMove().returns(1).once()
		movementStrategy.getNextMove().returns(2).once()
		movementStrategy.getNextMove().returns(3).once()
		
		movementSender.move(1).returns(scoreServerResponse).stub()
		movementSender.move(2).returns(scoreServerResponse).stub()
		movementSender.move(3).returns(gameOverServerResponse).stub()
		
		play {
			roboexplorer.start()
			assertEquals 20, roboexplorer.getScore()
		}
	}
	
	@Test
	public void testYouWin() {
		ServerResponse winnerServerResponse = new ServerResponse(status:YOU_WIN_MESSAGE, score:0)
		movementStrategy.getNextMove().returns(1).once()
		movementSender.move(1).returns(winnerServerResponse).stub()
		
		play {
			roboexplorer.start()
			assertEquals YOU_WIN_MESSAGE, roboexplorer.getStatus()
		}
	}

}
/*
Gana:
El primero en hacer X movimientos y sumar la maxima puntuacion
(Empezamos con numeros del 0 al 100 y 50 movimientos para ganar)

Pierde:
Quien intente inicializar mas de una vez
Quien haga el mismo movimiento 2 veces seguidas
Quien haga mas de un movimiento cada 200 milisegundos (0.2secs)
Quien elija un movimiento mortal (killer positions)*/