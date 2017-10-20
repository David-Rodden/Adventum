package equipment;

public class Equipped {
    private Helm helm;
    private Body body;
    private Legs legs;
    private Shield shield;
    private Weapon weapon;

    public Equipped(final Equipment equipment) {
        helm = equipment.getStartingHelm();
        body = equipment.getStartingBody();
        legs = equipment.getStartingLegs();
        shield = equipment.getStartingShield();
        weapon = equipment.getStartingWeapon();
    }

    public Helm getHelm() {
        return helm;
    }

    public Body getBody() {
        return body;
    }

    public Legs getLegs() {
        return legs;
    }

    public Shield getShield() {
        return shield;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setHelm(final Helm helm) {
        this.helm = helm;
    }

    public void setBody(final Body body) {
        this.body = body;
    }

    public void setLegs(final Legs legs) {
        this.legs = legs;
    }

    public void setShield(final Shield shield) {
        this.shield = shield;
    }

    public void setWeapon(final Weapon weapon) {
        this.weapon = weapon;
    }

    public int getPhysOffBonus() {
        return weapon.getPhysAtt();
    }

    public int getMagOffBonus() {
        return weapon.getMagAtt();
    }

    public int getPhysDefBonus() {
        return helm.getPhysDef() + body.getPhysDef() + legs.getPhysDef() + shield.getPhysDef();
    }

    public int getMagDefBonus() {
        return helm.getMagDef() + body.getMagDef() + legs.getMagDef() + shield.getMagDef();
    }
}
