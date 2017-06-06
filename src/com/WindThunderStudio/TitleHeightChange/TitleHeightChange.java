package com.WindThunderStudio.TitleHeightChange;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class TitleHeightChange extends JFrame {
    private static final String lp = System.lineSeparator();
    public TitleHeightChange() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        try {
//            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//            UIManager.setLookAndFeel(new MetalLookAndFeel());
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            
        }
        
        
        final JFrame frame1 = new JFrame();
        frame1.setTitle("Frame1");
        frame1.setLayout(new BorderLayout());
        final JTextArea area1 = new JTextArea();
        area1.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));
        frame1.add(area1, BorderLayout.CENTER);
        frame1.addComponentListener(new ComponentListener() {
            
            @Override
            public void componentShown(ComponentEvent e) {
                // TODO Auto-generated method stub
                area1.setText("frame height: " + frame1.getBounds().height + lp
                        + "frame width: " + frame1.getBounds().width + lp
                        + "content pane height: " + frame1.getContentPane().getBounds().height + lp
                        + "content pane width: " + frame1.getContentPane().getBounds().width + lp
                        + "title bar height: " + (frame1.getBounds().height-frame1.getContentPane().getBounds().height) + lp
                        + "isResizable() value: false");
            }
            
            @Override
            public void componentResized(ComponentEvent e) {
                // TODO Auto-generated method stub
                
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
        frame1.setResizable(false);
        frame1.pack();
        
        frame1.setBounds(0, 0, 300, 300);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        
        final JFrame frame2 = new JFrame();
        frame2.setTitle("Frame2");
        frame2.setLayout(new BorderLayout());
        final JTextArea area2 = new JTextArea();
        area2.setBorder(BorderFactory.createLineBorder(Color.darkGray,1));
        frame2.add(area2, BorderLayout.CENTER);
        frame2.addComponentListener(new ComponentListener() {
            
            @Override
            public void componentShown(ComponentEvent e) {
                // TODO Auto-generated method stub
                area2.setText("frame height: " + frame2.getBounds().height + lp
                        + "frame width: " + frame2.getBounds().width + lp
                        + "content pane height: " + frame2.getContentPane().getBounds().height + lp
                        + "content pane width: " + frame2.getContentPane().getBounds().width + lp
                        + "title bar height: " + (frame2.getBounds().height-frame2.getContentPane().getBounds().height) + lp
                        + "isResizable() value: true");
            }
            
            @Override
            public void componentResized(ComponentEvent e) {
                // TODO Auto-generated method stub
                
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
        frame2.setResizable(true);
        frame2.pack();
        frame2.setBounds(0, 0, 300, 300);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(false);
        
        setLayout(new BorderLayout());
        JButton b = new JButton();
        b.setText("switch");
        b.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (frame1.isVisible()) {
                    frame1.setVisible(false);
                    frame2.setVisible(true);
                } else {
                    frame1.setVisible(true);
                    frame2.setVisible(false);
                }
            }
        });
        b.setPreferredSize(new Dimension(100, 30));
        add(b, BorderLayout.CENTER);
        
        pack();
        setBounds(600, 700, 100, 30);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                TitleHeightChange frame = new TitleHeightChange();

            }

        });
    }
}
