package com.WindThunderStudio.TableWithComboBox;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class TC extends JFrame{
    JComboBox<String> combo;
    JTable table;
	public TC(){
		begin();
	}
	public void begin(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("nothing.");
		String[] options = {"One", "Two", "Three"};
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(options);
		combo = new JComboBox<>(model);
		table = new JTable(new Object[2][2], new String[]{"Column One", "Column Two"});
		TableColumn col0 = table.getColumnModel().getColumn(0);
		col0.setCellEditor(new DefaultCellEditor(combo));
//		class MyRender extends DefaultTableCellRenderer {
//			public MyRender() {
//			}
//			
//		}
//		
//		MyRender renderer = new MyRender();
//		col0.setCellRenderer(renderer);
		
		JButton button = new JButton("Clear");
		button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                combo.setSelectedIndex(1);
                for (int i = 0; i < table.getModel().getRowCount(); i++) {
//                    for (int j = 0; j < table.getModel().getColumnCount(); j++) {
//                        Object object = table.getModel().getValueAt(i, j);
//		                if (object instanceof JComboBox) {
//		                    JComboBox<String> box = (JComboBox<String>) object;
//		                    table.setValueAt(box.getSelectedItem().toString(), i, j);
//		                    
//		                }
//                    }
                    table.setValueAt(combo.getModel().getElementAt(0), i, 0);
                }
            }
        });
		
		combo.addItemListener(new ItemListener() {
            
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    combo.setSelectedItem(combo.getModel().getSelectedItem());
                }
                if (e.getStateChange() == ItemEvent.DESELECTED) {
                }
                
            }
        });
		getContentPane().setLayout(null);
//		getContentPane().setLayout(new MigLayout());
		
		setPreferredSize(new Dimension(500,500));
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0,0,300,100);
		getContentPane().add(sp);
		button.setBounds(300,100,200,200);
		getContentPane().add(button);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				TC tc = new TC();
				
			}
			
		});
	}
}
