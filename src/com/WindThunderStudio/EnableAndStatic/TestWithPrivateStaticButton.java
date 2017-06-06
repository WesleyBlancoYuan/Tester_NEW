package com.WindThunderStudio.EnableAndStatic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;

public class TestWithPrivateStaticButton extends JFrame {
    private static JButton b1;
    public static JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private StaticMenubar bar;

    
    public StaticMenubar getBar() {
        return bar;
    }
    
    public TestWithPrivateStaticButton() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1 = new JButton("Button 1, private static");
        b2 = new JButton("Button 2, public static");
        b3 = new JButton("Button 3, private");
        b4 = new JButton("Disable all");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disableAll();
            }
        });
        b5 = new JButton("Enable all");
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableAll();
            }
        });
        
        bar = new StaticMenubar();
        
        setLayout(new MigLayout("insets 5, fill", "[]5[]5[]5[]5[]", "[]10[]"));
        
        add(bar, "cell 0 0, span 5, grow");
        
        add(b1, "cell 0 1, grow");
        add(b2, "cell 1 1, grow");
        add(b3, "cell 2 1, grow");
        add(b4, "cell 3 1, grow");
        add(b5, "cell 4 1, grow");
        pack();
        setVisible(true);
    }

    public void disableAll() {
//        this.setVisible(false);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
//        this.setVisible(true);
    }
    public void enableAll() {
//        this.setVisible(false);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
//        this.setVisible(true);
    }
    

}

