package com.WindThunderStudio.SwingTest.MigLayoutCard;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class MigLayoutAndCard extends JFrame {
    public MigLayoutAndCard() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        final JPanel content = new JPanel();
        content.setLayout(new MigLayout("insets 0 0 0 0, fill, debug", "[]push[]", "[::500]5push[25!]"));
        
        final JPanel parent = new JPanel(new CardLayout());
        content.add(parent, "cell 0 0, grow, span 2");
        
        
        final JPanel a = new JPanel();
        JLabel labelA = new JLabel("This is A");
        labelA.setBounds(0, 0, 50, 25);
        a.add(labelA);
        a.setVisible(true);
        
        final JPanel b = new JPanel();
        JLabel labelB = new JLabel("This is B");
        labelA.setBounds(0, 0, 50, 25);
        b.add(labelB);
        b.setVisible(false);
        
        final JPanel c = new JPanel();
        JLabel labelC = new JLabel("This is C");
        labelC.setBounds(0, 0, 50, 25);
        c.add(labelC);
        c.setVisible(false);
        
        final JPanel d = new JPanel();
        JLabel labelD = new JLabel("This is D");
        labelD.setBounds(0, 0, 50, 25);
        d.add(labelD);
        d.setVisible(false);
        
        final JPanel e = new JPanel();
        JLabel labelE = new JLabel("This is E");
        labelE.setBounds(0, 0, 50, 25);
        e.add(labelE);
        e.setVisible(false);
        
        final JPanel f = new JPanel();
        JLabel labelF = new JLabel("This is F");
        labelF.setBounds(0, 0, 50, 25);
        f.add(labelF);
        f.setVisible(false);
        
        final JPanel g = new JPanel();
        JLabel labelG = new JLabel("This is G");
        labelG.setBounds(0, 0, 50, 25);
        g.add(labelG);
        g.setVisible(false);
        
        
        
        JButton button1 = new JButton("Toggle A");
        button1.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)parent.getLayout();
                cl.show(parent, "panelA");
            }
        });
        JButton button2 = new JButton("Toggle B");
        button2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)parent.getLayout();
                cl.show(parent, "panelB");
            }
        });
        
        content.add(button1, "cell 0 1, w 100!, h 25!");
        content.add(button2, "cell 1 1, w 100!, h 25!");
        
        //add to the same cell will divide the cell into 2 cells. Not working.
        parent.add(a, "panelA");
        parent.add(b, "panelB");
        
//        content.setBounds(0, 0, 500, 500);
        
        
        getContentPane().add(content);
        setBounds(0, 0, 500, getBounds().height);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MigLayoutAndCard frame = new MigLayoutAndCard();

            }

        });
    }
}

