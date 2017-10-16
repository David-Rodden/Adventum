package equipment;

public abstract class Armour {
    private final String name;
    private final int physDef, magDef;

    Armour(final String name, final int physDef, final int magDef) {
        this.name = name;
        this.physDef = physDef;
        this.magDef = magDef;
    }

    public String getName() {
        return name;
    }

    public int getPhysDef() {
        return physDef;
    }

    public int getMagDef() {
        return magDef;
    }

    @Override
    public String toString() {
        return name;
    }
}
