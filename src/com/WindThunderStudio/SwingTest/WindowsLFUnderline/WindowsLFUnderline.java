package com.WindThunderStudio.SwingTest.WindowsLFUnderline;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import net.miginfocom.swing.MigLayout;

public class WindowsLFUnderline extends JDialog {
    public WindowsLFUnderline() {
        begin();
    }

    private void begin() {
        
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
//            UIManager.setLookAndFeel(new WindowsClassicLookAndFeel());
//            UIManager.setLookAndFeel(new WindowsLookAndFeel());
            UIManager.put("Label.font", new Font("SimSun", Font.PLAIN, 14));
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        JTabbedPane tabs = new JTabbedPane();
        JLayeredPane layer = new JLayeredPane();
        
        layer.setLayout(new MigLayout("insets 5, fill", "[]", "[]"));
//        layer.setLayout(new BorderLayout());
        JLabel test = new JLabel("<html><u>TEST</u>");
        test.setForeground(Color.BLUE);
        test.setBounds(0, 0, 300, 150);
        layer.add(test, BorderLayout.CENTER);
        
        tabs.addTab("tab1", layer);
        
        add(tabs, BorderLayout.CENTER);
        pack();
        
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                WindowsLFUnderline frame = new WindowsLFUnderline();

            }

        });
    }
}
