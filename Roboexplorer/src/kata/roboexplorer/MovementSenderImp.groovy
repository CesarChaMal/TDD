package kata.roboexplorer

import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import groovyx.net.http.RESTClient


class MovementSenderImp implements MovementSender {

	String player
	def restClient

	public MovementSenderImp(String player) {
		player = player
		restClient = new RESTClient('http://188.165.135.37:81/')
	}

	@Override
	public ServerResponse initGame() {
		//- Iniciar el juego:
		// game?player=Terminator&command=Init
		def result = this.restClient.get(
			path: "game",
			query: [ player: player, command: "Init"],
			contentType: "application/json"
		)
		
		println "init: $result.data.status"
		
		new ServerResponse(status:result.data.status, score:0)		
	}

	@Override
	public ServerResponse move(Integer position) {
		//- Elegir una casilla:
		// game?player=Terminator&command=Move&position=30
		def result = this.restClient.get(
			path: "game",
			query: [ player: player, command: "Move", position: position ],
			contentType: "application/json"
		)
		
		println "move: $result.data.status"
		println "score: $result.data.score"
		
		new ServerResponse(status:result.data.status, score:result.data.score)
	}
}
