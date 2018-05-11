package com.WindThunderStudio.SwingTest.TimerAnime;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;


public class ButtonAnimation {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 300, 300);
        frame.setLayout(null);
        CustomButton cb = new ButtonAnimation().new CustomButton();
        cb.setBounds(100, 100, 100, 50);
        cb.setText("Test");
        frame.add(cb, BorderLayout.NORTH);
        
        JRadioButton radioButton = new JRadioButton("Hover me!");
        radioButton.setBounds(0, 0, 100, 25);
        radioButton.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                cb.getTimer().stop();
                cb.reset();
                cb.repaint();
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                cb.getTimer().start();
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        frame.add(radioButton, BorderLayout.SOUTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public class CustomButton extends JButton implements ActionListener {
        private Timer timer;
        public Timer getTimer() {
            return timer;
        }
        public CustomButton() {
            super();
            timer = new Timer(50, this);
            timer.setInitialDelay(100);
        }
        
        int offTop = -10;
        int offBot = -50;
        
        public void reset() {
            offTop = -10; //leave space for the very beginning white stripe: 10 px.
            offBot = -50;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            offTop+=5;
            offBot+=5;
            if (offBot > this.getBounds().width) {
                reset();
            }
            this.repaint();
            
        }
        @Override
        public void paintComponent(Graphics g) {
           // draw the rectangle here
           super.paintComponent(g);
           RenderingHints rh = new RenderingHints(
                   RenderingHints.KEY_TEXT_ANTIALIASING,
                   RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
           rh.add(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
           rh.add(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
           ((Graphics2D)g).setRenderingHints(rh);
           g.setColor(Color.LIGHT_GRAY);
           g.drawPolygon(new int[]{offTop, offTop+10, offBot+10, offBot},
                   new int[]{0, 0, 50, 50}, 4);
           g.setColor(Color.WHITE);
                   
           g.fillPolygon(new int[]{offTop, offTop+10, offBot+10, offBot},
                   new int[]{0, 0, 50, 50}, 4);
        }
    }
}
