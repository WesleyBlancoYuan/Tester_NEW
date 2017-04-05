package com.WindThunderStudio.Renderer_Model_LookAndFeel;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Renderer_Model_LookAndFeel extends JFrame {
    public Renderer_Model_LookAndFeel() {
        begin();
    }

    private void begin() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        Object[][] data = new Object[4][4];
        Object[] title = new Object[] {"Name", "Gender", "Age", "Prof."};

        JTable table = new JTable(new DefaultTableModel(data, title));
        
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                data[i][j] = "Tom"; 
            }
        }
        
        /**
         * If we set the model first and then change renderer, the renderer works.
         * But, if we set renderer first and reset the model, the renderer is invalidated:
         * no column will be right-aligned.
         */
        
        //set model
        table.setModel(new DefaultTableModel(data, title));
        //SET RENDERER
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(SwingConstants.RIGHT);
        table.getColumnModel().getColumn(2).setCellRenderer(r);
        
        table.setPreferredScrollableViewportSize(new Dimension(500, 300));
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 600, 400);
        getContentPane().add(sp);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Renderer_Model_LookAndFeel frame = new Renderer_Model_LookAndFeel();

            }

        });
    }
}

