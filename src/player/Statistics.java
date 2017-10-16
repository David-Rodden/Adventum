package player;

public class Statistics {
	private int health;
	private Level level;
	Statistics() {
		health = 10;
	}
	public void alterHealth(final int heal) {
		final int health = this.health + heal, max = level.getMaxHealth();
		this.health = health > max? max: health;
	}
}
