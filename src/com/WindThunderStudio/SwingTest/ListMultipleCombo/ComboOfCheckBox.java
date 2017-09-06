package com.WindThunderStudio.SwingTest.ListMultipleCombo;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;

public class ComboOfCheckBox extends JFrame {
	
	
	
	public ComboOfCheckBox() {
		begin();
	}
	
	private void begin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		JTable table = new JTable(new Object[2][2], new String[]{"COL1", "COL2"});
		final JCheckBox chx1 = new JCheckBox("Oh");
		final JCheckBox chx2 = new JCheckBox("My");
		final JCheckBox chx3 = new JCheckBox("God");
		String[] values = new String[] {"Oh", "My", "God"};
		JCheckBox[] array = new JCheckBox[] {chx1, chx2, chx3};
		final JComboBox<JCheckBox> comboBox = new JComboBox<JCheckBox>(array) {
			@Override
			public void setPopupVisible(boolean visible){
				if (visible) {
					super.setPopupVisible(visible);
				}
			}
		};
		
		
//		final JList<String> list = new JList<String>();
//		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
//		list.setVisibleRowCount(5);
//		
//		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//		list.setSelectionModel(new DefaultListSelectionModel(){
//			@Override
//			public void setSelectionInterval(int index0, int index1) {
//				if(super.isSelectedIndex(index0)) {
//		            super.removeSelectionInterval(index0, index1);
//		        }
//		        else {
//		            super.addSelectionInterval(index0, index1);
//		        }
//			}
//		});
		
//		list.addListSelectionListener(new ListSelectionListener() {
//			
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				List<String> values = list.getSelectedValuesList();
//				for (String s: values) {
//					System.out.println(s);
//				}
//				
//			}
//		});
		
		class CheckBoxRenderer  implements ListCellRenderer {
			private boolean[] selected;
			private String[] items;
			public CheckBoxRenderer(String[] items) {
				this.items = items;
				this.selected = new boolean[items.length];
			}
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				JLabel label = null;
				
				
				return label;
			}
			public void setSelected(int i, boolean selected) {
				this.selected[i] = selected;
			}
			
		}
//		
//		list.setCellRenderer(new CheckBoxAsListRenderer());
		comboBox.setRenderer(new CheckBoxRenderer(values));
		
		
		
		
		panel.add(comboBox);
		
		panel.add(new JCheckBox("Another"));
		getContentPane().add(panel);
		pack();
		setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ComboOfCheckBox frame = new ComboOfCheckBox();
				
			}
			
		});
	}
	
}
