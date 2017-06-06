package com.WindThunderStudio.JTableSwitch;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

/**
 * Demo to show how to remove/readd component and reset
 * the divider location in a JTable to be at the same position
 * as last time.
 * 
 * You can also remain the scrollpane and change the viewportview of it.
 * Without any refreshing.
 * @author 99GU6879
 *
 */
public class JTableSwitch extends JFrame {
    private static final long serialVersionUID = 1L;
    private boolean t1Shown = true;
    
    public JTableSwitch() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("insets 5, fill, debug", "[]", "[]5[]"));
        JTable t1 = new JTable();
        DefaultTableModel m1 = new DefaultTableModel();
        m1.setColumnIdentifiers(new String[]{"Column 1", "Column 2"});
        m1.addRow(new String[]{"Touhou 1", "Song"});
        m1.addRow(new String[]{"Touhou 2", "Sing"});
        t1.setModel(m1);
        t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JTable t2 = new JTable();
        DefaultTableModel m2 = new DefaultTableModel();
        m2.setColumnIdentifiers(new String[]{"Column 1", "Column 2"});
        m2.addRow(new String[]{"Now we act", "yes"});
        m2.addRow(new String[]{"Now we sing", "yes too"});
        t2.setModel(m2);
        t2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        JScrollPane scroll1 = new JScrollPane(t1);
//        scroll1.setBounds(0, 0, 300, 300);
        JScrollPane scroll2 = new JScrollPane(t2);
//        scroll2.setBounds(0, 0, 300, 300);
        
        
        JLabel label = new JLabel("<html>Meanwhile on the left...</html>");
        label.setFont(new Font("Consolas", Font.PLAIN, 20));
        label.setPreferredSize(new Dimension(200, 100));
        JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, label, scroll1);
        add(sp, "cell 0 0, w 500!, h 200!");
        
        JButton button = new JButton("Switch table");
        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (t1Shown) {
//                    sp.remove(scroll1);
//                    sp.setRightComponent(scroll2);
//                    sp.setDividerLocation(0);
//                    t1Shown = false;
//                } else {
//                    sp.remove(scroll2);
//                    sp.setRightComponent(scroll1);
//                    sp.setDividerLocation(sp.getLastDividerLocation());
//                    sp.resetToPreferredSizes();
//                    t1Shown = true;
//                }
                if (t1Shown) {
                    scroll1.setViewportView(t2);
                    sp.setDividerLocation(0);
                    t1Shown = false;
                } else {
                    scroll1.setViewportView(t1);
                    sp.setDividerLocation(sp.getLastDividerLocation());
                    sp.resetToPreferredSizes();
                    t1Shown = true;
                }
                
            }
        });
        add(button, "cell 0 1, w 250!, h 30!");

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JTableSwitch frame = new JTableSwitch();

            }

        });
    }
}

