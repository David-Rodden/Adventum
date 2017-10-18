package player;

public class Statistics {
    private int health;
    private Level level;

    Statistics() {
        level = new Level();
        health = level.getMaxHealth();
    }

    public void alterHealth(final int heal) {
        final int health = this.health + heal, max = level.getMaxHealth();
        this.health = health > max ? max : health;
    }

    public Level getLevel() {
        return level;
    }
}
