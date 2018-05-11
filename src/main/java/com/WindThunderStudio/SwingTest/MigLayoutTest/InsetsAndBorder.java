package com.WindThunderStudio.SwingTest.MigLayoutTest;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.CellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class InsetsAndBorder extends JFrame {
    public InsetsAndBorder() {
        begin();
    }
    
    private void begin() {
        addComponentListener(new ComponentListener() {
            
            @Override
            public void componentShown(ComponentEvent e) {
                // TODO Auto-generated method stub
            }
            
            @Override
            public void componentResized(ComponentEvent e) {
//                setSize(getSize().width, getSize().height);
//                pack();
//                revalidate();
            }
            
            @Override
            public void componentMoved(ComponentEvent e) {
                // TODO Auto-generated method stub
            }
            
            @Override
            public void componentHidden(ComponentEvent e) {
                // TODO Auto-generated method stub
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
//        panel.setBounds(0, 0, 500, 300);
        panel.setLayout(new MigLayout("insets 2 2 2 2, fillx, debug", "3[]3[]3[]3", "5[]5[]5[]5"));
        
        JLabel label1 = new JLabel("1");
        JLabel label2 = new JLabel("2");
        
        JButton button = new JButton("No way!");
        
        panel.add(label1, "cell 1 2, grow");
        
        panel.add(label2, "cell 2 2, grow");
        
        panel.add(button, "cell 0 1, grow");
        
        JPanel p1 = new JPanel();
        p1.setLayout(new MigLayout("insets 2 2 2 2, fillx, debug", "[30%]5[20%]5[50%, center]", "[30%]5[70%]"));
        JButton button2 = new JButton("Text panel in the panel");
        JLabel label3 = new JLabel("Another label");
        p1.add(button2, "cell 0 0, grow");
        p1.add(label3, "cell 2 1, grow, w 300!");
        
        panel.add(p1, "cell 1 1, grow");
        
        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                InsetsAndBorder frame = new InsetsAndBorder();
                
            }
            
        });
    }
}