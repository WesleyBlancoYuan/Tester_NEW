package com.WindThunderStudio.SwingTest.JTableWithStripe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 * Paint a JTable with different style compared to Nimbus default, make it easier
 * to distinguish the table data lines with the white background.
 * 
 * It works.
 * @author 99GU6879
 *
 */
public class JTableWithStripe extends JFrame {
    class CustomRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            // TODO Auto-generated method stub
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            return c;
        }
        
    }
    
    public JTableWithStripe() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBackground(Color.green);
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {

        }
        JTable table = new JTable();
        table.setFillsViewportHeight(true);
        table.setOpaque(false);
        table.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        table.setBackground(new ColorUIResource(Color.YELLOW));
     // We must set a Table renderer. Can just do nothing but is necessary.
        table.setDefaultRenderer(Object.class, new CustomRenderer());
        
        
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] {"Class", "Age", "Name"});
        model.addRow(new String[] {"A", "43", "Nostrom"});
        model.addRow(new String[] {"B", "24", "Alicia"});
        model.addRow(new String[] {"C", "28", "Sulaco"});
        model.addRow(new String[] {"", "", ""});
        model.addRow(new String[] {"", "", ""});
        model.addRow(new String[] {"", "", ""});
        model.addRow(new String[] {"", "", ""});
        model.addRow(new String[] {"", "", ""});
        table.setModel(model);
        
        
        
        JScrollPane pane = new JScrollPane(table);
        pane.getViewport().setPreferredSize(new Dimension(500, 300));
//        pane.getViewport().setBackground(Color.GREEN);
        pane.getViewport().setBackground(new ColorUIResource(Color.YELLOW));
        pane.setBackground(Color.CYAN);
        pane.getViewport().setOpaque(true);
        pane.setPreferredSize(new Dimension(500, 300));
        pane.setOpaque(true);
        add(pane, BorderLayout.CENTER);
        CustomRenderer r1 = new CustomRenderer();
        CustomRenderer r2 = new CustomRenderer();
        CustomRenderer r3 = new CustomRenderer();
        
//        TableColumn col = table.getColumn("Class");
//        r1.setHorizontalAlignment(SwingConstants.LEFT);
//        col.setCellRenderer(r1);
//        col = table.getColumn("Age");
//        r2.setHorizontalAlignment(SwingConstants.CENTER);
//        col.setCellRenderer(r2);
//        col = table.getColumn("Name");
//        r3.setHorizontalAlignment(SwingConstants.RIGHT);
//        col.setCellRenderer(r3);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        System.out.println(table.getBackground());
        System.out.println(pane.getViewport().getBackground());
        System.out.println(getBackground());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JTableWithStripe frame = new JTableWithStripe();

            }

        });
    }
}
