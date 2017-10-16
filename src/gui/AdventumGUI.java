package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import equipment.Armour;
import equipment.Body;
import equipment.Equipment;
import equipment.Equipped;
import equipment.Helm;
import equipment.Legs;
import equipment.Shield;
import equipment.Weapon;
import player.Player;

public class AdventumGUI {

    private JFrame frame;
    private Player player;
    private JLabel offensiveBonus, physDefBonus, magDefBonus;
    private JPanel playerInfo;
    private JComboBox helmBox;
    private JComboBox bodyBox;
    private JComboBox legsBox;
    private JComboBox shieldBox;
    private JComboBox weaponBox;
    private JLabel physOffBonus;
    private JLabel magOffBonus;
    private JPanel monsterIcon;
    private JLabel monsterName;
    private JProgressBar enemyHp;
    private JProgressBar myHp;
    private JProgressBar levelProgress;
    private JLabel enemyPhysOff;
    private JLabel enemyMagOff;
    private JLabel enemyPhysDef;
    private JLabel enemyMagDef;
    private JLabel level;
    private JPanel overarching;

    /**
     * Create the application.
     */
    public AdventumGUI() {
        final JFrame frame = new JFrame("Adventum");
        frame.setContentPane(overarching);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void init(){

    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 837, 506);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Gear", TitledBorder.CENTER,
                TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(17, 19, 277, 404);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblHelm = new JLabel("Helm: ");
        lblHelm.setBounds(17, 60, 82, 23);
        panel.add(lblHelm);
        final Equipment equipment = new Equipment();
        JComboBox<Helm> helmBox = new JComboBox(equipment.getHelms());
        helmBox.setBounds(92, 58, 168, 26);
        panel.add(helmBox);

        JLabel lblBody = new JLabel("Body: ");
        lblBody.setBounds(17, 99, 82, 23);
        panel.add(lblBody);

        JComboBox<Body> bodyBox = new JComboBox(equipment.getBodies());
        bodyBox.setBounds(92, 102, 168, 23);
        panel.add(bodyBox);

        JLabel lblLegs = new JLabel("Legs: ");
        lblLegs.setBounds(17, 141, 82, 23);
        panel.add(lblLegs);

        JComboBox<Legs> legsBox = new JComboBox(equipment.getLegs());
        legsBox.setBounds(92, 141, 168, 26);
        panel.add(legsBox);

        JLabel lblShield = new JLabel("Shield: ");
        lblShield.setBounds(17, 188, 82, 23);
        panel.add(lblShield);

        JLabel lblWeapon = new JLabel("Weapon: ");
        lblWeapon.setBounds(17, 232, 82, 23);
        panel.add(lblWeapon);

        JComboBox<Shield> shieldBox = new JComboBox(equipment.getShields());
        shieldBox.setBounds(92, 183, 168, 26);
        panel.add(shieldBox);

        JComboBox<Weapon> weaponBox = new JComboBox(equipment.getWeapons());
        weaponBox.setBounds(92, 230, 168, 26);
        panel.add(weaponBox);

        JLabel lblOffensive = new JLabel("Offensive");
        lblOffensive.setHorizontalAlignment(SwingConstants.CENTER);
        lblOffensive.setBounds(17, 301, 82, 23);
        panel.add(lblOffensive);

        JLabel lblPhysDef = new JLabel("Phys Def");
        lblPhysDef.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhysDef.setBounds(106, 301, 82, 23);
        panel.add(lblPhysDef);

        offensiveBonus = new JLabel("0");
        offensiveBonus.setHorizontalAlignment(SwingConstants.CENTER);
        offensiveBonus.setBounds(7, 342, 82, 23);
        panel.add(offensiveBonus);

        physDefBonus = new JLabel("0");
        physDefBonus.setHorizontalAlignment(SwingConstants.CENTER);
        physDefBonus.setBounds(106, 343, 82, 23);
        panel.add(physDefBonus);

        JLabel lblMagDef = new JLabel("Mag Def");
        lblMagDef.setHorizontalAlignment(SwingConstants.CENTER);
        lblMagDef.setBounds(195, 301, 82, 23);
        panel.add(lblMagDef);

        magDefBonus = new JLabel("0");
        magDefBonus.setHorizontalAlignment(SwingConstants.CENTER);
        magDefBonus.setBounds(195, 342, 82, 23);
        panel.add(magDefBonus);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Battle", TitledBorder.CENTER, TitledBorder.TOP, null, null));
        panel_1.setBounds(314, 19, 350, 404);
        frame.getContentPane().add(panel_1);

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
    }

    private void configureBonuses() {
        final Equipped equipped = player.getEquipped();
        offensiveBonus.setText(String.valueOf(equipped.getWeapon().getPhysAtt()));
        final Armour helm = equipped.getHelm(), body = equipped.getBody(), legs = equipped.getLegs(),
                shield = equipped.getShield();
        physDefBonus.setText(
                String.valueOf(helm.getPhysDef() + body.getPhysDef() + legs.getPhysDef() + shield.getPhysDef()));
        magDefBonus
                .setText(String.valueOf(helm.getMagDef() + body.getMagDef() + legs.getMagDef() + shield.getMagDef()));
    }

    public void setData(AdventumGUI data) {
    }

    public void getData(AdventumGUI data) {
    }

    public boolean isModified(AdventumGUI data) {
        return false;
    }
}
