package locale.enemy;

import equipment.Equipment;
import equipment.Equipped;
import org.json.JSONObject;
import org.json.JSONTokener;
import player.Player;
import player.Statistics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * Combat between one player and one enemy.
 */
public class CombatInstance {
    private final Equipped equipped;
    private final Statistics statistics;
    private final Random random;
    private Enemy enemy;

    private boolean selfPriority;

    /**
     * @param name   as the name of the enemy
     * @param player to be used to get statistics & worn equipment
     */
    public CombatInstance(final String name, final Player player) {
        try {
            this.enemy = new Enemy(name, ((JSONObject) new JSONTokener(new FileInputStream("src/locale/enemy/enemies.json")).nextValue()).getJSONObject(name));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        equipped = player.getEquipped();
        statistics = player.getStatistics();
        selfPriority = new Random().nextBoolean();
        random = new Random();
    }

    /**
     * @return whether the players starts the fight first
     */
    public boolean isSelfPriority() {
        return selfPriority;
    }

    /**
     * Checks whether the enemy's health is 0.
     *
     * @return boolean signifying whether enemy is dead
     */
    public boolean haveWon() {
        return enemy.isDead();
    }

    /**
     * Deals physical damage to the enemy based on self stats
     */
    public void physAttackEnemy() {
        enemy.dealDamage(random.nextInt(equipped.getPhysOffBonus()));
    }

    /**
     * Deals magical damage to the enemy based on self stats
     */
    public void magAttackEnemy() {
        enemy.dealDamage(random.nextInt(equipped.getMagDefBonus()));
    }

    /**
     * Deals physical damage to self based on enemy stats
     */
    public void bePhysAttacked() {
        statistics.alterHealth(random.nextInt(enemy.getPhysAtt()));
    }

    /**
     * Deals magical damage to self based on enemy stats
     */
    public void beMagAttacked() {
        statistics.alterHealth(random.nextInt(enemy.getMagAtt()));
    }
}
