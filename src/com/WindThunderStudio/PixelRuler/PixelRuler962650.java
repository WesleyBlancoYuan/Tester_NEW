package com.WindThunderStudio.PixelRuler;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PixelRuler962650 extends JFrame {
    
    private static final Dimension DEFAULT_DIMENSION = new Dimension(962, 650);
    public PixelRuler962650() {
        begin();
    }
    
    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pack();
        setBounds(0, 0, 962, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                PixelRuler962650 frame = new PixelRuler962650();

            }

        });
    }
}

