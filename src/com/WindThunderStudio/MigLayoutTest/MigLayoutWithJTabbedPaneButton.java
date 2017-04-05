package com.WindThunderStudio.MigLayoutTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class MigLayoutWithJTabbedPaneButton extends JFrame {
    public MigLayoutWithJTabbedPaneButton() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button1 = new JButton("In the grid");
        JButton button2 = new JButton("Out of the grid");
        ActionListener ls = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MigLayoutWithJTabbedPaneButton.this, "This can be clicked. ");
                
            }
        };
        button1.addActionListener(ls);
        button2.addActionListener(ls);
        JPanel panel = new JPanel();
        //      panel.setBounds(0, 0, 500, 300);
        panel.setLayout(null);
        panel.add(button2);
//        panel.setLayout(new MigLayout("insets 2 2 2 2, fillx, debug", "[]", "[]"));

        JTabbedPane tabsPane = new JTabbedPane();
        tabsPane.setBounds(20, 20, 300, 400);
        panel.add(tabsPane);
        
//        panel.add(tabsPane, "id tabsPane, h 300!, w 400!");
        
        JLayeredPane tab = new JLayeredPane();
//        tab.setLayout(null);
        tab.setLayout(new MigLayout("insets 2 2 2 2, fillx, debug", "[]5[]5[]", "[]5[]"));
        
        
        
        tab.add(button1, "cell 0 0, grow");
        
        tabsPane.addTab("This is a tab", tab);
        
//        panel.add(button2, "pos (tabsPane.x + tabsPane.w - 120) (tabsPane.y), w 120!, h 20!");
        button2.setBounds(200, 20, 80, 20);
        getContentPane().add(panel);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MigLayoutWithJTabbedPaneButton frame = new MigLayoutWithJTabbedPaneButton();

            }

        });
    }
}

