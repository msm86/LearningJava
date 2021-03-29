package genericsChallenges;

public abstract class Player {
	private String playerName;

	public Player(String name) {
		this.playerName = name;
	}
	
	public String getName() {
		return this.playerName;
	}
}