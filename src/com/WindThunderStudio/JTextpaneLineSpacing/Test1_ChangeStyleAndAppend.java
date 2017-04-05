package com.WindThunderStudio.JTextpaneLineSpacing;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import net.miginfocom.swing.MigLayout;

public class Test1_ChangeStyleAndAppend extends JFrame {
    public Test1_ChangeStyleAndAppend() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new MigLayout("insets 5, fillx", "[]", "[]"));
        
        JTextPane pane = new JTextPane();
        changeLineSpacing(pane, 1.5f, false);
        
        pane.setText("Now what?" + System.getProperty("line.separator") + "Second line. ");
        appendTextToPane(pane, System.getProperty("line.separator"));
        appendTextToPane(pane, "Third line");
        
        add(pane, "grow");
        
        pack();
        setVisible(true);
    }

    /**
     * Select all the text of a <code>JTextPane</code> first and then set the line spacing.
     * @param pane the <code>JTextPane</code> to apply the change
     * @param factor the factor of line spacing. For example, <code>1.0f</code>.
     * @param replace whether the new <code>AttributeSet</code> should replace the old set. If set to <code>false</code>, will merge with the old one.
     */
    
    /* it will be called in the content change listener, AND the first time the content is filled, 
     * in Gestor_Configuration.mostrarAtributosImpresoraWC() */
    public static void changeLineSpacing(JTextPane pane, float factor, boolean replace) {
        pane.selectAll();
        MutableAttributeSet set = new SimpleAttributeSet(pane.getParagraphAttributes());
        StyleConstants.setLineSpacing(set, factor);
        pane.setParagraphAttributes(set, replace);
        pane.setCaretPosition(0); //scroll to the top.
    }
    
    /**
     * Append some text to the JTextpane.
     * 
     * @param args
     */
    
    private void appendTextToPane(JTextPane pane, String text){
        pane.setText(pane.getText() + text);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Test1_ChangeStyleAndAppend frame = new Test1_ChangeStyleAndAppend();

            }

        });
    }
}

