package equipment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Equipment {
	private List<Helm> helms;
	private List<Body> bodies;
	private List<Legs> legs;
	private List<Shield> shields;
	private List<Weapon> weapons;

	public Equipment() {
		JSONObject all = null;
		try {
			all = (JSONObject) new JSONTokener(new FileInputStream("src/equipment/armour_info.json")).nextValue();
		} catch (JSONException | FileNotFoundException e) {
			e.printStackTrace();
		}
		helms = new ArrayList<>();
		all.getJSONArray("helm").forEach(helm -> {
			final JSONObject current = (JSONObject) helm;
			helms.add(new Helm(current.getString("name"), current.getInt("pdef"), current.getInt("mdef")));
		});
		bodies = new ArrayList<>();
		all.getJSONArray("body").forEach(body -> {
			final JSONObject current = (JSONObject) body;
			bodies.add(new Body(current.getString("name"), current.getInt("pdef"), current.getInt("mdef")));
		});
		legs = new ArrayList<>();
		all.getJSONArray("legs").forEach(leg -> {
			final JSONObject current = (JSONObject) leg;
			legs.add(new Legs(current.getString("name"), current.getInt("pdef"), current.getInt("mdef")));
		});
		shields = new ArrayList<>();
		all.getJSONArray("shields").forEach(shield -> {
			final JSONObject current = (JSONObject) shield;
			shields.add(new Shield(current.getString("name"), current.getInt("pdef"), current.getInt("mdef")));
		});
		weapons = new ArrayList<>();
		all.getJSONArray("weapons").forEach(weapon -> {
			final JSONObject current = (JSONObject) weapon;
			weapons.add(new Weapon(current.getString("name"), current.getInt("patt"), current.getInt("matt")));
		});
	}

	public Helm getStartingHelm() {
		return helms.get(0);
	}

	public Body getStartingBody() {
		return bodies.get(0);
	}

	public Legs getStartingLegs() {
		return legs.get(0);
	}

	public Shield getStartingShield() {
		return shields.get(0);
	}

	public Weapon getStartingWeapon() {
		return weapons.get(0);
	}

	public Helm[] getHelms() {
		return helms.toArray(new Helm[helms.size()]);
	}

	public Body[] getBodies() {
		return bodies.toArray(new Body[bodies.size()]);
	}

	public Legs[] getLegs() {
		return legs.toArray(new Legs[legs.size()]);
	}

	public Shield[] getShields() {
		return shields.toArray(new Shield[shields.size()]);
	}

	public Weapon[] getWeapons() {
		return weapons.toArray(new Weapon[weapons.size()]);
	}
}
