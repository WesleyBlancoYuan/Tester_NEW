package com.WindThunderStudio.SwingTest.JTextpaneLineSpacing;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import net.miginfocom.swing.MigLayout;

public class Test1_ChangeStyleAndAppend extends JFrame {
    public class MyJTextPane extends JTextPane {
        /**
         * Append some text to this pane.
         * @param s
         */
        public void append(String s) {
            try {
               Document doc = this.getDocument();
               doc.insertString(doc.getLength(), s, null);
            } catch(BadLocationException e) {
                System.err.println(e);
            }
        }
        
        /**
         * Append some text and change line.
         * @param s
         */
        public void appendLine(String s) {
            try {
                Document doc = this.getDocument();
                doc.insertString(doc.getLength(), s + System.lineSeparator(), null);
            } catch(BadLocationException e) {
                System.err.println(e);
            }
        }
        
//        @Override
//        public String getText() {
//            String string = "";
//            try {
//                string = this.getDocument().getText(0, this.getDocument().getLength());
//            } catch (BadLocationException e) {
//                e.printStackTrace();
//            }
//            return string;
//        }
    }
    public Test1_ChangeStyleAndAppend() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new MigLayout("insets 5, fillx, flowy", "[]", "[]5[]5[]"));
        setLayout(new BorderLayout());
        MyJTextPane pane0 = new MyJTextPane();
        pane0.appendLine("MyJTextPane using append() and then calling setText()");
        pane0.appendLine("Second line. ");
        pane0.appendLine("Third line");
        pane0.setText(pane0.getText() + "At last" + System.lineSeparator());
        pane0.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        add(pane0, BorderLayout.NORTH);
        
        MyJTextPane pane = new MyJTextPane();
//        changeLineSpacing(pane, 1.5f, false);
        pane.appendLine("MyJTextPane calling appendLine()");
        pane.appendLine("Second line. ");
        pane.appendLine("Third line");
        pane.appendLine("At last");
        pane.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        add(pane, BorderLayout.CENTER);
        
        
        JTextPane pane2 = new JTextPane();
        pane2.setText("Normal JTextPane calling setText()");
        pane2.setText(pane2.getText() + System.lineSeparator() + "Second line. ");
        pane2.setText(pane2.getText() + System.lineSeparator() + "Third line");
        pane2.setText(pane2.getText() + System.lineSeparator() + "At last");
        pane2.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        add(pane2, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
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

