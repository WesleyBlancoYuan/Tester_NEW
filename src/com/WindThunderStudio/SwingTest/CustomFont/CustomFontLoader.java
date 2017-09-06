package com.WindThunderStudio.SwingTest.CustomFont;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
/**
 * This snippet shows how to register a Font in the system, without interferring
 * other programs in the system, e.g., only register the font inside this program.
 * You can run this, then run <code>ParallelRunningFontDetector</code> to check.
 * 
 * @author 99GU6879
 *
 */
public class CustomFontLoader extends JFrame {
    
    final JLabel label;
    public CustomFontLoader() {
        label = new JLabel("Now what is it like???");
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            System.out.println("All fonts name before adding the new one: ");
            for (Font f: ge.getAllFonts()) {
                if (f.getName().contains("Consolas")) System.out.print("(" + f.getName() + ") ");
            }
            System.out.println();
            
            Font custom1 = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/YaHei Consolas Hybrid 1.12.ttf"));
            Font custom2 = custom1.deriveFont(48f).deriveFont(Font.BOLD);
//            ge.registerFont(custom2); 
            //without regestering we can still use it, but the scope is limited, because we cannot
            //use new Font("fontname", style, size) to get it in somewhere else.
            label.setFont(custom2);
            System.out.println("Available font family name after registering: ");
            for (String name: ge.getAvailableFontFamilyNames()) {
                if (name.contains("Consolas")) {
                    System.out.print("(" + name + ") ");
                }
            }
            System.out.println();
            System.out.println("All fonts name after registering: ");
            for (Font f: ge.getAllFonts()) {
                if (f.getName().contains("Consolas")) System.out.print("(" + f.getName() + ") ");
            }
        } catch (IOException|FontFormatException e) {
            e.printStackTrace();
        } catch (Exception e0) {
            e0.printStackTrace();
        }
        
        System.out.println();
        
        label.setBounds(100, 100, 100, 50);

        getContentPane().add(label);
        
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                CustomFontLoader frame = new CustomFontLoader();

            }

        });
    }
}

