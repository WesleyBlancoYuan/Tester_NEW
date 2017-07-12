package com.WindThunderStudio.JTextpaneLineSpacing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import com.WindThunderStudio.JTextpaneLineSpacing.Test1_ChangeStyleAndAppend.MyJTextPane;

public class JTextPaneLineSpacing extends JFrame {
    public class MyJTextPane extends JTextPane {
        /**
         * Append some text to this pane.
         * @param s
         */
        public void append(String s) {
            try {
                Document doc = this.getDocument();
                doc.insertString(doc.getLength(), s, this.getParagraphAttributes());
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
                doc.insertString(doc.getLength(), s + System.lineSeparator(), this.getParagraphAttributes());
            } catch(BadLocationException e) {
                System.err.println(e);
            }
        }
        
        @Override
        public String getText() {
            String string = "";
            try {
                string = this.getDocument().getText(0, this.getDocument().getLength());
            } catch (BadLocationException e) {
                System.err.println(e);
            }
            return string;
        }
        
        public void clearText() {
            try {
                this.getDocument().remove(0, this.getDocument().getLength());
            } catch (BadLocationException e) {
                System.err.println(e);
            }
        }
    }
    public JTextPaneLineSpacing() {
        begin();
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

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new MigLayout("insets 5, fillx, flowy", "[]", "[]5[]5[]"));
        setLayout(new BorderLayout());
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        MyJTextPane pane0 = new MyJTextPane();
        changeLineSpacing(pane0, 0.5f, false);
        pane0.appendLine("MyJTextPane using append() and then calling setText()");
        pane0.appendLine("Second line. ");
        pane0.appendLine("Third line");
        pane0.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        add(pane0, BorderLayout.NORTH);
        
        JTextPane pane = new JTextPane();
        pane.setPreferredSize(new Dimension(400, 200));
        pane.setMargin(new Insets(10, 5, 10, 5));
        pane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        changeLineSpacing(pane, 0.5f, false);
        pane.setBorder(new EtchedBorder(EtchedBorder.RAISED));
        
        JScrollPane sp = new JScrollPane(pane);
        add(sp, BorderLayout.CENTER);
        
        
        JButton remove = new JButton("Remove");
        remove.setBounds(0, 0, 100, 30);
        remove.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pane.getDocument().remove(0, pane.getDocument().getLength());
                } catch (BadLocationException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        
        JButton insert = new JButton("Insert");
        insert.setBounds(0, 0, 100, 30);
        insert.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    pane.getDocument().insertString(0, new Date().toString() + System.lineSeparator(),
                            pane.getParagraphAttributes());
                } catch (BadLocationException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        
        JButton removeAndInsert = new JButton("Remove and Insert");
        removeAndInsert.setBounds(0, 0, 100, 30);
        removeAndInsert.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    pane.getDocument().remove(0, pane.getDocument().getLength());
                    pane.getDocument().insertString(0, new Date().toString() + System.lineSeparator(), pane.getParagraphAttributes());
                } catch (BadLocationException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        JPanel panelBot = new JPanel();
        panelBot.setOpaque(false);
        panelBot.setLayout(new BorderLayout());
        panelBot.add(insert, BorderLayout.WEST);
        panelBot.add(remove, BorderLayout.EAST);
        panelBot.add(removeAndInsert, BorderLayout.CENTER);
        
        add(panelBot, BorderLayout.SOUTH);
        
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        JTextPaneLineSpacing panel = new JTextPaneLineSpacing();
    }
}
