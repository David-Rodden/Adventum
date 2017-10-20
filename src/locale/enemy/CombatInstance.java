package locale.enemy;

import equipment.Equipment;
import equipment.Equipped;
import org.json.JSONObject;
import org.json.JSONTokener;
import player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class CombatInstance {
    private final Player player;
    private Enemy enemy;

    private boolean selfPriority;

    public CombatInstance(final String name, final Player player) {
        try {
            this.enemy = new Enemy(name, ((JSONObject) new JSONTokener(new FileInputStream("src/locale/enemy/enemies.json")).nextValue()).getJSONObject(name));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.player = player;
        selfPriority = new Random().nextBoolean();
    }

    public boolean haveWon() {
        return enemy.isDead();
    }

    public void physAttackEnemy() {
        enemy.dealDamage(new Random().nextInt(player.getEquipped().getPhysOffBonus()));
    }

    public void bePhysAttacked() {
        player.getStatistics().alterHealth(new Random().nextInt(enemy.getPhysAtt()));
    }
}
