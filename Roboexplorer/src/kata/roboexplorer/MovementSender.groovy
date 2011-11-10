package kata.roboexplorer;

public interface MovementSender {

	public abstract ServerResponse initGame();

	public abstract ServerResponse move(Integer position);

}