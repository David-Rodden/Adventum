package enemy;

import org.json.JSONObject;

public class Enemy {
	final int physAtt, physDef, magAtt, magDef;

	Enemy(final String name, final JSONObject enemy) {
		physAtt = enemy.getInt("patt");
		physDef = enemy.getInt("pdef");
		magAtt = enemy.getInt("matt");
		magDef = enemy.getInt("mdef");
	}
}
