package com.WindThunderStudio.MigLayoutTest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import net.miginfocom.swing.MigLayout;


public class MigLayoutWithJTabbedPane extends JFrame {
    
    private static final Font ARIAL_BOLD_20 = new Font("Arial", Font.BOLD, 20);
    public MigLayoutWithJTabbedPane() {
        begin();
    }
    
    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        getContentPane().setLayout(new MigLayout("insets 0, fill","[]", "[]"));
        
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension d = getSize();
                ImageIcon image = new ImageIcon("img/back.png");
                g.drawImage(image.getImage(), 0, 0, d.width, d.height, null);
                
            }
        };
//        panel.setBounds(0, 0, 500, 500);
        panel.setLayout(new MigLayout("insets 0 0 0 0, fill, debug", "[]", "[]5[fill, grow]5[]"));
        
        JLabel label1 = new JLabel("Section title, Long long long");
        label1.setFont(ARIAL_BOLD_20);
        label1.setForeground(Color.YELLOW);
        panel.add(label1, "cell 0 0, grow");
        
        JButton button = new JButton("Yes");
        panel.add(button, "cell 0 2, gapleft push");
        
        JTabbedPane tabs = new JTabbedPane(SwingConstants.TOP);
        
        panel.add(tabs, "cell 0 1, grow");
        
//        System.out.println("x: " + tabs.getBounds().getX() + " y: " + tabs.getBounds().getY());
        JLayeredPane tab1 = new JLayeredPane();
        tab1.setLayout(new MigLayout("insets 5 5 5 5, fill", "[]", "[]5[fill, grow]"));
        
        JLabel l1 = new JLabel("Long text!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        l1.setForeground(Color.white);
        l1.setFont(ARIAL_BOLD_20);
        tab1.add(l1, "cell 0 0, grow");
        
        JTextArea area1 = new JTextArea("Some area text");
        tab1.add(area1, "cell 0 1, grow");
        
        tabs.addTab("tab1", tab1);
        JLayeredPane tab2 = new JLayeredPane();
        tab2.setLayout(new MigLayout("insets 5 5 5 5, fill", "[]", "[]5[fill, grow]"));
        
        JLabel l2 = new JLabel("Long text!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        l2.setForeground(Color.white);
        l2.setFont(ARIAL_BOLD_20);
        tab2.add(l2, "cell 0 0, grow");
        
        JTextArea area2 = new JTextArea("Some area text");
        tab2.add(area2, "cell 0 1, grow");
        
        tabs.addTab("tab2", null, tab2, null);
        
        getContentPane().add(panel, "grow");
        pack();
//        System.out.println("x: " + tabs.getBounds().getX() + " y: " + tabs.getBounds().getY());
//        System.out.println("x2: " + (tabs.getBounds().getX()+tabs.getWidth())+ " y2: " + (tabs.getBounds().getY()+tabs.getHeight()));
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                MigLayoutWithJTabbedPane frame = new MigLayoutWithJTabbedPane();
                
            }
            
        });
    }
    

}
