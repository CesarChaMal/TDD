package kata.roboexplorer

import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*
import groovyx.net.http.RESTClient


class MovementSenderTestImp implements MovementSender {

	String player
	def restClient

	public MovementSenderTestImp(String player) {
		player = player
		restClient = new RESTClient('http://188.165.135.37:81/')
	}

	@Override
	public ServerResponse initGame() {
		def result = this.restClient.get(
			path: "test",
			query: [ reponse: "InitOk" ],
			contentType: "application/json"
		)
		
		new ServerResponse(status:result.data.status, score:0)		
	}

	@Override
	public ServerResponse move(Integer position) {
		def result = this.restClient.get(
			path: "test",
			query: [ reponse: "MoveOk" ],
			contentType: "application/json"
		)
		
		new ServerResponse(status:result.data.status, score:0)
	}
}
