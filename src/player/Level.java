package player;

public class Level {
	private int level;
	private int xp;

	public Level() {
		level = 1;
	}

	public int getLevel() {
		return level;
	}

	public void addXp(final int xp) {
		this.xp += xp;
	}

	public int getMaxHealth() {
		return 9 + level;
	}

	public void update() {
		level = (int) Math.floor(Math.pow(xp, .5));
	}
}
