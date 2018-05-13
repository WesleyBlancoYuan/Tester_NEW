package com.WindThunderStudio.SwingTest.MigLayoutTest;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class PanelMigracion extends JFrame {
    public PanelMigracion() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("insets 5, fillx, debug","[]5[fill, grow]5[]", "[30!]10[30!]10[fill, grow]10[25!]"));
        
        JLabel buzonEnt = new JLabel("Buzon Entrada:");
        JLabel buzonSal = new JLabel("Buzon Salida:");

        add(buzonEnt, "cell 0 0, grow, w 100!");
        add(buzonSal, "cell 0 1, grow, w 100!");
        JTextField ent = new JTextField(20);
        JTextField sal = new JTextField(20);
        
        add(ent, "cell 1 0, grow");
        add(sal, "cell 1 1, grow");
        
        JLabel icon1 = new JLabel("1");
        JLabel icon2 = new JLabel("2");
        
        add(icon1, "cell 2 0, grow, w 100!");
        add(icon2, "cell 2 1, grow, w 100!");
        
        JTextArea area = new JTextArea();
        area.setColumns(20);
        
        JButton button = new JButton("Aceptar");
        JButton button1 = new JButton("Cancelar");
        
        add(button, "cell 2 3, w 100!, h 30!, split 2");
        add(button1, "w 100!, h 30!");
        
        add(area, "align center, grow, gapleft 10, gapright 10, gaptop 10, gapbottom 10, cell 0 2, span 3");
        pack();
        setBounds(0, 0, 600, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                PanelMigracion frame = new PanelMigracion();

            }

        });
    }
}

