package kata.roboexplorer;

import org.junit.Before
import org.junit.Test


class MovementSenderTest extends GroovyTestCase{

	MovementSender movementSender
	
	@Before
	public void setUp() throws Exception {
		movementSender = new MovementSenderTestImp("jcasalruiz")
	}

	@Test
	public void testInitGame() {
		assertEquals "OK", movementSender.initGame().getStatus()
	}

	@Test
	public void testMove(){
		assertEquals "OK", movementSender.move(30).getStatus()
	}

}

/*
- Iniciar el juego:
/game?player=Terminator&command=Init 

Posibles respuestas: 
* {STATUS: 'OK'} 
* {STATUS: 'GameOver'} 
* {STATUS: 'NoGame'} 

- Elegir una casilla: 
/game?player=Terminator&command=Move&position=30 

Posibles respuestas: 
* {STATUS: 'OK', 'score': 10 } 
* {STATUS: 'GameOver'} 
* {STATUS: 'YouWin'} 

Test API: 
- /test?reponse="InitOK" 
- /test?reponse="MoveOK" 
- /test?response="GameOver"  
 * */
