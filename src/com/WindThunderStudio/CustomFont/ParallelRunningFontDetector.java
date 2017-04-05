package com.WindThunderStudio.CustomFont;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class ParallelRunningFontDetector {

    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        System.out.println("All fonts name: (to detect if YaHei Consolas is present if the first program runs)");
        for (Font f: ge.getAllFonts()) {
            if (f.getName().contains("Consolas")) System.out.print("(" + f.getName() + ") ");
        }
        
        //no YaHei Consolas found. So the first program only register the new font in its scope,
        //without interferring other Java program, neither system fonts.
    }

}
