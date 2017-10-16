package root;

import java.awt.EventQueue;

import equipment.Equipment;
import gui.AdventumGUI;

public class Adventum {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new AdventumGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Equipment();
        });
    }
}
