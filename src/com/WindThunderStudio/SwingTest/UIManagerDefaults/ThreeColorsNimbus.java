package com.WindThunderStudio.SwingTest.UIManagerDefaults;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class ThreeColorsNimbus {
    private static final Font ARIAL_BOLD_20 = new Font("Arial", Font.BOLD, 20);
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            /* (non-Javadoc)
             * @see java.lang.Runnable#run()
             */
            @Override
            public void run() {
                Color color1 = null;
                Color color2 = null;
                Color color3 = null;
                JLabel label1 = new JLabel("Sample 1");
                label1.setFont(ARIAL_BOLD_20);
                JLabel label2 = new JLabel("Sample 2");
                label2.setFont(ARIAL_BOLD_20);
                JLabel label3 = new JLabel("Sample 3");
                label3.setFont(ARIAL_BOLD_20);
                
                
                try {
                    UIManager.setLookAndFeel(new NimbusLookAndFeel());
                } catch (UnsupportedLookAndFeelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                color1 = UIManager.getDefaults().getColor("Table:\"Table.cellRenderer\".background");
                label1.setForeground(color1);
                System.out.println("Sample 1: Table: Table.cellrenderer.background: " + color1);
                
                color2 = UIManager.getDefaults().getColor("Table.background");
                label2.setForeground(color2);
                System.out.println("Sample 2: Table.background: " + color2);
                
                color3 = UIManager.getDefaults().getColor("Table.alternateRowColor");
                label3.setForeground(color3);
                System.out.println("Sample 3: Table.alternateRowColor: " + color3);
                
                System.out.println(color2.equals(color1));
                
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JPanel panel = new JPanel();
                panel.setOpaque(false);
                panel.setBackground(Color.WHITE);
                panel.setLayout(new BorderLayout());
                
                panel.add(label1, BorderLayout.WEST);
                panel.add(label2, BorderLayout.CENTER);
                panel.add(label3, BorderLayout.EAST);
                
                frame.add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
