package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;

    private JTextField husyField;
    private JTextField kraliciField;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;

    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);
        husyField.setHorizontalAlignment(JTextField.TRAILING);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Kralici");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);

        add(createButtonBar(), "span");

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Pocet hlav");
        pocetHlavLabel.setDisplayedMnemonic('P');
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField);
        pocetHlavField.setEditable(false);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Pocet nohou");
        pocetNohouLabel.setDisplayedMnemonic('N');
        pocetNohouLabel.setLabelFor(pocetNohouField);
        add(pocetNohouLabel);
        add(pocetNohouField);
        pocetNohouField.setEditable(false);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);


        pack();

        getRootPane().setDefaultButton(vypocitatButton);

        vypocitatButton.addActionListener(this::handleVypocitat);

    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypocitat");
        vypocitatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }

    private void handleVypocitat(ActionEvent actionEvent) {
        System.out.println("Provedu vypocet");
        System.out.printf("Husy: %s ", husyField.getText()).println();
        System.out.printf("Kralici: %s ", kraliciField.getText()).println();

        int cislo1 = Integer.parseInt(husyField.getText());
        int cislo2 = Integer.parseInt(kraliciField.getText());
        int vysledek = cislo1 + cislo2;
        int vysledek2 = (cislo1 * 2) + (cislo2 * 4);

        String text1 = Integer.toString(vysledek);
        pocetHlavField.setText(text1);

        String text2 = Integer.toString(vysledek2);
        pocetNohouField.setText(text2);

        System.out.printf("Pocet hlav: %s ", pocetHlavField.getText()).println();
        System.out.printf("Pocet nohou: %s ", pocetNohouField.getText()).println();

    }
}


