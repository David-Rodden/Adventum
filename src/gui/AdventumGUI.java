package gui;

import equipment.*;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdventumGUI {

    private JFrame frame;
    private Player player;
    private JPanel playerInfo;
    private JComboBox<Helm> helmBox;
    private JComboBox<Body> bodyBox;
    private JComboBox<Legs> legsBox;
    private JComboBox<Shield> shieldBox;
    private JComboBox<Weapon> weaponBox;
    private JLabel physOffBonus, magOffBonus, physDefBonus, magDefBonus;
    private JLabel monsterIcon, monsterName;
    private JProgressBar enemyHp;
    private JProgressBar myHp;
    private JProgressBar levelProgress;
    private JLabel enemyPhysOff;
    private JLabel enemyMagOff;
    private JLabel enemyPhysDef;
    private JLabel enemyMagDef;
    private JLabel level;
    private JPanel overarching;
    private JPanel combatPanel;
    private JLabel location;
    private JLabel locationIcon;
    private JButton exploreButton;
    private JButton shopButton;

    /**
     * Create the application.
     */
    public AdventumGUI() {
        final JFrame frame = new JFrame("Adventum");
        frame.setContentPane(overarching);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        init();
    }

    /**
     * Configures the JFrame and its components & adds listeners
     */
    private void init() {
        final Equipment equipment = new Equipment();
        player = new Player(equipment);
        for (final Helm helm : equipment.getHelms()) helmBox.addItem(helm);
        for (final Body body : equipment.getBodies()) bodyBox.addItem(body);
        for (final Legs legs : equipment.getLegs()) legsBox.addItem(legs);
        for (final Shield shield : equipment.getShields()) shieldBox.addItem(shield);
        for (final Weapon weapon : equipment.getWeapons()) weaponBox.addItem(weapon);
        helmBox.addActionListener((l) -> {
            player.getEquipped().setHelm((Helm) helmBox.getSelectedItem());
            configureBonuses();
        });
        bodyBox.addActionListener((l) -> {
            player.getEquipped().setBody((Body) bodyBox.getSelectedItem());
            configureBonuses();
        });
        legsBox.addActionListener((l) -> {
            player.getEquipped().setLegs((Legs) legsBox.getSelectedItem());
            configureBonuses();
        });
        shieldBox.addActionListener((l) -> {
            player.getEquipped().setShield((Shield) shieldBox.getSelectedItem());
            configureBonuses();
        });
        weaponBox.addActionListener((l) -> {
            player.getEquipped().setWeapon((Weapon) weaponBox.getSelectedItem());
            configureBonuses();
        });
        monsterIcon.setIcon(new ImageIcon("src/gui/img/testing.jpg"));
        monsterIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                combatPanel.setVisible(false);
            }
        });
        location.setText("Denville");
        locationIcon.setIcon(new ImageIcon(new ImageIcon("src/locale/img/Denville.jpg").getImage().getScaledInstance(400, 400, Image.SCALE_AREA_AVERAGING)));
        combatPanel.setVisible(false);
    }

    private void configureBonuses() {
        final Equipped equipped = player.getEquipped();
        physOffBonus.setText(String.valueOf(equipped.getWeapon().getPhysAtt()));
        magOffBonus.setText(String.valueOf(equipped.getWeapon().getMagAtt()));
        final Armour helm = equipped.getHelm(), body = equipped.getBody(), legs = equipped.getLegs(),
                shield = equipped.getShield();
        physDefBonus.setText(
                String.valueOf(helm.getPhysDef() + body.getPhysDef() + legs.getPhysDef() + shield.getPhysDef()));
        magDefBonus
                .setText(String.valueOf(helm.getMagDef() + body.getMagDef() + legs.getMagDef() + shield.getMagDef()));
    }
}
