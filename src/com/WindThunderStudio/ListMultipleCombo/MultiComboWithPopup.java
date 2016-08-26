package com.WindThunderStudio.ListMultipleCombo;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class MultiComboWithPopup extends JFrame {
	private JPopupMenu menu;
	private JMenuItem[]	options;
	private JLabel lll;
	private JPanel panel;
	public MultiComboWithPopup() {
		begin();
	}
	
	private void begin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JPopupMenu menu = new JPopupMenu("Several") ;
		MouseListener itemListener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getSource() instanceof JMenuItem) {
					JMenuItem item = (JMenuItem) e.getSource();
					if (item.getParent().equals(menu)){
						setVisible(true);
					}
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getSource() instanceof JMenuItem) {
					JMenuItem item = (JMenuItem) e.getSource();
					if (item.getParent().equals(menu)){
						setVisible(true);
					}
				}
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
				JMenuItem item = (JMenuItem) e.getSource();
				if (item.getParent().equals(menu)){
					menu.setVisible(true);
				}
			}
		};
		final JLabel lll = new JLabel("SSS");
		lll.setSize(new Dimension(100,100));
		lll.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.isPopupTrigger()) {
		            menu.show(e.getComponent(),
		                       e.getX(), e.getY());
		        }
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.isPopupTrigger()) {
		            menu.show(e.getComponent(),
		                       e.getX(), e.getY());
		        }
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
				if (e.getButton() == MouseEvent.BUTTON1) {
		            menu.show(e.getComponent(),
		                       e.getX(), e.getY());
				}
				
			}
		});
		JCheckBoxMenuItem item1 = new JCheckBoxMenuItem("One");
		JCheckBoxMenuItem item2 = new JCheckBoxMenuItem("Two");
		item1.addMouseListener(itemListener);
		item2.addMouseListener(itemListener);
		options = new JMenuItem[2];
		options[0] = item1;
		options[1] = item2;
		menu.add(item1);
		menu.add(item2);
//		JTable table = new JTable() {
//			@Override
//			public TableCellRenderer getCellRenderer(int row, int column) {
//				if (row == 1 && column == 1){
//					MyRenderer ren = new MyRenderer(menu, options);
//					return ren;
//				} else {
//					return super.getCellRenderer(row, column);
//				}
//			}
//		};
//		
//		DefaultTableModel model = new DefaultTableModel(2,2);
//		
//		class MyTableModel extends AbstractTableModel {
//			private String[] header;
//			private Object[][] data;
//			
//			
//			
//			public String[] getHeader() {
//				return header;
//			}
//
//			public void setHeader(String[] header) {
//				this.header = header;
//			}
//
//			public Object[][] getData() {
//				return data;
//			}
//
//			public void setData(Object[][] data) {
//				this.data = data;
//			}
//
//			@Override
//			public int getRowCount() {
//				return data.length;
//			}
//
//			@Override
//			public int getColumnCount() {
//				return header.length;
//			}
//
//			@Override
//			public Object getValueAt(int rowIndex, int columnIndex) {
//				return data[rowIndex][columnIndex];
//				
//			}
//			@Override
//			public void setValueAt(Object value, int rowIndex, int columnIndex) {
//				data[rowIndex][columnIndex] = value;
//				fireTableDataChanged();
//			}
//			@Override
//			public boolean isCellEditable(int rowIndex, int columnIndex) {
//				if (rowIndex == 1 && columnIndex == 1) {
//					return false;
//				} else {
//					return true;
//				}
//			}
//			
//			@Override
//			public Class getColumnClass(int c) {
//				return getValueAt(0, c).getClass();
//			}
//			
//		}
//		
//		model.setDataVector(new Object[][]{{"One", "Two"}, {"Three", lll}}, new String[]{"Col1", "Col2"});
//		table.setModel(model);
//		table.setDefaultRenderer(JPopupMenu.class, new MyRenderer());
		
		
		panel = new JPanel();
		panel.add(lll);
		panel.add(menu);
		
		getContentPane().add(panel);
		pack();
		setVisible(true);
	}
	
	class MyRenderer extends JLabel implements TableCellRenderer {
		
		private JMenuItem[] items;
		private JPopupMenu menu;
		public MyRenderer(JPopupMenu menu, JMenuItem[] items) {
			this.menu = menu;
			this.items = items;
			for (JMenuItem i: items) {
				menu.add(i);
			}
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
				boolean hasFocus, int row, int column) {
			if (row == 1 && column == 1){
				// TODO Auto-generated method stub
				JLabel label = (JLabel) value;
				int index = menu.getSelectionModel().getSelectedIndex();
				if (menu.getSubElements().length == 0) {
					for (JMenuItem i: items) {
						menu.add(i);
					}
				}
				if (index == -1) index = 0;
				
				JCheckBoxMenuItem box = (JCheckBoxMenuItem) menu.getSubElements()[index];
				label.setText(box.getText());
				return label;
			}
			return new JLabel();
		}
		
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MultiComboWithPopup frame = new MultiComboWithPopup();
				
			}
			
		});
	}
		
}
