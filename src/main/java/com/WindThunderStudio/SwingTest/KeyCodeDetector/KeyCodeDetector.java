package com.WindThunderStudio.SwingTest.KeyCodeDetector;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class KeyCodeDetector extends JFrame {
    public KeyCodeDetector() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 500, 500);
        setLayout(new BorderLayout());
        JTextArea area = new JTextArea();
        area.addKeyListener(new KeyListener() {
            
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
             // TODO Auto-generated method stub
                System.out.println(e.getExtendedKeyCode());
                System.out.println(KeyEvent.getKeyModifiersText(e.getKeyCode()));
                System.out.println(KeyEvent.getKeyText(e.getExtendedKeyCode()));
                System.out.println();
                
            }
        });
        add(area, BorderLayout.CENTER);
        
        pack();
        setBounds(0, 0, 500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                KeyCodeDetector frame = new KeyCodeDetector();

            }

        });
    }
}
