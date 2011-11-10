package kata.roboexplorer

class RoboLauncher {

	static void main(String[] args) {
		String player = "jcasalruiz"
		Roboexplorer robot = new Roboexplorer()
		robot.setMovementSender(new MovementSenderImp(player))
		robot.setMovementStrategy(new MovementStrategy())
		robot.start()
	}
}
