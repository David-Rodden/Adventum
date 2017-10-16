package equipment;

public class Weapon {
	private final String name;
	private final int physAtt, magAtt;

	Weapon(final String name, final int physAtt, final int magAtt) {
		this.name = name;
		this.physAtt = physAtt;
		this.magAtt = magAtt;
	}

	public int getPhysAtt() {
		return physAtt;
	}

	public int getMagAtt() {
		return magAtt;
	}

	@Override
	public String toString() {
		return name;
	}
}
