package com.WindThunderStudio.RowGroupInTable;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.RowSorter.SortKey;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.SortOrder;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.WindThunderStudio.JHeaderToolTip.JHeaderToolTip;

import net.miginfocom.swing.MigLayout;

public class RowGroupInTable extends JFrame {
    public RowGroupInTable() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        
        DefaultTableModel model = new DefaultTableModel();
        Object[][] data = new Object[][] {{"Ding", "17", "Book1"},
            {"Ding", 23, "Book2"}, 
            {"Ding", 25, "Book3"},
            {"Polazzo", 41, "Book2"}, 
            {"Polazzo", 45, "Book4"},
            {"Polazzo", 12, "Book5"},
            {"Anna", 1, "Book1"}, 
            {"Anna", 33, "Book3"}};
        
        String[] titles = new String[] {"Name", "Last job duration", "Book #"};
        JTable table = new JTable(data, titles);
        table.setFillsViewportHeight(true);
        
        table.setAutoCreateRowSorter(false);
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
        ArrayList<SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
        sortKeys.add(new SortKey(0, SortOrder.ASCENDING));
        sortKeys.add(new SortKey(1, SortOrder.ASCENDING));
        sortKeys.add(new SortKey(2, SortOrder.ASCENDING));
        
        sorter.setSortKeys(sortKeys);
        sorter.setSortable(0, true);
        sorter.setSortable(1, true);
        sorter.setSortable(2, true);
        
        table.setRowSorter(sorter);
        
        table.setDefaultRenderer(Object.class, new MyRenderer(table.getDefaultRenderer(Object.class)));
        JTableHeader header = table.getTableHeader();
        header.addMouseListener(new MouseListener() {
            
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
        });
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 200, 200);
        
        add(sp, BorderLayout.CENTER);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                RowGroupInTable frame = new RowGroupInTable();

            }

        });
    }
    
    private class MyRenderer implements TableCellRenderer {
        
        TableCellRenderer def;
        public MyRenderer() {
            // TODO Auto-generated constructor stub
        }
        
        public MyRenderer(TableCellRenderer defaultRend) {
            this();
            this.def = defaultRend;
        }
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            int rowCount = table.getModel().getRowCount();
            
            Component orig = (def).getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (column == 0) {
                if (row == 0) {
                    return orig;
                } else if (row > 0 && row < rowCount) {
                    if (table.getValueAt(row-1, column).equals(value)) {
                        JLabel l = (JLabel)orig;
                        l.setText("");
                        return l;
                    } else {
                        return orig;
                    }
                }
            }
            
            return orig;
        }
        
    }
    
    
 }
