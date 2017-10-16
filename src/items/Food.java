package items;

import player.Statistics;

public class Food extends Item {
	private final int heal;
	public Food(final int cost, final int heal) {
		super(cost);
		this.heal = heal;
	}
	public void eat(final Statistics stats) {
		stats.alterHealth(heal);
	}

}
