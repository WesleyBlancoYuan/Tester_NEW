package com.WindThunderStudio.SwingTest.NimbusDefaultValues;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.EventObject;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class PrintDefaultValues extends JFrame {
    private JTable table;
    
    public PrintDefaultValues() {
        begin();
    }

    private class FieldEditor implements TableCellEditor {
        private JTextField field;
        public FieldEditor() {
            // TODO Auto-generated constructor stub
        }
        
        public FieldEditor(JTextField field){
            this.field = field;
        }


        @Override
        public Object getCellEditorValue() {
            return field == null ? new JTextField("") : field;
        }

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean stopCellEditing() {
            // TODO Auto-generated method stub
            return true;
        }

        @Override
        public void cancelCellEditing() {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void addCellEditorListener(CellEditorListener l) {
            
        }

        @Override
        public void removeCellEditorListener(CellEditorListener l) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {
            // TODO Auto-generated method stub
            if (row == 0) {
                
                return field == null ? new JTextField(value.toString()) : field;
            } else {
                return new JLabel(value.toString());
            }
        }
        
    }
    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] {"Keys", "R", "G", "B", "Color"});
        JTextField fR = new JTextField();
        fR.setText("");
        JTextField fG = new JTextField();
        fG.setText("");
        JTextField fB = new JTextField();
        fG.setText("");
        model.addRow(new Object[]{fR, fG, fB});
        table.setModel(model);
        
        FieldEditor rR = new FieldEditor(fR);
        FieldEditor rG = new FieldEditor(fG);
        FieldEditor rB = new FieldEditor(fB);
        
        TableColumn col = table.getColumnModel().getColumn(0);
        col.setCellEditor(rR);
        col = table.getColumnModel().getColumn(1);
        col.setCellEditor(rG);
        col = table.getColumnModel().getColumn(2);
        col.setCellEditor(rB);
        
        
        
        table.setAutoCreateRowSorter(true);
        table.setBounds(0, 0, 500, 500);
        prepareData();
        table.setDefaultRenderer(Object.class, new ColorRenderer());
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 500, 500);
        
        add(pane, BorderLayout.CENTER);
        
        pack();
        setVisible(true);
    }
    
    private class ColorRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            if (row > 0) {
                if (value instanceof Color) {
                    Component label = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    label.setBackground((Color)value);
                    JLabel label2 = (JLabel)label;
                    label2.setText("");
                    return label2;
                } else {
                    setBackground(Color.WHITE);
                    setText(value.toString());
                    return this;
                }
            } else {
                return null;
            }
        }
        
    }

    private void prepareData() {
        Map<Object, Object> colorKeys = new TreeMap<Object, Object>();
        
        UIManager.installLookAndFeel("Nimbus", "javax.swing.plaf.nimbus.NimbusLookAndFeel");
        
        LookAndFeel lf = UIManager.getLookAndFeel();
        Set<Entry<Object, Object>> entries = lf.getDefaults().entrySet();
        for (Entry entry : entries) {
            if (entry.getValue() instanceof Color) {
                colorKeys.put(entry.getKey(), entry.getValue());
            }
        }
        
        
        Object[] row = new Object[5];
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        Iterator<Object> i1 = colorKeys.keySet().iterator();
        while (i1.hasNext()) {
            Object o = i1.next();
//            System.out.println(UtilMethods.substituteWithContent(50, o.toString(), " ", CTS.ALIGN_LEFT) + " " + colorKeys.get(o));
            row[0] = o.toString();
            row[1] = ((Color)colorKeys.get(o)).getRed();
            row[2] = ((Color)colorKeys.get(o)).getGreen();
            row[3] = ((Color)colorKeys.get(o)).getBlue();
            row[4] = colorKeys.get(o);
            
            model.addRow(row);
        }
        model.fireTableDataChanged();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                PrintDefaultValues frame = new PrintDefaultValues();

            }

        });
    }
}

