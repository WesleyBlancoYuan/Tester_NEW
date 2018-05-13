package com.WindThunderStudio.Util.Elements;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * For appending text with convinience, because if we want to change the line spacing of 
 * <code>txtEnvioRecepcion</code>, we must change JTextArea to JTextPane, and thus <code>append()</code>
 * is unavailable. 
 * <br />
 * And, <code>setText(getText() + text)</code> cannot work, and consume a lot of memory.
 * 
 * @author 99GU6879
 *
 */
public class MyJTextPane extends JTextPane {
    public void append(String s) {
        try {
           Document doc = this.getDocument();
           doc.insertString(doc.getLength(), s, null);
        } catch(BadLocationException e) {
           System.err.println(e);
        }
    }
}