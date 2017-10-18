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

    int getMaxHealth() {
        return 9 + level;
    }

    public void update() {
        level = (int) Math.floor(Math.pow(xp, .4));
    }

    public int getXp() {
        return xp;
    }

    public int getPrevXp() {
        return (int) Math.pow(level, 2.5);
    }

    public int getNextXp() {
        return (int) Math.pow(level + 1, 2.5);
    }

    public int getRemainingXp() {
        return getNextXp() - xp;
    }
}
