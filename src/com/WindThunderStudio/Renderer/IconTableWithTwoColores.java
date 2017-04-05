package com.WindThunderStudio.Renderer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class IconTableWithTwoColores extends JFrame {
    private static final String imgPath = "img/carpeta.png";
    public IconTableWithTwoColores() {
        begin();
    }

    private void begin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel content = new JPanel();
        content.setLayout(null);
        
        JTable table = new JTable();
        table.setFillsViewportHeight(true);
        table.setPreferredScrollableViewportSize(new Dimension(300, 300));
        ImageIcon icon1 = new ImageIcon(imgPath);
        
        table.setModel(new DefaultTableModel(new Object[][] {{icon1, "no way!"}, {icon1, "now what"}}, new String[] {"Col 1", "Col 2"}));
        
        class MyRenderer extends JLabel implements TableCellRenderer {

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JLabel label = new JLabel();
                if (row % 2 == 0) {
                    label.setBackground(Color.pink);
                } else {
                    label.setBackground(Color.green);
                }
                
                if (value instanceof Icon) {
                    label.setIcon((Icon)value);
                    label.setOpaque(true); //if this line is commented, we cannot see the background color of cell.
                    return label;
                } else {
                    label.setText(value.toString());
                    label.setOpaque(true);
                    return label;
                }
            }
            
            
            
        }
        table.setDefaultRenderer(Object.class, new MyRenderer());
        
        JScrollPane scroll = new JScrollPane(table);
        scroll.setVisible(true);
        scroll.setBounds(0, 0, 300, 300);
        
        content.add(scroll);
        
        getContentPane().add(content);
        
        pack();
        setVisible(true);
        setBounds(0, 0, 300, scroll.getHeight());
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                IconTableWithTwoColores frame = new IconTableWithTwoColores();
            }
        });
    }
}

