package player;

import equipment.Equipment;
import equipment.Equipped;

public class Player {
    private Equipped equipped;
    private Statistics statistics;

    public Player(final Equipment equipment) {
        equipped = new Equipped(equipment);
        statistics = new Statistics();
    }

    public Equipped getEquipped() {
        return equipped;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
