package player;

import javax.swing.*;
import java.awt.*;

public class Level {
    private int level;
    private int xp;

    public Level() {
        update();
    }

    /**
     *
     * @return int - the current level
     */
    public int getLevel() {
        return level;
    }

    /**
     *
     * @param xp
     */
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
        return (int) Math.ceil(Math.pow(level + 1, 2.5));
    }

    public int getRemainingXp() {
        return getNextXp() - xp;
    }

    /**
     * To be called when a level progressbar needs its text updated
     *
     * @return String as "current xp / required xp for next level"
     */
    public String toString() {
        return xp + "/" + getNextXp() + " XP";
    }
}
