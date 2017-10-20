package locale.enemy;

import org.json.JSONObject;

class Enemy {
    final String name;
    private final int physAtt, physDef, magAtt, magDef;
    private int hp;

    Enemy(final String name, final JSONObject enemy) {
        this.name = name;
        hp = enemy.getInt("hp");
        physAtt = enemy.getInt("patt");
        physDef = enemy.getInt("pdef");
        magAtt = enemy.getInt("matt");
        magDef = enemy.getInt("mdef");
    }

    void dealDamage(final int hp) {
        final int hpResult = this.hp - hp;
        this.hp = hpResult > 0 ? hpResult : 0;
    }

    boolean isDead() {
        return hp == 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getPhysAtt() {
        return physAtt;
    }

    public int getPhysDef() {
        return physDef;
    }

    public int getMagAtt() {
        return magAtt;
    }

    public int getMagDef() {
        return magDef;
    }
}
