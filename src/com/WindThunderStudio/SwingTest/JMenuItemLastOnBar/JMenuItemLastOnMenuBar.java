package com.WindThunderStudio.SwingTest.JMenuItemLastOnBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class JMenuItemLastOnMenuBar {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                createGUI();
            }
        });
    }
    
    private static void createGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setBounds(0, 0, 300, 300);
        
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu 1");
        JMenuItem item1 = new JMenuItem("Item 1");
        menu.add(item1);
        bar.add(menu);
        
        JMenuItem item2 = new JMenuItem("Item 2") {
            @Override
            public Dimension getMaximumSize() {
                Dimension d1 = super.getPreferredSize();
                Dimension d2 = super.getMaximumSize();
                d2.width = d1.width;
                return d2;
            }
        };
        item2.setBorder(BorderFactory.createLineBorder(Color.black));
        item2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("000000");
            }
        });
        bar.add(item2);
        
        
        frame.setJMenuBar(bar);
        
        frame.pack();
        frame.setVisible(true);
    }

}
