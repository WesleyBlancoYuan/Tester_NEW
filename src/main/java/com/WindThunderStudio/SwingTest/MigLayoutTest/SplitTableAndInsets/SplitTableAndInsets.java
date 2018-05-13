package com.WindThunderStudio.SwingTest.MigLayoutTest.SplitTableAndInsets;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;

import com.WindThunderStudio.Util.CTS;

import net.miginfocom.swing.MigLayout;

public class SplitTableAndInsets extends JFrame {
    public JPanel panelCentro;
    
    
    JPanel getPanelCentro() {
        return panelCentro;
    }

    void setPanelCentro(JPanel panelCentro) {
        this.panelCentro = panelCentro;
    }

    public SplitTableAndInsets() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("insets 10, fill, debug", "[]", "[]5[fill, grow]5[]"));
        
        //Title top
        JLabel title = new JLabel("This is a big title");
        title.setFont(CTS.ARIAL_PLAIN_30);
        
        add(title, "cell 0 0, grow");

        //panelCentro as Container
        panelCentro = new JPanel();
        panelCentro.setOpaque(false);
        panelCentro.setLayout(null);
        
        add(panelCentro, "cell 0 1, grow");
        
        //panelBot at bottom
        JPanel panelBot = new JPanel();
        panelBot.setOpaque(false);
        panelBot.setLayout(new MigLayout("insets 5, fill, debug", "[]push[]", "[]"));
        
        JButton goBack = new JButton("Be hold!");
        panelBot.add(goBack, "cell 0 0, w 100!");
        JButton goOn = new JButton("Continue");
        panelBot.add(goOn, "cell 1 0, w 100!");
        
        goBack.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)SplitTableAndInsets.this.getPanelCentro().getLayout();
                cl.show(SplitTableAndInsets.this.getPanelCentro(), "blank");
                
            }
        });
        
        goOn.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout)SplitTableAndInsets.this.getPanelCentro().getLayout();
                cl.show(SplitTableAndInsets.this.getPanelCentro(), "centro");
            }
        });
        add(panelBot, "cell 0 2, growx");
        
        //hide the frame
        setVisible(false);
    }

    public class CentroPanel extends JPanel {
        public CentroPanel() {
            setBounds(0, 0, 300, 300);
            setOpaque(false);
            setLayout(new MigLayout("insets 5, fill", "[fill, grow]", "[fill, grow]"));
            
            JSplitPane split = new JSplitPane();
            
            JPanel left = new JPanel();
            left.setLayout(new MigLayout("insets 3, fillx, debug", "[]", "[]5[]push[]"));
            left.setOpaque(false);
            
            JLabel l1 = new JLabel("Left panel label 1");
            l1.setFont(CTS.ARIAL_PLAIN_14);
            JTextField t = new JTextField();
            t.setFont(CTS.ARIAL_PLAIN_14);
            JButton b1 = new JButton("Click me!");
            
            left.add(l1, "cell 0 0, grow");
            left.add(t, "cell 0 1, w 150!");
            left.add(b1, "cell 0 2, gapleft push, w 100!");
            
            split.setLeftComponent(left);
            
            JTable t1 = new JTable();
            DefaultTableModel m1 = new DefaultTableModel();
            m1.setColumnIdentifiers(new String[]{"Column 1", "Column 2"});
            m1.addRow(new String[]{"Touhou 1", "Song"});
            m1.addRow(new String[]{"Touhou 2", "Sing"});
            t1.setModel(m1);
            t1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            JScrollPane sp = new JScrollPane(t1);
            sp.setBorder(new EtchedBorder());
            split.setRightComponent(sp);
            
            split.setDividerLocation(150);
            split.setContinuousLayout(true);
            
            add(split, "cell 0 0, grow");
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
                SplitTableAndInsets frame = new SplitTableAndInsets();
                
                
                
                frame.getPanelCentro().setLayout(new CardLayout());
                
                CentroPanel centro = new SplitTableAndInsets().new CentroPanel();
                frame.getPanelCentro().add(centro, "centro");
                
                JPanel blank = new JPanel();
                frame.getPanelCentro().add(blank, "blank");
                
                frame.setBounds(0, 0, 500, 500);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }

        });
    }
}
