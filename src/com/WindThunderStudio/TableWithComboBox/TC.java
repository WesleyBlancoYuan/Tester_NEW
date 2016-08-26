package com.WindThunderStudio.TableWithComboBox;

import java.awt.EventQueue;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class TC extends JFrame{
	public TC(){
		begin();
	}
	private void begin(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("nothing.");
		String[] options = {"One", "Two", "Three"};
		JComboBox<String> combo = new JComboBox<>(options);
		JTable table = new JTable(new Object[2][2], new String[]{"One", "Two"});
		TableColumn col0 = table.getColumnModel().getColumn(0);
		col0.setCellEditor(new DefaultCellEditor(combo));
		
		class MyRender extends DefaultTableCellRenderer {
			public MyRender() {
			}
			@Override
			public void setValue(Object value) {
				if (value instanceof JComboBox) {
					setText(((JComboBox) value).getSelectedItem().toString());
					((JComboBox) value).setSelectedIndex(0);
				}
			}
		}
		
		MyRender renderer = new MyRender();
		col0.setCellRenderer(renderer);
		
		JScrollPane sp = new JScrollPane(table);
		getContentPane().add(sp);
		
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
