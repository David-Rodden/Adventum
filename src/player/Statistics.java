package player;

public class Statistics {
    private int health;
    private final Level level;

    /**
     * Initialize statistics with player's health & level
     */
    Statistics() {
        level = new Level();
        health = level.getMaxHealth();
    }

    /**
     * Heals the player by a specified amount
     *
     * @param heal
     */
    public void alterHealth(final int heal) {
        final int health = this.health + heal, max = level.getMaxHealth();
        this.health = health > max ? max : health;
    }

    public Level getLevel() {
        return level;
    }
}
